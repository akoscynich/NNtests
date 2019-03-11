import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ScreenshotsTests extends _Manager {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String date = dateFormat.format(new Date());

    public void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/hamster/IdeaProjects/NNtests/out/screenshots/" + date + "/" + dateFormat.format(new Date()) + ".png"), true);
    }

    @BeforeClass
    public void preconditions() {
        new File("/Users/hamster/IdeaProjects/NNtests/out/screenshots/" + date).mkdir();
    }

    @Test(enabled = false)
    //Собирает ссылки с главной страницы и страниц категорий, переходит по ним, если они 404 то собирает ссылки в список и выводит на консоль,
    //делает скриншоты на каждое заданное разрешение. ~20 минут.
    public void screenshotsOfLinksFromHomePageAndCategories() throws IOException, InterruptedException {
        Set<String> links = new HashSet<>();
        Set<String> links404 = new HashSet<>();
        for (String page : _Data.mainPages()) {
            goTo(page);
            links.addAll(_Data.setOfLinks());
        }
        for (String link : links) {
            goTo(link);
            if (isElementPresent(By.cssSelector("h1.number")) && parseInt(getText(By.cssSelector("h1.number"))) == 404) {
                links404.add(link);
            }
            for (String breakPoint : _Data.breakPoints()) {
                wd.manage().window().setSize(new Dimension(parseInt(breakPoint), 1080));
                Thread.sleep(800);
                takeScreenshot();
            }
        }
        System.out.println(links404);
    }

}
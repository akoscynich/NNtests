import org.apache.commons.io.DirectoryWalker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class LinksTests extends _Manager {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String date = dateFormat.format(new Date());

    public void takeScreenshot() throws IOException {File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/hamster/IdeaProjects/NNtests/out/screenshots/" + date + "/" + dateFormat.format(new Date()) + ".png"), true);}

    @BeforeClass
    public void preconditions() {
        new File("/Users/hamster/IdeaProjects/NNtests/out/screenshots/" + date).mkdir();
    }

    @Test
    public void homePageLinksText() throws IOException {
        List<String> links404 = new ArrayList<>();
        int i = 0;
        for (String link : _Data.listOfLinks()) {
            i++;
            goTo(link);
            takeScreenshot();
            if (isElementPresent(By.cssSelector("h1.number")) && parseInt(getText(By.cssSelector("h1.number"))) == 404) {
                links404.add(link);
            }
        }
        /*for (String category : _Data.categories()) {
            goTo(category);
            {
                for (String link : _Data.listOfLinks()) {
                    goTo(link);
                    if (isElementPresent(By.cssSelector("h1.number")) && parseInt(getText(By.cssSelector("h1.number"))) == 404) {
                        links404.add(link);
                    }
                }
            }
        }*/
        System.out.println(links404);
    }

    @Test
    public void categoryLinksText() throws IOException {
        for (String category : _Data.categories()) {
            goTo(category);
            {
                for (String link : _Data.listOfLinks()) {
                    goTo(link);
                    takeScreenshot();
                    //System.out.println(link);
                }
            }
        }
    }
}
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LinksTests extends _Manager {

    @Test
    public void homePageLinksText() throws NoSuchElementException {
        List<String> links404 = new ArrayList<>();
        for (String link : _Data.listOfLinks()) {
            goTo(link);
            if (isElementPresent(By.cssSelector("h1.number")) && parseInt(getText(By.cssSelector("h1.number"))) == 404) {
                links404.add(link);
            }
        }
        for (String category : _Data.categories()) {
            goTo(category);
            {
                for (String link : _Data.listOfLinks()) {
                    goTo(link);
                    if (isElementPresent(By.cssSelector("h1.number")) && parseInt(getText(By.cssSelector("h1.number"))) == 404) {
                        links404.add(link);
                    }
                }
            }
        }
        System.out.println(links404);
    }

    @Test
    public void categoryLinksText() {
        for (String category : _Data.categories()) {
            goTo(category);
            {
                for (String link : _Data.listOfLinks()) {
                    //I.goTo(linkText);
                    System.out.println(link);
                }
            }
        }
    }
}
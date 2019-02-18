import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class _Data extends _Manager {

    //Ссылки

    public static String HomePage = "https://nsp.mygento.net/ru/";

    //Список категорий

    public static List<String> categories() {
        List<String> categories = new ArrayList<>();
        categories.add(0, "https://nsp.mygento.net/ru/coffee-capsules");
        categories.add(1, "https://nsp.mygento.net/ru/coffee-machines-1");
        categories.add(2, "https://nsp.mygento.net/ru/accessories");
        return categories;
    }

    //Собирает список ссылок с текущей страницы

    public static List<String> listOfLinks() {
        List<WebElement> allTheLinkList = I.finds(By.tagName("a"));
        List<String> linksWithText = new ArrayList<>();
        for (WebElement link : allTheLinkList) {
            if (link.getAttribute("href") != null) {
                if (!(link.getAttribute("href").equals(""))) ;
                linksWithText.add(link.getAttribute("href"));
            }
        }
        return linksWithText;
    }

    public static int productCount(){
        return I.finds(By.cssSelector("li.item.product.product-item")).size();
    }
    /*public static List<WebElement> listOfProducts() {
        return new ArrayList<>(I.finds(By.cssSelector("div.actions-primary")));

    }*/
}

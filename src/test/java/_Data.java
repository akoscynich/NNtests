import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class _Data extends _Manager {

    //Ссылки

    public static String homePage = "https://nsp.mygento.net/ru/";
    public static String cart = "https://nsp.mygento.net/ru/checkout/cart/";
    public static String reg = "https://nsp.mygento.net/ru/customer/account/create/";

    //Кнопки

    public static void openMiniCart() {
        click(By.cssSelector("a.action.showcart"));
    }
    public static void clearMiniCart() {
        click(By.xpath("//div[2]/div[1]/div[2]/a"));
    }
    public static By logIn = By.cssSelector("div.welcome.welcome-ppl");
    public static By createAccount = By.xpath("//div/div[2]/div/div[2]/div");
    public static By submitReg = By.cssSelector("#form-validate > div > div.primary > button");

    //Локаторы

    public static String summInMiniCart = "//div[2]/div/div[2]/span";
    public static String priceInMiniCart = "//div[3]/span[2]/span";
    public static String totalInMiniCart = "//div[4]/div[1]/div/span/span";

    public static By firstnameRegField = By.name("firstname");
    public static By lastnameRegField = By.name("lastname");
    public static By machineCodeRegField = By.name("machine_code_reg");
    public static By eMailRegField = By.name("email");
    public static By passRegField = By.name("password");
    public static By passConfRegField = By.name("password_confirmation");

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
        List<WebElement> allTheLinkList = finds(By.tagName("a"));
        List<String> links = new ArrayList<>();
        for (WebElement link : allTheLinkList) {
            if (link.getAttribute("href") != null) {
                if (!(link.getAttribute("href").equals(""))) ;
                links.add(link.getAttribute("href"));
            }
        }
        return links;
    }

    //Собирает список всех сумм в корзине в виде строк удаляя все символы кроме цифр

    public static List<String> summsFromMiniCart() {
        List<WebElement> summs = finds(By.xpath(_Data.summInMiniCart));
        List<String> summText = new ArrayList<>();
        for (WebElement sum : summs) {
            List<String> formatedString = new ArrayList<>(asList((sum.getText()).split(" ")));
            formatedString.remove(formatedString.size() - 1);
            summText.add(formatedString.stream().map(String::toString).collect(Collectors.joining("")));
        }
        return summText;
    }

    //Количество продуктов на странице в категории

    public static int productCount() {
        return finds(By.cssSelector("li.item.product.product-item")).size();
    }

    //Находит элемент по локатору, берет его текст, режет на части по пробелам удаляет последний элемент,
    //склеивает в строку то что осталось и парсит в int.
    //Например преобразует строку "123 456 руб." в int 123456
    public static int i(String link) {
        List<String> i = new ArrayList<>(asList(getText(By.xpath(link)).split(" ")));
        i.remove(i.size() - 1);
        return parseInt(i.stream().map(String::toString).collect(Collectors.joining("")));
    }


}

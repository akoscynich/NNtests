import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTests extends _Manager {

    @Test
    public void priceTest() throws InterruptedException {
        for (String category : _Data.categories()) {
            goTo(category);
            int r = (int) (Math.random() * _Data.productCount() + 1);
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div"));
            int z = parseInt(getText(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]")));
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]"));
            Thread.sleep(3000);
            click(By.cssSelector("a.action.showcart"));
            List<String> summ = new ArrayList<>(asList(getText(By.xpath("//div[2]/div/div[2]/span")).split(" ")));
            summ.remove(summ.size() - 1);
            int x = parseInt(summ.stream().map(String::toString).collect(Collectors.joining("")));
            List<String> price = new ArrayList<>(asList(getText(By.xpath("//div[3]/span[2]/span")).split(" ")));
            price.remove(price.size() - 1);
            int y = parseInt(price.stream().map(String::toString).collect(Collectors.joining("")));
            assertThat(x, equalTo(y * z));
            click(By.xpath("//div[2]/div[1]/div[2]/a"));
            Thread.sleep(3000);

            //goTo("https://nsp.mygento.net/ru/checkout/cart/");

            //System.out.println(price[0]);
            //System.out.println(price[1]);
        }

    }
}

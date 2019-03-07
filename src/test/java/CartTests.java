import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTests extends _Manager {

    @Test
    //Добавляет случайный товар из категории в корзину и проверяет правильность подсчета суммы. Повторяет для каждой категории.
    public void priceTest() throws InterruptedException {
        for (String category : _Data.categories()) {
            goTo(category);
            int r = (int) (Math.random() * _Data.productCount() + 1);
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div"));
            int count = parseInt(getText(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]")));
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]"));
            Thread.sleep(3000);
            _Data.openMiniCart();
            int summ = _Data.i(_Data.summInMiniCart);
            int price = _Data.i(_Data.priceInMiniCart);
            assertThat(summ, equalTo(price * count));
            _Data.clearMiniCart();
            Thread.sleep(3000);
        }
    }

    @Test //Добавляет по одному случайному товару из каждой категории в корзину и проверяет правильность подсчета суммы.
    public void priceTest3RandomProducts() throws InterruptedException {
        for (String category : _Data.categories()) {
            goTo(category);
            int r = (int) (Math.random() * _Data.productCount() + 1);
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div"));
            //int count = parseInt(getText(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]")));
            click(By.xpath("//li[" + r + "]/div/div/div[2]/div/div[1]/form/div/div[3]/div[5]"));
            Thread.sleep(4000);
        }
        _Data.openMiniCart();
        Thread.sleep(1000);
        int total = 0;
        for (String summ : _Data.summsFromMiniCart()) {
            total += parseInt(summ);
        }
        int totalInMiniCart = _Data.i(_Data.totalInMiniCart);
        assertThat(total, equalTo(totalInMiniCart));
        _Data.clearMiniCart();
        Thread.sleep(3000);
    }

}


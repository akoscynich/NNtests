import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CatalogTests extends _Manager {

    @Test //Проверка счетчиков товаров в категориях
    public void productsCountTest(){
        for (String category : _Data.categories()) {
            goTo(category);
            String[] count = getText(By.cssSelector("div.category-product-count")).split(" ");
            assertThat(parseInt(count[1]), equalTo(_Data.productCount()));
        }
    }
}

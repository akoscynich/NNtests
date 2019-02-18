import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RegistrationTests extends _Manager {

    @Test(enabled = true)
    public void PositiveRegistrationTest(){

        I.goTo(_Data.HomePage);
        I.click(By.xpath("//em[2]"));
        I.click(By.linkText("Регистрация"));
        I.type((By.name("email")), "sadasd");
        I.type(By.name("password"), "sadasd");
        I.click(By.xpath("//div[2]/button/span/span"));
    }

}

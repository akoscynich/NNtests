import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationTests extends _Manager {

    long now = System.currentTimeMillis();

    @Test(enabled = true)
    public void positiveRegistrationTest() throws InterruptedException {
        goTo(_Data.reg);
        type(_Data.firstnameRegField, "Test_name" + now);
        type(_Data.lastnameRegField, "Test_lastname" + now);
        type(_Data.eMailRegField, "Test_email" + now + "@somewhere.ru");
        type(_Data.passRegField, "_Aa" + now);
        type(_Data.passConfRegField, "_Aa" + now);
        click(_Data.submitReg);
        assertThat(getUrl(), equalTo(_Data.myAccount));
    }

    @Test(enabled = false) //<---с пустыми полями ToDo
    public void negativeRegistrationTest() throws InterruptedException {
        goTo(_Data.reg);
        Thread.sleep(500);
        click(_Data.submitReg);
        assertThat(getText(By.cssSelector("#firstname-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#lastname-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#email_address-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#password-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#password-confirmation-error")), equalTo("Это поле обязательно для заполнения."));
    }

    @Test(enabled = false) //<---с невалидными данными ToDo
    public void negativeRegistrationTest1() throws InterruptedException {
        goTo(_Data.reg);
        type(_Data.firstnameRegField, "sadasd");
        type(_Data.lastnameRegField, "sadasd");
        type(_Data.eMailRegField, "sadasd");
        type(_Data.passRegField, "sadasd");
        type(_Data.passConfRegField, "sadasd");
        click(_Data.submitReg);
        assertThat(getText(By.cssSelector("#firstname-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#lastname-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#email_address-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#password-error")), equalTo("Это поле обязательно для заполнения."));
        assertThat(getText(By.cssSelector("#password-confirmation-error")), equalTo("Это поле обязательно для заполнения."));
    }

}

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _Manager {

    private String browser = BrowserType.FIREFOX; //<--Выбор браузера FIREFOX CHROME IE SAFARI
    private static WebDriver wd;
    protected static final _Manager I = new _Manager();
    //ProxyServer bmp = new ProxyServer(8071);


    //Fixture--------------------------------------------------------------------------------

    public void init() throws Exception {


        //bmp.start();
        //bmp.autoBasicAuthorization("", "nsp", "mygento");

        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability(CapabilityType.PROXY, bmp.seleniumProxy());

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }


        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://nsp:mygento@nsp.mygento.net"); //<---------------Стартовая страница


    }

    public void stop() throws Exception {
        wd.quit();
        //bmp.stop();
    }

    //Methods--------------------------------------------------------------------------------

    protected void type(By locator, String text) {
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void clear(By locator) {
        wd.findElement(locator).clear();
    }

    protected void find(By locator) {
        wd.findElement(locator);
    }

    protected void goTo(String url) {
        wd.get(url);
    }

    protected String getText(By locator) {
        String text = wd.findElement(locator).getText();
        return text;
    }

    public List<WebElement> finds(By locator) {
        return wd.findElements(locator);
    }


    //---------------------------------------------------------------------------------------



    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        I.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        I.stop();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Registration {

    private By btnLogin = By.xpath("//div[@class='r1yVH']//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By btnJoin = By.xpath("//div[@class='login__alt-cta text-center']//a[@href='/join']");
    private By inputFirstName = By.xpath("//div[@class='form-group']//input[@id='user_first_name']");
    private By inputLastName = By.xpath("//div[@class='form-group']//input[@id='user_last_name']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputUserName = By.xpath("//div[@class='form-group']//input[@id='user_username']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnRegistration = By.xpath("//div[@class='form-group']//input[@class='btn btn-default btn-block-level']");
    private By btnCopyEmail = By.id("pre_copy");

    @Test
    public void registration () {
        WebDriver driver = new ChromeDriver();


        driver.get("https://unsplash.com/");
        driver.manage().window().maximize();
        driver.findElement(btnLogin).click();
        driver.findElement(btnJoin).click();
        driver.findElement(inputFirstName).sendKeys("New");
        driver.findElement(inputLastName).sendKeys("Test");

        driver.switchTo().newWindow(WindowType.TAB).get("https://tempmail.plus/ru/#!");

        driver.findElement(btnCopyEmail).click();
        sleep(2000);

        ArrayList<String> newTab = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));

        driver.findElement(inputEmail).sendKeys(Keys.LEFT_CONTROL + "v");
        driver.findElement(inputUserName).sendKeys("Valera");
        driver.findElement(inputPassword).sendKeys("888888888");
        driver.findElement(btnRegistration ).click();
       // sleep(3000);
    }

    private void sleep(int i) {
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ShareLaneTests {

    WebDriver driver;
    WebDriver driver1;

    @AfterMethod(alwaysRun = true)

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void positiveZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }

    @Test
    public void negativeZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver1.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        WebElement continueButton = driver1.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement errorMessage = driver1.findElement(By.className("error_message"));
        Assert.assertEquals(errorMessage.isDisplayed(), true);

        driver1.quit();
    }

    @Test
    public void positiveSignUpTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver2.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver2.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement firstNameInput = driver2.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Nikita");

        WebElement lastNameInput = driver2.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Dunyashenko");

        WebElement emailInput = driver2.findElement(By.name("email"));
        emailInput.sendKeys("dnik123@gmail.co");

        WebElement passwordInput = driver2.findElement(By.name("password1"));
        passwordInput.sendKeys("12345");

        WebElement confirmPasswordInput = driver2.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("12345");

        WebElement registerButton = driver2.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        WebElement confirmationMessage = driver2.findElement(By.className("confirmation_message"));
        Assert.assertEquals(confirmationMessage.isDisplayed(), true);

        driver2.quit();

    }

    @Test
    public void negativeSignUpTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver3 = new ChromeDriver();
        driver3.manage().window().maximize();
        driver3.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver3.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        WebElement continueButton = driver3.findElement(By.cssSelector("[value = Continue]"));
        continueButton.click();

        WebElement firstNameInput = driver3.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Nikita");

        WebElement lastNameInput = driver3.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Dunyashenko");

        WebElement emailInput = driver3.findElement(By.name("email"));
        emailInput.sendKeys("dnik123gmail.co");

        WebElement passwordInput = driver3.findElement(By.name("password1"));
        passwordInput.sendKeys("12345");

        WebElement confirmPasswordInput = driver3.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("12345");

        WebElement registerButton = driver3.findElement(By.cssSelector("[value = Register]"));
        registerButton.click();

        WebElement errorMessage2 = driver3.findElement(By.className("error_message"));
        Assert.assertEquals(errorMessage2.isDisplayed(), true);

        driver3.quit();
    }

}

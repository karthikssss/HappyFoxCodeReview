package webdriverbase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Unsed import statement
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
    	/*  Path is hardcoded.you can set the WebDriver path in the system's environment variables OR
            use a WebDriver manager library like WebDriverManager to handle the WebDriver setup dynamically OR
            use Selenium Manager functionality starting from version 4.6 */
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\test\\Desktop\\D drive\\automation\\Chrome driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterSuite
    public void afterSuite() {
        // null! =driver Handle potential NullPointerException by using exception handling (try/catch block)
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}



package Admin_Portal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriverbase.AppPage;
/* 1.Nested clases in PageObjectModel is not recommended. Better to create seperate class files for each class.
   2.Outer class should not be static and moreover outer class should be Login_Page Not BasePage. If BasePage is
   inner class, outer class should be defined.
   3.Use @FindBy from Page Factory. use this statement inside constructor to initilze it
   "PageFactory.initElements(driver, this);
   4.General Suggestion using exception handling in methods where ever possible for a element using try/catch &
Add meaningful comments to explain the purpose of complex logic or non-obvious steps */"
*/

static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }

	}

}

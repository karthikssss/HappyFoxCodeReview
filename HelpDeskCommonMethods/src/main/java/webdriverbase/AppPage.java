package webdriverbase;

import java.awt.Toolkit;  //Unsed import statement
import java.awt.datatransfer.StringSelection; //Unsed import statement
import java.io.File; //Unsed import statement
import java.io.InputStream; //Unsed import statement
import java.net.HttpURLConnection; //Unsed import statement
import java.net.MalformedURLException; //Unsed import statement
import java.net.URL; //Unsed import statement
import java.time.Duration; //Unsed import statement
import java.util.ArrayList; //Unsed import statement
import java.util.HashMap; //Unsed import statement
import java.util.List; //Unsed import statement
import java.util.Set; //Unsed import statement
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert; //Unsed import statement
import org.testng.TestListenerAdapter; //Unsed import statement

 /* General Suggestion using exception handling in methods where ever possible for a element using try/catch &
Add meaningful comments to explain the purpose of complex logic or non-obvious steps */

public class AppPage {
	//Hard coded path . Consider using a configuration file or system properties to manage such paths dynamically
	public static String PATH_TO_TEST_DATA_FILE = "src/main/resources/";
	public static String WINDOWS_PATH_TO_TEST_DATA_DIR = "src/main/resources/";
	public static int WAIT_TIME_SEC = 60;	
	protected WebDriver driver ;

	
	JavascriptExecutor javaScriptExecutor;
	
	public AppPage(WebDriver driver) {
		this.driver = driver;
		waitImplicitly();
		PageFactory.initElements(driver, this);
		maximizeWindow();
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}

	public void get(String url) {
		this.driver.get(url);
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	public void maximizeWindow() {
			driver.manage().window().maximize();		
	}

	//Duplicate code for waitImplicitly. Can be comibed in a single Method.

	public void waitImplicitly() {
		driver.manage().timeouts().implicitlyWait(WAIT_TIME_SEC, TimeUnit.SECONDS);
	}

	public void waitImplicitly(int timeOutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
	}
	
	public void clearAndType(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
	}
	
	public void switchToFrame(WebElement frame) {
		this.driver.switchTo().frame(frame);
	}
	
	public void hoverOverElementUsingJS(WebElement element) {
		String js = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		getJavaScriptExecutor().executeScript(js, element);
	}
	
	public JavascriptExecutor getJavaScriptExecutor() {
		if (javaScriptExecutor == null)
			javaScriptExecutor = (JavascriptExecutor) driver;
		return javaScriptExecutor;
	}
	//Method is not in camel case
	public void scrolltoElement(String locator) {
		try {
			WebElement element = this.driver.findElement(By.xpath(locator));

			scrolltoElement(element);
		} catch (Exception ex) {
			//Here we need to print the e.printStackTrace() in order to tell user.
		}
	}
	
	public void scrolltoElement(WebElement element) throws InterruptedException {
		getJavaScriptExecutor().executeScript("arguments[0].scrollIntoView(false)", element);
		// Not recommended to use Thread.sleep. Use implicit/explicit waut
		Thread.sleep(1000);
	}
	
	public void waitForVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_SEC);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public String getCurrentWorkingDirectory()
	{
		String workingDir = null;
		try{
			workingDir = System.getProperty("user.dir");
		}catch(Exception e){
			e.printStackTrace();
		}
		return workingDir;
	}
	
	public String getTestDataFullDirPath(String fileName)
	{
		String path = PATH_TO_TEST_DATA_FILE;
		if(getOperatingSystemType() == OSType.Windows)
			path = WINDOWS_PATH_TO_TEST_DATA_DIR;
		return (getCurrentWorkingDirectory()+ path+ fileName);
	}
	
	public enum OSType {
	    Windows, MacOS, Linux, Other
	  };
	  
	 protected static OSType detectedOS;
	 
	 public static OSType getOperatingSystemType() 
	 {
		 detectedOS = OSType.Windows;
		 return detectedOS;
	 }
	

}

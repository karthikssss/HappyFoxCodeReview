package CustomerPortal;
import java.util.concurrent.TimeUnit;  //Unsed Import

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Admin_Portal.AdminPortalTest2ndPage;
import Admin_Portal.Login_Page;
import webdriverbase.AppPage; // Unsed import

/*General Suggestion using exception handling in methods where ever possible for a element using try/catch &
Add meaningful comments to explain the purpose of complex logic or non-obvious steps */
public class SupportPortalPage extends AppPage{
	
	public SupportPortalPage(WebDriver driver)
	{
		super(driver);
				
	}
	
	
	public void navigateToHappyFoxSupportPortalURL(String url) {
		this.driver.get(url);
	}
		
	@FindBy(id = "id_subject")
	/*Variable name should start with a lowercase letter. Consider renaming it to "subject" for
	better readability. Make sure to update all the methods where this variable is used to avoid any issues.
	 */
	private WebElement Subject;
	
	public void enterSubject(String text)
 	{
		Subject.sendKeys(text);
 	}

	/*Xpath is very long and it is prone to breakage. Considering using contains method in xpath or other
	locator for robust xpath */
	@FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")

	 /*Variable name should start with a lowercase letter. Consider renaming it to "message" for
	better readability. Make sure to update all the methods where this variable is used to avoid any issues. */
	private WebElement Message;
	
	public void enterMessage(String text)
 	{
	    Message.sendKeys(text);
 	}
	
	@FindBy(id = "add-cc")
	/* Variable name starts with capital. It should start with smallletter to meet the standards.Make sure to update all the methods where this
	 variable is used to avoid any issues. */
	private WebElement AddCC;
	
	public void clickAddCC()
 	{
	    AddCC.click();
 	}
	
	@FindBy(id = "add-bcc")
	// Variable Name not meeting the CamelCase standard
	private WebElement AddBCC;
	
	public void clickAddBCC()
 	{
	    AddBCC.click();
 	}
	
	@FindBy(xpath = "//input[@id='id_cc']")
	// Variable Name not meeting the CamelCase standard
	private WebElement CC;
	
	public void enterCC(String text)
 	{
	    CC.sendKeys(text);
 	}
	
	@FindBy(xpath = "//input[@id='id_bcc']")
	// Variable Name not meeting the CamelCase standard
	private WebElement BCC;
	
	public void enterBCC(String text)
 	{
	    BCC.sendKeys(text);
 	}
	
	
	
	@FindBy(xpath = "//a[@class='hf-attach-file_link']")
	// Variable Name not meeting the CamelCase standard
	private WebElement BrowseFile;

	//Method Name can be "uploadScreenshot"
	public void addingScreenshot(String abc)
 	{
	    BrowseFile.sendKeys(getTestDataFullDirPath(abc));
	    
 	}
	
	//Locator is wrong and finding two matches in DOM. This will break the execution.
	@FindBy(id = "id_name")

	/* Variable name starts with capital. It should start with smallletter to meet the standards.Make sure to update all the methods where this
	 variable is used to avoid any issues. */
	private WebElement FullName;
	
	public void enterFullName(String text) throws InterruptedException
 	{
		 /*Not recommended to use Thread.Sleep. It will slow down the execution. Better to use implicit and
		explicit wait.*/

		sleep();
	    FullName.sendKeys(text);
 	}

	//Locator is wrong and finding two matches in DOM. This will break the execution.
	@FindBy(id = "id_email")

	/* Variable name starts with capital. It should start with smallletter to meet the standards.Make sure to update all the methods where this
	 variable is used to avoid any issues. */
	private WebElement Email;
	
	public void enterEmail(String text) throws InterruptedException
 	{
		  /*Not recommended to use Thread.Sleep. It will slow down the execution. Better to use implicit and
		explicit wait.*/
		sleep();
	    Email.sendKeys(text);
 	}
	//Locator is wrong and finding two matches in DOM. This will break the execution.
	@FindBy(id = "id_phone")

	/* Variable name starts with capital. It should start with smallletter to meet the standards.Make sure to update all the methods where this
	 variable is used to avoid any issues. */
	private WebElement Phone;
	
	public void enterPhone(String text)
 	{
	    Phone.sendKeys(text);
 	}
	
	
	@FindBy(xpath = "//button[@id='submit']")

	//Variable name should be in CamelCase for better readability. It can be renamed as "createTicet"
	private WebElement CreateTicket;
		
	public AdminPortalTest2ndPage clickCreateTicket()
	 {
		   CreateTicket.click();
		   return new AdminPortalTest2ndPage(driver);
	 }


	 // Replace thread.sleep with other wait like implicitylyWait, Explict, FluentWait.
     public void sleep() throws InterruptedException {
    	 Thread.sleep(1000);
     }

}

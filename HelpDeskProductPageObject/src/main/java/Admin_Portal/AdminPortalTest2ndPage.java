package Admin_Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import webdriverbase.AppPage;

/* Instead of AdminPortalTest2stPage, a more descriptive name would be better
General Suggestion using exception handling in methods where ever possible for a element using try/catch &
Add meaningful comments to explain the purpose of complex logic or non-obvious steps */

public class AdminPortalTest2ndPage extends AppPage {

	public AdminPortalTest2ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
	private WebElement Title;
	
	@FindBy(xpath = "//a[contains(text(),'Pending Tickets')]")

	/* Variable Name is not meeting the coding standards like camelcase.
	I assume pendingTickets will be single link.
	 */

	private WebElement PendingTickets;
	
	public void clickPendingTickets()
 	{
		hoverOverElementUsingJS(PendingTickets);
		PendingTickets.click();
		
 	}
	
	
     public void openCustomerTicket(String xpath) throws InterruptedException {
		
	    String ticket = "//a[@title='"+xpath+"']";
		WebElement pqr = driver.findElement(By.xpath(ticket));
		hoverOverElementUsingJS(pqr);
	    pqr.click();
		//Thread.sleep is not recommended. Use implicty wait or explicit wait.
	    sleep();  
	    
	}	
     
     
    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']") 
  	private WebElement contactName;
    
    public String getContactName()
	{
		//No need this statement since we are using Assert for validation
    	System.out.println(contactName.getText());
		// No need toString() as getText() method returns String only
		return contactName.getText().toString();
	}
    // Xpath is length and prone to breakge. Use id, name or short xpath.
    @FindBy(xpath = "//a[@data-test-id='ticket-side-pane-contact-name']//following::div[1]/div[1]/span[1]") 

	//Variable name is not following the naming standards
	private WebElement Emailtxt;
    
    public String getEmailtxt()
	{
		/*No need this statement since we are using Assert for validation and variable name "Emailtxt" not meeting the coding
		standards */
    	System.out.println(Emailtxt.getText());
		// No need toString() as getText() method returns String only
		return Emailtxt.getText().toString();
	}
    
    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]") 
  	private WebElement Statustxt;
    
    public String getStatustxt()
	{
		/*No need this statement since we are using Assert for validation */
    	System.out.println(Statustxt.getText());
		// No need toString() as getText() method returns String only
		return Statustxt.getText().toString();
	}
    
    //Xpath is very long. Prone to breakage. Use shorted Xpath.
    @FindBy(xpath = "//div[contains(text(),'status')]//following::div[1]//following::span[1]/div/div/div/div[2]") 
  	private WebElement Prioritytxt;
    
    public String getPrioritytxt()
	{
		// Not needed as we are using Assert statement
    	System.out.println(Prioritytxt.getText());

		//toString() is not needed as getText() will return String
		return Prioritytxt.getText().toString();
	}
    
      
     
    @FindBy(xpath = "//span[contains(text(),'Reply')]") 
 	private WebElement ReplyButton;
 	// Variable Name not meeting the CamelCase standard
 	public void clickReplyButton()
  	{
 		ReplyButton.click();
 		
  	}
 	
 	@FindBy(xpath = "//span[@data-test-id='canned-action-trigger']") 
 	private WebElement CannedAction;
 	//Variable Name not meeting the CamelCase standards
 	public void clickCannedAction()
  	{
 		CannedAction.click();
 		
  	}
 	
 	@FindBy(xpath = "//input[@placeholder='Search more Canned Actions']")
	// Variable Name not meeting the CamelCase standard
	private WebElement SearchCannedAction;
 	
 	@FindBy(xpath = "//li[@class='ember-power-select-option']")

	//Variable name not meeting the CamelCase standard
 	private WebElement ChooseCannedAction;
 	
 	public void clickSearchCannedAction(String abc)
  	{
 		SearchCannedAction.click();
 		SearchCannedAction.sendKeys(abc);
 		ChooseCannedAction.click();
 		
  	}
 	
 	
 	@FindBy(xpath = "//button[@data-test-id='hf-add-canned-action']")

	//Again variable name not meeting the camelcase
 	private WebElement ApplyCannedAction;
 	
 	public void clickApplyCannedAction()
  	{
 		ApplyCannedAction.click();
 		
  	}
 	
 	
 	@FindBy(xpath = "//button[@data-test-id='add-update-reply-button']")
	//Variable Name is not meeting the coding standards
 	private WebElement Reply;
 	
 	public void sendReply() throws InterruptedException
  	{
 		Reply.click();
		 // Thread.sleep is not recommended. Use implicit wait or explicit wait
 		sleep();
 		
  	}
 	
    
    @FindBy(xpath = "//a[contains(text(),'Agent Portal')]")

	//Variable name "AgentPortal" does not follow naming standards. It should be in camelcase.
 	private WebElement AgentPortal;
     
     public void gotoAgentPortal() {
    	 
    	 AgentPortal.click();
     }
 	
 	
  	@FindBy(xpath = "//a[@data-test-id='details-close']")

	//Varaible name is not meeting the coding standards like CamelCase
  	private WebElement CloseTicket;
  	
  	public AdminPortalTest1stPage closeTheTicket()
   	{
  		CloseTicket.click();
  		return new AdminPortalTest1stPage(driver);
  		
   	}

	   //Do not use Thread.sleep method use implicit or explicit wait for synchronization problem
     public void sleep() throws InterruptedException {
    	 Thread.sleep(2000);
     }
}

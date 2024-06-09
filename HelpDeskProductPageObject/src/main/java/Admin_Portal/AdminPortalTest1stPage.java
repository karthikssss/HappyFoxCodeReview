package Admin_Portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;  // Unsed import statement
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriverbase.AppPage;

/* Instead of AdminPortalTest1stPage, a more descriptive name like AdminPortalHomePage would be better
General Suggestion using exception handling in methods where ever possible for a element using try/catch &
Add meaningful comments to explain the purpose of complex logic or non-obvious steps */

public class AdminPortalTest1stPage extends AppPage {

	public AdminPortalTest1stPage(WebDriver driver) {
		super(driver);
		
	}
	
	/* Class name is not meaningfull and it is long. Prone to breakage. Please consider using another locator
	 or use contains method using class AND Variable name "Title" does not follow follow standards as CamelCase*/
	@FindBy(xpath = "//span[@class='hf-top-bar_title_text hf-font-light']")
	private WebElement Title;

	/* Variable name "Statuses" does not follow follow standards as CamelCase and this variable is not needed as Title
	itself would do the job */
	@FindBy(linkText = "Statuses")
	private WebElement Statuses;
	
	public void clickStatus()
 	{
		hoverOverElementUsingJS(Title);
		Title.click();
		/* I suppose afte hovering to Statuses element above Title.click() would complete the job of this method
		No need to click on Statuses.click() */
		Statuses.click();
		
 	}
	
	@FindBy(linkText = "Priorities")

	//Variable name is not following the camcelcase standard
	private WebElement Priorities;
	
	public void clickPriorities() throws InterruptedException
 	{
		 //Thread.sleep is not required. Use implicit /explicit wait
		sleep();
		hoverOverElementUsingJS(Title);
		Title.click();
		hoverOverElementUsingJS(Priorities);
		Priorities.click();
		
 	}
	
	
	@FindBy(xpath = "//button[@class='hf-mod-create']")

	//Variable "NewStatus does not follow the naming standard like CamelCase.
	private WebElement NewStatus;
	
	public void clickNewStatus() {
		NewStatus.click();
	}

	// Variable name "StatusName" does not follow follow standards as CamelCase
	@FindBy(xpath = "//input[@aria-label='Status Name']")
	private WebElement StatusName;
	
	public void enterStatusName(String text) {
		StatusName.sendKeys(text);
	}
	
	
	@FindBy(xpath = "//div[@class='sp-preview-inner']")

	//Change the variable name to CamelCase
	private WebElement StatusColourInner;
	
	public void clickStatusColourInner() {
		StatusColourInner.click();
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Enter any valid color code format.']")
	//Variable name "StatusColour" does not follow follow standards as CamelCase
	private WebElement StatusColour;
	
	public void enterStatusColour(String text) {
		clickStatusColourInner();
		StatusColour.clear();
		StatusColour.sendKeys(text);
		clickStatusColourInner();
	}
	
	
	@FindBy(xpath = "//div[@aria-label='Behavior']")
	//Variable name "StatusColour" does not follow follow standards as CamelCase
	private WebElement Behavior;

	//Behaviour is not textbox. It is a drowndown. Logic is incorrect.
	public void enterBehavior(String text) {
		Behavior.click();
		Behavior.sendKeys(text);
		Behavior.sendKeys(Keys.ENTER);

	}

	//Variable name "StatusDescription" does not follow follow standards as CamelCase
	@FindBy(xpath = "//textarea[@aria-label='Description']")
	private WebElement StatusDescription;
	
	public void enterStatusDescription(String text) {
		StatusDescription.clear();
		StatusDescription.sendKeys(text);
	}

	//Variable name "AddStatus" does not follow follow standards as CamelCase
	@FindBy(xpath = "//button[@data-test-id='add-status']")
	private WebElement AddStatus;
	
	public void clickAddStatus() {
		AddStatus.click();
	}
	
		@FindBy(xpath = "//a[@data-test-id='manage-statuses-left-nav']")
		//Correct the variable name into CamelCase
		private WebElement StatusesSection;
		
		public void clickStatusesSection() throws InterruptedException {
			scrolltoElement(StatusesSection);
			StatusesSection.click();
		}
		
		
		public void setDefaultStatus(String xpath) throws InterruptedException {                        
			String Status = "//div[contains(text(),'"+xpath+"')]//following::td[3]";
			WebElement abc = driver.findElement(By.xpath(Status));
			hoverOverElementUsingJS(abc);
		    abc.click();
		}	
		
	
	@FindBy(xpath = "//a[contains(text(),'Priorities')]")
	//Variable name "PrioritySection" does not follow follow standards as CamelCase
	private WebElement PrioritySection;

	public void clickPrioritySection() {
		PrioritySection.click();
	}

	/* This is absolute Xpath.Very higher chance to prone to breakage
	 and it is slow.Recommened to change to relative xpath
	 AND Variable name "PrioritySection" does not follow follow standards as CamelCase */
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")
	private WebElement NewPriority;
	
	public void clickNewPriority() {
		NewPriority.click();
	}
	
	@FindBy(xpath = "//input[@data-test-id='form-field-name']")
	// Variable name "PrioritySection" does not follow follow standards as CamelCase
	private WebElement PriorityName;
	
	public void enterPriorityName(String text) {
		PriorityName.clear();
		PriorityName.sendKeys(text);
	}

	/* This is absolute Xpath.Very higher chance to prone to breakage
	 and it is slow.Recommened to change to relative xpath
	 AND Variable name "PriorityDescription" does not follow follow standards as CamelCase */

	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")
	private WebElement PriorityDescription;
	
	public void enterPriorityDescription(String text) {
		PriorityDescription.clear();
		PriorityDescription.sendKeys(text);
	}
	
	@FindBy(xpath = "//textarea[@data-test-id='form-field-helpText']")
	// Variable name "PriorityHelpText" does not follow follow standards as CamelCase
	private WebElement PriorityHelpText;
	
	public void enterPriorityHelpText(String text) {
		PriorityHelpText.clear();
		PriorityHelpText.sendKeys(text);
	}
	
	@FindBy(xpath = "//button[@data-test-id='add-priority']")

	// Variable name "AddPriority" does not follow follow standards as CamelCase
	private WebElement AddPriority;
	
	public void clickAddPriority() {
		AddPriority.click();
	}
	
	
	public void setDefaultPriroity(String xpath) throws InterruptedException {
		
	    String priority = "//span[contains(text(),'"+xpath+"')]//following::td[3]";
		WebElement pqr = driver.findElement(By.xpath(priority));
		hoverOverElementUsingJS(pqr);
	    pqr.click();

		//Recommened to use Implicit Wait and Explicit Wait. Thread.Sleep is not recommended.
	    sleep();
	    sleep();
	    
	}	
	
	public void ClickAddedPriority(String xpath) throws InterruptedException {
		//Thread.sleep is not recommended. Use implicit wait or explicit wait
		sleep();
		String priority = "//span[contains(text(),'"+xpath+"')]";
	    scrolltoElement(priority);
	    driver.findElement(By.xpath(priority)).click();


	}
	
	@FindBy(xpath = "//a[@data-test-id='priority-delete-trigger']")

	//Variable name is not meeting the codingstandards
	private WebElement PriorityDeleteLink;
	
	public void clickPriorityDeleteLink() throws InterruptedException {
		scrolltoElement(PriorityDeleteLink);
		PriorityDeleteLink.click();
	}
	
		@FindBy(xpath = "//span[contains(text(),'Choose Priority')]") 
		private WebElement NewDefaultPriority;
		
		@FindBy(xpath = "//input[contains(@class,'ember-power-select-search-input')]") 
		private WebElement ChoosingNewDefaultPriority;
		
		public void setNewDefaultPriority() throws InterruptedException {
			hoverOverElementUsingJS(NewDefaultPriority);
			NewDefaultPriority.click();
			ChoosingNewDefaultPriority.click();
			ChoosingNewDefaultPriority.sendKeys("Low");
			ChoosingNewDefaultPriority.sendKeys(Keys.ENTER);
		}
	
	@FindBy(xpath = "//button[@data-test-id='delete-dependants-primary-action']")
	//Varible Name is not meeting the coding standard
	private WebElement DeleteConfirm;
	
	public void clickDeleteConfirm() throws InterruptedException{
		DeleteConfirm.click();
		// Use implicit OR explicit wait.
		Thread.sleep(5000);
	}
	

	public void ClickAddedStatus(String xpath) throws InterruptedException {
		//Thead.sleep is not recommended
		sleep();
		String Status = "//div[contains(text(),'"+xpath+"')]";
	    scrolltoElement(Status);
	    driver.findElement(By.xpath(Status)).click();;


	}
		
	@FindBy(xpath = "//a[@data-test-id='status-delete-trigger']")

	//Variable name is not meeting the coding standards
	private WebElement StatusDeleteLink;
		
	public void clickStatusDeleteLink() throws InterruptedException {  
		scrolltoElement(StatusDeleteLink);
		StatusDeleteLink.click();
	}
	
			@FindBy(xpath = "//span[contains(text(),'Choose Status')]") 
			private WebElement NewDefaultStatus;
			
			public void setNewDefaultStatus() throws InterruptedException {
				hoverOverElementUsingJS(NewDefaultStatus);
				NewDefaultStatus.click();
				NewDefaultStatus.sendKeys(Keys.DOWN);
				NewDefaultStatus.sendKeys(Keys.ENTER);
			}
		
	@FindBy(xpath = "//iframe[@id='hfc-frame']") 
	private WebElement ToFrames;
		
	public void switchToFrames() {
		switchToFrame(ToFrames);
	}	
		
	public void switchToDefaultPage() {
		switchToDefaultContent();
	}	
		
	// Xpath is prone to breakage as it is lengthy
	@FindBy(xpath = "//div[@class='hf-avatar-image-container ember-view']//img[@class='hf-avatar-image hf-avatar-image_show']")
	private WebElement Profile;

	public void clickProfile() throws InterruptedException{
		//Thread.sleep is not recommended. Use implicit or explicit wait
		sleep();
		waitForVisible(Profile);
		Profile.click();
	}
	
	
	@FindBy(xpath = "//a[text()='Logout']")
	//Variable name is not using the camelCase
	private WebElement Logout;
		
	public void clickLogout() {
		Logout.click();
	}
	
	public void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}
}

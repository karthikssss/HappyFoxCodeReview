package CommonTests;

//unsed import statement.
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Admin_Portal.AdminPortalTest1;
import Admin_Portal.AdminPortalTest1stPage;
import Admin_Portal.AdminPortalTest2ndPage;
import Admin_Portal.Login_Page;
import CustomerPortal.SupportPortalPage;
import webdriverbase.BaseTest;

	/* Data has been hard coded for the all variable values.It would be good to use ApachePOI to read
	input from Xcel or any other library to get input from other sources to achieve data driving testing */

public class CommonTests1 extends BaseTest{
	/*Variable name "hploginpage is not following the CamelCase.It should be renamed as "hpLoginPage"
	for better readability*/
public Login_Page hploginpage;

public SupportPortalPage hpSupportPortalPage;

	/*It would be good to change to more meaningfull varaible name for "hpAdminPortalTest1"
  	depending on functionality */

public AdminPortalTest1stPage hpAdminPortalTest1;

	/*It would be good to change to more meaningfull varaible name for "hpAdminPortalTest1"
	depending on functionality.*/
public AdminPortalTest2ndPage hpAdminPortalTest2;

	/*Variable name "AdminPortalURL" is not following the CamelCase.It should be renamed as
	"adminPortalURL" for better readability*/
public String AdminPortalURL = "https://interview.supporthive.com/staff";

	/*Variable name "SupportTicketURL" is not following the CamelCase.It should be renamed as "supportTicketURL"
	 for better readability*/
public static String SupportTicketURL = "https://interview.supporthive.com/new/";

public static String browser = "Chrome";
public static String username = "interview_agent";
public static String password = "Interview@123";
public static String statusName = "Issue created";
public static String priorityName = "Assistance required";

//Variable name does not start with small letter. It should be renamed to "subject" for readability
public static String Subject = "Test Ticket raised by XYZ";

//Variable name does not start with small letter. It should be renamed to "subject" for readability
public static String Message = "Hi, i am having certain issues in the Happy fox portal. Can you please help me.";

//Variable name does not start with small letter. It should be renamed to "fullname" for readability
public static String FullName = "Reese Harrold";

//Variable name does not start with small letter. It should be renamed to "fullname" for readability
public static String Email = "testno100@gmail.com";


public void loginasAdmin() {

	//Variable name "Methodname" does not follow naming standards. It should be in camelcase.
    String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();

	//Instead of sout, use any logging framework for more readablity.
	System.out.println("Start of LoginAsAdmin "+"MethodName : "+Methodname); 

	try
	{
		/* Fix naming standard problems: Change "hploginpage" to "hpLoginPage" globally,
		Methods like navigateToHappyFoxHomePageURL, enterUsername,
		enterPassword, clickLoginbutton,validatePendingTicketsTitle are not implemented in the Login_Page.
		Please implement these methods */.

		/*Instead of sout statement, please use any logging framework statement for better readability
		and use Assert statement in order to validate the expected responses for better validation */

		/* The line Login_Page(getDriver()) won't work because there aren't any constructors in the
		Login_Page class. To fix this, we need to add constructors named Login_Page and Login_Page(WebDriver driver)
		to the Login_Page class. Another option is to change the way we create instances by either using the
		constructor of the BasePage class or by calling the constructor of the outer class and then the inner class.

		AND putting "_" in class Name is not good practise.
		 */

		hploginpage = new Login_Page(getDriver());
		hploginpage.navigateToHappyFoxHomePageURL(AdminPortalURL);
		hploginpage.enterUsername(username);
		System.out.println("username entered");
		hploginpage.enterPassword(password);
		System.out.println("password entered");
		hploginpage.clickLoginbutton();
		System.out.println("login clicked");
		hpAdminPortalTest1=hploginpage.validatePendingTicketsTitle();

	}
 	/*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */
	catch(Throwable t)
	{
		t.printStackTrace();
		Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	}
	
	
}
  
  public void CreatingSupportTicket() {

	  //Variable name "Methodname" does not follow naming standards. It should be in camelcase.
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();
	  //Instead of sout, use any logging framework for more readablity.
	  System.out.println("Start of Client support ticket "+"MethodName : "+Methodname); 
	  
	  try 
	  {
		    
		  hpSupportPortalPage = new SupportPortalPage(getDriver());
		  hpSupportPortalPage.navigateToHappyFoxSupportPortalURL(SupportTicketURL);
		  hpSupportPortalPage.enterSubject(Subject);
		  hpSupportPortalPage.enterMessage(Message);
		  hpSupportPortalPage.clickAddCC();
		  hpSupportPortalPage.clickAddBCC(); 
		  hpSupportPortalPage.enterFullName(FullName);
		  hpSupportPortalPage.enterEmail(Email);
		  hpAdminPortalTest2=hpSupportPortalPage.clickCreateTicket();
		  /* Instead of sout using any logging framework to log and use Assert statement to validate the
		   expected result */
		  System.out.println("Ticket created");
		  hpAdminPortalTest2.gotoAgentPortal();
	  
	  }
	       /*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */
	  catch (Throwable t) {
		  
		    t.printStackTrace();
			Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	  }
  }

  /* Replace sout statement in method TestCase2() with any logging framework to better readabiliyt and use Assert to validate the
expected result
 */
  public void TestCase1() {

		try {
			
			String Classname = getClass().getSimpleName();
          System.out.println("start of method : " + Classname);
          hpAdminPortalTest1=hploginpage.validatePendingTicketsTitle();
          hpAdminPortalTest1.clickStatus();
          hpAdminPortalTest1.clickNewStatus();
          System.out.println("New Status process started");
          hpAdminPortalTest1.enterStatusName(statusName);
          System.out.println("status name entered");
		  // Below has to commented out to enter color.
          //hpAdminPortalTest1.enterStatusColour("#21d0d5"); //#21d0d5 skyblue, #21d567 green
          System.out.println("colour set");

		  //Behaviour is not a textbox. In the image it looks like a drown down. Below method logic will not work
          hpAdminPortalTest1.enterBehavior("Pending");

          hpAdminPortalTest1.enterStatusDescription("Status when a new issue ticket is created in HappyFox");
          System.out.println("description added");
          hpAdminPortalTest1.clickAddStatus();
          System.out.println("Status added");
          hpAdminPortalTest1.setDefaultStatus(statusName); 
          hpAdminPortalTest1.clickPrioritySection();
          hpAdminPortalTest1.clickNewPriority();
          System.out.println("New priority process started");
          hpAdminPortalTest1.enterPriorityName(priorityName);
          hpAdminPortalTest1.enterPriorityDescription("Priority of the newly created tickets");
          hpAdminPortalTest1.enterPriorityHelpText("priority helptext");
          hpAdminPortalTest1.clickAddPriority();
          hpAdminPortalTest1.setDefaultPriroity(priorityName);
          System.out.println("Priority added");    
				
		} 
		/*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */
		catch (Throwable e) {
			e.printStackTrace();
		}
		
	
} 

/*
	1.Replace sout statement in method TestCase2() with any logging framework to better readabiliyt and use Assert to validate the
expected result
	2.Change the method name to camelcase.
	3.System.out.println("start of method : " + Classname); Here classname should be changed the methodName

 */
  public void TestCase2() {
		
		try {
			String Classname = getClass().getSimpleName();
          System.out.println("start of method : " + Classname);
          CreatingSupportTicket();

		  //This method is not available in the Login_Page.
          hploginpage.validatePendingTicketsTitle1();
          hpAdminPortalTest2.clickPendingTickets();
          System.out.println("Pending tickets clicked");
          hpAdminPortalTest2.openCustomerTicket(Subject);
          
          //Assertion of the Priority and Status of the ticket created

			/* This will return false as the name passed is Reese Harrold */
          Assert.assertEquals(hpAdminPortalTest2.getContactName(),"Aravind");
          Assert.assertEquals(hpAdminPortalTest2.getEmailtxt(),Email);
          
          hpAdminPortalTest2.clickReplyButton();
          Assert.assertEquals(hpAdminPortalTest2.getStatustxt(),statusName);
          Assert.assertEquals(hpAdminPortalTest2.getPrioritytxt(),priorityName.toUpperCase());
          
          hpAdminPortalTest2.clickCannedAction();
          hpAdminPortalTest2.clickSearchCannedAction("Reply to Customer Query");
          hpAdminPortalTest2.clickApplyCannedAction();
          
          //Assertion of the Priority and Status of the ticket after edition
          Assert.assertEquals(hpAdminPortalTest2.getStatustxt(),"Closed");
          Assert.assertEquals(hpAdminPortalTest2.getPrioritytxt(),"Medium");
          hpAdminPortalTest2.sendReply(); 
          hpAdminPortalTest1=hpAdminPortalTest2.closeTheTicket();
          hpAdminPortalTest1.clickPriorities();
          System.out.println("Test Case 2 over");
          
		}

		/*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */

		catch(Throwable t) {
			 t.printStackTrace();
		}
}
	/*
      1.Replace sout statement in method TestCase3() with any logging framework to better readabiliyt and use Assert to validate the
  expected result
      2.Change the method name to camelcase.
   */
  public void TestCase3() {
		
		try {
			
			String Classname = getClass().getSimpleName();
			hpAdminPortalTest1.setDefaultPriroity("Low");
			System.out.println("Default priority set as Low");
			hpAdminPortalTest1.ClickAddedPriority(priorityName);
			System.out.println("Priority clicked");
			hpAdminPortalTest1.clickPriorityDeleteLink();
			hpAdminPortalTest1.clickDeleteConfirm();
			System.out.println("Priority deleted");  
			hpAdminPortalTest1.clickStatusesSection();
			hpAdminPortalTest1.setDefaultStatus("New");
			System.out.println("Default status set as New");
			hpAdminPortalTest1.ClickAddedStatus(statusName);
			System.out.println("Statuses clicked");
			hpAdminPortalTest1.clickStatusDeleteLink();
			//hpAdminPortalTest1.setNewDefaultStatus();
			hpAdminPortalTest1.clickDeleteConfirm();
			System.out.println("Statuses deleted");  
			hpAdminPortalTest1.clickProfile();
            hpAdminPortalTest1.clickLogout();
            System.out.println("Logged out successfully"); 
			
				
		} 
		/*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */
		catch (Throwable e) {
			e.printStackTrace();
		}
		
	
} 
}

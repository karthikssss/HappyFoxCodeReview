
//The package name is not in lower case letters. It can be renamed as com.fox.admin_portal for better readability.
package Admin_Portal;

//Unused import statement. It is recommended to remove it to enhance code readability.
import org.seleniumhq.jetty9.util.log.LoggerLog;

import org.testng.Assert;

import org.testng.annotations.Test;

import CommonTests.CommonTests1


 public class AdminPortalTest1 extends CommonTests1  {

  @Test

  /* Method Name is not following the naming standard and not having meaningfull name specific to functionality. Scenario1() name
  is more generic.*/
  public void Scenario1() {

      // Variable name is not following the CamelCase. It should be renamed "methodName" for better readability.
	   String Methodname = new Object(){}.getClass().getEnclosingMethod().getName();

      try {

            //Variable name is not following the CamelCase.It should be renamed as "className" for better readability
             String Classname = getClass().getSimpleName();

            /* It should use "methodName" as the variable instead of className since it says "start of method"
            & instead of sout statement we can use any logging framework to better readability */
             System.out.println("start of method : " + Classname);

            //The method name does not follow CamelCase. It can be renamed as loginAsAdmin() for better readability.
             loginasAdmin();

            //The method name does not follow CamelCase. It can be renamed as testCase1() for better readability.
             TestCase1();

            //The method name does not follow CamelCase. It can be renamed as testCase3() for better readability.
             TestCase3();
				
		}

      /*Change the exception handling to be more specific. You can use Exception class or a more specific type of
      exception for better error handling. */

		catch (Throwable e) {
			e.printStackTrace();
			Assert.fail("Error in "+ Methodname +" : "+ e.getMessage());
		}

  } 
  
 }
 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;

public class Helloword_total {
	
	public static void main(String[] args) {

		
	       // Initialize the eyes SDK and set your private API key.
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\miracle\\Downloads\\chromedriver_win32\\chromedriver.exe");
	       Eyes eyes = new Eyes();
	      // eyes.setApiKey("2Dw5101Ql32LWT5U4CANwu9wCetWWsJqaypRXNNu66A1A110");
		   //Set only once per Jenkins job
		BatchInfo mybatch = new BatchInfo(System.getenv("APPLITOOLS_BATCH_NAME")); 
		System.out.println("my batch"+mybatch);
		mybatch.setId(System.getenv("APPLITOOLS_BATCH_ID"));
		//End of - Set only once per Jenkins job
		eyes.setBatch(mybatch);
		String apiKey = System.getenv("APPLITOOLS_API_KEY");
		System.out.println("API KEY"+apiKey);
        eyes.setApiKey(apiKey);
	       WebDriver driver = new ChromeDriver();

	
 

      try {
        	 eyes.open(driver, "Hello World!", "My first Selenium Java test!",
                     new RectangleSize(800, 600));
            driver.get("https://applitools.com/helloworld2");
            
            eyes.checkWindow("Before enter name");                 // Visual checkpoint 1

            driver.findElement(By.id("name")).sendKeys("My Name");  //enter the name
            eyes.checkWindow("After enter name");                  // Visual checkpoint 2

            driver.findElement(By.tagName("button")).click();      // Click the  button
            eyes.checkWindow("After Click");                       // Visual checkpoint 3

            TestResults result = eyes.close(false); //false means don't thow exception for failed tests
            handleResult(result);
        } finally {
            eyes.abortIfNotClosed();
        }
    }



	private static void handleResult(TestResults result) {
		// TODO Auto-generated method stub
		String resultStr;
	    String url;
	    if (result == null) {
	        resultStr = "Test aborted";
	        url = "undefined";
	    } else {
	        url = result.getUrl();
	        int totalSteps = result.getSteps();
	        if (result.isNew()) {
	            resultStr = "New Baseline Created: " + totalSteps + " steps";
	        } else if (result.isPassed()) {
	            resultStr = "All steps passed:     " + totalSteps + " steps";
	        } else {
	            resultStr = "Test Failed     :     " + totalSteps + " steps";
	            resultStr += " matches=" +  result.getMatches();      /*  matched the baseline */
	            resultStr += " missing=" + result.getMissing();       /* missing in the test*/
	            resultStr += " mismatches=" + result.getMismatches(); /* did not match the baseline */
	        }
	    }
	    resultStr += "\n" + "results at " + url;
	    System.out.println(resultStr);
	}
	}






import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class Submit {  
	
	
	WebDriver driver;
	Eyes eyes;
	String TestName;
	
	@Before
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\miracle\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser=new ChromeDriver();
		eyes=new Eyes();
		//eyes.setApiKey("qKlqIJX7ro107C53Iq8jelF3gkFO3F3pCPQTXv7S43Rgc110");
		eyes.setApiKey("2Dw5101Ql32LWT5U4CANwu9wCetWWsJqaypRXNNu66A1A110");
	    driver=eyes.open(browser, "application",TestName,new RectangleSize(1000,600));
	}
	
	@Rule
    public TestWatcher watcher=new  TestWatcher() {
		
		@Override
		
		protected void starting(Description discription) {
			TestName=discription.getDisplayName();
	}
};
	
	@After
	public void TearDown() {
		
		driver.quit();
	}
   
	
	@Test
	public void Login() throws InterruptedException {
		
		driver.navigate().to("https://www.facebook.com/");
		eyes.checkWindow("login form");
		driver.findElement(By.id("email")).sendKeys("002kumarharish");
		driver.findElement(By.id("pass")).sendKeys("9866539941");
		driver.findElement(By.id("loginbutton")).click();
		eyes.checkWindow("login");
		eyes.close();
		driver.close();
	}
	
}

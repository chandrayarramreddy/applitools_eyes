import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;

public class Image_compare_HelloWorld {

	public static void main(String[] args) throws InterruptedException {

		// Open a Chrome browser.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\miracle\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Initialize the eyes SDK and set your private API key.
		Eyes eyes = new Eyes();
		//eyes.setApiKey("o56yRL2H10scuzrsd99t14Nwv106d16eh5oMQ8zZfFjz4U110");
		eyes.setApiKey("2Dw5101Ql32LWT5U4CANwu9wCetWWsJqaypRXNNu66A1A110");
		

		try {

			// Start the test and set the browser's viewport size to 800x600.
			eyes.open(driver, "Hello World!", "My first Selenium Java test!", new RectangleSize(800, 600));

			// Navigate the browser to the "hello world!" web-site.
			// driver.get("https://applitools.com/helloworld");
			driver.get("http://www.miraclesoft.com/");

			// Visual checkpoint #1.
			// eyes.checkWindow("Hello!");
			eyes.checkWindow("Miracle");

			// Click the "Click me!" button.
			// driver.findElement(By.tagName("button")).click();
			//driver.wait(10000);
		
			// Visual checkpoint #2.
			eyes.checkWindow("Miracle");

			// End the test.
			eyes.close();

		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the
			// test as aborted.
			eyes.abortIfNotClosed();
		}

	}

}
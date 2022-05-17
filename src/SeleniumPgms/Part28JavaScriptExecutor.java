package SeleniumPgms;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part28JavaScriptExecutor
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']/a/img"));
		WebElement element = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].style.border='3px solid red'", logo);		//Drawing border
		TakesScreenshot ts = (TakesScreenshot)driver;								//Takes Screenshot
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screencapture\\img1.png");
		FileUtils.copyFile(src, trg);
		
		System.out.println(js.executeScript("return document.title;").toString());	//Getting title of the page
		js.executeScript("arguments[0].click();",element);							//click action
	//	js.executeScript("history.go(0)");											//Refreshing the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");			//Scrolling down page
	//	js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");			//Scroll up page
	//	js.executeScript("document.body.style.zoom='50%'");							//Zoom Page
	//	js.executeScript("alert(' msg ') ");										//Generate alert
		
		WebElement electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a"));	//Flashing of element
		String bgcolor = electronics.getCssValue("backgroundColor");
		for(int i=0; i<50; i++) {
			js.executeScript("arguments[0].style.backgroundColor = '"+ bgcolor+ "'", electronics);
			js.executeScript("arguments[0].style.backgroundColor = '#000000'", electronics);				//Changing color
			}
	
		Thread.sleep(6000);
		driver.quit();
	}
}

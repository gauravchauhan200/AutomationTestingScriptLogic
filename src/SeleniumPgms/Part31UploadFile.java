package SeleniumPgms;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//upload file using SendKeys
public class Part31UploadFile 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");	// disables WebPush notifications
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.monsterindia.com/");
		
		
		driver.findElement(By.xpath("//span[text()='Upload Resume']")).click();
		driver.findElement(By.xpath("/html/body/div[3]/section[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/section/div/form/div[1]/div[1]/div/div/input[1]")).sendKeys("C:\\Users\\GC\\Downloads\\file-sample_150kB.pdf");
		 
		By element = By.xpath("/html/body/div[3]/section[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/section/div/form/span/input");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));		
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		driver.findElement(element).click();
	
		Thread.sleep(15000);
		driver.quit();
	}
}

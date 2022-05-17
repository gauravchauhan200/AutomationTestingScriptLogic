package SeleniumPgms;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Part19ExplicitWait 
{
	public static void  main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GC\\Desktop\\selenium components\\chromedriver.exe");
		WebDriver	driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium"+Keys.RETURN);
			
		By textBoxEle =  By.xpath("//h3[text()='Selenium']");		
		webDriverWaitMethod(driver, textBoxEle, 10).click();
		
		By readElement = By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase font-weight-bold']");
		webDriverWaitMethod(driver, readElement, 10).click();	
		
		Thread.sleep(3000);
		driver.quit();
	}

	static WebElement webDriverWaitMethod(WebDriver driver , By locator,int timeout)	
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
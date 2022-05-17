package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Part19Synchronization 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--diasable-notifications");
		WebDriver driver = new ChromeDriver(o);	
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();	
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q' or  @title='Search']")).sendKeys("Selenium"+Keys.RETURN);
		
		
	//	Here Repetition of Code  for WebDriverWait	
		
		WebElement textBoxEle = driver.findElement(By.xpath("//h3[text()='Selenium']"));
				
		WebDriverWait	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement textBoxEleAvail = wait.until(ExpectedConditions.visibilityOf(textBoxEle));
		textBoxEleAvail.click();
	
		
		WebElement readElement =driver.findElement(By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase font-weight-bold']"));
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement readElementAvail = wait1.until(ExpectedConditions.visibilityOf(readElement));
		readElementAvail.click();	
		
		
		Thread.sleep(4000);
		driver.quit();
	}
}

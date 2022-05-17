package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part17HandlingAlerts 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");	
		
		ChromeOptions o=  new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert1 =driver.switchTo().alert();
		alert1.accept();
	 	
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alert2 =driver.switchTo().alert();
		Thread.sleep(3000);
		alert2.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert3 =driver.switchTo().alert();
		alert3.sendKeys("gaurav chauhan");
		alert3.accept();
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}
package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class Part27getLocation 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
		driver.get("https://demo.nopcommerce.com/");
		WebElement element = driver.findElement(By.xpath(" //button[@class='button-1 search-box-button']"));
		
		//Method--1	Location
		System.out.println(element.getLocation());
		
		//Method--2
		System.out.println(element.getRect().getWidth());
		System.out.println(element.getRect().getHeight());
		
		//Method--3
		System.out.println(element.getRect().getDimension().getWidth());
		System.out.println(element.getRect().getDimension().getHeight());
		
		//Method--4
		System.out.println(element.getSize());
	
		
		
		
		
		Thread.sleep(6000);
		driver.quit();
	}
	
	
	
	
}

package SeleniumPgms;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part05Navigation 
{
	public static void main(String[] args) throws InterruptedException 
	{	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Dimension d=new Dimension(420,600);
		driver.manage().window().setSize(d);

		driver.navigate().to("http://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");	
		driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[@class='bxc-grid__image   bxc-grid__image--light']")).click();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.close();
		
		
	}
}

package SeleniumPgms;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part20WebTableElementCapture 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o=  new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver =  new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
		Set <String> winIds = driver.getWindowHandles();
		ArrayList	<String> winIdsList	= new ArrayList<String>(winIds); 
	
		for(String winId : winIdsList)
		{
			driver.switchTo().window(winId);
			System.out.println("Title of Current Page : "+driver.getTitle());
		}	
		WebElement	username=driver.findElement(By.xpath("//input[@name='username']"));
		username.clear();
		username.sendKeys("demo");
		WebElement	password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("demo");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/a[@class='parent collapsed']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse26']/li[1]/a")).click();
		
		
	//HandlingTable
		
		int rows= driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
		int cols =driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[1]/td")).size();
		
		System.out.println("Total Rows : "+rows);
		System.out.println("Total Cols : "+cols);
		
		for(int i=1;i<=rows;i++)
		{	
			String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[4]")).getText();
			
			if(status.equalsIgnoreCase("pending"))
			{
				for(int j=1;j<=cols-1;j++)
				{
					String col_data	=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.print(col_data+"		");
				}
				System.out.println();
			}	
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}

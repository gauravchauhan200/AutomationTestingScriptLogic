package SeleniumPgms;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part15WindowHandles 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		
/*
		Set <String> winIds =driver.getWindowHandles();
	
		Iterator <String> it=winIds.iterator();
		String parentId = it.next();		
		String childId=it.next();
		
		System.out.println(parentId);
		System.out.println(childId);
*/		
	
		//Converting set to List 
		Set <String> winIds=driver.getWindowHandles();
		ArrayList <String> winIdsList = new ArrayList(winIds);
		
		
		for(String winId : winIdsList)
		{
			System.out.println(winId);
			driver.switchTo().window(winId);
			System.out.println(driver.getTitle());
		}
		
		
		
		Thread.sleep(7000);
		driver.quit();
	}

}

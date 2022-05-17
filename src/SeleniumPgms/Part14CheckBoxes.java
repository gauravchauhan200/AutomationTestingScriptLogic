package SeleniumPgms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part14CheckBoxes 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://itera-qa.azurewebsites.net/home/automation");
/*	
	// 1 Selecting Single Checkbox
	
		driver.findElement(By.xpath("//input[@type='checkbox' and contains(@id,'monday')]")).click();
*/
	
	
	
/*	
	// 2 Selecting multiple Checkbox
	 
	 List <WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
	
	 for(WebElement ele : list)
	 {
		 ele.click();
	 }
*/
	
	// 3 Selecting particular checkboxes
	 
	List <WebElement> list=driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));
	 for(int i=0;i<=list.size()-1;i++)
	 {
		 list.get(i).click();
	 }
	 
	Thread.sleep(8000);
	driver.close();	
	
	}
}

package SeleniumPgms;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Part11DropDownSorted 
{
	//click on liveposting
	//Performing operation on Search box ALL elements sorting and comparing them
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.twoplugs.com/");

		
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		WebElement drpCateg=driver.findElement(By.xpath("//select[@name='category_id']"));
		
		Select drpOption = new Select(drpCateg); 
		List <WebElement> allOptions =drpOption.getOptions();
		
		ArrayList originalEleList = new ArrayList(); 
		ArrayList tempEleList = new ArrayList(); 
		
		for(WebElement option:allOptions)
			{
				originalEleList.add(option.getText());
				tempEleList.add(option.getText());
			}
		
		Collections.sort(tempEleList);
		
		System.out.println("OrignalList : "+originalEleList);
		System.out.println("SortedList : "+tempEleList);
		
		if(originalEleList.equals(tempEleList))
		{
		System.out.println("DropDown not Sorted sorted");	
		}
		else
		{
			System.out.println("DropDown  sorted");
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}

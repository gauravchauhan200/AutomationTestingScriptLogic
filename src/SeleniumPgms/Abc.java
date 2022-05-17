package SeleniumPgms;

import java.io.IOException;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Abc 
{
	public static void main(String args[]) throws IOException, InterruptedException
	{
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GC\\Desktop\\selenium components\\chromedriver.exe");
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		
	//	selectChoiceValue(driver,"choice 1");
		selectChoiceValue(driver,"choice 1","choice 2","choice 2 1 ");
	//	selectChoiceValue(driver,"all");
	
		driver.quit();
		
	}
	

	public static void selectChoiceValue(WebDriver driver ,String... value)
	{
		List <WebElement> allChoice = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
	
		if(value[0].equalsIgnoreCase("all"))
		{
			for(WebElement ele: allChoice)
			{
				ele.click();
			}
		}
		
		else
		{
			for(WebElement ele :allChoice)
			{
				String text =ele.getText();
				
				for(String val: value)
				{
					if(text.equalsIgnoreCase(val))
					{
						ele.click();
						break;
					}
				}
			}
			
		}
		
	}
	
	
	
	
}
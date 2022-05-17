package SeleniumPgms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part10JDropDownJquery 
{
	//https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
	//Select multipleChoicevalues
	//selectChoiceValue(driver,"choice 1");
	//selectChoiceValue(driver,"choice 1","choice 2","choice 2 1");
	//selectChoiceValue(driver,"all");	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions o=new ChromeOptions();
		o.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		
	//	selectChoiceValue(driver,"choice 1");
		selectChoiceValue(driver,"choice 1","choice 2","choice 2 1");
	//	selectChoiceValue(driver,"all");	
		
		
		Thread.sleep(4000);
		driver.quit();

	}
	
	public static void selectChoiceValue(WebDriver driver, String... value) //String ...  can hold multiple value
	{
		List <WebElement>	choiceList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item:choiceList)
			{
				String text =item.getText();
			
				for(String val:value)
				{
					if(text.equalsIgnoreCase(val))
					{
						item.click();
						break; 
					}
				}
			}		
		}
		else
		{
			
			try {
				for(WebElement item:choiceList)
					{
						item.click();
					}
				} 
			catch (Exception e) 
				{
					e.getStackTrace();
				}
		}
	}

}

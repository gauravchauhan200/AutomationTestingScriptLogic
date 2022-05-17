package SeleniumPgms;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part22DatePicker 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		String date = "16";
		String year = "2022";
		String month = "July";
		
		while(true)	//selecting month and year in loop
		{
			String month_yr = driver.findElement(By.xpath("//table//tbody/tr[@class='rb-monthHeader']/td[2]")).getText();
			String arr[] = month_yr.split(" ");
			String mth = arr[0];
			String yr = arr[1];

			if(year.equalsIgnoreCase(yr) && mth.equalsIgnoreCase(month))
				break;
			else
			{driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")).click();}
		}
		
		
		List <WebElement> dates_Ele = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody//tr/td"));		
		
		for(WebElement date_Ele : dates_Ele ) 	//Selecting Only date
		{
			String dateT = date_Ele.getText();
			if(dateT.equalsIgnoreCase(date))
				date_Ele.click();
		}
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}

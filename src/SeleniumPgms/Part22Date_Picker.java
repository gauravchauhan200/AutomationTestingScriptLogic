package SeleniumPgms;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Part22Date_Picker 
{
	public static void main(String[] args) throws InterruptedException 
	{	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		String year = "1990";
		String month = "Nov";
		String date = "25";
	
		driver.findElement(By.xpath("//*[@id='dob']")).click();
		
		Select selecty = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		selecty.selectByVisibleText(year);
	
		Select selectm = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		selectm.deselectByVisibleText(month);
	
		List <WebElement> date_Elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));
		
		for(WebElement date_Element : date_Elements )
		{
			String date_Text = date_Element.getText();
			System.out.println(date_Text);
			
			if(date.equals(date_Text));	// issue here
			{
				date_Element.click();
				break;
			}
		}
		Thread.sleep(10000);
		driver.quit();
	}
}

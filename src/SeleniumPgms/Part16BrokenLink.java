package SeleniumPgms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Part16BrokenLink 
{
	public static void main(String args[]) throws InterruptedException, IOException
	{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		
		ChromeOptions o =  new ChromeOptions();
		o.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.get("http://www.deadlinkcity.com/");
		driver.get("https://www.flipkart.com/");
		
		
		List <WebElement> elements = driver.findElements(By.tagName("a"));
		String url;
		int brokenlink = 0;
		
		for(WebElement element : elements )
		{
			url= element.getAttribute("href");
			
			if(url.isEmpty() || url== null)
			{
				System.out.println("url is Empty");
				continue;
			}
			else
			{
				URL	link = new URL(url);
				try {
					HttpURLConnection 	httpConn = (HttpURLConnection)link.openConnection();
					httpConn.connect();
					
					if(httpConn.getResponseCode()>= 400)
					{
						System.out.println("This "+url+" is Broken");
						brokenlink++;
					}
					else
					{
						System.out.println(url+" This is valid Link");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Total Broken links are : "+brokenlink);
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}
}

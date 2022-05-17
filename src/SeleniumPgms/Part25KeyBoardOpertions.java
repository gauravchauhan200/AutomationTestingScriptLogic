package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Part25KeyBoardOpertions 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-noitifications");
		RemoteWebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://text-compare.com");
		
		WebElement text_box1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement text_box2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		text_box1.sendKeys(" Will Power is Enough to handle any Situation");
		
		//CTRL+a
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		//CTRL+C
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//Tab
		act.sendKeys(Keys.TAB);
		
		//CTRL+V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(text_box1.getAttribute("value").equals(text_box2.getAttribute("value")))
			{
				System.out.println(text_box1.getAttribute("value"));
				System.out.println("Text Content is same in both text box");
			}
		else
		{
			System.out.println("Text content doesnt match");
		}
		
		Thread.sleep(6000);
		driver.quit();
	}
}

package SeleniumPgms;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Part26ElementScreenShot 
{
	public static  void main(String args[]) throws InterruptedException, IOException
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.nopcommerce.com/");
		
		/*		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tar = new File(".\\screencapture\\pic.png");
		FileUtils.copyFile(src, tar);
	*/		
		WebElement noptitle = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		File scr= noptitle.getScreenshotAs(OutputType.FILE);
		File tar = new File(".\\screencapture\\pic1.png");
		FileUtils.copyFile(scr, tar);
	
		/*		
		WebElement region = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[2]/p[1]"));
		File src = region.getScreenshotAs(OutputType.FILE);
		File tar = new File(".\\screencapture\\pic3.png");
		FileUtils.copyFile(src,tar);
	*/		
		
		
		Thread.sleep(6000);
		driver.quit();
	}
}

package SeleniumPgms;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Part03Browsers 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		ChromeDriver c=new ChromeDriver();
	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		FirefoxDriver f=new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\GC\\Desktop\\selenium components\\msedgedriver.exe");
		EdgeDriver e=new EdgeDriver();
		
		c.quit();
		f.quit();
		e.quit();
	}

}

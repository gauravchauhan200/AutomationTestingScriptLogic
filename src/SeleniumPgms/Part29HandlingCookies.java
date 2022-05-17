package SeleniumPgms;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

//How to capture cookies from browser ?
//How to print cookies from browser ?
//How to add cookie to the browser ?
//How to delete specific cookie from browser ?
//How to delete all cookies from browsers
//https://demo.nopcommerce.com/

public class Part29HandlingCookies 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getPageSource());
		Set<Cookie> cookies = driver.manage().getCookies();	// cookies captured
		System.out.println(cookies.size());					// cookies size
		
		for(Cookie cookie : cookies)						// cookies printed
			{	System.out.println(cookie.getName()+" : "+cookie.getValue());
			}
		Cookie cookie = new Cookie("Gaurav123","My cookie"); 
		driver.manage().addCookie(cookie);					// add cookie by object	
		driver.manage().deleteCookie(cookie); 				// delete cookie by object
		driver.manage().deleteCookieNamed("Gaurav123");		// delete cookie by name
		driver.manage().deleteAllCookies();					// delete all cookies	
		
		Thread.sleep(3000);
		driver.quit();
	}
}

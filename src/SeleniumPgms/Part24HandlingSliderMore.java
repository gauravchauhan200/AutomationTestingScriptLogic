package SeleniumPgms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

//How to handle slider
//How to find the location and size of the WebElement   
//What is the difference between Actions and Action
//What is the difference between Build() and Perform()

public class Part24HandlingSliderMore
{		
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

		//	System.out.println("Slider loction minimum "+min_slider.getLocation());
		// How to handle slider
		
		
		WebElement min_slider= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		WebElement max_slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]"));
		
		System.out.println("Slider loction minimum "+max_slider.getLocation());
		System.out.println("Slider loction minimum "+max_slider.getRect().getWidth());
		System.out.println("Slider loction minimum "+min_slider.getRect().getWidth());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider,96,0).perform();
		act.dragAndDropBy(max_slider,-97, 0).perform();
		
		Thread.sleep(3000);		
		
		//Action is Interface user to store the action when we are imediately not performing
		driver.navigate().refresh();
		 
		WebElement min_slider1= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));

		WebElement max_slider1 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]"));
		
		
		Actions act1 = new Actions(driver);
		Action ac1 = act1.dragAndDropBy(min_slider1,150,0).build();
		Action ac2 = act1.dragAndDropBy(max_slider1,-140, 0).build();

		ac1.perform();
		ac2.perform();
		
		Thread.sleep(6000);
		driver.quit();
	}
}

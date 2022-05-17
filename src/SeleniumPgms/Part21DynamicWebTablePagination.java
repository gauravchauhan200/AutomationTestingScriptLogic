package SeleniumPgms;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part21DynamicWebTablePagination 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		driver.findElement(By.xpath("//div[@class='col-sm-6']//div[@class='demonstration-box']//a[@class='box-overlay']")).click();
		
		//Switching to childWindow
		
		Set <String> winIds = driver.getWindowHandles();
		for(String winId : winIds)
		{
			driver.switchTo().window(winId);
			System.out.println("Current Window Title is : "+driver.getTitle());
		}
		
		WebElement usn_ele = driver.findElement(By.xpath("//input[@name='username']"));
		usn_ele.clear();
		usn_ele.sendKeys("demo");
		WebElement pass_ele=driver.findElement(By.xpath("//input[@name='password']"));
		pass_ele.clear();
		pass_ele.sendKeys("demo");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//li[@id='menu-sale']/a[@class='parent collapsed']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse26']/li[1]/a")).click();
		
		
		//1 Finding Total Number of Pages and switching pages
													
		String pagenotext = driver.findElement(By.xpath("//div[@class='col-sm-6 text-right']")).getText();	//Showing 41 to 60 of 12248 (613 Pages)
		int totalpage = Integer.valueOf(pagenotext.substring(pagenotext.indexOf("(")+1,pagenotext.indexOf("Pages")-1)); //613
		
		for(int p=1;p<=totalpage;p++)
		{
			System.out.println("Page No is : "+p);
			WebElement active_page = driver.findElement(By.xpath("//div[@class='col-sm-6 text-left']/ul[@class='pagination']/li/span"));
			active_page.click();
	
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			System.out.println("No of rows : "+rows);
		
			for(int i=1;i<=rows;i++)	//2 printing table data in console
			{
				String Order_id = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")).getText();
				String Customer_name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[3]")).getText();
				String  status= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[4]")).getText();
				String total = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[5]")).getText();
				String date_add = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[6]")).getText();
				String mod_add = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[7]")).getText();
				
			//	if(status.equalsIgnoreCase("Pending"))
			//	{
					System.out.println(Order_id+"		"+Customer_name+"		"+status+"		"+total+"		"+date_add+" "+	mod_add);
			//	}
			}
				
			String q=Integer.toString(p+1);	//Incrementing value for next page
			driver.findElement(By.xpath("//div[@class='col-sm-6 text-left']/ul[@class='pagination']//li//a[text()='"+q+"']")).click();
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}

package SeleniumPgms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part32DataBaseTesting 
{
	public static void main(String[] args) throws SQLException 
	{
		//Data
		String cust_firstname = "John";
		String cust_lastname="Kenedy";
		String cust_email = "john@gmail.com";
		String cust_telPhone = "1234567890";
		String cust_password = "john123";
		
		//User
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys(cust_firstname);
		driver.findElement(By.name("lastname")).sendKeys(cust_lastname);
		driver.findElement(By.name("email")).sendKeys(cust_email);
		driver.findElement(By.name("telephone")).sendKeys(cust_telPhone);
		driver.findElement(By.name("password")).sendKeys(cust_password);
		driver.findElement(By.name("confirm")).sendKeys(cust_password);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	try 
	{
		String confmsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		
		if(confmsg.equals("Your Account Has Been Created!"))
			{	System.out.println("Registration successful from the UI?Application");	}
		else
			{	System.out.println("Registration Not Successful");}
	}
	catch(Exception e)
	{		System.out.println("Some problem in the application");}
	
	
	
	
	//--------Database validation----------	
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop","root","");
	Statement stmt = con.createStatement();
	String query = "select firstname,lastname,email,telephone from oc_customer";
	ResultSet rs = stmt.executeQuery(query);
	
	boolean status = false;
	
	while(rs.next())
	{
		String firstname = rs.getString("firstname");
		String lastname = rs.getString("lastname ");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
	
		if(cust_firstname.equals(firstname) && cust_lastname.equals(lastname)
				&& cust_email.equals(email) && cust_telPhone.equals(telephone))
		{
			System.out.println("Record found in the table || Test Passed");
			status= true;
			break;
		}
	}
	if(status == false)
	{
		System.out.println("Record Not Found || Test Failed");
	}	
	}
}

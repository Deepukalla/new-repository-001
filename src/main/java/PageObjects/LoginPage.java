package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	          
	By user=By.cssSelector("input[type='email']");
	By password= By.cssSelector("input[type='password']");
	By login= By.xpath("//input[@type='submit']");
	By text= By.xpath("//div[@class='text-center']//h2");
	By header=By.xpath("//ul[@class=\'nav navbar-nav navbar-right\']");
	
	
	
	
	
	public WebElement getuser()
	{
		return driver.findElement(user);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	public WebElement gettext()
	{
		return driver.findElement(text);
	}
	public WebElement getheader()
	{
		return driver.findElement(header);
	}
	
	
	
}

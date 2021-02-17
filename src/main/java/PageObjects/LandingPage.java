package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login= By.xpath("//i[@class='fa fa-lock fa-lg']");
	
	
	public WebElement loginlink()
	{
		return driver.findElement(login);
	}
	



}





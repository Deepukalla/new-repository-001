package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class TestHomepage extends base{
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		WebDriver driver;
		driver =intilizeDriver();
	    driver.get(prop.getProperty("url"));
		//LandingPage  l= new LandingPage(driver);
		//l.loginlink().click();
	
	

		LoginPage lp=new LoginPage(driver);
		lp.gettext().getText();
	    Assert.assertEquals(lp.gettext().getText(), "FEATURED COURSES");
	   
	    Assert.assertTrue(lp.getheader().isDisplayed());
	    
	

}
}


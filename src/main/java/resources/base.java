package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base 
{
	
public WebDriver driver;
public Properties prop;

public WebDriver intilizeDriver() throws IOException
{
	prop= new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\default.defaultpc\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	
	if(browserName.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	else if(browserName.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver","D:\\WebDrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	
	else if(browserName.equals("Internet Explorer"))
	{
		System.setProperty("webdriver.ie.driver","D:\\WebDrivers\\msedgedriver.exe");
		driver=new InternetExplorerDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
}
	
    
    public void getScreenshotPath(String testcaseName,WebDriver driver)
	{
		
	TakesScreenshot ts= (TakesScreenshot)driver;
    File source=ts.getScreenshotAs(OutputType.FILE);
    String destinationFile=System.getenv("User.dir"+"\\reports\\"+testcaseName+".png");
   // FileUtils.copyFile(source,new File(destinationFile));
    try {
		FileHandler.copy(source, new File(destinationFile));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		
	}
	
	
}














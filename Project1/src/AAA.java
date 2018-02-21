import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AAA {

	public static void Browser ( WebDriver driver ){
	    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("https://www.aaalife.com/term-life-insurance-quote-input");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("zip")).clear();
	    driver.findElement(By.id("zip")).sendKeys("48103");
	    driver.findElement(By.id("feet")).sendKeys("5");
	    driver.findElement(By.id("inches")).sendKeys("1");
	    driver.findElement(By.id("weight")).sendKeys("50");
	    driver.findElement(By.xpath("//select[contains(@id,'gender')]")).sendKeys("Female");
	    driver.findElement(By.xpath("//label[@for='nicotineUseNo']")).click();
	    driver.findElement(By.xpath("//select[@id='month']")).sendKeys("December");
	    driver.findElement(By.xpath("//select[@id='day']")).sendKeys("13");
	    driver.findElement(By.xpath("//option[@value='1990']")).click();
        driver.findElement(By.name("coverageAmount")).sendKeys("$550,000");
	    driver.findElement(By.xpath("//label[@for='isMemberNo']")).click();
        driver.findElement(By.name("termLength")).sendKeys("10 Years");
	    driver.findElement(By.cssSelector("input[type='email']")).sendKeys("mrudula.badgandi@gmail.com");
	    //driver.close();
	}
	
	void DisablePop()
	{
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		//Firefox:		
		FirefoxOptions geoDisabled = new FirefoxOptions();
	    geoDisabled.addPreference("geo.enabled", false);
	    geoDisabled.addPreference("geo.provider.use_corelocation", false);
	    geoDisabled.addPreference("geo.prompt.testing", false);
	    geoDisabled.addPreference("geo.prompt.testing.allow", false);
	    
		WebDriver firefoxDriver = new FirefoxDriver(geoDisabled);
		Browser ( firefoxDriver );
		
		Thread.sleep(5000); //Sleep just to check the UI for 5 seconds
		firefoxDriver.close();		
		
		//Chrome:		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");		

		WebDriver chromeDriver = new ChromeDriver(options);
	    Browser ( chromeDriver );
	    Thread.sleep(5000); 	//Sleep just to check the UI for 5 seconds
	    chromeDriver.close();
	}
}

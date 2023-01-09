package sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppiumInstalledAppTest {
	static WebDriver driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		dc.setCapability("appPackage", "com.google.android.calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		 driver = new RemoteWebDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(enabled = false)
	public void calculatorTest()  throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		dc.setCapability("appPackage", "com.google.android.calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		driver = new RemoteWebDriver(url, dc);
		System.out.println("device connected");
	}
	
	
	@Test(enabled = false)
	public void installed_calculatorTest()  throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		WebElement digit_8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
		WebElement digit_3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		WebElement addElement = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		WebElement equalElement = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		
		Thread.sleep(5000);
		
		digit_8.click();
		addElement.click();
		digit_3.click();
		equalElement.click();
		WebElement resultElement = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		String resultValue = resultElement.getText();
		
		System.out.println("device connected");
	}
	@Test(enabled = true)
	public void dynamicSumTotal() throws InterruptedException {
	int finalResult = getSumTotal(6, 4);
	System.out.println("Result is :" + finalResult);
	Assert.assertEquals(finalResult, 10 );
	getSumTotal(7,3,4,2,1,6);
	}
	
	public static int getSumTotal(int a, int b) throws InterruptedException {
		if (a < 10 && b < 10) {
			WebElement first_digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+a));
		WebElement second_digit = driver.findElement(By.id("com.google.android.calculator:id/digit_"+b));
		WebElement addElement = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		WebElement equalElement = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		
Thread.sleep(5000);
		
		first_digit.click();
		addElement.click();
		second_digit.click();
		equalElement.click();
		
WebElement resultElement = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		
		String resultValue = resultElement.getText();
		
		return Integer.parseInt(resultValue);
		}else {
			return 0;
		}
	}
	public static int getSumTotal(int... arr) {
		return 0;
	}
}

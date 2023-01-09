package sample;

import java.io.File;
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

public class Appium_w_InstallationFile {
	
	static WebDriver driver;
	@BeforeClass
	
	public void setup() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.ANDROID);
		dc.setVersion("12");
	    dc.setCapability("app", new File("src/main/resources/Demo.apk").getAbsolutePath());
		URL url = new URL("http://127.0.0.1:4723/wd/hub/");
		 driver = new RemoteWebDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void test() throws InterruptedException {
		WebElement item = driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[4]/android.view.ViewGroup[1]/android.widget.ImageView"));
		item.click();
		
		WebElement addToCartElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]"));
		addToCartElement.click();
		
		WebElement viewCartElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"));
		viewCartElement.click();
		
		WebElement proceedToCartElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]/android.widget.TextView"));
		proceedToCartElement.click();
		
		Thread.sleep(3000);
		WebElement loginTextElement = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView"));
			
		Assert.assertEquals(loginTextElement.getText(),"Login");
	}

}

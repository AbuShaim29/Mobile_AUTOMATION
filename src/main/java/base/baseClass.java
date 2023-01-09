package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import utils.Configuration;

public class baseClass {

	public static WebDriver driver;
	public Configuration configuration = new Configuration();
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities dc = capsForInstallationFile();
		try {
		URL url = new URL(configuration.getProperty("urlPath"));
		driver = new RemoteWebDriver(url,dc);
	}catch (MalformedURLException e) {
		e.printStackTrace();
	}
		
	}
	public  DesiredCapabilities capsForInstalledApp() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatfrom");
		if(platform.equalsIgnoreCase("android")) {
		dc.setPlatform(Platform.ANDROID);
		dc.setCapability("appActivity", configuration.getProperty("appActivity"));
		dc.setCapability("appPackage", configuration.getProperty("appPackage"));
		}else if (platform.equals("ios")) {
			dc.setPlatform(Platform.IOS);
		}
		
		dc.setVersion(configuration.getProperty("deviceVersion"));
	
	    return dc;
	}
	
	public DesiredCapabilities capsForInstallationFile() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatfrom");
		if(platform.equalsIgnoreCase("android")) {
		dc.setPlatform(Platform.ANDROID);
         dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		}else if (platform.equals("ios")) {
			dc.setPlatform(Platform.IOS);
			dc.setCapability("app", new File(configuration.getProperty("appLocation")).getAbsolutePath());
		}
		
		dc.setVersion(configuration.getProperty("deviceVersion"));
	
	    return dc;
	}
	public DesiredCapabilities capsForWebView() {
		DesiredCapabilities dc = new DesiredCapabilities();
		String platform = configuration.getProperty("devicePlatform");
		if(platform.equalsIgnoreCase("android")) {
		dc.setPlatform(Platform.ANDROID);
		
		}else if (platform.equals("ios")) {
			dc.setPlatform(Platform.IOS);
		}
		
		dc.setVersion(configuration.getProperty("deviceVersion"));
	    dc.setBrowserName(configuration.getProperty("browserName"));
	    return dc;
	}
}

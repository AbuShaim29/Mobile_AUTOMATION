package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

   public HomePage(WebDriver driver) {
	   PageFactory.initElements(driver, getClass());
   }
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\\\"store item\\\"])[4]/android.view.ViewGroup[1]/android.widget.ImageView")
	WebElement item;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"Add To Cart button\\\"]")
	WebElement addToCartElement;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"cart badge\\\"]/android.widget.ImageView")
	WebElement viewCartElement;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"Proceed To Checkout button\\\"]/android.widget.TextView")
	WebElement proceedToCartElement;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"container header\\\"]/android.widget.TextView")
	WebElement loginTextElement;
	
		public void clickItem() {
			
		}
	
	
}

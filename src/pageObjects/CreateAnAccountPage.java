package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
public WebDriver driver;
public WebDriverWait sync;
public WebElement element;
public By locator;
	public CreateAnAccountPage(WebDriver webdriver,WebDriverWait Webdriverwait)
	{
		super();
		this.driver = webdriver;
		this.sync = Webdriverwait;
	}
	
}

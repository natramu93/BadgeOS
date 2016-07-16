package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
public WebDriver driver;
public WebDriverWait sync;
public By locator;
public WebElement element;
	public HomePage(WebDriver Webdriver, WebDriverWait Webdriverwait)
	{
		super();
		this.driver=Webdriver;
		this.sync = Webdriverwait;
	}
	public WebElement Register_Link(){
		locator = By.linkText("Register");
		sync.until(ExpectedConditions.elementToBeClickable(locator));
		element = driver.findElement(locator);
		return element;
	}
	public WebElement Username_Txtbox(){
		locator = By.name("log");
		sync.until(ExpectedConditions.presenceOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	public WebElement Password_Txtbox(){
		locator = By.name("pwd");
		sync.until(ExpectedConditions.presenceOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	public WebElement Login_Btn(){
		locator = By.name("wp-submit");
		sync.until(ExpectedConditions.presenceOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
	public WebElement Login_Error(){
		locator = By.xpath("//span[@class='lwa-status lwa-status-invalid']");
		sync.until(ExpectedConditions.presenceOfElementLocated(locator));
		element = driver.findElement(locator);
		return element;
	}
}

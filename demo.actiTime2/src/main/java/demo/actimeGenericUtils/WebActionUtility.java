package demo.actimeGenericUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtility {
	
	WebDriver driver;
	JavascriptExecutor js;
	Actions action;
	public WebActionUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	public void enterData(WebElement targetElement, String KeyToEnter) {
		targetElement.clear();
		targetElement.sendKeys(KeyToEnter);
	}
	public void clickOnELement(WebElement targetElement) {
		targetElement.click();
	}
	public void javaScriptClick(WebElement targetElement) {
		js.executeScript("arguments[0].click()", targetElement);
	}
	public void enterJsData(WebElement targetElement, String keyToEnter) {
		js.executeScript("arguments[0].value='"+keyToEnter+"'", targetElement);
	}
	public void mouseHOvering(WebElement tragetElement) {
		action.moveToElement(tragetElement).perform();
	}
	public void rightClick(WebElement targetElement) {
		action.contextClick(targetElement).perform();
	}
	public void dragAndDrop(WebElement source, WebElement destination) {
		action.dragAndDrop(source, destination).perform();
	}
	public void waitAndClick(WebElement targetElement) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(targetElement));
		action.doubleClick(targetElement).perform();
	}
	
}

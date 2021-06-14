package Page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public void selectDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	public int generatedNumber(int bound) {
		Random rnd = new Random();
		int generateNumber = rnd.nextInt(bound);
		return generateNumber;

	}
	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement elementLocator) {
		WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(elementLocator));
		
	}
//	public void waitForDashboardElement(WebDriver driver, int timeInSecond, WebElement elementlocator) {
//		  WebDriverWait wait = new WebDriverWait(driver,timeInSecond );
//			wait.until(ExpectedConditions.invisibilityOf(elementlocator));
//		
//	}
	
}

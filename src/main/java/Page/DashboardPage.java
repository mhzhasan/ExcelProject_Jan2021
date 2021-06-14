package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardPage {
	WebDriver driver;
   
	public DashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),' Dashboard ')]")
	WebElement DASHBOARD_FIELD;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Customers')]")
	WebElement CUSTOMER_PAGE;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add Customer')]")
	WebElement ADD_CUSTOMER_PAGE;
	//WebElement ADD_CUSTOMER_PAGE = driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]"));
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement LIST_CUSTOMER_BUTTON;
	 
	public void verifyDashboardpage() {
		Assert.assertEquals(DASHBOARD_FIELD.getText(), "Dashboard", "wrong page");
	}
	public void clickCustomerButton() throws InterruptedException {
		Thread.sleep(3000);
		CUSTOMER_PAGE.click();
	}
	
	public void clickAddCustomerButton() throws InterruptedException  {
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("argument[0].click", ADD_CUSTOMER_PAGE);
		ADD_CUSTOMER_PAGE.click();
	}
	public void clickOnListCustomerButton() {
		LIST_CUSTOMER_BUTTON.click();
	}
}		

    



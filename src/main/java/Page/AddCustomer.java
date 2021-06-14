package Page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomer extends BasePage {
	WebDriver driver;

	public void AddCustomer(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")WebElement CUSTOMER_FULLNAME;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']")WebElement COMPANY_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")WebElement CUSTOMER_EMAIL;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")WebElement SAVE_BUTTON_ON_ADD_CONTUCT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")WebElement SUMMARY_BUTTON_ON_SUMMARY_PAGE;
	
	String enterName;
	public void CustomerFullName(String fullName) {
	    enterName =  generatedNumber(99999) + fullName ;
		CUSTOMER_FULLNAME.sendKeys(enterName);
	}
	public void AddompanyName(String companyName) throws InterruptedException {
		//Thread.sleep(4000);
		//selectDropDown(COMPANY_NAME, companyName);
		COMPANY_NAME.sendKeys(companyName);
	}
	public void AddustomerEmail(String Email) {
		CUSTOMER_EMAIL.sendKeys(generatedNumber(999) + Email);
	}
	public void enterphoneNumber(String phone) {
		PHONE_FIELD.sendKeys(phone + generatedNumber(999));
	}
	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}
	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}
	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}
	public void enterZip(String zip) {
		ZIP_FIELD.sendKeys(zip);
	}
	public void enterCountry(String country) {
		COUNTRY_FIELD.sendKeys(country);
	}
	public void clickSaveButtonOnAddContuct() {
		SAVE_BUTTON_ON_ADD_CONTUCT.click();
	}
	
	public void verifySummarypage() {
//		WebDriverWait wait = new WebDriverWait(driver,5);
//		wait.until(ExpectedConditions.invisibilityOf(SAVE_BUTTON_ON_ADD_CONTUCT));
		waitForElement(driver,5,SAVE_BUTTON_ON_ADD_CONTUCT);
		Assert.assertEquals(SAVE_BUTTON_ON_ADD_CONTUCT.getText(), " Summary ", "wrong page");
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]
	
	public void verifyEnteredNameAndDelete() {
		String bfore_xpath ="//tbody/tr[";
		String after_xpath ="]/td[3]";
		String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
		for(int i = 1; i <=10; i++) {
			String name = driver.findElement(By.xpath(bfore_xpath + i + after_xpath)).getText();
//			System.out.println(name);
//			Assert.assertEquals(name, enterName, "enter name doesnt exist!!");
//			break;
			
			if(name.contains(enterName)) {
				System.out.println("enter name exsit.");
				driver.findElement(By.xpath(bfore_xpath + i + after_xpath_delete)).click();
			}
		}
	}
	

}

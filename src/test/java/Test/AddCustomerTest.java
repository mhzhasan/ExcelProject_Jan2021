package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Page.AddCustomer;
import Page.BasePage;
import Page.DashboardPage;
import Page.LoginPage;
import Util.Browserfactory;
import Util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	ExcelReader excelReader = new ExcelReader("src\\main\\java\\data\\ExcelFile.xlsx");
	String userName = excelReader.getCellData("Sheet1", "UserName", 2);
	String password = excelReader.getCellData("Sheet1", "Password", 2);

	String fullName = excelReader.getCellData("Sheet2", "FullName", 2);
	String companyName = excelReader.getCellData("Sheet2", "CompanyName", 2);
	String email = excelReader.getCellData("Sheet2", "Email", 2);
	String phone = excelReader.getCellData("Sheet2", "Phone", 2);
	String address = excelReader.getCellData("Sheet2", "Address", 2);
	String city = excelReader.getCellData("Sheet2", "City", 2);
	String country = excelReader.getCellData("Sheet2", "Country", 2);
	String state = excelReader.getCellData("Sheet2", "State", 2);
	String zip = excelReader.getCellData("Sheet2", "Zip", 2);

	@Test
	public void validUserShouldBeAbleAddCustomer() throws InterruptedException  {
		driver = Browserfactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSiginButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardpage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();

		AddCustomer addCustomer = PageFactory.initElements(driver, AddCustomer.class);
		addCustomer.CustomerFullName(fullName);
		addCustomer.AddompanyName(companyName);
		addCustomer.AddustomerEmail(email);
		addCustomer.enterphoneNumber(phone);
		addCustomer.enterAddress(address);
		addCustomer.enterCity(city);
		addCustomer.enterState(state);
		addCustomer.enterZip(zip);
		addCustomer.enterCountry(country);
		addCustomer.clickSaveButtonOnAddContuct();

		addCustomer.verifySummarypage();
		dashboardPage.clickOnListCustomerButton();
		dashboardPage.clickAddCustomerButton();
		addCustomer.verifyEnteredNameAndDelete();
	}
	//@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}

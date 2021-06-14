package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.DashboardPage;
import Page.LoginPage;
import Util.Browserfactory;
import Util.ExcelReader;
   
public class LoginTest {
	 WebDriver driver;
	 ExcelReader excelReader = new ExcelReader("src\\main\\java\\data\\ExcelFile.xlsx");
	 String userName = excelReader.getCellData("Sheet1", "UserName", 2);
	 String password = excelReader.getCellData("Sheet1", "Password", 2);
	
	@Test
	public void validUserShouldableToLoging() {
		driver = Browserfactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSiginButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardpage();
		
		//Browserfactory.tearDown();
	}

}

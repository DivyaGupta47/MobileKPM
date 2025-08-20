package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewOrderPage;

public class LoginAdminTest extends BaseTest {

	DashboardPage dashboardPage;

	@Test
	public void testLogin() throws InterruptedException {
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterEmail("d@yopmail.com");
	    loginPage.enterPassword("KestrelPro@123");
	    loginPage.tapLogin();

	    // Initialize dashboard page after login
	    dashboardPage = new DashboardPage(driver);

	    System.out.println("TEST PASSED: Login successfully via Admin");
	    Thread.sleep(3000);
	}

	@AfterClass
	public void logoutAfterTest() {
	    dashboardPage = new DashboardPage(driver);
	    dashboardPage.logout();
	}

}

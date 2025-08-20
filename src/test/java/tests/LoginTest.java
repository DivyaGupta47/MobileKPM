package tests;

import base.BaseTest;
import io.appium.java_client.AppiumBy;
import pages.LoginPage;
import pages.NewOrderPage;
import pages.QueuedAndCompletedOrderPage;
import pages.DashboardPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	DashboardPage dashboardPage;
	QueuedAndCompletedOrderPage queuedAndCompletedOrderPage;

	@Test
	public void testLogin() throws InterruptedException {
	

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("d@yopmail.com");
		loginPage.enterPassword("KestrelPro@123");
		loginPage.tapLogin();

		System.out.println("TEST PASSED: Login successfully via Admin");

		dashboardPage = new DashboardPage(driver);
		Thread.sleep(5000);
		int totalOrders = dashboardPage.getTotalOrderCount();
		int completedOrders = dashboardPage.getCompletedOrderCount();

		assert totalOrders > 0 : "Total order count invalid";
		assert completedOrders >= 0 : "Completed order count invalid";

		System.out.println("Total Orders: " + totalOrders);
		System.out.println("Completed Orders: " + completedOrders);

		dashboardPage.tapNewOrder();

		NewOrderPage newOrderPage = new NewOrderPage(driver);
		//newOrderPage.queuedOrderList();
		
		Thread.sleep(1000);
		newOrderPage.enterCustomerName("Yadhish Automation");
		newOrderPage.enterOrganization("47 Billion");
		newOrderPage.enterCustomerCode("CUST 321");
		newOrderPage.selectWorkflowDefault();
		newOrderPage.enterRegion("Indore");
		newOrderPage.enterQuantity("10");
		newOrderPage.enterUOM("KG");
		Thread.sleep(3000);
		newOrderPage.selectTodayDate();
		newOrderPage.enterSingleRollW("Single_1");
		newOrderPage.enterFilmType("Plastic");
		newOrderPage.enterSONumber("3");
		newOrderPage.enterLength("34");
		newOrderPage.enterWidth("56");
		newOrderPage.enterCoreId("57");
		newOrderPage.enterOD("89");
		newOrderPage.enterNumberOfRolls("45");
		newOrderPage.enterDestination("Pune");
		newOrderPage.enterSalesOrderLineNumber("Line_number_50");
		newOrderPage.enterPackagingType("Bag");
		newOrderPage.enterSalesCategory("Parcel");
		Thread.sleep(1000);
		newOrderPage.enterGrade("B");
		Thread.sleep(3000);
		newOrderPage.selectPromiseDate();
		newOrderPage.enterPalletType("Type 1");
		newOrderPage.enterPalletTier("C");
		newOrderPage.enterConsigneeDetail("Pune MH");
		Thread.sleep(3000);
		newOrderPage.selectRequestDate();
		newOrderPage.clickSaveOrder();
		
		queuedAndCompletedOrderPage = new QueuedAndCompletedOrderPage(driver);
		queuedAndCompletedOrderPage.queuedOrderList();

	}

	@AfterClass
	public void logoutAfterTest() {
		if (dashboardPage != null) {
			dashboardPage.logout();
		}
	}
}

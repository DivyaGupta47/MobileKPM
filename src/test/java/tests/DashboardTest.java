package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

	DashboardPage dashboardPage;

	@Test
	public void verifyDashboardCounts() throws InterruptedException {

		// Dashboard checks
		dashboardPage = new DashboardPage(driver);
		Thread.sleep(3000);

		int totalOrders = dashboardPage.getTotalOrderCount();
		int completedOrders = dashboardPage.getCompletedOrderCount();

		Assert.assertTrue(totalOrders > 0, "Total order count invalid");
		Assert.assertTrue(completedOrders >= 0, "Completed order count invalid");

		System.out
				.println("TEST PASSED: Dashboard Verified → Total: " + totalOrders + ", Completed: " + completedOrders);
	}

	
}

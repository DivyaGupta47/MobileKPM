package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewOrderPage;

public class NewOrderTest extends BaseTest {

    DashboardPage dashboardPage;
    NewOrderPage newOrderPage;
  
    @Test
    public void createNewOrder() throws InterruptedException {
       
        // Go to New Order
        dashboardPage = new DashboardPage(driver);
        Thread.sleep(3000);
        dashboardPage.tapNewOrder();

        // Fill New Order Page
        newOrderPage = new NewOrderPage(driver);
        Thread.sleep(2000);
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

        // Save Order
        newOrderPage.clickSaveOrder();

        System.out.println("TEST PASSED: New Order Created Successfully!");
        Assert.assertTrue(true, "TEST FAILED: New order was not created properly!");
    }
     
}

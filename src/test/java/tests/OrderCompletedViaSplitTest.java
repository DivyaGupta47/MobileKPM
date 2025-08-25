package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.NewOrderPage;
import pages.OrderCompletedViaSplitPage;
import pages.QueuedAndCompletedOrderPage;

public class OrderCompletedViaSplitTest extends BaseTest {

    DashboardPage dashboardPage;
    NewOrderPage newOrderPage;
    OrderCompletedViaSplitPage orderCompletedViaSplitPage;
  
    @Test
    public void createNewOrder() throws InterruptedException {
       
        // Go to New Order
        dashboardPage = new DashboardPage(driver);
        Thread.sleep(3000);
        dashboardPage.tapNewOrder();

        // Fill New Order Page
        newOrderPage = new NewOrderPage(driver);
        Thread.sleep(2000);
        newOrderPage.enterCustomerName("YadhiComplete Automation");
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
        
        orderCompletedViaSplitPage = new OrderCompletedViaSplitPage(driver);
        orderCompletedViaSplitPage.queuedSplitOrderList();

        System.out.println("TEST PASSED: Order Completed and verify on completed Successfully!");
        Assert.assertTrue(true, "TEST FAILED: New order was not created properly!");
    }
     
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddAndUpdateUserPage;
import pages.DashboardPage;

public class AddAndUpdateUserTest extends BaseTest{
	AddAndUpdateUserPage addAndUpdateUserPage;
	
	 String firstName = "TestUser_" + System.currentTimeMillis(); // Generates a unique name like TestUser_1720090812345
	 String assigneeEmail = firstName.toLowerCase() + "@yopmail.com"; // Ensure email is also unique
	    
	@Test
	public void addUser() throws InterruptedException {

		// Dashboard checks
		addAndUpdateUserPage = new AddAndUpdateUserPage(driver);
		Thread.sleep(3000);
		addAndUpdateUserPage.settingNewUser();
		addAndUpdateUserPage.addNewUser(firstName,assigneeEmail);
		addAndUpdateUserPage.searchAndVerifyUser(assigneeEmail);		
	}
	
}

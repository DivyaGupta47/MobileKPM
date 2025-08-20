package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AddAndUpdateUserPage {
	AndroidDriver driver;

	public AddAndUpdateUserPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void settingNewUser() throws InterruptedException {
		By profileTab = By.xpath("//android.widget.Button[contains(@content-desc, 'Profile')]");
		driver.findElement(profileTab).click();

		Thread.sleep(1000); // Optional wait

		By setting = By.xpath("//android.widget.ImageView[contains(@content-desc, 'Settings')]");
		driver.findElement(setting).click();

		Thread.sleep(1000);

		By teams = By.xpath("//android.view.View[contains(@content-desc, 'Teams')]");
		driver.findElement(teams).click();

		Thread.sleep(1000);

		By addMember = By.xpath("//android.widget.Button[contains(@content-desc, 'Add Member')]");
		driver.findElement(addMember).click();

		Thread.sleep(1000);
	}

	public void addNewUser(String userName, String assigneeEmail) throws InterruptedException {
		WebElement firstName = driver.findElement(By.xpath("//android.widget.EditText[@hint='First Name']"));
		firstName.click();
		firstName.sendKeys(userName);
		WebElement lastName = driver.findElement(By.xpath("//android.widget.EditText[@hint='Last Name']"));
		lastName.click();
		lastName.sendKeys("Automation");
		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@hint='Email']"));
		email.click();
		email.sendKeys(assigneeEmail);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
		WebElement phone = driver.findElement(By.xpath("//android.widget.EditText[@hint='Phone']"));
		phone.click();
		phone.sendKeys("01234567891");
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
		Thread.sleep(500);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement adminDropdown = wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Admin\")")));

		adminDropdown.click();

		Thread.sleep(500);

		WebElement associate = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Associate")));
		associate.click();
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
		Thread.sleep(1000);
		By saveBtn = By.xpath("//android.widget.Button[contains(@content-desc, 'Save')]");
		driver.findElement(saveBtn).click();
		Thread.sleep(3000);

		System.out.println("TEST PASSED: New user added successfully");

	}

	public void searchAndVerifyUser(String userName) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminDropdown = wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Admin\")")));

		// Click to expand
		adminDropdown.click();

		Thread.sleep(500);
		// Step 2: Select Associate from list

		WebElement associate = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Associate")));
		associate.click();
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
		Thread.sleep(1000);

		WebElement searchBox = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@hint='Search']"));
		searchBox.click();
		searchBox.sendKeys(userName);

		WebElement userItem = driver
				.findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + userName + "\")"));

		if (userItem.isDisplayed()) {
			System.out.println("TEST PASSED: New user '" + userName + "' found in the list");
		} else {
			System.out.println("TEST FAILED: New user '" + userName + "' not found in the list");
		}

		Assert.assertTrue(userItem.isDisplayed(), "Expected first name '" + userName + "' not found!");
		Thread.sleep(1000);

		WebElement menuButton = driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)"));
		menuButton.click();
		Thread.sleep(1000);
		menuButton.click();
		Thread.sleep(1000);
		By logoutIcon = By.xpath("//android.widget.ImageView[@content-desc='Logout']");
		driver.findElement(logoutIcon).click();

		By yesButton = By.xpath("//android.widget.Button[@content-desc='Yes']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(yesButton));

		driver.findElement(yesButton).click();

	}
}

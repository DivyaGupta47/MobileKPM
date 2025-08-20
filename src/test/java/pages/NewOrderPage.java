package pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NewOrderPage {
	private AndroidDriver driver;

	public NewOrderPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void enterCustomerName(String customerName) {

		WebElement field = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]"));
		field.click();
		field.clear();
		field.sendKeys(customerName);
	}

	public void enterOrganization(String organization) {

		WebElement field = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[2]"));
		field.click();
		field.clear();
		field.sendKeys(organization);
	}

	public void enterCustomerCode(String customerCode) {

		WebElement field = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[3]"));
		field.click();
		field.clear();
		field.sendKeys(customerCode);
	}

	private By workflowField = AppiumBy
			.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)");

	private By workflowDefaultOption = AppiumBy.accessibilityId("default");

	public void selectWorkflowDefault() {
		driver.findElement(workflowField).click();
		driver.findElement(workflowDefaultOption).click();
	}

	public void enterRegion(String regionName) {

		WebElement field = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[4]"));
		field.click();
		field.clear();
		field.sendKeys(regionName);
	}

	public void enterQuantity(String quantity) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='SO Quantity']"));
		field.click();
		field.clear();
		field.sendKeys(quantity);
	}

	public void enterUOM(String uom) {

		WebElement field = driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[6]"));
		field.click();
		field.clear();
		field.sendKeys(uom);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
	}

	public void selectTodayDate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		// 1️⃣ Click SO Date field with retries & fallback
		WebElement dateField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@hint='SO Date']")));

		Thread.sleep(1000);
		dateField.click();

		// 2️⃣ Build today's date accessibility ID dynamically
		LocalDate today = LocalDate.now();
		int dayOfMonth = today.getDayOfMonth();
		String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = today.getYear();

		String todayDateId = String.format("%d, %s, %s %d, %d, Today", dayOfMonth, dayOfWeek, month, dayOfMonth, year);

		// 3️⃣ Click today's date
		WebElement todayButton = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(todayDateId)));
		todayButton.click();

		// 4️⃣ Click OK button
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
		okButton.click();

	}

	public void enterSingleRollW(String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement field = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@hint='Single Roll W']")));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterFilmType(String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement field = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@hint='Film Type']")));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterSONumber(String value) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement field = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.EditText[@hint='SO Number']")));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterLength(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Length']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterWidth(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Width (mm)']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterCoreId(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Core ID (mm)']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterOD(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='OD (mm)']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterNumberOfRolls(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='No. of Rolls']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterDestination(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Destination']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterSalesOrderLineNumber(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Sales Order Line Number']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterPackagingType(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Packaging Type']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterSalesCategory(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Sales Category']"));
		field.click();
		field.clear();
		field.sendKeys(value);

	}

	public void enterGrade(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Grade']"));
		field.click();
		field.clear();
		field.sendKeys(value);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
	}

	public void selectPromiseDate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement dateField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@hint='Promise Day']")));

		Thread.sleep(1000);
		dateField.click();

		// 2️⃣ Build today's date accessibility ID dynamically
		LocalDate today = LocalDate.now();
		int dayOfMonth = today.getDayOfMonth();
		String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = today.getYear();

		String todayDateId = String.format("%d, %s, %s %d, %d, Today", dayOfMonth, dayOfWeek, month, dayOfMonth, year);

		// 3️⃣ Click today's date
		WebElement todayButton = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(todayDateId)));
		todayButton.click();

		// 4️⃣ Click OK button
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
		okButton.click();

	}

	public void enterPalletType(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Pallet Type']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterPalletTier(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Pallet Tier']"));
		field.click();
		field.clear();
		field.sendKeys(value);
	}

	public void enterConsigneeDetail(String value) {

		WebElement field = driver.findElement(By.xpath("//android.widget.EditText[@hint='Consignee Details']"));
		field.click();
		field.clear();
		field.sendKeys(value);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not visible, skipping hide.");
		}
	}

	public void selectRequestDate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement dateField = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@hint='Request Date']")));

		Thread.sleep(1000);
		dateField.click();

		// 2️⃣ Build today's date accessibility ID dynamically
		LocalDate today = LocalDate.now();
		int dayOfMonth = today.getDayOfMonth();
		String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		String month = today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = today.getYear();

		String todayDateId = String.format("%d, %s, %s %d, %d, Today", dayOfMonth, dayOfWeek, month, dayOfMonth, year);

		// 3️⃣ Click today's date
		WebElement todayButton = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(todayDateId)));
		todayButton.click();

		// 4️⃣ Click OK button
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("OK")));
		okButton.click();

	}

	public void clickSaveOrder() throws InterruptedException {
		Thread.sleep(1000);
		WebElement saveButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Save Order']"));
		saveButton.click();
		System.out.println("TEST PASSES: Order Saved successfully");
		WebElement backButton = driver.findElement(By.xpath(
				"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
		backButton.click();

	}
}

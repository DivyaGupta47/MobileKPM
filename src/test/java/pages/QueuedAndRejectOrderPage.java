package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class QueuedAndRejectOrderPage {
	private AndroidDriver driver;

	public QueuedAndRejectOrderPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void queuedOrderList() throws InterruptedException {
		Thread.sleep(1000);
		WebElement productTab = driver.findElement(AppiumBy.accessibilityId("Product\nTab 2 of 4"));
		productTab.click();
		Thread.sleep(1000); // Optional wait
		WebElement customerCard = driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc, 'YadhiReject Automation')]"));
		customerCard.click();
		Thread.sleep(1000); // Optional wait
		WebElement noButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc='No']"));
		noButton.click();
		Thread.sleep(2000); // Optional wait
		WebElement zeroBtn = driver.findElement(By.xpath("//android.widget.Button[@content-desc='0']"));
		zeroBtn.click();
		Thread.sleep(2000); // Optional wait
		WebElement threeBtn = driver.findElement(By.xpath("//android.widget.Button[@content-desc='3']"));
		threeBtn.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement detailsTab = wait
				.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Details\nTab 2 of 3")));
		detailsTab.click();

		Thread.sleep(3000);

		WebElement onTime = driver.findElement(By.xpath("//android.view.View[@content-desc='On Time']"));
		onTime.click();
		Thread.sleep(2000);

		WebElement completedBtn = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Completed']"));
		completedBtn.click();

		Thread.sleep(3000);

		WebElement onTimeStage3 = driver.findElement(By.xpath("//android.view.View[@content-desc='On Time']"));
		onTimeStage3.click();
		Thread.sleep(2000);

		rejectOrder();
		onTime();
	}

	public void rejectOrder() throws InterruptedException {
		WebElement reject = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Reject']"));
		reject.click();
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement rejectReason = driver.findElement(
			    By.xpath("//android.widget.EditText[contains(@hint,'Comment')]")
			);
			rejectReason.click();
			System.out.println("Click");
			Thread.sleep(500);
			rejectReason.sendKeys("Reject reason entered");


		Thread.sleep(1000);
		WebElement rejectBtn = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Submit']"));
		rejectBtn.click();

		WebElement element = driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)"));
		element.click();
		Thread.sleep(1000);

		System.out.println("TEST PASSED: Order Rejected Successfully");
	}

	public void onTime() throws InterruptedException {
		Thread.sleep(1000);
		WebElement onTimeTab = driver.findElement(By.xpath("//android.widget.Button[@content-desc='On Time ']"));
		onTimeTab.click();

		WebElement onTimedOrder = driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc,'YadhiReject Automation')]"));

		// Assertion: Verify order is displayed in Completed list
		Assert.assertTrue(onTimedOrder.isDisplayed(), "Order not visible in On Time list!");
		System.out.println("TEST PASSED: Order is visible in On Time list after Rejected.");

	}

}

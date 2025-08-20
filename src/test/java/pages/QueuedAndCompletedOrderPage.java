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

public class QueuedAndCompletedOrderPage {
	private AndroidDriver driver;

	public QueuedAndCompletedOrderPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public void queuedOrderList() throws InterruptedException {
		Thread.sleep(1000);
		WebElement productTab = driver.findElement(AppiumBy.accessibilityId("Product\nTab 2 of 4"));
		productTab.click();
		Thread.sleep(1000); // Optional wait
		WebElement customerCard = driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc, 'YadhiComplete Automation')]"));
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

		for (int i = 0; i < 6; i++) {
			Thread.sleep(3000);

			WebElement onTime = driver.findElement(By.xpath("//android.view.View[@content-desc='On Time']"));
			onTime.click();
			Thread.sleep(2000);

			WebElement completedBtn = driver
					.findElement(By.xpath("//android.widget.Button[@content-desc='Completed']"));
			completedBtn.click();

			// Scroll after 3rd and 5th iteration
			if (i == 2 || i == 4) {

				Dimension size = driver.manage().window().getSize();
				int startX = size.width / 2;
				int startY = (int) (size.height * 0.8); // bottom
				int endY = (int) (size.height * 0.3); // top

				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence swipe = new Sequence(finger, 1);

				swipe.addAction(
						finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
				swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
				swipe.addAction(
						finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
				swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

				driver.perform(Arrays.asList(swipe));

				Thread.sleep(2000); // wait after scroll
			}
		}

		System.out.println("TEST PASSED: All status completed");
		Thread.sleep(2000);
		WebElement element = driver.findElement(
				AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(5)"));
		element.click();
		Thread.sleep(1000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement completedBtn = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[contains(@content-desc,'Completed')]")));
		completedBtn.click();

		WebElement completedOrder = driver
				.findElement(By.xpath("//android.view.View[contains(@content-desc,'YadhiComplete Automation')]"));

		// Assertion: Verify order is displayed in Completed list
		Assert.assertTrue(completedOrder.isDisplayed(), "Order not visible in Completed list!");
		System.out.println("TEST PASSED: Order is visible in Completed list.");

	}

}

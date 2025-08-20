package pages;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	AndroidDriver driver;

	By newOrderButton = By.xpath("//android.widget.Button[@content-desc='New Order']");

	public DashboardPage(AndroidDriver driver) {
		this.driver = driver;
	}

	public int getTotalOrderCount() {
		By totalOrderLocator = By.xpath("//android.view.View[contains(@content-desc, 'Total Orders')]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(totalOrderLocator));

		String rawContent = driver.findElement(totalOrderLocator).getAttribute("content-desc");

		String orderCount = rawContent.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(orderCount);

		return count;
	}

	public void logout() {
		try {

			By profileTab = By.xpath("//android.widget.Button[contains(@content-desc, 'Profile')]");
			driver.findElement(profileTab).click();

			Thread.sleep(1000); // Optional wait

			By logoutIcon = By.xpath("//android.widget.ImageView[@content-desc='Logout']");
			driver.findElement(logoutIcon).click();

			// 🔒 Wait for the confirmation popup and click "Yes"

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			By yesButton = By.xpath("//android.widget.Button[@content-desc='Yes']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(yesButton));

			driver.findElement(yesButton).click();

		} catch (Exception e) {
			System.err.println("❌ Logout failed: " + e.getMessage());
		}
	}

	public int getCompletedOrderCount() {
		By completedOrderLocator = By.xpath("//android.view.View[contains(@content-desc, 'Completed')]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(completedOrderLocator));

		String rawContent = driver.findElement(completedOrderLocator).getAttribute("content-desc");

		// Extract digits
		String orderCount = rawContent.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(orderCount);

		return count;
	}

	public void tapNewOrder() {
		driver.findElement(newOrderButton).click();
	}

}

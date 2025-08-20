package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class LoginPage {

    AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
       
        List<WebElement> fields = driver.findElements(By.className("android.widget.EditText"));
        fields.get(0).click();
        fields.get(0).clear();
        fields.get(0).sendKeys(email);
    }

    public void enterPassword(String password) {
        ;
        List<WebElement> fields = driver.findElements(By.className("android.widget.EditText"));
        fields.get(1).click();
        fields.get(1).clear();
        fields.get(1).sendKeys(password);
    }

    public void tapLogin() {
        
        try {
            driver.hideKeyboard();  // Safely attempt to hide the keyboard
        } catch (Exception e) {
            System.out.println("Keyboard already hidden or cannot hide it.");
        }

       
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();
    }

}

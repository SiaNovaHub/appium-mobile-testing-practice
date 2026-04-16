package sianova;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommApp_StartForm extends BaseMethods {
    @Test
    public void FillFormSuccessfully() {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("User Test");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scrollIntoView("Aruba");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Aruba\")")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test
    public void SendEmptyFormErrorToast() {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastText = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
        Assert.assertEquals(toastText, "Please enter your name");
    }
}

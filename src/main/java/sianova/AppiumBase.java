package sianova;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBase extends BaseTest {
    @Test
    public void SetWifiSettings() {
        //supported locators XPath, id, accessibilityID,classname,adroidUIAutomator
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Preference\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"3. Preference dependencies\")"))
                .click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String popUpText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popUpText, "WiFi settings");
        driver.findElement(By.id("android:id/edit")).sendKeys("Test Wifi");
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test
    public void LongPressMenuValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Expandable Lists\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"1. Custom Adapter\")")).click();

        WebElement peopleNamesElement = driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"People Names\")"));
        longPressAction(peopleNamesElement);
        String longPressMenuTitle = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(longPressMenuTitle, "Sample menu");
        Assert.assertTrue(driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"Sample menu\")")).isDisplayed());
    }
    @Test
    public void ScrollValidation() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Views\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Expandable Lists\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"1. Custom Adapter\")")).click();

        WebElement peopleNamesElement = driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"People Names\")"));
        longPressAction(peopleNamesElement);
        String longPressMenuTitle = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(longPressMenuTitle, "Sample menu");
        Assert.assertTrue(driver.findElement(
                new AppiumBy.ByAndroidUIAutomator("text(\"Sample menu\")")).isDisplayed());
    }
}

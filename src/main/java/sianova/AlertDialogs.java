package sianova;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import sianova.util_methods.MobileActions;

public class AlertDialogs extends BaseMethods {
    @BeforeClass
    public void openAlertDialogs() {
        //V1 uses appPackage and appActivity that can be retrieved by opening needed page and running this command
        //adb shell dumpsys window | find "mCurrentFocus"
        driver.executeScript("mobile: startActivity", ImmutableMap.of(
                "intent", "io.appium.android.apis/io.appium.android.apis.app.AlertDialogSamples"
        ));
    }
    @Test
    public void OkCancelDialogWithMessage() {
        driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();

        String popUpText = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popUpText,
                "Lorem ipsum dolor sit aie consectetur adipiscing\n" +
                        "Plloaso mako nuto siwuf cakso dodtos anr koop.");
        driver.findElement(By.id("android:id/button1")).click();
    }
    @Test
    public void OkCancelDialogWithLongMessage() {
        driver.findElement(By.id("io.appium.android.apis:id/two_buttons2")).click();

        WebElement popUpHeader = driver.findElement(By.id("android:id/alertTitle"));
        Assert.assertTrue(popUpHeader.isDisplayed(), "true");

        String popUpText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(popUpText,
                "Plloaso mako nuto siwuf cakso dodtos anr koop a cupy uf cak vux noaw yerw phuno." +
                        " Whag schengos, uf efed, quiel ba mada su otrenzr.\n\n" +
                        "Swipontgwook proudgs hus yag su ba dagarmidad. Plasa maku noga wipont trenzsa schengos " +
                        "ent kaap zux comy.\n\nWipont trenz kipg naar mixent phona. Cak pwico siructiun " +
                        "ruous nust apoply tyu cak Uhex sisulutiun munityuw uw dseg");
        driver.findElement(By.id("android:id/button3")).click();
    }
    @Test
    public void ListDialog() {
        driver.findElement(By.id("io.appium.android.apis:id/select_button")).click();

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Command two\")")).click();
        String popUpText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(popUpText, "You selected: 1 , Command two");
    }
    @Test
    public void SingleChoiceListConfirm() {
        driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
        WebElement option1 = driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Traffic\")"));
        WebElement option2 = driver.findElement(new AppiumBy.ByAndroidUIAutomator("text(\"Map\")"));
        option1.click();
        driver.findElement(By.id("android:id/button1")).click();

        driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
        Assert.assertEquals(option1.getAttribute("checked"), "true");
        Assert.assertEquals(option2.getAttribute("checked"), "false");
    }

}

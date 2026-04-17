package ecomm_app_e2e;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseMethods {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws URISyntaxException, MalformedURLException {
        File appiumJs =
                new File("C:\\Users\\nastz\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(appiumJs)
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("HUAWEI ANA-NX9");
        //options.setApp("E:\\AppiumTestProjectIntelliJ\\src\\main\\java\\resources\\ApiDemos-debug.apk");
        options.setApp("E:\\AppiumTestProjectIntelliJ\\src\\main\\java\\resources\\General-Store.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void addProductToCart (String productName) {
        //scrollIntoView(productName);
        WebElement productCard = driver.findElement(By.xpath(
                "//android.widget.TextView[@text = '" + productName + "']//parent::android.widget.LinearLayout"));
        WebElement productAddToCartBtn = productCard.findElement(By.xpath(
                "//android.widget.TextView[@resource-id = 'com.androidsample.generalstore:id/productAddCart']"));
        productAddToCartBtn.click();
    }
    public void verifyAddToCartBtnChanged (String productName) {
        WebElement productCard = driver.findElement(By.xpath(
                "//android.widget.TextView[@text = '" + productName + "']//parent::android.widget.LinearLayout"));
        WebElement productAddToCartBtn = productCard.findElement(By.xpath(
                "//android.widget.TextView[@resource-id = 'com.androidsample.generalstore:id/productAddCart']"));
        Assert.assertEquals(productAddToCartBtn.getText(), "ADDED TO CART");
    }
    public void navigateToCart () {
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}

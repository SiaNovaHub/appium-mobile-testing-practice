package sianova;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class eCommApp_ProductsList extends BaseMethods {
    @BeforeClass
    public void openProductsList() {
//        driver.executeScript("mobile: startActivity", ImmutableMap.of(
//                "intent", "com.androidsample.generalstore/com.androidsample.generalstore.AllProductsActivity"
//        ));
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("User Test");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    }
    @Test
    public void AddProductToCart() {
        scrollIntoView("Jordan 6 Rings");
        WebElement productCard = driver.findElement(By.xpath(
                "//android.widget.TextView[@text = 'Jordan 6 Rings']//parent::android.widget.LinearLayout"));
        WebElement productAddToCartBtn = productCard.findElement(By.xpath(
                "//android.widget.TextView[@resource-id = 'com.androidsample.generalstore:id/productAddCart']"));
        productAddToCartBtn.click();
    }
}

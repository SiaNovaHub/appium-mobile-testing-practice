package sianova;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
        addProductToCart("Jordan 6 Rings");
        //Verify button text changed
        verifyAddToCartBtnChanged("Jordan 6 Rings");
        //Verify cart counter updated
        WebElement cartItemsCounter = driver.findElement(By.id("com.androidsample.generalstore:id/counterText"));
        Assert.assertEquals(cartItemsCounter.getText(), "1");
        //Navigate to cart page
        navigateToCart();
        //Wait until page header will be Cart
        WebElement pageHeader = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try { wait.until(ExpectedConditions.attributeContains(pageHeader, "text", "Cart"));

        } catch (StaleElementReferenceException e) {
            System.out.println("Element is stale. Handle appropriately.");
        }
        //Find product in cart
        String productNameInCart = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(productNameInCart, "Jordan 6 Rings");
    }
    @Test
    public void ValidateTotal() {
        addProductToCart("Air Jordan 4 Retro");
        addProductToCart("Air Jordan 1 Mid SE");
        //Navigate to cart page
        navigateToCart();
        //get sum of products and compare with display total
        List<WebElement> productsPriceInCart = driver.findElements(By.id(
                "com.androidsample.generalstore:id/productPrice"));
        double totalSum = 0;
        for (int i = 0; i < productsPriceInCart.size(); i++) {
            String priceString = productsPriceInCart.get(i).getText();
            Double price = Double.parseDouble(priceString.substring(1)); //price is in format $120.0
            totalSum = totalSum + price;
        }
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displaySumValue = Double.parseDouble(displaySum.substring(1));
        Assert.assertEquals(totalSum, displaySumValue);
    }
    @Test
    public void ValidateTermsOfConditions() {
        addProductToCart("Air Jordan 4 Retro");
        //Navigate to cart page
        navigateToCart();
        //Open terms of conditions toast
        WebElement termsBtn = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(termsBtn);
        //Assert Terms toast is visible
        WebElement termsToastTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle"));
        Assert.assertTrue(termsToastTitle.isDisplayed());
        //Close toast
        driver.findElement(By.id("android:id/button1")).click();
    }
}

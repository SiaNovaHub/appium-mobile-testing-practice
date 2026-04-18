package ecomm_app_e2e;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.android.CartPage;
import pages.android.ProductListPage;
import pages.android.StartFormPage;

public class eCommApp_ProductsList extends BaseMethods {
    @BeforeClass
    public void openProductsList() {
//        driver.executeScript("mobile: startActivity", ImmutableMap.of(
//                "intent", "com.androidsample.generalstore/com.androidsample.generalstore.AllProductsActivity"
//        ));
        StartFormPage startFormPage = new StartFormPage(driver);
        startFormPage.enterName("User Test");
        startFormPage.clickShopBtn();
    }
    @Test
    public void AddProductToCart() {
        ProductListPage productListPage = new ProductListPage(driver);
        CartPage cartPage = new CartPage(driver);

        productListPage.addProductToCart("Jordan 6 Rings");

        productListPage.verifyAddToCartBtnLabelChanged("Jordan 6 Rings", "ADDED TO CART");
        productListPage.verifyCartItemsCounter(1);
        productListPage.navigateToCart();

        cartPage.verifyProductInCart("Jordan 6 Rings");
    }
    @Test
    public void ValidateTotal() {
        ProductListPage productListPage = new ProductListPage(driver);
        CartPage cartPage = new CartPage(driver);

        productListPage.addProductToCart("Air Jordan 4 Retro");
        productListPage.addProductToCart("Air Jordan 1 Mid SE");

        productListPage.navigateToCart();

        //get sum of products and compare with display total
        cartPage.verifyDisplayTotalSumIsCorrect();
    }
    @Test
    public void ValidateTermsOfConditions() {
        ProductListPage productListPage = new ProductListPage(driver);
        CartPage cartPage = new CartPage(driver);

        productListPage.addProductToCart("Air Jordan 4 Retro");
        productListPage.navigateToCart();

        cartPage.openTermsOfConditions();
        cartPage.verifyTermsOfConditionsAreVisible();
        cartPage.closeToast();
    }
}

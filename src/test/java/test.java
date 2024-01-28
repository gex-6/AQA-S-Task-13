import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class test {

    private final LoginPage loginPage = new LoginPage();
    private final ProductPage productPage = new ProductPage();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private final CheckoutPage checkoutPage = new CheckoutPage();
    private final OverviewPage overviewPage = new OverviewPage();

    @BeforeMethod
    public void openPage() {
        Selenide.open("https://www.saucedemo.com/");
    }

    @Test
    public void invalidLogin() {
        loginPage.setNameField("standard_user")
                .setPasswordField("wrong")
                .clickLoginButton()
                .checkErrorMessage();
    }

    @Test
    public void validLogin() {
        loginPage.setNameField("standard_user")
                .setPasswordField("secret_sauce")
                .clickLoginButton();
        productPage.checkProductList();
    }

    @Test
    public void checkPurchaseFlow() {
        //login
        loginPage.setNameField("standard_user")
                .setPasswordField("secret_sauce")
                .clickLoginButton();

        //add to cart products with price $7.99 and $9.99
        productPage.addOnesieToCart()
                .addBikeLightToCart()
                .openCart();

        //check if products were added to cart
        shoppingCartPage.checkOnesieInCart()
                        .checkBikeLightInCart()
                        .openCheckoutPage();

        //fill the checkout form
        checkoutPage.fillFirstName()
                    .fillLastName()
                    .fillZip()
                    .clickContinue();

        //find the tax percentage
        double taxPerCent = overviewPage.getTaxValue() / overviewPage.getTotalValue() * 100;
        System.out.println("The tax % is " + taxPerCent + "%");

        //open the last page and check if the text is displayed
        overviewPage.clickFinishButton()
                    .checkHeaderHasCorrectValue();
    }
}

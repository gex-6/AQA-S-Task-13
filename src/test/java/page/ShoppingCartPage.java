package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class ShoppingCartPage {

    private final SelenideElement onesieInCart = $("#item_2_title_link > [class=\"inventory_item_name\"]");
    private final SelenideElement bikeLightInCart = $("#item_0_title_link > [class=\"inventory_item_name\"]");

    private final SelenideElement checkoutButton = $("#checkout");

    public ShoppingCartPage checkOnesieInCart() {
        onesieInCart.shouldBe(Condition.visible);
        return this;
    }
    public ShoppingCartPage checkBikeLightInCart() {
        bikeLightInCart.shouldBe(Condition.visible);
        return this;
    }

    public CheckoutPage openCheckoutPage() {
        checkoutButton.click();
        return new CheckoutPage();
    }
}

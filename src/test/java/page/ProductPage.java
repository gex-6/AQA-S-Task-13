package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class ProductPage {

    private final ElementsCollection productList = $$x("//div[@class='inventory_container']/div/div");
    private final SelenideElement onesieProductButton = $("[id=\"add-to-cart-sauce-labs-onesie\"]");
    private final SelenideElement bikeLightProductButton = $("[id=\"add-to-cart-sauce-labs-bike-light\"]");
    private final SelenideElement cartButton = $("[class=\"shopping_cart_link\"]");

    public void checkProductList() {
        productList.shouldHave(CollectionCondition.size(6));
    }

    public ProductPage addOnesieToCart() {
        onesieProductButton.click();
        return this;
    }

    public ProductPage addBikeLightToCart() {
        bikeLightProductButton.click();
        return this;
    }

    public ShoppingCartPage openCart() {
        cartButton.click();
        return new ShoppingCartPage();
    }

}

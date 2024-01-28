package page;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class CheckoutPage {

    private final SelenideElement firstNameField = $("#first-name");
    private final SelenideElement lastNameField = $("#last-name");
    private final SelenideElement zipField = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");

    public CheckoutPage fillFirstName() {
        firstNameField.setValue("Пес");
        return this;
    }

    public CheckoutPage fillLastName() {
        lastNameField.setValue("Патрон");
        return this;
    }

    public CheckoutPage fillZip() {
        zipField.setValue("00000");
        return this;
    }

    public OverviewPage clickContinue() {
        continueButton.click();
        return new OverviewPage();
    }

}

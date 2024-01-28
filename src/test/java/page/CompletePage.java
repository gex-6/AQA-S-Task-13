package page;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class CompletePage {

    public final SelenideElement thankYouHeader = $("[class=\"complete-header\"]");

    public void checkHeaderHasCorrectValue() {
        thankYouHeader.shouldHave(text("Thank you for your order!"));
    }
}

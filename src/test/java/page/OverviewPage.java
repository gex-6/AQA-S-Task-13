package page;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;

@Accessors(fluent = true)
@NoArgsConstructor
public class OverviewPage {

    private final SelenideElement summaryInfo = $("[class=\"summary_info\"]");
    private final SelenideElement finishButton = $("#finish");


    public double getTotalValue() {
        String summary = summaryInfo.getText();
        return extractDoubleValue(summary, "Total");
    }

    public double getTaxValue() {
        String summary = summaryInfo.getText();
        return extractDoubleValue(summary, "Tax");
    }

    public static double extractDoubleValue(String input, String label) {
        String pattern = label + ": \\$(\\d+\\.\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            String match = matcher.group(1);
            return Double.parseDouble(match);
        } else {
            throw new IllegalArgumentException("Could not find " + label + " value in the input.");
        }
    }

    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage();
    }
}

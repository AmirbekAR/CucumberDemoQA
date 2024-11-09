package demo.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demo.helper.SelenideElementActions;
import io.cucumber.java.en.Given;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
public class RadioButtonStepDefs {
    SelenideElementActions elementActions = new SelenideElementActions();

    private final SelenideElement clickButtonYes = $x("//label[normalize-space()='Yes']");
    private final SelenideElement clickButtonImpressive = $x("//label[normalize-space()='Impressive']");
    private final SelenideElement selectedBy = $x("//span[@class='text-success']");

    @Given("open url Demo")
    public void open_url_demo() {
        Selenide.open("https://demoqa.com/radio-button");
    }

    @Given("click button yes")
    public void click_button_yes() {
        elementActions.click(clickButtonYes);
        String selectedText = selectedBy.getText();
        assertEquals("Yes", selectedText);
        Selenide.sleep(2000);
    }

    @Given("user click button impressive")
    public void user_click_button_impressive() {
        elementActions.click(clickButtonImpressive);
        String selectedText = selectedBy.getText();
        assertEquals("Impressive", selectedText);
        Selenide.sleep(2000);
    }
}
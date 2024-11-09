package demo.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonStepDef {

    private final SelenideElement doubleClick = $(By.id("doubleClickBtn"));
    private final SelenideElement rightClick = $(By.id("rightClickBtn"));
    private final SelenideElement clickButton = $x("//button[text()='Click Me']");
    SelenideElement resultRightClickMassage = $(By.id("rightClickMessage"));
    SelenideElement doubleClickMessage = $(By.id("doubleClickMessage"));
    SelenideElement dynamicClickMessage = $(By.id("dynamicClickMessage"));


    @Given("user on page browser Demoqa")
    public void user_on_page_browser_demoqa() {
        Selenide.open("https://demoqa.com/buttons");
    }

    @Given("user select double click")
    public void user_select_double_click() {
        doubleClick.doubleClick();
        Assertions.assertEquals("You have done a double click", doubleClickMessage.getText());
        Selenide.sleep(2000);
    }

    @Given("user select right click")
    public void user_select_right_click() {
        rightClick.contextClick();
        Assertions.assertEquals("You have done a right click", resultRightClickMassage.getText());
        Selenide.sleep(2000);
    }

    @Given("user one click")
    public void user_one_click() {
        clickButton.click();
        Assertions.assertEquals("You have done a dynamic click", dynamicClickMessage.getText());
        Selenide.sleep(2000);
    }
}

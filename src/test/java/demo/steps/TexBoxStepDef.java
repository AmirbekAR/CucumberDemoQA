package demo.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TextBoxPage;

public class TexBoxStepDef {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Given("user is on Text box page")
    public void user_is_on_text_box_page() {
        Selenide.open("https://demoqa.com/text-box");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @Given("user enter full name")
    public void user_enter_full_name() {
        textBoxPage.getUserName().sendKeys("Jonathon Dru");
    }

    @Given("user enter email")
    public void user_enter_email() {
        textBoxPage.getUserEmail().sendKeys("talantMMS@mail.com");
    }

    @Given("user enter current address")
    public void user_enter_current_address() {
        textBoxPage.getCurrentAddress().sendKeys("some address 1");
    }

    @Given("user enter permanent address")
    public void user_enter_permanent_address() {
        textBoxPage.getPermanentAddress().sendKeys("some address 1/123");
    }

    @When("user click submit button")
    public void user_click_submit_button() {
        textBoxPage.getSubmitButton().click();
    }

    @Then("user should successfully")
    public void user_should_successfully() {
        Selenide.sleep(2000);
    }
}

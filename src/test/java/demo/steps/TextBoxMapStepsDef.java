package demo.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TextBoxPage;

import java.util.Map;

public class TextBoxMapStepsDef {
        TextBoxPage textBoxPage = new TextBoxPage();

    @When("the user updates their profile with the following information:")
    public void the_user_updates_their_profile_with_the_following_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> profileInfo = dataTable.asMap(String.class, String.class);
        if (profileInfo.containsKey("First Name")) {
            textBoxPage.getUserName().sendKeys(profileInfo.get("First Name"));
        }
        if (profileInfo.containsKey("Email")) {
            textBoxPage.getUserEmail().sendKeys(profileInfo.get("Email"));
        }
        if (profileInfo.containsKey("Current Address")) {
            textBoxPage.getCurrentAddress().sendKeys(profileInfo.get("Current Address"));
        }
        if (profileInfo.containsKey("Permanent Address")) {
            textBoxPage.getPermanentAddress().sendKeys(profileInfo.get("Permanent Address"));
        }
    }

    @Then("the user should see a confirmation message")
    public void the_user_should_see_a_confirmation_message() {
        textBoxPage.getSubmitButton().click();
        Selenide.sleep(3000);
    }
}

package demo.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyHeisenStepsdefs {

    @Given("I open page {string}")
    public void iOpenPage(String url) {
        Selenide.open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @When("I click on {string} button")
    public void iClickOnButton(String elementText) {
        $(By.partialLinkText(elementText)).shouldBe(Condition.enabled).click();
        Selenide.sleep(2000);
    }

    @Then("I see {string} speaker")
    public void iSeeSpeaker(String seeElement) {
        $(By.partialLinkText(seeElement)).shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
    }
}

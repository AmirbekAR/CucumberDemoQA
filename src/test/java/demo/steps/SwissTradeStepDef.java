package demo.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SwissTradeStepDef {
    @Given("User is on SwissTrade login page")
    public void userIsOnSwissTradeLoginPage() {
        Selenide.open("http://swis.trade.kg/");
    }

    @And("User should login with following credentials {string} {string}")
    public void userShouldLoginWithFollowingCredentials(String login, String password) {
        $(By.id("userName")).sendKeys(login);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $(By.id("password")).sendKeys(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $x("//input[@value='Войти']").click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

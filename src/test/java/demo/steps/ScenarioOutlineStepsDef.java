package demo.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.$x;

public class ScenarioOutlineStepsDef {


    @Given("user is on Orange HRM login page")
    public void user_is_on_orange_hr_login_page() {
        Selenide.open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @And("user should login with following credentials {string} {string}")
    public void userShouldLoginWithFollowingCredentials(String userName, String password) {
        $x("//input[@name='username']").sendKeys(userName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $x("//input[@name='password']").sendKeys(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $x("//button[@type='submit']").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

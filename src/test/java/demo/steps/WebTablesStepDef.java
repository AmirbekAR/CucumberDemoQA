package demo.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Getter;
import org.openqa.selenium.By;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class WebTablesStepDef {

    private final SelenideElement firstName = $(By.id("firstName"));
    private final SelenideElement lastName = $(By.id("lastName"));
    private final SelenideElement userEmail = $(By.id("userEmail"));
    private final SelenideElement age = $(By.id("age"));
    private final SelenideElement salary = $(By.id("salary"));
    private final SelenideElement department = $(By.id("department"));
    private final SelenideElement clickAddButton = $(By.id("addNewRecordButton"));
    private final SelenideElement submit = $(By.id("submit"));


    @Given("user in on the Web Tables")
    public void user_in_on_the_web_tables() {
        Selenide.open("https://demoqa.com/webtables");

    }

    @And("fills in new users")
    public void fillsInNewUsers(io.cucumber.datatable.DataTable dataTable) {
        clickAddButton.click();
        Map<String, String> profileInfo = dataTable.asMap(String.class, String.class);
        if (profileInfo.containsKey("First Name")) {
            firstName.sendKeys(profileInfo.get("First Name"));
            if (profileInfo.containsKey("Last Name")) {
                lastName.sendKeys(profileInfo.get("Last Name"));
                if (profileInfo.containsKey("Email")) {
                    userEmail.sendKeys(profileInfo.get("Email"));
                    if (profileInfo.containsKey("Age")) {
                        age.sendKeys(profileInfo.get("Age"));
                        if (profileInfo.containsKey("Salary")) {
                            salary.sendKeys(profileInfo.get("Salary"));
                            if (profileInfo.containsKey("Department")) {
                                department.sendKeys(profileInfo.get("Department"));
                                Selenide.sleep(3000);
                                submit.click();
                            }
                        }
                    }
                }
            }
        }
    }

    @Then("get text list of user")
    public void getTextListOfUser() {
    Selenide.sleep(1000);
        }
    }

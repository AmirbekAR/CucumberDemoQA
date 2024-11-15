package demo.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import demo.helper.SelenideElementActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.PracticeFormPage;

import java.io.File;

public class PracticeFormStepDef extends PracticeFormPage {
    SelenideElementActions elementActions = new SelenideElementActions();

    @Given("Student Registration Form")
    public void openUrl() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @And("user enter first name")
    public void userEnterFirstName() {
        getFirstName().sendKeys("Timur");
    }

    @And("user enter last name")
    public void userEnterLastName() {
        getLastName().sendKeys("Temirov");
    }

    @And("user enter email for Practice form")
    public void userEnterEmailForPracticeForm() {
        getUserEmail().sendKeys("temir@gmail.com");
    }

    @And("user choose gender {string}")
    public void userChooseGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            getMale().scrollTo().click(); // Клик по метке для Male
        } else if (gender.equalsIgnoreCase("Female")) {
            getFemale().scrollTo().click(); // Клик по метке для Female
            Selenide.sleep(1000);
        }
    }

    @And("user enter mobile number")
    public void userEnterMobileNumber() {
        getUserNumber().sendKeys("0777668877");
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        getDateOfBirthInput().sendKeys(Keys.COMMAND + "a");
        getDateOfBirthInput().sendKeys("30 Oct 2010" + Keys.ESCAPE);
        Selenide.sleep(1000);
    }


    @And("user choose subjects")
    public void userEnterSubjects() throws InterruptedException {
        getSubjectsInput().sendKeys("math");
        elementActions.pressEnter(getSubjectsInput());
        Selenide.sleep(1000);
    }

    @And("user choose hobbies {string}")
    public void userChooseHobbies(String hobbies) {
        switch (hobbies) {
            case "Sports" :
                elementActions.clickElementWithJsExecutor(getSportsClick());
                break;
            case "Reading" :
                elementActions.clickElementWithJsExecutor(getReadingClick());
                break;
            case "Music" :
                elementActions.clickElementWithJsExecutor(getMusicClick());
                Selenide.sleep(2000);
        }
    }

    @And("user download picture")
    public void userDownloadPicture() {
        String filePath = "/Users/amir/Desktop/Screenshot2024.png";
        File file = new File(filePath);
        SelenideElement uploadButton = getUploadPicture();
        Selenide.sleep(2000);
        uploadButton.uploadFile(file);
    }

    @And("user enter current address for Practice form")
    public void userCurrentAddress() {
        getCurrentAddress().setValue("some address 123");
        Selenide.sleep(2000);
    }

    @And("user select state {string}, {string}")
    public void userSelectState(String states, String city) {
        elementActions.click(getClickState());
        Selenide.sleep(1000);

        switch (states) {

            case "NCR" :
                elementActions.clickElementWithJsExecutor(getNcr());
                elementActions.click(getClickCity());
                if (city.equals("Delhi")) {
                    getDelhi().click();
                } else if (city.equals("Gurgaon")) {
                    getGurgaon().click();
                } else {
                    getNoida().click();
                }
                Selenide.sleep(1000);
                break;

            case "Uttar Pradesh" :
                elementActions.clickElementWithJsExecutor(getUttarPradesh());
                elementActions.click(getClickCity());
                if (city.equals("Agra")) {
                    getAgra().click();
                } else if (city.equals("Lucknow")) {
                    getLucknow().click();
                } else {
                    getMerrut().click();
                }
                Selenide.sleep(1000);
                break;

            case "Haryana":
                elementActions.clickElementWithJsExecutor(getHaryana());
                elementActions.click(getClickCity());
                if (city.equals("Karnal")) {
                    getKarnal().click();
                } else {
                    getPanipat().click();
                }
                Selenide.sleep(1000);
                break;

            case "Rajasthan":
                elementActions.clickElementWithJsExecutor(getRajasthan());
                elementActions.click(getClickCity());
                if (city.equals("Jaipur")) {
                getJaipur().click();
                } else {
                    getJaiselmer().click();
                }
                break;
            default:
                System.out.println("Not clickable");
        }
    }

    @When("user click submit button for Practice for")
    public void clickSubmitButton() {
        getSubmit().click();
        Selenide.sleep(3000);
    }
}

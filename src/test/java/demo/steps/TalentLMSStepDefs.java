package demo.steps;

import com.codeborne.selenide.*;
import demo.helper.SelenideElementActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TalentLMSStepDefs {


    SelenideElement inputLogin = $x("//input[@name='login']");
    SelenideElement inputPassword = $x("//input[@name='password']");
    SelenideElement loginButton = $$(".btn-primary").find(visible);

    ElementsCollection mainMenu = $$x("//ul[@id='main-menu']/li");
    SelenideElement usersMain = $x("//li[@data-testid='users-menu-item']");
    SelenideElement coursesMain = $x("//li[@data-testid='courses-menu-item']");
    SelenideElement accountAndSettingsMainSelect = $x("//div[contains(text(),'Account & Settings')]");
    SelenideElement accountAndSettingsMain = $x("//a[@aria-label='Account & Settings'][2]");
    SelenideElement clickAddUser = $x("//span[@class='btn-with-dropdown-text']");

    SelenideElement inputFirstName = $x("//input[@data-testid='first-name']");
    SelenideElement inputLastName = $x("//input[@data-testid='last-name']");
    SelenideElement inputEmail = $x("//input[@data-testid='email']");
    SelenideElement inputBio = $x("//textarea[@id='description']");
    SelenideElement inputUserName = $x("//input[@data-testid='username']");
    SelenideElement inputPassword2 = $x("//input[@data-testid='password']");
    SelenideElement languageChoose = $x("(//div[@class=' css-b62m3t-container'])[2]");
    SelenideElement userLanguageClick = $x("(//div[@class=' css-19bb58m'])[1]");
    SelenideElement userTypeClick = $x("//div[@role='tooltip']//div[@class='custom-value' and text()='Learner-Type']");
    SelenideElement saveClick = $x("//span[normalize-space()='Save']");
    SelenideElement element = $x("//span[@id='react-select-3-live-region']");
    SelenideElement notificationMain = $x("(//div[contains(text(),'Notifications')])[1]");


    @Given("user is on TalentLMS login page")
    public void userIsOnTalentLMSLoginPage() {
        open("https://amihost.talentlms.com/index");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @And("user log in {string} {string}")
    public void userLogIn(String userName, String password) throws InterruptedException {
        SelenideElementActions elementActions = new SelenideElementActions();
        try {
            elementActions.input(inputLogin, userName);
            elementActions.input(inputPassword, password);
            loginButton.click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user choose menu-main {string}")
    public void userChooseMenuMain(String chooseMain) {
        SelenideElementActions elementActions = new SelenideElementActions();
        switch (chooseMain) {
            case "Users" :
                elementActions.click(usersMain);
                sleep(1000);
                break;
            case "Courses" :
                elementActions.click(coursesMain);
                sleep(1000);
                break;
            case "Account & Setting" :
                elementActions.click(accountAndSettingsMainSelect);
                break;
            case "Notifications" :
                elementActions.click(notificationMain);
                break;
        }
    }

    @And("user click add user button")
    public void userClickAddUserButton() {
        SelenideElementActions elementActions = new SelenideElementActions();
        elementActions.click(clickAddUser);
        Selenide.sleep(2000);
    }

    @And("fill up the form with add new user")
    public void fillUpTheFormWithAddNewUser(List<List<String>> textBoxData) {

        for (int i = 1; i < textBoxData.size(); i++) {
            List<String> row = textBoxData.get(i);
            String firstName = row.get(0);
            String lastName = row.get(1);
            String email = row.get(2);
            String bio = row.get(3);
            String userName = row.get(4);
            String password = row.get(5);



            inputFirstName.sendKeys(firstName);
            inputLastName.sendKeys(lastName);
            inputEmail.sendKeys(email);
            inputBio.sendKeys(bio);
            inputUserName.sendKeys(userName);
            inputPassword2.sendKeys(password);
            Selenide.sleep(2000);

            }
            Selenide.sleep(2000);
                saveClick.scrollTo().click();
    }
}

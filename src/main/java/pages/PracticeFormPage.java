package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PracticeFormPage {

    SelenideElement firstName = $(By.id("firstName"));
    SelenideElement lastName = $(By.id("lastName"));
    SelenideElement userEmail = $(By.id("userEmail"));
    SelenideElement male = $x("//label[@for='gender-radio-1']");
    SelenideElement female = $x("//label[@for='gender-radio-2']");
    SelenideElement userNumber = $(By.id("userNumber"));
    SelenideElement dateOfBirthInput = $(By.id("dateOfBirthInput"));
    SelenideElement subjectsInput = $(By.id("subjectsInput"));
    SelenideElement sportsClick = $(By.id("hobbies-checkbox-1"));
    SelenideElement readingClick = $(By.id("hobbies-checkbox-2"));
    SelenideElement musicClick = $(By.id("hobbies-checkbox-3"));
    SelenideElement uploadPicture = $(By.id("uploadPicture"));
    SelenideElement currentAddress = $(By.id("currentAddress"));

    SelenideElement ncr = $(By.id("react-select-3-option-0"));
        SelenideElement delhi = $x("//div[contains(text(),'Delhi')]");
        SelenideElement gurgaon = $x("//div[contains(text(),'Gurgaon')]");
        SelenideElement noida = $x("//div[contains(text(),'Noida')]");


    SelenideElement uttarPradesh = $(By.id("react-select-3-option-1"));
        SelenideElement agra = $x("//div[contains(text(),'Agra')]");
        SelenideElement lucknow = $x("//div[contains(text(),'Lucknow')]");
        SelenideElement merrut = $x("//div[contains(text(),'Merrut')]");


    SelenideElement haryana = $(By.id("react-select-3-option-2"));
        SelenideElement karnal = $x("//div[contains(text(),'Karnal')]");
        SelenideElement panipat = $x("//div[contains(text(),'Panipat')]");

    SelenideElement rajasthan = $(By.id("react-select-3-option-3"));
        SelenideElement jaipur = $x("//div[contains(text(),'Jaipur')]");
        SelenideElement jaiselmer = $x("//div[contains(text(),'Jaiselmer')]");

    SelenideElement clickState = $(By.id("state"));
    SelenideElement clickCity = $(By.id("city"));
    SelenideElement submit = $(By.id("submit"));
}

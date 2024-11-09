package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TextBoxPage {
    private SelenideElement userName = $(By.id("userName"));
    private SelenideElement userEmail = $(By.id("userEmail"));
    private SelenideElement currentAddress = $(By.id("currentAddress"));
    private SelenideElement permanentAddress = $(By.id("permanentAddress"));
    private SelenideElement submitButton = $(By.id("submit"));

}
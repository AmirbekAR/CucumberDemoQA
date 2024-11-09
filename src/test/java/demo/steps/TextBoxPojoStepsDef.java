package demo.steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import pages.TextBoxPage;
import pages.pojo.TextBoxPojo;
import java.util.List;
import java.util.Map;

public class TextBoxPojoStepsDef {
    TextBoxPage textBoxPage = new TextBoxPage();

    // Преобразование строки таблицы в POJO
    @DataTableType
    public TextBoxPojo convert(Map<String, String> entry) {
        return TextBoxPojo.builder()
                .fullName(entry.get("fullName"))
                .email(entry.get("email"))
                .currentAddress(entry.get("currentAddress"))
                .permanentAddress(entry.get("permanentAddress"))
                .build();
    }

    @And("fill up Text box form with following data")
    public void fill_up_the_form_with_following_with_data(List<TextBoxPojo> textBoxPojos) {
        for (TextBoxPojo pojo : textBoxPojos) {
            textBoxPage.getUserName().sendKeys(pojo.getFullName());
            textBoxPage.getUserEmail().sendKeys(pojo.getEmail());
            textBoxPage.getCurrentAddress().sendKeys(pojo.getCurrentAddress());
            textBoxPage.getPermanentAddress().sendKeys(pojo.getPermanentAddress());
            textBoxPage.getSubmitButton().click();
            System.out.println("Заполняем форму данными: " + pojo);
        }
    }
}

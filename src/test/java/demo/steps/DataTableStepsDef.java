package demo.steps;

import io.cucumber.java.en.Given;
import java.util.List;

public class DataTableStepsDef {

    @Given("fill up the form with following with data")
    public void fill_up_the_form_with_following_with_data(List<List<String>> textBoxData) {
        for (int i = 1; i < textBoxData.size(); i++) {
            List<String> row = textBoxData.get(i);
            String name = row.get(0);
            String email = row.get(1);
            String currentAddress = row.get(2);
            String permanentAddress = row.get(3);

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Current Address: " + currentAddress);
            System.out.println("Permanent Address: " + permanentAddress);
            System.out.println("---------------");
        }
    }

    @Given("user is not on Text box page")
    public void userIsNotOnTextBoxPage() {
        System.out.println("User is not opening the Text box page.");
    }
}

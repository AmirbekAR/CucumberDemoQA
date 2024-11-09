package demo.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SortableStepDefs {

    private Actions actions;

    private final ElementsCollection listCollection = $$x("//div[@id='demo-tabpane-list']/div/div");
    private final ElementsCollection gridCollection = $$x("//div[@class='create-grid']/div");
    private final SelenideElement gridButton = $x("//a[@id='demo-tab-grid']");

    @Given("user on page browser for sortable")
    public void userOnPageBrowserForSortable() {
        Selenide.open("https://demoqa.com/sortable");

        actions = new Actions(WebDriverRunner.getWebDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @And("user swaps the numbers for List")
    public void user_swaps_the_numbers_for_list() {
        Selenide.sleep(1000);
        actions.clickAndHold(listCollection.get(1))
                .moveToElement(listCollection.get(4))
                .release()
                .build()
                .perform();
        Selenide.sleep(2000);
    }

    @And("user swaps the numbers for Grid")
    public void user_swaps_the_numbers_for_grid() {
        gridButton.click();
        actions.clickAndHold(gridCollection.get(1))
                .moveToElement(gridCollection.get(6))
                .release()
                .build()
                .perform();
        Selenide.sleep(2000);
    }
}

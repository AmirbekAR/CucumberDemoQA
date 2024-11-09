package demo.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class Hook {

    @Before(order = 1)
    public void setUpAllureSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)  // Включаем скриншоты
                .savePageSource(true)  // Включаем сохранение page source
                .includeSelenideSteps(true));  // Включаем шаги Selenide в отчет
    }

    @Before(order = 0)
    public void setUp() {
        Configuration.browser = "chrome"; // Вы можете динамически выбирать браузер
        Configuration.headless = false; // для безголового режима
    }

    @After(order = 0)
    public void tearDownAllure() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide"); // Удаляем слушателя после теста
    }

    @io.cucumber.java.AfterStep
    public void makeScreenShot() {
        String testName = "unknown_test"; // Здесь можно получить имя теста динамически
        String threadId = String.valueOf(Thread.currentThread().getId());
        String screenshotName = "step_" + testName + "_" + threadId + "_" + System.currentTimeMillis();
        System.out.println("Making screenshot after step...");
        Selenide.screenshot(screenshotName);  // Делает скриншот с уникальным именем
    }
}

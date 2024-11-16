package demo.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hook {

    @Before(order = 1)
    public void setUpAllureSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)  // Включаем скриншоты
                .savePageSource(true)  // Включаем сохранение page source
                .includeSelenideSteps(true));  // Включаем шаги Selenide в отчет
    }

    @Before(order = 0)
    public void setUpDriver() {

        // Конфигурация Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.timeout = 10000;  // Таймаут ожидания для поиска элементов
        Configuration.pageLoadTimeout = 60000;  // Таймаут на загрузку страницы (60 секунд)

    }

    @After(order = 0)
    public void tearDownAllure() {
        // Очистка cookies и закрытие браузера
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide"); // Удаляем слушателя после теста
    }

    @io.cucumber.java.AfterStep
    public void makeScreenShot() {
        // Получаем динамическое имя теста через Cucumber context (если нужно)
        String testName = "unknown_test"; // В реальности получите имя теста динамически
        String threadId = String.valueOf(Thread.currentThread().getId());
        String screenshotName = "step_" + testName + "_" + threadId + "_" + System.currentTimeMillis();
        System.out.println("Making screenshot after step...");
        Selenide.screenshot(screenshotName);  // Делает скриншот с уникальным именем
    }
}

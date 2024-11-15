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
        // Инициализация WebDriver с использованием WebDriverManager
        WebDriverManager.chromedriver().setup();  // Автоматически загружает и настраивает ChromeDriver

        // Опции для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Открытие окна браузера на весь экран
        options.addArguments("--disable-notifications"); // Отключение уведомлений

        // Конфигурация Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";  // Устанавливаем размер окна браузера
        Configuration.timeout = 10000;  // Устанавливаем таймаут ожидания элементов

        // Устанавливаем дополнительные опции для Chrome
        Configuration.browserCapabilities = options;
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

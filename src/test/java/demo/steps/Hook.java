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
    public void setUp() {
        // Настройка WebDriverManager для автоматической загрузки нужного драйвера
        WebDriverManager.chromedriver().setup();

        // Устанавливаем браузер как Chrome
        Configuration.browser = "chrome";

        // Проверяем, если нужно использовать headless режим
        Configuration.headless = false; // Устанавливаем headless режим

        // Настройка опций для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless",            // Режим без интерфейса
                "--disable-gpu",         // Отключение GPU
                "--no-sandbox",          // Отключение sandbox (нужно для CI/CD)
                "--disable-dev-shm-usage", // Для работы с ограниченным ресурсом памяти
                "--remote-debugging-port=9222" // Порт для отладки
        );

        // Устанавливаем ChromeDriver с опциями
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

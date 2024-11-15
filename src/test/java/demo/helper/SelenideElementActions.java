package demo.helper;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;

public class SelenideElementActions {

    // Общий метод для ожидания видимости и прокрутки
    private void waitAndScroll(SelenideElement element, Duration duration) {
        element.shouldBe(visible, duration);
        element.scrollTo();
    }

    // Клик по элементу
    public SelenideElementActions click(SelenideElement element) {
        waitAndScroll(element, Duration.ofSeconds(10));
        element.click();
        return this;
    }

    // Ввод текста в элемент
    public SelenideElementActions input(SelenideElement element, String text) {
        waitAndScroll(element, Duration.ofSeconds(10));
        element.sendKeys(text);
        return this;
    }

    // Получение текста из элемента
    public String getText(SelenideElement element) {
        waitAndScroll(element, Duration.ofSeconds(5));
        element.shouldNotBe(empty);
        return element.getText();
    }

    // Обновление страницы
    public void refreshPage() {
        Selenide.refresh();
    }

    // Клик с использованием JavaScript
    public SelenideElementActions clickElementWithJsExecutor(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click();", element);
        return this;
    }

    // Получение значения из элемента
    public String getValue(SelenideElement element) {
        waitAndScroll(element, Duration.ofSeconds(5));
        element.shouldNotBe(empty);
        return element.getValue();
    }

    // Выбор опции в элементе
    public SelenideElementActions selectOption(SelenideElement element, String text) {
        waitAndScroll(element, Duration.ofSeconds(5));
        element.selectOption(text);
        return this;
    }

    // Нажатие Enter
    public SelenideElementActions pressEnter(SelenideElement element) {
        waitAndScroll(element, Duration.ofSeconds(5));
        element.pressEnter();
        return this;
    }

    // Нажатие Tab
    public SelenideElementActions pressTab(SelenideElement element) {
        waitAndScroll(element, Duration.ofSeconds(5));
        element.pressTab();
        return this;
    }

    // Работа с WebElement
    private void waitElementToBeVisible(WebElement element) {
        new WebDriverWait(Selenide.webdriver().driver().getWebDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }

    private void waitElementToBeClickable(WebElement element) {
        new WebDriverWait(Selenide.webdriver().driver().getWebDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Прокрутка WebElement в видимую часть экрана
    public void scrollToElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Ожидание и клик по WebElement
    public void click(WebElement element) {
        waitElementToBeVisible(element);
        scrollToElement(element);
        element.click();
    }

    // Прокрутка и очистка поля WebElement
    public void scrollAndClear(WebElement element) {
        scrollToElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
        executor.executeScript("arguments[0].value = '';", element);
    }

//    // Двойной клик по WebElement
//    public void doubleClick(WebElement element) {
//        waitElementToBeClickable(element);
//        Action action;
//        actions.doubleClick(element).build().perform();
//    }
//
//    // Правый клик по WebElement
//    public void rightClick(WebElement element) {
//        waitElementToBeClickable(element);
//        actions.contextClick(element).build().perform();
//    }

    // Проверка видимости WebElement
    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Клик по WebElement с использованием JavaScript
    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    // Подсветка WebElement с помощью JavaScript
    public void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) Selenide.webdriver().driver().getWebDriver();
        executor.executeScript("arguments[0].style.border='3px solid red';", element);
    }
}

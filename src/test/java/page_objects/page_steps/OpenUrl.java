package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static page_objects.page_elements.EdujiraStartPage.bodyStartPage;
import static web_hooks.WebHooks.saveScreenshot;

public class OpenUrl {

    @Step("Открываем сайт: {url} и проверяем наличие Body" )
    public static void openUrlGetWebDriver(String url) {
        open(url);
        getWebDriver().manage().window().maximize();
        saveScreenshot("Открываем сайт: " + url + "и проверяем наличие Body");

        Assertions.assertTrue(bodyStartPage.shouldBe(Condition.visible).exists(), "На странице отсутствует Body.");
    }
}

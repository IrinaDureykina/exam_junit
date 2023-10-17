package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.EdujiraStartPage;

import java.util.Objects;

import static page_objects.web_hooks.WebHooks.saveScreenshot;


public class CheckUrl extends EdujiraStartPage {
    @Step("Сверяем URL страницы с введенным {url} и наличие ссылки на главную страницу сайта" )
    public static void checkUrlPageHref(String url) {
        saveScreenshot("Сверяем URL страницы с введенным: "+ url+" и наличие ссылки на главную страницу сайта");
        Assertions.assertTrue(Objects.requireNonNull(homePageHref.shouldBe(Condition.visible).attr("href")).contains(url), "Страница не содержит ссылки на главную страницу или она не верна");
        Assertions.assertTrue(WebDriverRunner.url().contains(url), "URL не совпадает с введенным");
    }
}

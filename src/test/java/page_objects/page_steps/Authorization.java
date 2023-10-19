package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.EdujiraStartPage;

import static page_objects.page_elements.HomePage.*;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static page_objects.web_hooks.WebHooks.saveScreenshot;

public class Authorization extends EdujiraStartPage {

    @Step("Вводим имя прользователя: \"{login}\" вводим пароль: \"{password}\" и нажимаем Войти")
    public static void authorization(String login, String password) {
        inputField(inputLogin, login, "Имя пользователя", false);
        inputField(inputPassword, password, "Пароль", false);
        buttonClick(battonLogin, "Кнопка 'Войти'");
        saveScreenshot("Вводим имя прользователя: " + login + ", вводим пароль: " + password + " и нажимаем Войти");
    }

    @Step("Заходим в профиль")
    public static void profileLogIn() {
        buttonClick(profileBatton, "Кнопка пользовательский профиль");
        buttonClick(profileLink, "Ссылка профиль");
        saveScreenshot("Вход в профиль");
    }

    @Step("Сверяем имя профиля с введенным {login}")
    public static void authorizationCheck(String login) {
        saveScreenshot("Сверяем имя профиля с введенным: " + login);
        Assertions.assertEquals(nameUser.shouldBe(Condition.visible).getOwnText(), login, "Не авторизованы");
    }
}

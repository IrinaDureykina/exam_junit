package page_objects.page_steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.HomePage;

import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.web_hooks.WebHooks.saveScreenshot;

public class OpenProject extends HomePage {

    @Step("Заходим в проект {nameProject}")
    public static void openProject(String nameProject) {

        buttonClick(openProjectButton, "Project Button");
        buttonClick(openProjectLink(nameProject), "Project Link");
        buttonClick(allIssues, "Задачи");
        saveScreenshot("Заходим в проект: " + nameProject);

    }

    @Step("Получаем количество задач в проекте и проверяем наличие значения в поле")
    public static void countIssue() {
        Assertions.assertTrue(countIssues.is(Condition.visible), "Количество задач не отображается.");
        String countIssuesText = countIssues.getOwnText();
        String newCountIssues = countIssuesText.replace("1 из ", "");
        saveScreenshot("Получаем количество задач в проекте и проверяем наличие значения в поле");
        Assertions.assertNotNull(newCountIssues.isEmpty(), "Нет значения в количестве задач.");
    }
}

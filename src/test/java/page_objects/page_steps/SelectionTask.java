package page_objects.page_steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.HomePage;

import static page_objects.page_elements.BrowseTaskPage.taskStatus;
import static page_objects.page_elements.BrowseTaskPage.taskVersions;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static page_objects.web_hooks.WebHooks.saveScreenshot;

public class SelectionTask extends HomePage {

    @Step("Производим поиск задачи по имени: {nameTask}")
    public static void selectionTask(String nameTask) {
        inputField(searchInput, nameTask, "Поиск", true);
        buttonClick(taskLink, "issueLink");
        saveScreenshot("Производим поиск задачи по имени: " + nameTask);
    }

    @Step("Сверяем статус задачи с: {statusTask} и поле Затронуты версии: {affectVersion}")
    public static void selectedTaskCheck(String statusTask, String affectVersion) {
        saveScreenshot("Сверяем статус задачи с: " + statusTask + " и поле Затронуты версии: "+ affectVersion);
        Assertions.assertEquals(statusTask, taskStatus.getOwnText(), "Не верный статус задачи");
        Assertions.assertTrue(taskVersions.getOwnText().contains(affectVersion), "Не верная привязка задачи к затронутой версии");
    }
}

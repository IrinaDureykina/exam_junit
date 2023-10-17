package page_objects.page_steps;

import org.junit.jupiter.api.Assertions;
import page_objects.page_elements.HomePage;

import static io.qameta.allure.Allure.step;
import static page_objects.page_elements.BrowseTaskPage.taskStatus;
import static page_objects.page_elements.BrowseTaskPage.taskVersions;
import static page_objects.page_steps.InputFieldClickButton.buttonClick;
import static page_objects.page_steps.InputFieldClickButton.inputField;
import static page_objects.web_hooks.WebHooks.saveScreenshot;

public class SelectionTask extends HomePage {

    public static void selectionTask(String nameTask) {

        step("Производим поиск задачи по имени: "+ nameTask, () -> {
            inputField(searchInput, nameTask, "Поиск", true);
            buttonClick(taskLink, "issueLink");
            saveScreenshot("Производим поиск задачи по имени: " + nameTask);

        });
    }

    public static void selectedTaskCheck(String statusTask, String affectVersion) {

        step("Сверяем статус задачи с: "+statusTask+" и поле Затронуты версии: " +affectVersion, () -> {
            saveScreenshot("Сверяем статус задачи с: " + statusTask + " и поле Затронуты версии: "+ affectVersion);
            Assertions.assertEquals(statusTask, taskStatus.getOwnText(), "Не верный статус задачи");
            Assertions.assertTrue(taskVersions.getOwnText().contains(affectVersion), "Не верная привязка задачи к затронутой версии");
        });
    }
}

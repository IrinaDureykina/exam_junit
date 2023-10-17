package page_objects;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page_objects.web_hooks.WebHooks;

import static page_objects.page_steps.Authorization.*;
import static page_objects.page_steps.CheckUrl.checkUrlPageHref;
import static page_objects.page_steps.CreatingTask.creatingTask;
import static page_objects.page_steps.CreatingTask.switchingTask;
import static page_objects.page_steps.OpenProject.countIssue;
import static page_objects.page_steps.OpenProject.openProject;
import static page_objects.page_steps.OpenUrl.openUrlGetWebDriver;
import static page_objects.page_steps.SelectionTask.selectedTaskCheck;
import static page_objects.page_steps.SelectionTask.selectionTask;
import static util.Config.getProperties;

@Epic("Junit")
@Feature("Jira")
public class TestIfellowEdujira extends WebHooks {

    private final String url = getProperties("URL");
    private final String login = getProperties("login");
    private final String password = getProperties("password");
    private final String nameProject = "TEST";
    private final String nameTask = "TestSelenium";
    private final String statusTask = "Сделать";
    private final String affectVersion = "Version 2.0";
    private final String issueType = "Ошибка";
    private final String issueSummaryValue = "Проверка создания задачи.";

    @Test
    @Story("Проверка доступности сайта и авторизация")
    @Description("Тест открывает URL и проверяет правильность URL  и наличие ссылки на главную страницу")
    @DisplayName("Проверка доступности сайта")
    public void checkUrlTest() {
        openUrlGetWebDriver(url);
        checkUrlPageHref(url);
    }

    @Test
    @Story("Проверка доступности сайта и авторизация")
    @Description("Тест проверяет авторизацию на сайте с валидными логином и паролем")
    @DisplayName("Проверка авторизации")
    public void authorizationTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        authorizationCheck(login);
    }

    @Test
    @Story("Проверка поиска")
    @Description("Тест проверяет доступность поля 'Количество задач' и наличие значения ")
    @DisplayName("Проверка количества задач")
    public void openProjectTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        openProject(nameProject);
        countIssue();
    }

    @Test
    @Story("Проверка поиска")
    @Description("Тест выбирает задачу по заданному имени и проверяет поля на валидные значения")
    @DisplayName("Проверка поиска задачи и заполнения полей")
    public void selectTaskTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        selectionTask(nameTask);
        selectedTaskCheck(statusTask, affectVersion);
    }

    @Test
    @Story("Создание задачи и перевод по статусам")
    @Description("Тест создаёт задачу с валидными данными и переводит её по статусам")
    @DisplayName("Проверка создания задачи и перевода по статусам")
    public void creatingTaskTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        creatingTask(issueType, issueSummaryValue);
        switchingTask();
    }
}

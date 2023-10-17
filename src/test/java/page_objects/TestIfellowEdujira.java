package page_objects;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import web_hooks.WebHooks;

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

@Feature("Junit")
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
    public void checkUrlTest() {
        openUrlGetWebDriver(url);
        checkUrlPageHref(url);
    }

    @Test
    public void authorizationTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        authorizationCheck(login);
    }

    @Test
    public void openProjectTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        openProject(nameProject);
        countIssue();
    }

    @Test
    public void selectTaskTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        selectionTask(nameTask);
        selectedTaskCheck(statusTask, affectVersion);
    }

    @Test
    public void creatingTaskTest() {
        openUrlGetWebDriver(url);
        authorization(login, password);
        profileLogIn();
        creatingTask(issueType, issueSummaryValue);
        switchingTask();
    }
}

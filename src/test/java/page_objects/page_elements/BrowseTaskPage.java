package page_objects.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowseTaskPage {

    public static SelenideElement taskStatus = $x("//span[@id='status-val']//following-sibling::span");

    public static SelenideElement taskVersions = $x("//span[@id='versions-val' and @title='Нажмите, чтобы изменить']");

    public static SelenideElement inWorkButton = $x("//a[@id='action_id_21']/span[contains(text(),'В работе')]");

    public static SelenideElement businessProcessButton = $x("//span[contains(text(),'Бизнес-процесс')]//ancestor::a");

    public static SelenideElement closeButton = $x("//div[contains(text(),' был обновлен.')]/button[@aria-label='Закрыть']");

    public static SelenideElement executedButton = $x("//span[contains(text(),'Исполнено')]//ancestor::a");

    public static SelenideElement executedButtonForm = $x("//input[@id='issue-workflow-transition-submit' and @value='Исполнено']");

    public static SelenideElement confirmedButton = $x("//span[contains(text(),'Подтверждено')]//ancestor::a");

    public static SelenideElement confirmedButtonForm = $x("//input[@value='Подтверждено' and @id='issue-workflow-transition-submit']");


}

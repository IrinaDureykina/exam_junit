package page_objects.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CreatingTaskForm {

    public static SelenideElement issueTypeSelect = $x("//div[@id='issuetype-single-select']/input");

    public static SelenideElement issueSummary = $x(" //input[@id='summary' and @name='summary']");


    public static SelenideElement CreateIssueButton = $x(" //input[@id='create-issue-submit' and @value='Создать']");

    public static SelenideElement messageIssueKey = $x(" //div[contains(text(),'Запрос ')]/a");

    public static SelenideElement messageDescription = $x("//html/body[@id='tinymce' and @data-id='mce_12']");

    public static SelenideElement fixVersionSelector = $x("//label[contains(text(),'Исправить в версиях')]//following-sibling::select//descendant::option[@value='10000']");

    public static SelenideElement priorityselector = $x("//input[@aria-label='Приоритет']");

    public static SelenideElement tagsSlectorClik = $x("//div[@id='labels-multi-select']/span");

    public static SelenideElement tagsSlector = $x("(//ul[@id=\"предложения\"]/li/a)[1]");

    public static SelenideElement affectedVersionsSelector = $x("//label[contains(text(),'Затронуты версии')]//following-sibling::select//descendant::option[@value='10000']");

    public static SelenideElement relatedTagsSlector = $x("//select[@id='issuelinks-linktype']/option[@value='blocks']");

    public static SelenideElement taskSlectorClik = $x("//div[@id='issuelinks-issues-multi-select']/span");

    public static SelenideElement taskSlector = $x("(//ul[@id=\"поиск-по-истории\"]//a)[3]");

    public static SelenideElement appointMeButton = $x("//button[contains(text(),'Назначить меня')]");

    public static SelenideElement sprintSlectorClik = $x("//div[@class='field-group']/label[contains(text(),'Спринт')]//following-sibling::div/div/span");

    public static SelenideElement sprintSlector = $x(" (//ul[@id='предложения']/li[contains(@id,'доска-спринт')]/a)[1]");

    public static SelenideElement returnFrameField = $x("//body[@id='tinymce']/p");

    public static SelenideElement frameInputField(String text) {
        return $x("//label[contains(text(),'" + text + "')]//following-sibling::div//iframe");
    }


}

package page_objects.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    public static SelenideElement nameUser = $x("//dt[contains(text(),'Полное имя:')]//following-sibling::dd");

    public static SelenideElement profileBatton = $x("//a[@id='header-details-user-fullname' and contains(@title, 'Пользовательский профиль для')]");

    public static SelenideElement profileLink = $x("//li/a[contains(text(),'Профиль')]");

    public static SelenideElement allIssues = $x("//span[contains(text(),'Задачи')]/ancestor::a[@class='aui-nav-item ']");

    public static SelenideElement openProjectButton = $x("//a[contains(text(),'Проекты') and @aria-controls = 'browse_link-content']");

    public static SelenideElement openProjectLink(String text) {
        return $x("//a[contains(text(),'" + text + "')]");
    }

    public static SelenideElement countIssues = $x("//div[@class='pager']/div[@class='showing']/span[contains(text(),'1 из')]");

    public static SelenideElement searchInput = $x("//input[@id='quickSearchInput']");

    public static SelenideElement taskLink = $x("//a[@id='key-val']");

    public static SelenideElement createBatton = $x("//a[@id='create_link' and contains(text(),'Создать')]");

    public static SelenideElement tasksButton = $x("//a[@id='find_link' and @title='Поиск и просмотр недавних задач']");

    public static SelenideElement reportedByMeButton = $x("//a[@id='filter_lnk_reported_lnk' and contains(text(),'Сообщенные мной')]");


}

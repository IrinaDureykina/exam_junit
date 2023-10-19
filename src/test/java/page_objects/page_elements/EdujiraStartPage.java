package page_objects.page_elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class EdujiraStartPage {

    public static SelenideElement homePageHref = $x("//span[@id='logo']/a[contains(@aria-label,'Перейти на главную страницу')]");

    public static SelenideElement inputLogin = $x("//input[@id='login-form-username' and @name='os_username']");

    public static SelenideElement inputPassword = $x("//input[@id='login-form-password' and @name='os_password']");

    public static SelenideElement battonLogin = $x("//input[@id='login' and @value='Войти']");

    public static SelenideElement bodyStartPage = $x("//body[@id='jira']");
}

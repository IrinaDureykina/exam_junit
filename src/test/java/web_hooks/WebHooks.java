package web_hooks;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static util.Config.getProperties;


public class WebHooks {



    @BeforeEach
    public void allureSelenideListener() {
        String listenerName = "Allureselenide";
        if(SelenideLogger.hasListener(listenerName)) {
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide()
                            .screenshots(true)
                            .savePageSource(false)));
        }
    }

    @Attachment(value = "{nameScreenshot}", type = "image/png")
    public static byte[] saveScreenshot(String nameScreenshot) {
        return Selenide.screenshot(OutputType.BYTES);
    }


    @AfterEach
    public void afterTest() {
        saveScreenshot("Скриншот после выполнения теста");
        WebDriverRunner.closeWebDriver();
        SelenideLogger.removeListener("Allureselenide");
    }
}

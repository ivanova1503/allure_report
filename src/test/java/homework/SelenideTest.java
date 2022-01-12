package homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test

    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());    // листенер для отчёта

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("ivanova1503/allure_report");
        $(".header-search-input").submit();

        $(linkText("ivanova1503/allure_report")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#2")).should(Condition.visible);

}

}

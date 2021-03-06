package dex.ivanova.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;

    @Test
    public void lambdaStepsTest() {

        step("Открываем главную страницу", ()-> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY,() -> {
             $(".header-search-input").click();
             $(".header-search-input").sendKeys(REPOSITORY);
             $(".header-search-input").submit();
         }) ;
        step("Переходим в репозиторий" + REPOSITORY,() -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем tab Issues", ()->{
            $(By.partialLinkText("Issues")).click();
        });
        step ("Проверяем наличие issue с номером," + NUMBER, () ->{
            $(withText("#"+ NUMBER )).should(Condition.visible);
        }) ;
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(NUMBER);
    }

}

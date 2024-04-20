package ru.aydar.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.aydar.pages.JobsPage;

@Epic("UI сайта IBS.ru")
@Feature("Страница вакансий")
@DisplayName("Сценарии проверок страницы вакансий")
public class JobsPageTests extends TestBase {
    JobsPage jobsPage = new JobsPage();
    int checkboxesToCheck = 5;

    @Story("Раскрывающиеся группы фильтров списка вакансий")
    @DisplayName("Фильтры: ")
    @ParameterizedTest(name = "Проверка отображения фильтра {1} при раскрытии группы {0}")
    @CsvSource(value = {
            "Направление , Все направления",
            "Город , Любой город",
            "Технологии , Все технологии"
    })
    @Severity(SeverityLevel.CRITICAL)
    @Owner("aydarium")
    void collapsibleFiltersTest(String header, String filter) {
        jobsPage.openPage()
                .clickJobsFilterHeader(header)
                .checkJobFilterIsVisible(filter);
    }

    @Test
    @DisplayName("Проверка поля для приложения резюме в соответствии с опцией «файлом/ссылкой»")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void resumeRadioButtonsTest() {
        jobsPage.openPage()
                .clickResumeLinkRadio()
                .checkLinkFieldIsVisible()
                .clickResumeFileRadio()
                .checkFileFieldIsVisible();
    }

    @Test
    @DisplayName("Проверка работы чекбоксов фильтров")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void filterCheckboxesTest() {
        jobsPage.openPage()
                .checkFilterCounterIsNotVisible()
                .checkFilterClearButtonIsNotVisible();
        for (int i = 0; i < checkboxesToCheck; i++) {
            jobsPage.clickFilterCheckbox(i)
                    .checkFilterCounterValue(i + 1);
        }
        jobsPage.clickFilterClearButton()
                .checkFilterCounterIsNotVisible()
                .checkFilterClearButtonIsNotVisible();
        for (int i = 0; i < checkboxesToCheck; i++) {
            jobsPage.checkCheckboxIsNotTicked(i);
        }
    }

    @Story("Поиск вакансий")
    @DisplayName("Поиск: ")
    @ParameterizedTest(name = "Проверка фильтрации вакансий по значению {0}")
    @ValueSource(strings = {
            "Разработчик", "Аналитик", "Руководитель"
    })
    @Severity(SeverityLevel.CRITICAL)
    @Owner("aydarium")
    void textFilterTest(String value) {
        jobsPage.openPage()
                .searchJobs(value)
                .checkJobsTitle(value);
    }
}

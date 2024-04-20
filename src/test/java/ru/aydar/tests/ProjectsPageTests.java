package ru.aydar.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.aydar.pages.ProjectsPage;

@Epic("UI сайта IBS.ru")
@Feature("Страница проектов")
@DisplayName("Сценарии проверок страницы проектов")
public class ProjectsPageTests extends TestBase {
    ProjectsPage projectsPage = new ProjectsPage();

    @Story("Фильтрация проектов по отраслям и направлениям")
    @DisplayName("Проекты: ")
    @ParameterizedTest(name = "Проверка фильтрации по отрасли {0} и направлению {1}")
    @CsvSource(value = {
            "Промышленность и транспорт , Управление программами",
            "ТНП и ритейл , Аутсорсинг ИТ-процессов",
            "Финансовые институты , Тестирование"
    })
    @Severity(SeverityLevel.CRITICAL)
    @Owner("aydarium")
    void dropdownFiltersTest(String category, String type) {
        projectsPage.openPage()
                .clickIndustryDropdown()
                .clickOption(category)
                .clickServiceDropdown()
                .clickOption(type)
                .checkProjectsCategory(category)
                .checkProjectsType(type);
    }
}

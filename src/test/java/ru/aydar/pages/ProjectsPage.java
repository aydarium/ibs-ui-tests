package ru.aydar.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {
    private final SelenideElement
            industryDropdown = $("[data-placeholder=Отрасли]").parent(),
            serviceDropdown = $("[data-placeholder=Направления]").parent(),
            firstProjectsCategory = $(".projects-item__category"),
            firstProjectsType = $(".projects-item__type");
    private final ElementsCollection dropdownOptions = $$("[role=option]");

    @Step("Открываем страницу проектов")
    public ProjectsPage openPage() {
        open("/projects");
        return this;
    }

    @Step("Раскрываем список отраслей")
    public ProjectsPage clickIndustryDropdown() {
        industryDropdown.click();
        return this;
    }

    @Step("Раскрываем список направлений")
    public ProjectsPage clickServiceDropdown() {
        serviceDropdown.click();
        return this;
    }

    @Step("Нажимаем на строку '{value}' в выпадающем списке")
    public ProjectsPage clickOption(String value) {
        dropdownOptions.findBy(text(value)).click();
        return this;
    }

    @Step("Проверяем соответствие категории первого проекта в списке выбранной отрасли (ожидаем '{industry}')")
    public ProjectsPage checkProjectsCategory(String industry) {
        firstProjectsCategory.scrollIntoView("{block: \"center\", inline: \"center\"}").shouldHave(text(industry));
        return this;
    }

    @Step("Проверяем соответствие типа первого проекта в списке выбранному направлению (ожидаем '{service}')")
    public ProjectsPage checkProjectsType(String service) {
        firstProjectsType.scrollIntoView("{block: \"center\", inline: \"center\"}").shouldHave(text(service));
        return this;
    }
}

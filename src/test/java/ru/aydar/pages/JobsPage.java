package ru.aydar.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class JobsPage {
    private final SelenideElement
            filterCounter = $(".jobs-filter-count"),
            filterClearButton = $(".js-filter-clear"),
            searchInput = $(".js-input"),
            firstJobsTitle = $(".jobs-item-title"),
            resumeFileRadio = $("[data-toggle-block='.js-resume-file']").parent(),
            resumeFileField = $(".js-resume-file"),
            resumeLinkRadio = $("[data-toggle-block='.js-resume-link']").parent(),
            resumeLinkField = $(".js-resume-link");
    private final ElementsCollection jobFilterHeaders = $$(".jobs-filter-block-header"),
            jobFilters = $$(".jobs-filter-block-content"),
            checkboxTitles = $$(".checkbox"),
            checkboxes = $$("[type=checkbox]");

    @Step("Открываем страницу вакансий")
    public JobsPage openPage() {
        open("/career/jobs");
        return this;
    }

    @Step("Нажимаем на заголовок группы фильтров '{value}' (для его раскрытия)")
    public JobsPage clickJobsFilterHeader(String value) {
        jobFilterHeaders.findBy(text(value)).scrollIntoView("{block: \"center\", inline: \"center\"}").click();
        return this;
    }

    @Step("Проверяем, что фильтр вакансий '{value}' сейчас виден на странице")
    public JobsPage checkJobFilterIsVisible(String value) {
        jobFilters.findBy(text(value)).shouldBe(visible);
        return this;
    }

    @Step("Кликаем радио-кнопку «Добавить резюме файлом»")
    public JobsPage clickResumeFileRadio() {
        resumeFileRadio.scrollIntoView("{block: \"center\", inline: \"center\"}").click();
        return this;
    }

    @Step("Проверяем отображение поля для загрузки файла резюме")
    public JobsPage checkFileFieldIsVisible() {
        resumeFileField.shouldBe(visible);
        return this;
    }

    @Step("Кликаем радио-кнопку «Добавить резюме ссылкой»")
    public JobsPage clickResumeLinkRadio() {
        resumeLinkRadio.scrollIntoView("{block: \"center\", inline: \"center\"}").click();
        return this;
    }

    @Step("Проверяем отображение поля для ввода ссылки на резюме")
    public JobsPage checkLinkFieldIsVisible() {
        resumeLinkField.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем на чекбокс фильтра с индексом {i}")
    public JobsPage clickFilterCheckbox(int i) {
        checkboxTitles.get(i).scrollIntoView("{block: \"center\", inline: \"center\"}").click();
        return this;
    }

    @Step("Проверяем, что счётчик применённых фильтров не отображается")
    public JobsPage checkFilterCounterIsNotVisible() {
        filterCounter.shouldNotBe(visible);
        return this;
    }

    @Step("Проверяем, что кнопка сброса фильтров не отображается")
    public JobsPage checkFilterClearButtonIsNotVisible() {
        filterClearButton.shouldNotBe(visible);
        return this;
    }

    @Step("Нажимаем на кнопку сброса фильтров")
    public JobsPage clickFilterClearButton() {
        filterClearButton.click();
        return this;
    }

    @Step("Проверяем, что счётчик применённых фильтров равен {i}")
    public JobsPage checkFilterCounterValue(int i) {
        filterCounter.shouldHave(text(String.valueOf(i)));
        return this;
    }

    @Step("Проверяем, что в чекбоксе с индексом {i} не стоит галочка")
    public JobsPage checkCheckboxIsNotTicked(int i) {
        checkboxes.get(i).shouldNotBe(checked);
        return this;
    }

    @Step("Ищем вакансии по запросу '{value}'")
    public JobsPage searchJobs(String value) {
        searchInput.type(value).pressEnter();
        return this;
    }

    @Step("Проверяем, в заголовке первой вакансии содержится текст '{value}'")
    public JobsPage checkJobsTitle(String value) {
        firstJobsTitle.shouldHave(text(value));
        return this;
    }
}

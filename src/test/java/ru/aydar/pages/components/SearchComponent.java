package ru.aydar.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchComponent {
    private final SelenideElement
            searchButton = $(".js-header-search"),
            searchPopUp = $(".search"),
            searchInput = $(".js-search-input");

    @Step("Нажимаем на кнопку поиска по сайту")
    public void click() {
        searchButton.click();
    }

    @Step("Проверяем наличие заголовка '{value}' в окне поиска по сайту")
    public void checkHeader(String value) {
        searchPopUp.shouldHave(text(value)).shouldBe(visible);
    }

    @Step("Проверяем наличие плейсхолдера в поле поиска по сайту")
    public void checkPlaceholder() {
        searchInput.shouldBe(visible);
        searchInput.shouldHave(attribute("placeholder", "Поиск по сайту"));
    }

}

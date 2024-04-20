package ru.aydar.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.aydar.pages.components.BurgerComponent;
import ru.aydar.pages.components.FooterComponent;
import ru.aydar.pages.components.HeaderComponent;
import ru.aydar.pages.components.SearchComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            topSlideDescription = $(".top-slide__desc");

    SearchComponent searchComponent = new SearchComponent();
    BurgerComponent burgerComponent = new BurgerComponent();
    HeaderComponent headerComponent = new HeaderComponent();
    FooterComponent footerComponent = new FooterComponent();

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Проверяем текст описания в верхнем слайде (ожидаем '{value}')")
    public MainPage checkTopSlideDescription(String value) {
        topSlideDescription.shouldHave(text(value));
        return this;
    }

    public MainPage switchLang(String value) {
        headerComponent.clickLink(value);
        return this;
    }

    public MainPage checkCopyrightTextInFooter(String value) {
        footerComponent.checkCopyrightText(value);
        return this;
    }

    public MainPage checkSearchPlaceholder() {
        searchComponent.checkPlaceholder();
        return this;
    }

    public MainPage clickSearch() {
        searchComponent.click();
        return this;
    }

    public MainPage checkSearchHeader(String value) {
        searchComponent.checkHeader(value);
        return this;
    }

    public MainPage performSearch(String value) {
        searchComponent.sendInput(value);
        return this;
    }

    public MainPage checkSearchTabsAreVisible() {
        searchComponent.checkTabsAreVisible();
        return this;
    }

    public MainPage checkSearchResultsAreVisible() {
        searchComponent.checkResultsAreVisible();
        return this;
    }

    public MainPage clickHamburger() {
        burgerComponent.click();
        return this;
    }

    public MainPage checkNavigationSectionString(String value) {
        burgerComponent.checkIfSectionExists(value);
        return this;
    }
}

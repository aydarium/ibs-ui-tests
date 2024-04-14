package ru.aydar.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.aydar.pages.components.BurgerComponent;
import ru.aydar.pages.components.SearchComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement
            topSlideDescription = $(".top-slide__desc"),
            footerCopyright = $(".footer-copy"),
            headerLinks = $(".header-links");

    SearchComponent searchComponent = new SearchComponent();
    BurgerComponent burgerComponent = new BurgerComponent();

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Нажимаем на кнопку смены языка сайта '{value}'")
    public MainPage switchLang(String value) {
        headerLinks.$(byText(value)).click();
        return this;
    }

    @Step("Проверяем текст описания в верхнем слайде (ожидаем '{value}')")
    public MainPage checkTopSlideDescription(String value) {
        topSlideDescription.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, что в футере сайта написан копирайт '{value}'")
    public MainPage checkCopyrightTextInFooter(String value) {
        footerCopyright.scrollIntoView(true).shouldHave(text(value));
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

    public MainPage clickHamburger() {
        burgerComponent.click();
        return this;
    }

    public MainPage checkNavigationSectionString(String value) {
        burgerComponent.checkIfSectionExists(value);
        return this;
    }
}

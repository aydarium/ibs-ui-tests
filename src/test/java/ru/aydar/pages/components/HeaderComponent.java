package ru.aydar.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {
    private final SelenideElement
            links = $(".header-links");

    @Step("Нажимаем на кнопку '{value}' в шапке")
    public void clickLink(String value) {
        links.$(byText(value)).click();
    }
}

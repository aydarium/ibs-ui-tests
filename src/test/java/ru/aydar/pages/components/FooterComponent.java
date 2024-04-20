package ru.aydar.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FooterComponent {
    private final SelenideElement
            copyright = $(".footer-copy");

    @Step("Проверяем, что в футере сайта написан копирайт '{value}'")
    public void checkCopyrightText(String value) {
        copyright.scrollIntoView(true).shouldHave(text(value));
    }
}

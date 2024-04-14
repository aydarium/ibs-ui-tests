package ru.aydar.pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BurgerComponent {
    private final SelenideElement
            burgerButton = $(".header-burger"),
            navigationSections = $(".navigation-sections");

    @Step("Нажимаем на кнопку гамбургер-меню (три полоски)")
    public void click()
    {
        burgerButton.click();
    }

    @Step("Проверяем наличие пункта '{value}' в гамбургер-меню")
    public void checkIfSectionExists(String value)
    {
        navigationSections.shouldHave(text(value));
    }
}

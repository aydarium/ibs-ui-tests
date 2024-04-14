package ru.aydar.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {
    private final SelenideElement
            regionList = $(".contacts-tags"),
            pressEmail = $(".press-contacts").$(byText("E-mail")).parent(),
            pressPhoneNumber = $(".press-contacts").$(byText("Телефон")).parent();
    private final ElementsCollection addresses = $$("[itemprop=address]");

    @Step("Открываем страницу контактов")
    public ContactsPage openPage() {
        open("contacts/");
        return this;
    }

    @Step("Выбираем регион '{value}'")
    public ContactsPage clickRegion(String value) {
        regionList.$(byText(value)).click();
        return this;
    }

    @Step("Проверяем, что отображается адрес '{value}'")
    public ContactsPage checkVisibleAddress(String value) {
        addresses.findBy(text(value)).shouldBe(visible);
        return this;
    }

    public ContactsPage checkAddressInRegion(String region, String address) {
        clickRegion(region);
        checkVisibleAddress(address);
        return this;
    }

    @Step("Проверяем, что у пресс-службы адрес почты '{value}'")
    public ContactsPage checkPressEmail(String value) {
        pressEmail.scrollIntoView("{block: \"center\", inline: \"center\"}").shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, что у пресс-службы номер телефона '{value}'")
    public ContactsPage checkPressPhoneNumber(String value) {
        pressPhoneNumber.scrollTo().scrollIntoView("{block: \"center\", inline: \"center\"}").shouldHave(text(value));
        return this;
    }
}

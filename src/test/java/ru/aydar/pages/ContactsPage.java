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
            mapInfoCollapsible = $$(".collapse-link").find(visible),
            pressEmail = $(".press-contacts").$(byText("E-mail")).parent(),
            pressPhoneNumber = $(".press-contacts").$(byText("Телефон")).parent();
    private final ElementsCollection addressItems = $$("[itemprop=address]"),
            mapInfoAddressItems = $$(".map-info").find(visible).$$("[itemprop=address]");

    @Step("Открываем страницу контактов")
    public ContactsPage openPage() {
        open("/contacts");
        return this;
    }

    @Step("Выбираем регион '{value}'")
    public ContactsPage clickRegion(String value) {
        regionList.$(byText(value)).click();
        return this;
    }

    @Step("Раскрываем раздел с юридическим адресом (есть в некоторых городах)")
    public ContactsPage clickMapInfo() {
        mapInfoCollapsible.scrollIntoView("{block: \"center\", inline: \"center\"}").click();
        return this;
    }

    @Step("Проверяем, что отображается адрес '{value}'")
    public ContactsPage checkVisibleAddress(String value) {
        addressItems.findBy(text(value)).shouldBe(visible).scrollIntoView("{block: \"center\", inline: \"center\"}");
        return this;
    }

    @Step("Проверяем, что отображается юридический адрес '{value}'")
    public ContactsPage checkVisibleMapInfo(String value) {
        mapInfoAddressItems.findBy(text(value)).shouldBe(visible).scrollIntoView("{block: \"center\", inline: \"center\"}");
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

package ru.aydar.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.aydar.pages.ContactsPage;

@Epic("UI сайта IBS.ru")
@Feature("Страница контактов")
@DisplayName("Сценарии проверок страницы контактов")
public class ContactsPageTests extends TestBase {
    ContactsPage contactsPage = new ContactsPage();
    String pressEmail = "pressa@ibs.ru",
            pressPhoneNumber = "+7 (495) 967-80-80";

    @Story("Список контактов по городам")
    @DisplayName("Адреса: ")
    @ParameterizedTest(name = "Проверка отображения адреса {1} в городе {0}")
    @CsvSource(delimiter = '|', value = {
            "Санкт-Петербург | Английская набережная, д. 70",
            "Вологда | ул. Зосимовская, д.18",
            "Уфа | ул. Менделеева, д. 130, блок А, 2 этаж, офис 201"
    })
    @Severity(SeverityLevel.BLOCKER)
    @Owner("aydarium")
    void regionSelectionTest(String city, String address) {
        contactsPage.openPage()
                .clickRegion(city)
                .checkVisibleAddress(address);
    }

    @Story("Дополнительные контакты в городах")
    @DisplayName("Юридические адреса: ")
    @ParameterizedTest(name = "Проверка отображения юридического адреса {1} в городе {0}")
    @CsvSource(delimiter = '|', value = {
            "Москва | Дмитровское шоссе, 9Б",
            "Санкт-Петербург | ул. Галерная, д. 73, Лит. А",
            "Ульяновск | ул. Марата д.8Б, 3 этаж"
    })
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void mapInfoCollapsibleTest(String city, String address){
        contactsPage.openPage()
                .clickRegion(city)
                .clickMapInfo()
                .checkVisibleMapInfo(address);
    }

    @Test
    @DisplayName("Проверка отображения адреса электронной почты и номера телефона пресс-службы")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void pressContactsTest() {
        contactsPage.openPage()
                .checkPressEmail(pressEmail)
                .checkPressPhoneNumber(pressPhoneNumber);
    }
}

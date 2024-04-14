package ru.aydar.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aydar.pages.ContactsPage;

@Epic("UI сайта IBS.ru")
@Feature("Страница контактов")
@DisplayName("Сценарии проверок страницы контактов")
public class ContactsPageTests extends TestBase {
    ContactsPage contactsPage = new ContactsPage();
    String pressEmail = "pressa@ibs.ru",
            pressPhoneNumber = "+7 (495) 967-80-80";

    @Test
    @DisplayName("Проверка отображения адреса после выбора региона")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("aydarium")
    void languageSwitchTest() {
        contactsPage.openPage()
                .checkAddressInRegion("Санкт-Петербург", "Английская набережная, д. 70")
                .checkAddressInRegion("Вологда", "ул. Зосимовская, д.18")
                .checkAddressInRegion("Уфа", "ул. Менделеева, д. 130, блок А, 2 этаж, офис 201");
    }

    @Test
    @DisplayName("Проверка отображения адреса электронной почты пресс-службы")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void pressEmailTest() {
        contactsPage.openPage()
                .checkPressEmail(pressEmail);
    }

    @Test
    @DisplayName("Проверка отображения номера телефона пресс-службы")
    @Severity(SeverityLevel.NORMAL)
    @Owner("aydarium")
    void pressPhoneNumberTest() {
        contactsPage.openPage()
                .checkPressPhoneNumber(pressPhoneNumber);
    }
}

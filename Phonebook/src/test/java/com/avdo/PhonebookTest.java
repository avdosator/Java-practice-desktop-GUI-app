package com.avdo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PhonebookTest {

    private PhoneNumber number;
    private final Phonebook phones = new Phonebook();

    @BeforeEach
    public void setUp() throws IllegalInputException {
        number = MobilePhoneNumber.createNumber(62, "184-151");
    }

    @Test
    @DisplayName("If given name is present in phonebook it should return its number")
    void shouldReturnNumberIfContainsGivenName() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertEquals(Optional.of("062/184-151"), phones.getNumber("Vedo"));
    }

    @Test
    void shouldReturnOptional_emptyIfDoNotContainsGivenName() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertEquals(Optional.empty(), phones.getNumber("Klapa"));
    }

    @Test
    @DisplayName("If given number is present in phonebook, it should return its name")
    void shouldReturnNameIfContainsGivenNumber() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertEquals(Optional.of("Vedo"), phones.getName(number));
    }

    @Test
    void sizeShouldBeOneIfOneEntryIsAdded() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertTrue(phones.getPhonebookSize() == 1);
    }

    @Test
    void sizeShouldBeFiveIfFiveEntriesAdded() throws IllegalInputException {
        phones.addNumber(MobilePhoneNumber.createNumber(61, "111-111"), "Vedo");
        phones.addNumber(MobilePhoneNumber.createNumber(62, "222-222"), "Avdo");
        phones.addNumber(MobilePhoneNumber.createNumber(62, "333-333"), "Profa");
        phones.addNumber(HomeTelephoneNumber.createNumber(City.SARAJEVO, "444-444"), "Klapa");
        phones.addNumber(InternationalPhoneNumber.createNumber("+550", "555-555"), "Cako");
        assertTrue(phones.getPhonebookSize() == 5);
    }
}
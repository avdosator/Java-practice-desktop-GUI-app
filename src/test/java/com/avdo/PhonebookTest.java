package com.avdo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PhonebookTest {

    private PhoneNumber number;
    private Phonebook phones = new Phonebook();
    //private Phonebook phonesMock = mock(Phonebook.class);
    //PhoneNumber numberMock = mock(MobilePhoneNumber.class);

    @BeforeEach
    public void setUp() throws IllegalInputException {
        number = new MobilePhoneNumber(62, "184-151");
    }

    @Test
    @DisplayName("If given name is present in phonebook it should return its number")
    void shouldReturnNumberIfContainsGivenName() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertEquals("062/184-151", phones.getNumber("Vedo"));
    }

    @Test
    void shouldReturnNullIfDoNotContainsGivenName() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertNull(phones.getNumber("Klapa"));
    }

    @Test
    @DisplayName("If given number is present in phonebook, it should return its name")
    void shouldReturnNameIfContainsGivenNumber() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertEquals("Vedo", phones.getName(number));
    }

    @Test
    void sizeShouldBeOneIfOneEntryIsAdded() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        assertTrue(phones.getPhonebookSize() == 1);
    }

    @Test
    void sizeShouldBeFiveIfFiveEntriesAdded() throws IllegalInputException {
        phones.addNumber(number, "Vedo");
        phones.addNumber(number, "Avdo");
        phones.addNumber(number, "Profa");
        phones.addNumber(number, "Klapa");
        phones.addNumber(number, "Gazda");
        assertTrue(phones.getPhonebookSize() == 5);
    }
}
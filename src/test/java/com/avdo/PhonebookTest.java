package com.avdo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhonebookTest {

    private PhoneNumber number;
    private Phonebook phones = new Phonebook();
    //private Phonebook phonesMock = mock(Phonebook.class);
    //PhoneNumber numberMock = mock(MobilePhoneNumber.class);

    @Test
    @BeforeEach
    public  void setUp() throws IllegalInputException {
        number = new MobilePhoneNumber(62, "184-151");
    }

    @Test
    @DisplayName("If given name is present in phonebook it should return its number")
    void shouldReturnNumberIfContainsGivenName() {
        phones.addNumber("Vedo", number);
        assertEquals("062/184-151", phones.getNumber("Vedo"));
    }
    @Test
    void shouldReturnNullIfDoNotContainsGivenName() {
        phones.addNumber("Vedo", number);
        assertNull(phones.getNumber("Klapa"));
    }

    @Test
    @DisplayName("If given number is present in phonebook, it should return its name")
    void shouldReturnNameIfContainsGivenNumber() {
        phones.addNumber("Vedo", number);
        assertEquals("Vedo", phones.getName(number));
    }

    @Test
    void sizeShouldBeOneIfOneEntryIsAdded() {
        phones.addNumber("Vedo", number);
        assertTrue(phones.phonebook.size() == 1);
    }


}
package com.avdo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilePhoneNumberTest {

    PhoneNumber number;

    @Test
    @DisplayName("Throw IllegalInputException if provider is not between 60 and 67")
    void shouldThrowExceptionIfProviderNumberIsNotGood() {
        assertThrows(IllegalInputException.class,() ->
                number = new MobilePhoneNumber(68, "183-628"));
    }
    @Test
    void shouldNotThrowException() {
        assertDoesNotThrow(() -> number = new MobilePhoneNumber(62,"111-222"));
    }

}
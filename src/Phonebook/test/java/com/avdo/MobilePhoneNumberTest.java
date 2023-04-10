package com.avdo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilePhoneNumberTest {

    @Test
    @DisplayName("Throw IllegalInputException if provider is not between 60 and 67")
    void shouldThrowExceptionIfProviderNumberIsNotGood() {
        assertThrows(IllegalInputException.class, () ->
                MobilePhoneNumber.createNumber(68, "183-628"));
    }

    @Test
    void shouldNotThrowException() {
        assertDoesNotThrow(() -> MobilePhoneNumber.createNumber(62, "111-222"));
    }

}
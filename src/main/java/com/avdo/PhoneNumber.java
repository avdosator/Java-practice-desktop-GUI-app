package com.avdo;

import java.util.Objects;

public abstract class PhoneNumber implements Comparable<PhoneNumber> {

    protected String number;

    public abstract String getFormattedNumber();

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        final PhoneNumber otherNumber = (PhoneNumber) o;
        if (!otherNumber.canEqual(this)) {
            return false;
        }
        final Object thisNumber1 = this.number;
        final Object otherNumber1 = otherNumber.number;
        if (!Objects.equals(thisNumber1, otherNumber1)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PhoneNumber;
    }

    public int hashCode() {
        return Objects.hash(number);
    }
}

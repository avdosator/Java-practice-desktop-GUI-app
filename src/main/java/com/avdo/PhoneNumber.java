package com.avdo;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class PhoneNumber implements Comparable<PhoneNumber> {

    protected String number;

    /*public PhoneNumber(String number) {
        this.number = number;
    }*/

    public abstract String print();

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumber)) return false;
        final PhoneNumber other = (PhoneNumber) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$number = this.number;
        final Object other$number = other.number;
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PhoneNumber;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $number = this.number;
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        return result;
    }
}

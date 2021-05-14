package com.ho.practice.java.enm.case2;

public enum Apple {
    FUJI, PIPPIN, GRANNY_SMITH;

    @Override
    public String toString() {
        return this.name() + " custom";
    }
}

package com.example.fragments_sample;

public class BadgeDataClass {

    private String email;
    private boolean b1;
    private boolean b2;
    private boolean b3;
    private boolean b4;
    private boolean b5;

    public BadgeDataClass(String email, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5) {
        this.email = email;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
    }

    public String getEmail() {
        return email;
    }

    public boolean isB1() {
        return b1;
    }

    public boolean isB2() {
        return b2;
    }

    public boolean isB3() {
        return b3;
    }

    public boolean isB4() {
        return b4;
    }

    public boolean isB5() {
        return b5;
    }
}

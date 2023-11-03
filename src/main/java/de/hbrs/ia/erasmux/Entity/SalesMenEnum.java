package de.hbrs.ia.erasmux.Entity;//package de.hbrs.ia.erasmux.Entity;

public enum SalesMenEnum {
    FIRSTNAME("FirstName"),
    LASTNAME("LastName"),
    EMAIL("Email"),
    SID("Sid");

    private String value;

    SalesMenEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

//public enum SalesMenEnum {
//    FIRSTNAME,
//    LASTNAME,
//    EMAIL,
//    SID;
//}
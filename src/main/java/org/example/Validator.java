package org.example;

public class Validator {

    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (!phoneNumber.startsWith("0")) {
            return false;
        }
        if (phoneNumber.length() < 6 || phoneNumber.length() > 10) {
            return false;
        }
        return phoneNumber.matches("[0-9]+");
    }

    public static boolean isEmailValid(String email) {
        int indexOfTopLevelDomainStart = email.lastIndexOf(".");
        int indexOfAtSign = email.lastIndexOf("@");

        if(indexOfAtSign == -1 || indexOfTopLevelDomainStart == -1) {
            return false;
        }
        String topLevelDomain = email.substring(indexOfTopLevelDomainStart + 1); // se
        String domainName = email.substring(indexOfAtSign + 1, indexOfTopLevelDomainStart);
        if(domainName.contains("_")) {
            return false;
        }
        String name = email.substring(0, indexOfAtSign);
        if(name.length() > 64) {
            return false;
        }
        if(name.contains("@") && (name.charAt(0) != '"' || name.charAt(name.length() - 1) != '"')) {
            return false;
        }
        String[] requiredStringParts = {name, domainName, topLevelDomain};

        for (String part : requiredStringParts) {
            if (part.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}

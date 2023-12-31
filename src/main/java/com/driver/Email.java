package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password.equals(oldPassword)){
            if(isValid(newPassword)){
                System.out.println("Password changed successfully");
                this.password = newPassword;
            } else{
                System.out.println("Please enter a valid password");
            }
        } else {
            System.out.println("Password entered doesn't match with current password");
        }
    }

    public boolean isValid (String newPassword) {
        if(newPassword.length() < 8) return false;

        boolean uppercaseCharacter = false;
        boolean lowercaseCharacter = false;
        boolean digitCharacter = false;
        boolean specialCharacter = false;

        for (char ch : newPassword.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                uppercaseCharacter = true;
            } else if (ch >= 'a' && ch<= 'z') {
                lowercaseCharacter = true;
            } else if (Character.isDigit(ch)) {
                digitCharacter = true;
            } else {
                specialCharacter = true;
            }
        }

        if (uppercaseCharacter && lowercaseCharacter && digitCharacter && specialCharacter) return true;
        return false;
    }
}

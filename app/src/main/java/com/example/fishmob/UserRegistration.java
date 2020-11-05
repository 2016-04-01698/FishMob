package com.example.fishmob;

class UserRegistration {
    //propertiies of the user to be stored in the firebase
    private  String fullNames,phoneNumber, emailAccount, Password,time;

    public  UserRegistration(String namesFull, String numberPhone, String accountEmail, String Pwd,String time){
        this.fullNames=namesFull;
        this.phoneNumber=numberPhone;
        this.emailAccount=accountEmail;
        this.Password=Pwd;
        this.time=time;
    }
//empty extra constructor because firebase need it for it's process mechanisms.

    public  UserRegistration(){
    }

    public String getFullNames() {
        return fullNames;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

package fr.ktourret.poec.entity.bank;

import java.util.*;

public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private Date birthAt;

    public Client() { }

    public Client(String firstName, String lastName, String email, Date birthAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthAt = birthAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthAt() {
        return birthAt;
    }

    public void setBirthAt(Date birthAt) {
        this.birthAt = birthAt;
    }

    public int getAge() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        Calendar calendarBirth = new GregorianCalendar();
        calendarBirth.setTime(birthAt);
        return calendar.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);
    }
}

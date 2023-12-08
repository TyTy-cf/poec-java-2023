package fr.ktourret.poec.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private Date birthAt;

    public int getAge() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        Calendar calendarBirth = new GregorianCalendar();
        calendarBirth.setTime(birthAt);
        return calendar.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR);
    }
}

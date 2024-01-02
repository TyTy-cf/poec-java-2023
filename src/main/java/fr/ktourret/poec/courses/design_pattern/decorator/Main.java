package fr.ktourret.poec.courses.design_pattern.decorator;

import fr.ktourret.poec.courses.design_pattern.composite.HeadDepartment;
import fr.ktourret.poec.courses.design_pattern.composite.SubDepartment;

public class Main {

    public static void main(String[] args) {
        SMSDecorator smsDecorator = new SMSDecorator();
        DiscordDecorator discordDecorator = new DiscordDecorator();
        EmailDecorator emailDecorator = new EmailDecorator();

        // Cas de figure 1 : SMS
        smsDecorator.send("SOS");

        // Cas de figure 2 : SMS + email
        emailDecorator.setWrapper(smsDecorator);
        emailDecorator.send("Bonne année !");

        // Cas de figure 3 : SMS + email + Discord
        emailDecorator.setWrapper(smsDecorator);
        discordDecorator.setWrapper(emailDecorator);
        discordDecorator.send("Bonne année et la santé !");
    }

}

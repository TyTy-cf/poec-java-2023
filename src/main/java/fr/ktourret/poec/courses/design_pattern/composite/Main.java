package fr.ktourret.poec.courses.design_pattern.composite;

import fr.ktourret.poec.courses.design_pattern.observer.TwitterAccount;
import fr.ktourret.poec.courses.design_pattern.observer.User;
import fr.ktourret.poec.my_mvc.service.Dump;

public class Main {

    public static void main(String[] args) {
        HeadDepartment hd = new HeadDepartment();
        hd.setName("Head Department");
        hd.setNbPersonal(4);

        SubDepartment sd1 = new SubDepartment();
        sd1.setName("Sub Department 1");
        sd1.setNbPersonal(5);

        SubDepartment sd2 = new SubDepartment();
        sd2.setName("Sub Department 2");
        sd2.setNbPersonal(8);

        hd.addChild(sd1);
        hd.addChild(sd2);

        System.out.println(hd.getTotalPersonals());
    }

}

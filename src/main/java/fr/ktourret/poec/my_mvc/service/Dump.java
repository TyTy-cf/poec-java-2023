package fr.ktourret.poec.my_mvc.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dump {

    public static String dump(Object object) {
        Class<?> objectClass = object.getClass();
        StringBuilder sb = new StringBuilder(objectClass.getSimpleName());
        sb.append("\n");
        sb.append("(");
        sb.append("\n");
        for (Field field : objectClass.getDeclaredFields()) {
            try {
                sb.append("\t");
                sb.append(field.getName());
                sb.append(" : ");
                String upperCaseFieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                Method getter = objectClass.getDeclaredMethod("get" + upperCaseFieldName);
                sb.append(getter.invoke(object));
                sb.append("\n");
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Getter not found :(");
            }
        }
        sb.append(")");
        return sb.toString();
    }

}

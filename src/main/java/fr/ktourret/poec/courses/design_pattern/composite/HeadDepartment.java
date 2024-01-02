package fr.ktourret.poec.courses.design_pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment extends Department { // Composite

    private final List<Department> departments = new ArrayList<>();

    public void addChild(Department d) {
        this.departments.add(d);
    }

    public void removeChild(Department d) {
        this.departments.add(d);
    }

    public List<Department> getChild() {
        return this.departments;
    }

    public int getTotalPersonals() {
        int total = 0;
        for (Department d : this.departments) {
            total += d.getNbPersonal();
        }
        return total + this.getNbPersonal();
    }

}

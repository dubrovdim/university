package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас University представляє університет.
 * Є кореневим контейнером, що містить кафедри.
 */
public class University implements UniversityElement {
    private String name;
    private List<Department> departments = new ArrayList<>();

    /**
     * Конструктор університету.
     * @param name назва університету
     */
    public University(String name) {
        this.name = name;
    }

    /**
     * Додавання кафедри до університету.
     * @param department об'єкт кафедри
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visit(this);
    }
}
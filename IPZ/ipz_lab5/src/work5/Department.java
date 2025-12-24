package work5;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Department представляє кафедру.
 * Може містити викладачів та студентів (список підлеглих елементів).
 */
public class Department implements UniversityElement {
    private String name;
    private List<UniversityElement> elements = new ArrayList<>();

    /**
     * Конструктор кафедри.
     * @param name назва кафедри
     */
    public Department(String name) {
        this.name = name;
    }

    /**
     * Додавання елемента до кафедри (студента або викладача).
     * @param element елемент університету
     */
    public void addElement(UniversityElement element) {
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<UniversityElement> getElements() {
        return elements;
    }

    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visit(this);
    }
}
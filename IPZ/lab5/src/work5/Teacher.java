package work5;

/**
 * Клас Teacher представляє викладача.
 * Містить інформацію про зарплату для розрахунків.
 */
public class Teacher implements UniversityElement {
    private String name;
    private double salary;

    /**
     * Конструктор викладача.
     * @param name ім'я викладача
     * @param salary заробітна плата
     */
    public Teacher(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visit(this);
    }
}
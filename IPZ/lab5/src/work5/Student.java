package work5;

/**
 * Клас Student представляє студента університету.
 * Це простий елемент (лист дерева).
 */
public class Student implements UniversityElement {
    private String name;

    /**
     * Конструктор студента.
     * @param name ім'я студента
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * Отримати ім'я студента.
     * @return ім'я
     */
    public String getName() {
        return name;
    }

    @Override
    public void accept(UniversityVisitor visitor) {
        visitor.visit(this);
    }
}
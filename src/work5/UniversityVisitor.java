package work5;

/**
 * Інтерфейс Відвідувача (Visitor).
 * Оголошує методи для відвідування кожного конкретного типу елемента структури університету.
 * <p>
 * Дозволяє додавати нові операції без зміни класів елементів.
 */
public interface UniversityVisitor {
    /**
     * Відвідування студента.
     * @param student об'єкт студента
     */
    void visit(Student student);

    /**
     * Відвідування викладача.
     * @param teacher об'єкт викладача
     */
    void visit(Teacher teacher);

    /**
     * Відвідування кафедри.
     * @param department об'єкт кафедри
     */
    void visit(Department department);

    /**
     * Відвідування університету.
     * @param university об'єкт університету
     */
    void visit(University university);
}
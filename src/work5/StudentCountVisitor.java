package work5;

/**
 * Відвідувач для підрахунку кількості студентів.
 * Реалізує бізнес-логіку обходу структури та лічильника.
 */
public class StudentCountVisitor implements UniversityVisitor {
    private int count = 0;

    /**
     * Отримати результат підрахунку.
     * @return кількість студентів
     */
    public int getCount() {
        return count;
    }

    @Override
    public void visit(Student student) {
        System.out.println("StudentCountVisitor: found student " + student.getName());
        count++;
    }

    @Override
    public void visit(Teacher teacher) {
    }

    @Override
    public void visit(Department department) {
        System.out.println("StudentCountVisitor: entering department " + department.getName());
        // Проходимо по всіх елементах кафедри
        for (UniversityElement element : department.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(University university) {
        System.out.println("StudentCountVisitor: analyzing university " + university.getName());
        // Проходимо по всіх кафедрах
        for (Department dept : university.getDepartments()) {
            dept.accept(this);
        }
    }
}
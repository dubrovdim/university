package work5;

/**
 * Відвідувач для розрахунку загальної заробітної плати викладачів.
 */
public class SalarySumVisitor implements UniversityVisitor {
    private double totalSalary = 0;

    /**
     * Отримати загальну суму зарплат.
     * @return сума
     */
    public double getTotalSalary() {
        return totalSalary;
    }

    @Override
    public void visit(Student student) {
    }

    @Override
    public void visit(Teacher teacher) {
        System.out.println("SalarySumVisitor: counted salary for teacher " 
                + teacher.getName() + " (" + teacher.getSalary() + ")");
        totalSalary += teacher.getSalary();
    }

    @Override
    public void visit(Department department) {
        for (UniversityElement element : department.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(University university) {
        for (Department dept : university.getDepartments()) {
            dept.accept(this);
        }
    }
}
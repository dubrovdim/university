package work5;

/**
 * Головний клас для демонстрації роботи шаблону Visitor.
 * Створює структуру університету та застосовує до неї різні операції.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Створення структури університету
        University myUni = new University("KPI");

        Department csDept = new Department("Computer Science");
        Department mathDept = new Department("Mathematics");

        // Додаємо викладачів
        csDept.addElement(new Teacher("Dr. Smith", 15000));
        csDept.addElement(new Teacher("Prof. Johnson", 20000));
        mathDept.addElement(new Teacher("Dr. Brown", 14000));

        // Додаємо студентів
        csDept.addElement(new Student("Dubrov"));
        csDept.addElement(new Student("Davydchuk"));
        csDept.addElement(new Student("Biliy"));
        mathDept.addElement(new Student("Vovk"));

        // Формуємо дерево
        myUni.addDepartment(csDept);
        myUni.addDepartment(mathDept);

        System.out.println("=== Operation 1: Student Count ===");
        StudentCountVisitor studentCounter = new StudentCountVisitor();
        // Запуск відвідувача від кореня
        myUni.accept(studentCounter);
        System.out.println("Total students: " + studentCounter.getCount());

        System.out.println("\n=== Operation 2: Teacher Salary Sum ===");
        SalarySumVisitor salaryCalculator = new SalarySumVisitor();
        myUni.accept(salaryCalculator);
        System.out.println("Total salary fund: " + salaryCalculator.getTotalSalary());
    }
}
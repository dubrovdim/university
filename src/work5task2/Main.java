package work5task2;

/**
 * Головний клас для демонстрації роботи шаблону Interpreter (Завдання 2, Варіант 5).
 * Виконує розбір та обчислення алгебраїчних виразів.
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        
        // Приклад 1: 3 + 5 * 2
        // Дерево: Add(Number(3), Multiply(Number(5), Number(2)))
        Expression expr1 = new AddExpression(
            new NumberExpression(3),
            new MultiplyExpression(
                new NumberExpression(5),
                new NumberExpression(2)
            )
        );
        
        System.out.println("=== Example 1: 3 + 5 * 2 ===");
        System.out.println("Result: " + expr1.interpret(context)); // Очікується: 13.0

        // Приклад 2: (x - 4) / y
        // Дерево: Divide(Subtract(Variable(x), Number(4)), Variable(y))
        context.setVariable("x", 14);
        context.setVariable("y", 5);

        Expression expr2 = new DivideExpression(
            new SubtractExpression(
                new VariableExpression("x"),
                new NumberExpression(4)
            ),
            new VariableExpression("y")
        );

        System.out.println("\n=== Example 2: (x - 4) / y ===");
        System.out.println("Context: x = " + context.getVariable("x") + ", y = " + context.getVariable("y"));
        System.out.println("Result: " + expr2.interpret(context)); // (14-4)/5 = 2.0
        
        // Приклад 3: Зміна контексту без зміни структури виразу
        context.setVariable("x", 104);
        context.setVariable("y", 25);
        System.out.println("\n=== Example 2 (Updated Context): x = 104, y = 25 ===");
        System.out.println("Result: " + expr2.interpret(context)); // (104-4)/25 = 4.0
    }
}
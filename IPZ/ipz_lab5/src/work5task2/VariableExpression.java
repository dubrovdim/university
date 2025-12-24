package work5task2;

/**
 * Термінальний вираз, що представляє змінну.
 * Значення змінної витягується з об'єкта Context під час інтерпретації.
 */
public class VariableExpression implements Expression {
    private String name;

    /**
     * Конструктор.
     * @param name ім'я змінної
     */
    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public double interpret(Context context) {
        return context.getVariable(name);
    }
}
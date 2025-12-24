package work5task2;

/**
 * Термінальний вираз, що представляє константне число.
 */
public class NumberExpression implements Expression {
    private double number;

    /**
     * Конструктор.
     * @param number числове значення
     */
    public NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public double interpret(Context context) {
        return number;
    }
}
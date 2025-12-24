package work5task2;

/**
 * Нетермінальний вираз для операції ділення (/).
 */
public class DivideExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Конструктор.
     * @param left лівий операнд (вираз)
     * @param right правий операнд (вираз)
     */
    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Context context) {
        double denominator = right.interpret(context);
        if (denominator == 0) {
            System.err.println("Warning: Division by zero!");
        }
        return left.interpret(context) / denominator;
    }
}
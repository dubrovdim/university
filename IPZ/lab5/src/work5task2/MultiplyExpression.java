package work5task2;

/**
 * Нетермінальний вираз для операції множення (*).
 */
public class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Конструктор.
     * @param left лівий операнд (вираз)
     * @param right правий операнд (вираз)
     */
    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}
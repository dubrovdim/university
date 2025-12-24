package work5task2;

/**
 * Нетермінальний вираз для операції віднімання (-).
 */
public class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Конструктор.
     * @param left лівий операнд (вираз)
     * @param right правий операнд (вираз)
     */
    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}
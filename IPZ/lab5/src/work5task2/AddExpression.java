package work5task2;

/**
 * Нетермінальний вираз для операції додавання (+).
 * Обчислює суму результатів інтерпретації лівого та правого підвиразів.
 */
public class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    /**
     * Конструктор.
     * @param left лівий операнд (вираз)
     * @param right правий операнд (вираз)
     */
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}
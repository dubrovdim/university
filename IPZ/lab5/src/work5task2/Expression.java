package work5task2;

/**
 * Інтерфейс Expression (Вираз).
 * Визначає метод interpret, який повинні реалізувати всі типи виразів (термінальні та нетермінальні).
 */
public interface Expression {
    /**
     * Інтерпретує (обчислює) вираз на основі переданого контексту.
     * @param context контекст, що містить значення змінних
     * @return результат обчислення у вигляді числа
     */
    double interpret(Context context);
}
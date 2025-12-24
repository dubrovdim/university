package work4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Клас, що моделює один рядок (row) реляційної таблиці.
 * Зберігає дані у вигляді пар "назва стовпця" -> "значення".
 */
public class Row {

    /**
     * Сховище для даних рядка.
     */
    private Map<String, Object> data;

    /**
     * Конструктор для створення порожнього рядка на основі списку стовпців.
     *
     * @param columns Список назв стовпців для ініціалізації.
     */
    public Row(List<String> columns) {
        this.data = new HashMap<>();
        // Ініціалізуємо всі стовпці значеннями null
        for (String column : columns) {
            this.data.put(column, null);
        }
    }

    /**
     * Конструктор копіювання. Необхідний для створення резервних копій.
     *
     * @param other Інший рядок, з якого копіюються дані.
     */
    public Row(Row other) {
        // Створюємо глибоку копію мапи
        this.data = new HashMap<>(other.data);
    }

    /**
     * Встановлює значення для вказаного стовпця.
     *
     * @param column Назва стовпця.
     * @param value  Нове значення.
     */
    public void setValue(String column, Object value) {
        if (!data.containsKey(column)) {
            System.err.println("Попередження: Спроба встановити значення для неіснуючого стовпця: " + column);
        }
        data.put(column, value);
    }

    /**
     * Отримує значення з вказаного стовпця.
     *
     * @param column Назва стовпця.
     * @return Значення комірки або null, якщо стовпець не існує.
     */
    public Object getValue(String column) {
        return data.get(column);
    }

    @Override
    public String toString() {
        // Створюємо гарне представлення рядка
        return data.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", ", "{ ", " }"));
    }
}
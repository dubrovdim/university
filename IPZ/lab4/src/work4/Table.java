package work4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Суб'єкта (Subject) в термінах шаблону "Спостерігач".
 * Моделює реляційну таблицю, яка може мати тригери (Спостерігачів),
 * що реагують на зміни даних.
 */
public class Table {

    /** Назва таблиці. */
    private String tableName;

    /** Список назв стовпців. */
    private List<String> columns;

    /** Список рядків таблиці. */
    private List<Row> rows;

    /**
     * Список зареєстрованих Спостерігачів (тригерів).
     */
    private List<TableTrigger> triggers;

    /**
     * Конструктор для створення таблиці.
     *
     * @param tableName Назва таблиці.
     * @param columns   Список назв стовпців.
     */
    public Table(String tableName, List<String> columns) {
        this.tableName = tableName;
        this.columns = new ArrayList<>(columns);
        this.rows = new ArrayList<>();
        this.triggers = new ArrayList<>();
    }

    // --- Методи управління Спостерігачами ---

    /**
     * Реєструє новий тригер (Спостерігача).
     *
     * @param trigger Тригер для додавання.
     */
    public void addTrigger(TableTrigger trigger) {
        System.out.println("LOG: Added trigger: " + trigger.getClass().getSimpleName());
        this.triggers.add(trigger);
    }

    /**
     * Видаляє зареєстрований тригер (Спостерігача).
     *
     * @param trigger Тригер для видалення.
     */
    public void removeTrigger(TableTrigger trigger) {
        this.triggers.remove(trigger);
        System.out.println("LOG: Removed trigger: " + trigger.getClass().getSimpleName());
    }

    /**
     * Приватний метод для сповіщення всіх зареєстрованих тригерів.
     *
     * @param eventType     Тип події.
     * @param affectedRow   Рядок, що зазнав змін.
     * @param columnChanged Назва стовпця, що змінився.
     */
    private void notifyTriggers(String eventType, Row affectedRow, String columnChanged) {
        System.out.println("...Notifying " + triggers.size() + " triggers about event: '" + eventType + "'...");

        for (TableTrigger trigger : this.triggers) {
            trigger.onEvent(eventType, this, affectedRow, columnChanged);
        }
    }

    // --- Бізнес-методи (заглушки з викликом тригерів) ---

    /**
     * Додає новий рядок у таблицю і викликає тригер "INSERT".
     *
     * @param row Рядок, що додається.
     */
    public void addRow(Row row) {
        System.out.println("\n==> Method addRow with parameters row=" + row.toString());
        try {
            notifyTriggers("INSERT", row, null);

            this.rows.add(row);
            System.out.println("...Row added successfully.");

        } catch (Exception e) {
            System.err.println("ERROR adding row: " + e.getMessage());
        }
    }

    /**
     * Оновлює комірку в рядку і викликає тригер "UPDATE".
     *
     * @param rowIndex    Індекс рядка для оновлення.
     * @param column      Назва стовпця для оновлення.
     * @param newValue    Нове значення.
     */
    public void updateCell(int rowIndex, String column, Object newValue) {
        System.out.println("\n==> Method updateCell with parameters rowIndex=" + rowIndex + ", column=" + column + ", newValue=" + newValue);

        if (rowIndex < 0 || rowIndex >= rows.size()) {
            System.err.println("ERROR: Invalid row index.");
            return;
        }

        Row rowToUpdate = this.rows.get(rowIndex);

        try {
            notifyTriggers("UPDATE", rowToUpdate, column);

            rowToUpdate.setValue(column, newValue);
            System.out.println("...Cell updated successfully.");

        } catch (Exception e) {
            System.err.println("ERROR updating cell: " + e.getMessage());
        }
    }

    /**
     * Видаляє рядок з таблиці і викликає тригер "DELETE".
     *
     * @param rowIndex Індекс рядка для видалення.
     */
    public void deleteRow(int rowIndex) {

        System.out.println("\n==> Method deleteRow with parameters rowIndex=" + rowIndex);

        if (rowIndex < 0 || rowIndex >= rows.size()) {
            System.err.println("ERROR: Invalid row index.");
            return;
        }

        Row rowToDelete = this.rows.get(rowIndex);

        try {
            notifyTriggers("DELETE", rowToDelete, null);

            this.rows.remove(rowIndex);
            System.out.println("...Row deleted successfully.");

        } catch (Exception e) {
            System.err.println("ERROR deleting row: " + e.getMessage());
        }
    }



    public String getTableName() {
        return tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Table: '").append(tableName).append("' ---\n");
        sb.append(String.join("\t|\t", columns)).append("\n");
        sb.append("----------------------------------------\n");
        for (Row row : rows) {
            for (String col : columns) {
                sb.append(row.getValue(col)).append("\t|\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
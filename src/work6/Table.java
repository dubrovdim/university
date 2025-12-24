package work6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Клас, що представляє реляційну таблицю.
 * Містить назву, опис стовпців та дані (рядки).
 */
public class Table {
    private String name;
    private Map<String, String> columns;
    private List<Map<String, Object>> rows;

    /**
     * Конструктор таблиці.
     *
     * @param name Назва таблиці.
     */
    public Table(String name) {
        this.name = name;
        this.columns = new HashMap<>();
        this.rows = new ArrayList<>();
        System.out.println("Table created: " + name);
    }

    /**
     * Додає стовпець до таблиці.
     *
     * @param columnName Назва стовпця.
     * @param dataType Тип даних стовпця.
     */
    public void addColumn(String columnName, String dataType) {
        columns.put(columnName, dataType);
        System.out.println("Column added to table '" + name + "': " + columnName + " (" + dataType + ")");
    }

    /**
     * Додає рядок даних у таблицю.
     *
     * @param rowData Карта даних (Назва стовпця -> Значення).
     */
    public void addRow(Map<String, Object> rowData) {
        System.out.println("Method addRow called for table '" + name + "' with data: " + rowData.toString());
        rows.add(rowData);
    }

    /**
     * Отримує назву таблиці.
     *
     * @return Назва таблиці.
     */
    public String getName() {
        return name;
    }

    /**
     * Перевіряє наявність стовпця.
     *
     * @param columnName Назва стовпця.
     * @return true, якщо стовпець існує.
     */
    public boolean hasColumn(String columnName) {
        return columns.containsKey(columnName);
    }
    
    /**
     * Отримує тип даних стовпця.
     * * @param columnName Назва стовпця.
     * @return Тип даних або null.
     */
    public String getColumnType(String columnName) {
        return columns.get(columnName);
    }
}
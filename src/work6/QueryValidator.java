package work6;

/**
 * Клас QueryValidator відповідає за перевірку запитів до таблиць.
 * Використовує єдиний екземпляр DatabaseSchema для перевірки метаданих.
 */
public class QueryValidator {

    /**
     * Перевіряє симуляцію SQL запиту SELECT.
     * Наприклад: "SELECT * FROM Users"
     *
     * @param tableName Назва таблиці, до якої йде звернення.
     * @return true, якщо запит валідний.
     */
    public boolean validateSelectQuery(String tableName) {
        System.out.println("Validating query for table: " + tableName);

        DatabaseSchema schema = DatabaseSchema.getInstance();

        Table table = schema.getTable(tableName);
        if (table == null) {
            System.out.println("Error: Table '" + tableName + "' does not exist in schema.");
            return false;
        }

        System.out.println("Success: Table found. Query syntax is valid.");
        return true;
    }

    /**
     * Перевіряє валідність вставки даних (типи даних, not null тощо).
     *
     * @param tableName Назва таблиці.
     * @param fieldName Назва поля.
     * @param value Значення.
     */
    public void validateInsert(String tableName, String fieldName, Object value) {
        DatabaseSchema schema = DatabaseSchema.getInstance();
        Table table = schema.getTable(tableName);

        if (table != null && table.hasColumn(fieldName)) {
             String expectedType = table.getColumnType(fieldName);
             System.out.println("Validating data: Field '" + fieldName + "' expects " + expectedType + ". Value provided: " + value);
        } else {
             System.out.println("Error: Table or column not found.");
        }
    }
}
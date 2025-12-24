package work6;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас DatabaseSchema, що реалізує шаблон Singleton.
 * Єдина точка доступу до схеми бази даних.
 * Зберігає список таблиць та інформацію про базу.
 */
public class DatabaseSchema {
    
    // Приватне статичне поле для зберігання єдиного екземпляра [cite: 17]
    private static DatabaseSchema instance;
    
    private final String dbName;
    private final int version;
    private final Map<String, Table> tables;

    /**
     * Приватний конструктор, щоб заборонити створення екземплярів ззовні[cite: 16].
     */
    private DatabaseSchema() {
        this.dbName = "MyUniqueDB";
        this.version = 1;
        this.tables = new HashMap<>();
        System.out.println("Initializing DatabaseSchema (Singleton Instance Created).");
    }

    /**
     * Публічний статичний метод для отримання єдиного екземпляра класу[cite: 18].
     * Забезпечує створення екземпляра при першому виклику (Lazy Initialization).
     *
     * @return Єдиний екземпляр DatabaseSchema.
     */
    public static synchronized DatabaseSchema getInstance() {
        if (instance == null) {
            instance = new DatabaseSchema();
        }
        return instance;
    }

    public String getDbName() {
        return dbName;
    }

    public int getVersion() {
        return version;
    }

    /**
     * Додає таблицю до схеми бази даних.
     *
     * @param table Об'єкт таблиці.
     */
    public void addTable(Table table) {
        tables.put(table.getName(), table);
        System.out.println("Table '" + table.getName() + "' added to schema.");
    }

    /**
     * Видаляє таблицю зі схеми.
     *
     * @param tableName Назва таблиці.
     */
    public void dropTable(String tableName) {
        tables.remove(tableName);
        System.out.println("Table '" + tableName + "' dropped from schema.");
    }

    /**
     * Отримує таблицю за назвою.
     *
     * @param tableName Назва таблиці.
     * @return Об'єкт таблиці або null.
     */
    public Table getTable(String tableName) {
        return tables.get(tableName);
    }
    
    /**
     * Отримує загальну кількість таблиць.
     * @return кількість таблиць.
     */
    public int getTableCount() {
        return tables.size();
    }
}
package work6;

/**
 * Головний клас для демонстрації роботи варіанту 5 (Singleton, Table, Validator).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- STARTING SINGLETON DEMO ---");

        // 1. Отримання екземпляра Singleton
        DatabaseSchema schema1 = DatabaseSchema.getInstance();
        System.out.println("Schema 1 hash: " + System.identityHashCode(schema1));

        // 2. Створення та додавання таблиць 
        Table usersTable = new Table("Users");
        usersTable.addColumn("id", "Integer");
        usersTable.addColumn("username", "String");
        
        Table productsTable = new Table("Products");
        productsTable.addColumn("sku", "String");
        productsTable.addColumn("price", "Double");

        schema1.addTable(usersTable);
        schema1.addTable(productsTable);

        System.out.println("\n--- TESTING VALIDATOR ---");
        // 3. Використання валідатора [cite: 229]
        QueryValidator validator = new QueryValidator();
        
        // Валідний запит
        validator.validateSelectQuery("Users");
        
        // Невалідний запит (таблиці не існує)
        validator.validateSelectQuery("Orders");

        // Валідація даних
        validator.validateInsert("Products", "price", 100.50);

        System.out.println("\n--- TESTING SINGLETON UNIQUENESS ---");
        // 4. Спроба отримати "новий" екземпляр схеми [cite: 230]
        DatabaseSchema schema2 = DatabaseSchema.getInstance();
        System.out.println("Schema 2 hash: " + System.identityHashCode(schema2));

        // Перевірка, що це той самий об'єкт
        if (schema1 == schema2) {
            System.out.println("SUCCESS: schema1 and schema2 are the same instance.");
        } else {
            System.out.println("FAILURE: Different instances created.");
        }

        // Перевірка вмісту через друге посилання
        System.out.println("Table count in schema2: " + schema2.getTableCount()); // Має бути 2
    }
}
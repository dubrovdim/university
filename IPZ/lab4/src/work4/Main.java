package work4;

import java.util.Arrays;

/**
 * Головний клас для демонстрації роботи шаблону "Спостерігач".
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--- 1. Creating table 'Users' ---");
        Table users = new Table("Users", Arrays.asList("ID", "Name", "Email"));

        System.out.println("\n--- 2. Adding Triggers (Observers) ---");
        LoggingTrigger logger = new LoggingTrigger();
        BackupTrigger backup = new BackupTrigger();
        ValidationTrigger validator = new ValidationTrigger();

        users.addTrigger(logger);
        users.addTrigger(backup);
        users.addTrigger(validator);

        System.out.println("\n--- 3. Demonstration: Adding rows ---");

        // Спроба 1: Успішне додавання
        System.out.println("\n[Demo] Attempt 1: Valid row");
        Row row1 = new Row(users.getColumns());
        row1.setValue("ID", 1);
        row1.setValue("Name", "Alice");
        row1.setValue("Email", "alice@example.com");
        users.addRow(row1);

        // Спроба 2: Невдале додавання (ValidationTrigger спрацює)
        System.out.println("\n[Demo] Attempt 2: Invalid row (null Email)");
        Row row2_invalid = new Row(users.getColumns());
        row2_invalid.setValue("ID", 2);
        row2_invalid.setValue("Name", "Bob");
        // Email = null, це викличе помилку валідації
        users.addRow(row2_invalid);

        // Спроба 3: Ще одне успішне додавання
        System.out.println("\n[Demo] Attempt 3: Valid row");
        Row row3 = new Row(users.getColumns());
        row3.setValue("ID", 3);
        row3.setValue("Name", "Charlie");
        row3.setValue("Email", "charlie@example.com");
        users.addRow(row3);

        System.out.println("\n--- 4. Current table state ---");
        System.out.println(users.toString());

        System.out.println("\n--- 5. Demonstration: Updating a row ---");

        // Спроба 1: Успішне оновлення (BackupTrigger збереже копію)
        System.out.println("\n[Demo] Attempt 1: Valid update (Email)");
        users.updateCell(0, "Email", "alice.new@mail.com");

        // Спроба 2: Невдале оновлення (ValidationTrigger заборонить зміну ID)
        System.out.println("\n[Demo] Attempt 2: Invalid update (ID)");
        users.updateCell(1, "ID", 99);

        System.out.println("\n--- 6. Current table state ---");
        System.out.println(users.toString());

        System.out.println("\n--- 7. Demonstration: Deleting a row ---");
        // (BackupTrigger збереже копію)
        System.out.println("\n[Demo] Deleting row at index 0 (Alice)");
        users.deleteRow(0); // Видаляємо Alice

        System.out.println("\n--- 8. Final table state ---");
        System.out.println(users.toString());

        System.out.println("\n--- 9. Demonstration: BackupTrigger check ---");
        // Перевіряємо, що BackupTrigger зберіг копії
        backup.showBackups();
    }
}
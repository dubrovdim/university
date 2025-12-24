package work4;

import java.util.ArrayList;
import java.util.List;

/**
 * Конкретний Спостерігач (Concrete Observer).
 * Цей тригер зберігає резервну копію рядків.
 */
public class BackupTrigger implements TableTrigger {

    /**
     * Сховище для резервних копій рядків.
     */
    private List<Row> backupStorage = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEvent(String eventType, Table source, Row affectedRow, String columnChanged) {
        if ("UPDATE".equals(eventType) || "DELETE".equals(eventType)) {

            System.out.println("[BackupTrigger]: Creating backup of row before '" + eventType + "'...");
            
            backupStorage.add(new Row(affectedRow));
        }
    }

    /**
     * Допоміжний метод для демонстрації.
     */
    public void showBackups() {
        System.out.println("\n--- [BackupTrigger] Stored Backups (" + backupStorage.size() + ") ---");
        for (Row row : backupStorage) {
            System.out.println("  > " + row.toString());
        }
    }
}
package work4;

/**
 * Конкретний Спостерігач (Concrete Observer).
 * Цей тригер виводить у консоль детальну інформацію про кожну подію.
 */
public class LoggingTrigger implements TableTrigger {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEvent(String eventType, Table source, Row affectedRow, String columnChanged) {
        System.out.println("[LoggingTrigger]: Event '" + eventType + "' in table '" + source.getTableName() + "'.");

        switch (eventType) {
            case "INSERT":
                System.out.println("  > Data: " + affectedRow.toString());
                break;
            case "UPDATE":
                System.out.println("  > Row: " + affectedRow.toString());
                System.out.println("  > Column changed: " + columnChanged);
                break;
            case "DELETE":
                System.out.println("  > Deleting row: " + affectedRow.toString());
                break;
        }
    }
}
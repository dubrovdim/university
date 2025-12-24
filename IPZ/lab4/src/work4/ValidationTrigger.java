package work4;

/**
 * Конкретний Спостерігач (Concrete Observer).
 * Цей тригер перевіряє дані перед операцією.
 */
public class ValidationTrigger implements TableTrigger {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEvent(String eventType, Table source, Row affectedRow, String columnChanged) {
        if ("INSERT".equals(eventType)) {
            System.out.println("[ValidationTrigger]: Validating data for INSERT...");

            Object id = affectedRow.getValue("ID");
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null.");
            }

            Object email = affectedRow.getValue("Email");
            if (email == null || email.toString().isEmpty()) {
                throw new IllegalArgumentException("Email cannot be empty.");
            }
            System.out.println("[ValidationTrigger]: ...Data for INSERT is valid.");
        }

        if ("UPDATE".equals(eventType)) {
            System.out.println("[ValidationTrigger]: Validating data for UPDATE...");

            if ("ID".equals(columnChanged)) {
                throw new UnsupportedOperationException("Changing ID is forbidden.");
            }
            System.out.println("[ValidationTrigger]: ...UPDATE operation is valid.");
        }
    }
}
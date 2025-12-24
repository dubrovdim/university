package work4;

/**
 * Інтерфейс Спостерігача (Observer) в термінах шаблону "Спостерігач".
 * Визначає єдиний метод onEvent, який викликається Суб'єктом (Table)
 * при зміні свого стану.
 */
public interface TableTrigger {

    /**
     * Метод, що викликається при спрацюванні тригера.
     *
     * @param eventType     Тип події (наприклад, "INSERT", "UPDATE", "DELETE").
     * @param source        Таблиця, в якій відбулася подія.
     * @param affectedRow   Рядок, на який вплинула подія. Для "UPDATE" та "DELETE"
     * це рядок *до* внесення змін.
     * @param columnChanged Назва стовпця, що змінився (актуально для "UPDATE").
     */
    void onEvent(String eventType, Table source, Row affectedRow, String columnChanged);
}
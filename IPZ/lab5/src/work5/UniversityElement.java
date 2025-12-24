package work5;

/**
 * Інтерфейс UniversityElement.
 * Описує спільну поведінку всіх елементів університету.
 * Визначає метод accept для прийняття відвідувача.
 */
public interface UniversityElement {
    /**
     * Метод, що дозволяє об'єкту прийняти відвідувача.
     * @param visitor об'єкт відвідувача, який виконує операцію
     */
    void accept(UniversityVisitor visitor);
}
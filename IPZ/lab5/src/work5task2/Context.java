package work5task2;

import java.util.HashMap;
import java.util.Map;

/**
 * Клас Context зберігає значення змінних, що використовуються у виразах.
 * Він передається в метод interpret виразів для отримання конкретних значень.
 */
public class Context {
    private Map<String, Double> variables = new HashMap<>();

    /**
     * Встановлює значення для певної змінної.
     * @param name ім'я змінної
     * @param value значення змінної
     */
    public void setVariable(String name, double value) {
        variables.put(name, value);
    }

    /**
     * Отримує значення змінної за її ім'ям.
     * @param name ім'я змінної
     * @return значення змінної
     * @throws IllegalArgumentException якщо змінна не знайдена в контексті
     */
    public double getVariable(String name) {
        if (!variables.containsKey(name)) {
            throw new IllegalArgumentException("Variable '" + name + "' is not defined in the context.");
        }
        return variables.get(name);
    }
}
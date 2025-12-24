package work6_1;

/**
 * Головний клас для демонстрації роботи завдання 2 (Builder).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- STARTING BUILDER PATTERN DEMO ---");

        // 1. Створення будівельника (ConcreteGameBuilder)
        GameSpaceBuilder builder = new ConcreteGameBuilder();

        // 2. Створення директора
        Director director = new Director();

        // 3. Виклик процесу побудови
        // Шлях до файлу
        String configFilePath = "src/game_config.txt"; 
        
        director.construct(builder, configFilePath);

        // 4. Отримання готового об'єкту
        RectangleGameSpace gameSpace = builder.build();

        // 5. Візуалізація результату
        gameSpace.display();
    }
}
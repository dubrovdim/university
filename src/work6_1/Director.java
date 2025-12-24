package work6_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Клас Director.
 * Відповідає за зчитування параметрів конфігурації з зовнішнього файлу
 * і поетапне створення ігрового простору через інтерфейс Builder.
 */
public class Director {
    
    /**
     * Конструює ігровий простір, використовуючи дані з файлу.
     * * @param builder об'єкт будівельника.
     * @param filename шлях до файлу конфігурації.
     */
    public void construct(GameSpaceBuilder builder, String filename) {
        System.out.println("Director: Reading configuration from '" + filename + "'...");
        
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Error: File not found!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLine(builder, line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Розбирає рядок і викликає відповідний метод будівельника.
     * Формат рядка: key=value
     */
    private void processLine(GameSpaceBuilder builder, String line) {
        if (line.trim().isEmpty() || line.startsWith("#")) return;

        String[] parts = line.split("=", 2);
        if (parts.length != 2) return;

        String key = parts[0].trim();
        String value = parts[1].trim();

        switch (key) {
            case "width":
                builder.setWidth(Integer.parseInt(value));
                break;
            case "height":
                builder.setHeight(Integer.parseInt(value));
                break;
            case "background":
                builder.setBackground(value);
                break;
            case "object":
                builder.addObject(value);
                break;
            default:
                System.out.println("Unknown config key: " + key);
        }
    }
}
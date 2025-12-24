package work6_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас RectangleGameSpace описує прямокутний ігровий простір.
 * Містить параметри ширини, висоти, фону та список ігрових об'єктів.
 */
public class RectangleGameSpace {
    private int width;
    private int height;
    private String background;
    private List<String> objects;

    /**
     * Конструктор ініціалізує список об'єктів.
     */
    public RectangleGameSpace() {
        this.objects = new ArrayList<>();
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setBackground(String background) { this.background = background; }
    
    public void addObject(String objectName) {
        this.objects.add(objectName);
    }

    /**
     * Метод display() для відображення простору.
     * Виводить інформацію в консоль англійською мовою.
     */
    public void display() {
        System.out.println("\n=== GAME SPACE VISUALIZATION ===");
        System.out.println("Resolution: " + width + "x" + height);
        System.out.println("Background: " + background);
        System.out.println("Game Objects:");
        if (objects.isEmpty()) {
            System.out.println("  [None]");
        } else {
            for (String obj : objects) {
                System.out.println("  - " + obj);
            }
        }
        System.out.println("================================\n");
    }
}
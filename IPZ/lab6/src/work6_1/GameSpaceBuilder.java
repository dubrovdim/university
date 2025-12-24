package work6_1;

/**
 * Інтерфейс, який визначає кроки побудови ігрового простору.
 */
public interface GameSpaceBuilder {
    /**
     * Встановлює ширину простору.
     */
    void setWidth(int width);

    /**
     * Встановлює висоту простору.
     */
    void setHeight(int height);

    /**
     * Встановлює фон або текстуру.
     */
    void setBackground(String background);

    /**
     * Додає об'єкт до ігрового простору.
     */
    void addObject(String objectName);

    /**
     * Повертає готовий об'єкт типу RectangleGameSpace.
     * @return готовий ігровий простір.
     */
    RectangleGameSpace build();
}
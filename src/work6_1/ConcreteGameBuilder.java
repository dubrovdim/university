package work6_1;

/**
 * Клас, що є конкретною реалізацією будівельника.
 * Створює об'єкт RectangleGameSpace та наповнює його даними.
 */
public class ConcreteGameBuilder implements GameSpaceBuilder {
    private RectangleGameSpace gameSpace;

    /**
     * Конструктор скидає стан, створюючи новий об'єкт.
     */
    public ConcreteGameBuilder() {
        this.reset();
    }

    /**
     * Створення нового порожнього об'єкта RectangleGameSpace.
     */
    public void reset() {
        this.gameSpace = new RectangleGameSpace();
    }

    @Override
    public void setWidth(int width) {
        gameSpace.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        gameSpace.setHeight(height);
    }

    @Override
    public void setBackground(String background) {
        gameSpace.setBackground(background);
    }

    @Override
    public void addObject(String objectName) {
        gameSpace.addObject(objectName);
    }

    /**
     * Повертає готовий продукт і скидає будівельник для можливості повторного використання.
     */
    @Override
    public RectangleGameSpace build() {
        RectangleGameSpace result = this.gameSpace;
        this.reset();
        return result;
    }
}
package work4_1;

/**
 * Інтерфейс обробника (Handler) в термінах шаблону "Chain of Responsibility".
 */
public interface RequestHandler {
    void setNextHandler(RequestHandler nextHandler);
    void handle(HttpRequest request);
}
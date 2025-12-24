package work4_1;

/**
 * Конкретний обробник (Concrete Handler).
 * Обробляє лише запити типу "POST".
 */
public class PostRequestHandler implements RequestHandler {
    private RequestHandler nextHandler;

    @Override
    public void setNextHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(HttpRequest request) {
        System.out.println("==> Method handle (POST) with parameters request=" + request.toString());
        if ("POST".equals(request.getType())) {
            System.out.println("[PostHandler]: Processing POST request for " + request.getUrl() + " with body: " + request.getBody());
        } else if (nextHandler != null) {
            System.out.println("[PostHandler]: Cannot handle. Passing to next handler.");
            nextHandler.handle(request);
        } else {
            System.err.println("[PostHandler]: No next handler and cannot process request: " + request.getType());
        }
    }
}
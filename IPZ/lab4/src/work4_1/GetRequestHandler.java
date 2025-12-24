package work4_1;

/**
 * Конкретний обробник (Concrete Handler).
 * Обробляє лише запити типу "GET".
 */
public class GetRequestHandler implements RequestHandler {
    private RequestHandler nextHandler;

    @Override
    public void setNextHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handle(HttpRequest request) {
        System.out.println("==> Method handle (GET) with parameters request=" + request.toString());
        if ("GET".equals(request.getType())) {
            System.out.println("[GetHandler]: Processing GET request for " + request.getUrl());
        } else if (nextHandler != null) {
            System.out.println("[GetHandler]: Cannot handle. Passing to next handler.");
            nextHandler.handle(request);
        } else {
            System.err.println("[GetHandler]: No next handler and cannot process request: " + request.getType());
        }
    }
}
package work4_1;
/**
 * Головний клас для демонстрації роботи шаблону "Ланцюжок Обов'язків" (Варіант 5).
 */
public class Main {

    private static RequestHandler createInitialChain() {
        System.out.println("--- 1. Creating handlers (GET, POST) ---");
        RequestHandler getHandler = new GetRequestHandler();
        RequestHandler postHandler = new PostRequestHandler();

        System.out.println("--- 2. Dynamically forming the chain (GET -> POST) ---");
        getHandler.setNextHandler(postHandler);

        return getHandler;
    }

    public static void main(String[] args) {
        RequestHandler chain = createInitialChain();
        System.out.println("\n--- 3. Processing different HTTP requests ---");

        System.out.println("\n[Demo] Processing 'GET' request...");
        HttpRequest reqGet = new HttpRequest("GET", "/index.html");
        chain.handle(reqGet);

        System.out.println("\n[Demo] Processing 'POST' request (shows passing the chain)...");
        HttpRequest reqPost = new HttpRequest("POST", "/login", "user=admin&pass=123");
        chain.handle(reqPost);

        System.out.println("\n[Demo] Processing 'PUT' request (shows unhandled request)...");
        HttpRequest reqPut = new HttpRequest("PUT", "/api/data", "data=new");
        chain.handle(reqPut);

        System.out.println("\n--- 4. Adding a new handler AT RUNTIME (for PUT) ---");
        
        RequestHandler putHandler = new RequestHandler() {
            private RequestHandler nextHandler;
            @Override
            public void setNextHandler(RequestHandler nextHandler) { this.nextHandler = nextHandler; }
            @Override
            public void handle(HttpRequest request) {
                System.out.println("==> Method handle (PUT) with parameters request=" + request.toString());
                if ("PUT".equals(request.getType())) {
                    System.out.println("[PutHandler_Dynamic]: Processing PUT request for " + request.getUrl());
                } else if (nextHandler != null) {
                    System.out.println("[PutHandler_Dynamic]: Cannot handle. Passing to next.");
                    nextHandler.handle(request);
                } else {
                    System.err.println("[PutHandler_Dynamic]: No next handler and cannot process request: " + request.getType());
                }
            }
        };
        
        System.out.println("[Demo] Rebuilding chain: GET -> POST -> PUT");
        RequestHandler getHandler = new GetRequestHandler();
        RequestHandler postHandler = new PostRequestHandler();
        getHandler.setNextHandler(postHandler);
        postHandler.setNextHandler(putHandler); 
        chain = getHandler;

        System.out.println("\n--- 5. Processing 'PUT' request again ---");
        chain.handle(reqPut);
    }
}
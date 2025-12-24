package work4_1;

/**
 * Клас, що моделює HTTP-запит.
 */
public class HttpRequest {
    private String type;
    private String url;
    private String body;

    public HttpRequest(String type, String url) {
        this.type = type;
        this.url = url;
        this.body = ""; 
    }

    public HttpRequest(String type, String url, String body) {
        this.type = type;
        this.url = url;
        this.body = body;
    }

    public String getType() { return type; }
    public String getUrl() { return url; }
    public String getBody() { return body; }

    @Override
    public String toString() {
        return "HttpRequest [type=" + type + ", url=" + url + ", body=" + (body.isEmpty() ? "none" : body) + "]";
    }
}
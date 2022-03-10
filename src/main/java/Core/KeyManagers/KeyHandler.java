package Core.KeyManagers;

import Core.exception.AuthException;

import java.net.CookieManager;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class KeyHandler {
    protected String getKeys(String username, String password) throws AuthException {
        HttpClient.Builder client = login(username, password);

        AtomicReference<String> ssl = new AtomicReference<>("nothing");
        HttpRequest.BodyPublisher bodyPublisher1 = HttpRequest.BodyPublishers
                .ofString("");

        HttpRequest request1 = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/apikey/list"))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher1).build();

        client.build()
                .sendAsync(request1, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(ssl::set)
                .join();
        return ssl.get();
    }

    protected HttpClient.Builder login(String username, String password) throws AuthException {

        HttpClient.Builder client = HttpClient.newBuilder();
        CookieManager cookieManager = new CookieManager();

        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers
                .ofString("{\"email\":\""+username+"\",\"password\":\""+password+"\"}");
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/login")
                )
                .header("authorization", "")
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher).build();

        AtomicInteger statusCode = new AtomicInteger();
        client.cookieHandler(cookieManager)
                .build()
                .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(statusCode::set)
                .join();
        if (statusCode.get() != 200){
            throw new AuthException("Email or Password is incorrect");
        }
        return client;
    }

    protected String createKeys(String username, String password, String ip) throws AuthException {
        HttpClient.Builder client = login(username, password);
        String json = """
                {
                    "cidrRanges":
                     ["%s"],
                      "description": "Api key created by JClash on %s",
                      "name": "JClash",
                      "scopes": ["clash"]
                }
                """;
        HttpRequest.BodyPublisher bodyPublisher1 = HttpRequest.BodyPublishers
                .ofString(String.format(json, ip, LocalDateTime.now().toString()));

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create("https://developer.clashofclans.com/api/apikey/create"))
                .header("Content-Type", "application/json; charset=utf-8")
                .POST(bodyPublisher1).build();
        AtomicReference<String> stringAtomicReference = new AtomicReference<>();
        client.build().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(stringAtomicReference::set)
                .join();
        return stringAtomicReference.get();
    }
}
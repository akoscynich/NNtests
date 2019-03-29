import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SwaggerTests {

    @Test
    public void swaggerResponse() throws IOException {
        URL url = new URL("https://nsp.mygento.net/ru/rest/all/schema?services=all");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        Assert.assertEquals(connection.getResponseCode(), 200);
        System.out.println(connection.getResponseCode());
        String contentType = null;
        if ((connection.getContentType()).equals("application/json"))
            contentType = "application/json";
        if ((connection.getContentType()).equals("application/json; charset=utf-8"))
            contentType = "application/json; charset=utf-8";
        System.out.println(contentType);
        Assert.assertEquals(connection.getContentType(), contentType);
    }

}
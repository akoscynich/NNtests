import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SwaggerTests {

    @Test
    public void response() throws IOException {
        URL url = new URL("https://nsp.mygento.net/ru/rest/all/schema?services=all");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        Assert.assertEquals(connection.getContentType(), "application/json");
        Assert.assertEquals(connection.getResponseCode(), 200);
    }

}
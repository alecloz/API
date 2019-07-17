import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetRequest {

    static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {

        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=Жыл+был+дед+и+незнал+дед+что+бизграмотен+он");

            response = httpClient.execute(httpGet);

            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

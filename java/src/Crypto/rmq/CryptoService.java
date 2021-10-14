package Crypto.rmq;

import com.intersystems.enslib.pex.*;
import com.intersystems.jdbc.IRISObject;
import com.intersystems.jdbc.IRIS;
import com.intersystems.gateway.GatewayContext;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CryptoService extends BusinessService{

    private String URL = "https://api.coinpaprika.com/v1/global";
    private IRIS iris;

    @Override
    public void OnInit() throws Exception {
        LOGINFO("asd");
        iris = GatewayContext.getIRIS();
    }

    @Override
    public Object OnProcessInput(Object messageInput) throws Exception {
        IRISObject response = (IRISObject)(iris.classMethodObject("dc.Request","%New"));
        response.set("OriginalJSON", readJsonFromUrl(URL).toString());
        SendRequestAsync("RequestRoutingRule", response);
        return super.OnProcessInput(messageInput);
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonText = readAll(rd);
            return new JSONObject(jsonText);
        }
    }
}

package fr.minuskube.inv.opener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    public static final String token = "b41039abcffc65da8a393f91a74eda26";
    public List<String> getLicenseFromGitee() {
        List<String> licenseLines = new ArrayList<>();
        try {
            URL url = new URL("https://gitee.com/h1a/mega-walls-license/raw/master/mw"); // 替换为你的 URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "token " + token);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                licenseLines.add(inputLine);
            }
            // 关闭连接
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenseLines;
    }
}

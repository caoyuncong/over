package zong;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by caoyuncong on
 * 2017/5/6 15:03
 * over.
 */
// 编写一个程序，下载 google 首页 logo 图片保存到本地
public class Crawler {
        private static final String IMAGE_ADDRESS = "https://www.baidu.com/img/mother_2_a346e75dd5fd6fbd7d98cef4b250d630.gif";
//    private static final String USER_AGENT = "test";
    public static void main(String[] args) {
        try {
            URL url = new URL(IMAGE_ADDRESS);
//            System.setProperty("http.agent", USER_AGENT);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try (
                    InputStream inputStream = url.openStream();
//                    InputStream inputStream=httpURLConnection.getInputStream();
                    OutputStream outputStream=new FileOutputStream("logo.gif")
            ) {
//                System.out.println(inputStream.available());
                int i;
                while ((i = inputStream.read()) != -1) {
                    outputStream.write(i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

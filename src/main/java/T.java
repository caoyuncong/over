import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by caoyuncong on
 * 2017/5/12 9:16
 * over.
 */
public class T {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.baidu.com/img/mother_2_a346e75dd5fd6fbd7d98cef4b250d630.gif").get();
//        System.out.println(document);
//        Elements elements=document.select("div[id=lg]").first().select()
    }
}

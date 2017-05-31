package multiThread;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by caoyuncong on
 * 2017/5/13 9:21
 * over.
 */
// 使用多线程同时下载以下两个视频 20分
//  https://gifshow-static.download.ks-cdn.com/video/home-1.mp4
//  https://gifshow-static.download.ks-cdn.com/video/home-2.mp4
public class Thread8 implements Runnable {
    private static final String MV1_URL = "https://gifshow-static.download.ks-cdn.com/video/home-1.mp4";
    private static final String MV2_URL = "https://gifshow-static.download.ks-cdn.com/video/home-2.mp4";

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Thread8(), "thread1");
        Thread thread2 = new Thread(new Thread8(), "thread2");
        thread1.start();
        thread2.start();

    }
    @Override
    public void run() {
        try {
            URL url1 = new URL(MV1_URL);
            URL url2 = new URL(MV2_URL);
            try (
                    InputStream inputStream1 = url1.openStream();
                    InputStream inputStream2 = url2.openStream();
                    OutputStream outputStream1=new FileOutputStream("src/main/java/multiThread/mv1.mp4");
                    OutputStream outputStream2=new FileOutputStream("src/main/java/multiThread/mv2.mp4")
            ) {
                int i;
                while ((i = inputStream1.read()) != -1) {
                    outputStream1.write(i);
                }
                int j;
                while ((j = inputStream2.read()) != -1) {
                    outputStream2.write(j);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

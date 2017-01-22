package net.chromaryu.hiragana;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by midgard on 16/12/22.
 */
public class main {
    public static DataInputStream dis;
    public static byte[] metadatabuffer;
    private static String cmetadata = "";
    static int metaint,marker,length;static String metadata;
    static boolean stop;
    long skipped;
    public static void main(String[] args) {
        thread th = new thread();
        try {
            URL url = new URL("http://stream.gensokyoradio.net:8000");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Icy-MetaData","1");
            connection.setUseCaches(false);
            metaint = Integer.parseInt(connection.getHeaderField("icy-metaint"));
            dis = new DataInputStream(connection.getInputStream());
            th.start();
            while(true) {
                th.join();
                //if(cmetadata.equals(metadata)) continue;
                System.out.println(metadata);
                //Jacmetadata = metadata;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

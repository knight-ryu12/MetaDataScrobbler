package net.chromaryu.hiragana;

import org.apache.http.HttpConnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by midgard on 17/01/21.
 */
public class thread extends Thread {
    private int length;
    @Override
    public void run() {
        try {
                main.dis.skipBytes(main.metaint);
                length = main.dis.readByte();
                main.metadatabuffer = new byte[length * 16];
                main.dis.readFully(main.metadatabuffer);
                System.out.println(Arrays.toString(main.metadatabuffer));
                main.metadata = new String(main.metadatabuffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

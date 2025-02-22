package com.ljy.Spring0011.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc url资源
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url){
        this.url=url;
    }
    @Override
    public InputStream getInputStream() throws IOException {

        URLConnection urlConnection=url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}

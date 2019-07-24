package com.ljy.Spring0011.io;

import java.net.URL;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc 资源加载类
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL url=this.getClass().getClassLoader().getResource(location);
        return new UrlResource(url);
    }
}

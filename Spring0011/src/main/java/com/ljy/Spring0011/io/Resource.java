package com.ljy.Spring0011.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ljy
 * @create 2019-07-23
 * @desc Resource是spring内部定位资源的接口。
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}

package com.candy.geek.week01;

import java.io.*;

/**
 * @author zh0809
 * @date 2020/10/17 8:35
 **/
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Object obj = new HelloClassLoader().loadClass("Hello").newInstance();
        // 执行hello方法
        obj.getClass().getDeclaredMethod("hello").invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classByte = new byte[0];
        try {
            classByte = inputStream2ByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 处理字节 x = 255 -x
        for (int i = 0; i < classByte.length; i++) {
            classByte[i] = (byte) (255 - classByte[i]);
        }
        return defineClass(name, classByte, 0, classByte.length);
    }

    private byte[] inputStream2ByteArray() throws IOException {
        InputStream in = new FileInputStream("D:/Hello.xlass");
        byte[] data = toByteArray(in);
        in.close();
        return data;
    }

    private byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

}
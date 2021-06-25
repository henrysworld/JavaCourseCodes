package com.example.demo;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XlassLoader extends ClassLoader{

    public static void main(String[] args){
        String className = "com.example.demo.Hello";
        String methodName = "hello";

        XlassLoader xlassLoader = new XlassLoader();
        try {
            Class<?> cxlazz = xlassLoader.loadClass(className);

            for (Method method : cxlazz.getMethods()){
                System.out.println(cxlazz.getSimpleName() + "." + method.getName());
            }

            Object instance = cxlazz.getDeclaredConstructor().newInstance();

            //调用实例
            Method method = cxlazz.getMethod(methodName);
            method.invoke(instance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    };

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String resourcePath = name.replace(".", "/");
        String suffix = ".xlass";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath + suffix);

        try {
            int length = inputStream.available();
            byte[] byteArray = new byte[length];
            inputStream.read(byteArray);

            //转换
            byte[] classBytes = decode(byteArray);

            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name, e);
        } finally {
            close(inputStream);
        }

    }


    /**
     * 解码
     * @param byteArray
     * @return
     */
    public static byte[] decode(byte[] byteArray){
        byte[] bytes = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++){
            bytes[i] = (byte) (255 - byteArray[i]);
        }

        return bytes;
    }

    public static void close(Closeable res){
        if (res != null){
            try {
                res.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

package com.example.demo;


import java.util.Base64;

public class HelloClassLoader extends ClassLoader{

    public static void main(String[] args){
        try {
            new HelloClassLoader().findClass("com.example.demo.Hello").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String helloBase64 = "yv66vgAAADgAHQoABgAPCQAQABEIABIKABMAFAcAFQcAFgEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAARtYWluAQAWKFtMamF2YS9sYW5nL1N0cmluZzspVgEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgHABcMABgAGQEAIkhlbGxvIHRoaXMgaXMgbXkgZmlyc3QgQ2xhc3Nsb2FkISEHABoMABsAHAEAFmNvbS9leGFtcGxlL2RlbW8vSGVsbG8BABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABQAGAAAAAAACAAEABwAIAAEACQAAAB0AAQABAAAABSq3AAGxAAAAAQAKAAAABgABAAAAAwAJAAsADAABAAkAAAAlAAIAAQAAAAmyAAISA7YABLEAAAABAAoAAAAKAAIAAAAFAAgABgABAA0AAAACAA4=";
        byte[] bytes = decode(helloBase64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }
}

package org.example;

import org.example.core.HttpServerListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        HttpServerListener serverListener=new HttpServerListener(8080,"");
        serverListener.start();

    }
}
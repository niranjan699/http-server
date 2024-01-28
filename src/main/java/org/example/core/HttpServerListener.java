package org.example.core;

import org.example.util.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.util.Constants.CRLF;

public class HttpServerListener extends Thread{

    private final int port;
    private final String path;

    private final ServerSocket serverSocket;

    public HttpServerListener(int port, String path) throws IOException {
        this.port = port;
        this.path = path;
        serverSocket=new ServerSocket(port);
    }

    @Override
    public void run() {


        try {
            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                HttpWorkerThread workerThread=new HttpWorkerThread(socket);
                workerThread.start();

            }
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

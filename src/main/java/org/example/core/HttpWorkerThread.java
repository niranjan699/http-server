package org.example.core;

import org.example.util.Constants;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static org.example.util.Constants.CRLF;


public class HttpWorkerThread  extends Thread
{

    private final Socket socket;

    public HttpWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {


            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String html = "<html><head></head><body><h1>Welcome</h1></body></html>";
            String response = Constants.SUCCESS_HEADER + CRLF + html + "Content-Length :" + html.getBytes().length +
                    CRLF + CRLF + html + CRLF + CRLF;

            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();
        }
        catch (Exception e)
        {

        }
        finally {

        }
    }
}

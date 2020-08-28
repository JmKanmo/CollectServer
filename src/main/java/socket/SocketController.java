package socket;

import logger.LoggingController;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

public class SocketController {
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ServerSocket serverSocket;

    public SocketController() {
        try {
            serverSocket = new ServerSocket();
        } catch (IOException e) {
            LoggingController.errorLogging(e);
        }
    }

    public void stopServer() {
        if (serverSocket != null && serverSocket.isClosed() != true) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                LoggingController.errorLogging(e);
            }
        }

        if (executorService != null && executorService.isShutdown() != true) {
            executorService.shutdown();
        }
    }

    private void receiveJson(Socket socket) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                        socket.getInputStream());) {
                    while (true) {
                        try {
                            // TODO Auto-generated method stub
                            byte[] byteArr = new byte[6500];
                            int inputCount = bufferedInputStream.read(byteArr);
                            if (inputCount == -1) {
                                throw new IOException();
                            }
                            String data = new String(byteArr, 0, inputCount, "UTF-8");
                            LoggingController.logging(Level.INFO, data);
                            System.out.println(data);
                        } catch (Exception e) {
                            LoggingController.errorLogging(e);
                            try {
                                if (socket.isClosed() != true) {
                                    socket.close();
                                }
                            } catch (IOException e1) {
                                LoggingController.errorLogging(e1);
                            }
                            break;
                        }
                    }
                } catch (Exception e) {
                    LoggingController.errorLogging(e);
                }
            }
        });
    }

    public void startServer() {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(5001);

                    while (true) {
                        Socket socket = serverSocket.accept();
                        receiveJson(socket);
                    }
                } catch (IOException e) {
                    LoggingController.errorLogging(e);
                    try {
                        serverSocket.close();
                    } catch (IOException e1) {
                        LoggingController.errorLogging(e);
                    }
                }
            }
        });
    }
}

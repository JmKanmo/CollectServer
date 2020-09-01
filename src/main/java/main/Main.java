package main;

import logger.LoggingController;
import socket.SocketController;

import java.util.logging.Level;

class Main {
    public static void main(String[] args) {
        SocketController socketController = new SocketController();
        socketController.startServer();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                socketController.stopServer();
                LoggingController.logging(Level.INFO, "CollectorServer 종료 코드 동작");
            }
        }));
    }
}
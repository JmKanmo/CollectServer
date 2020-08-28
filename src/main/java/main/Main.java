package main;

import socket.SocketController;

class Main {
    public static void main(String[] args) {
        SocketController socketController = new SocketController();
        socketController.startServer();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                socketController.stopServer();
            }
        }));
    }
}
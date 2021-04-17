package network;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class ChessClientNetwork {
    private ServerSocket listener;
    private Socket socket;
    private PrintWriter printWriter;
    private String SOCKET_SERVER_ADDR = "localhost";
    private int PORT = 50000;



    public void movePiece(int fromCol, int fromRow, int toCol, int toRow) {
       // chessModel.movePiece(fromCol, fromRow, toCol, toRow);
        //chessBoardPanel.repaint();
        if (printWriter != null) {
            printWriter.println(fromCol + "," + fromRow + "," + toCol + "," + toRow);
        }
    }

    private void receiveMove(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String moveStr = scanner.nextLine();
            System.out.println("chess move received: " + moveStr);
            String[] moveStrArr = moveStr.split(",");
            Integer fromCol = Integer.parseInt(moveStrArr[0]);
            Integer fromRow = Integer.parseInt(moveStrArr[1]);
            Integer toCol = Integer.parseInt(moveStrArr[2]);
            Integer toRow = Integer.parseInt(moveStrArr[3]);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //chessModel.movePiece(fromCol, fromRow, toCol, toRow);
                    //chessBoardPanel.repaint();
                }
            });
        }
    }

    private void runSocketServer() {
        Executors.newFixedThreadPool(1).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    listener = new ServerSocket(PORT);
                    System.out.println("server is listening on port " + PORT);
                    socket = listener.accept();
                    System.out.println("connected from " + socket.getInetAddress());
                    printWriter = new PrintWriter(socket.getOutputStream(), true);
                    Scanner scanner = new Scanner(socket.getInputStream());
                    receiveMove(scanner);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void runSocketClient() {
        try {
            socket = new Socket(SOCKET_SERVER_ADDR, PORT);
            System.out.println("client connected to port " + PORT);
            Scanner scanner = new Scanner(socket.getInputStream());
            printWriter = new PrintWriter(socket.getOutputStream(), true);

            Executors.newFixedThreadPool(1).execute(new Runnable() {
                @Override
                public void run() {
                    receiveMove(scanner);
                }
            });
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

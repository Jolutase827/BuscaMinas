package es.ieslavereda.tools;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Menu {
    public static char[][] boardRequeriments(){
        Scanner sc = new Scanner(System.in);
        char board[][];
        int boardSize;
        int gameDifficult;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"                                                               ¡¡¡¡WELCOME TO MINESWEEPER!!!!                  ");
        System.out.println("                                                                         Press space                                                                                 "+Colors.ANSI_RESET);
        sc.nextLine();
        ScreenOptions.eraseScreen();
        boardSize = selectLenght();
        board = new char[boardSize][boardSize];
        gameDifficult = selectDificult(boardSize*boardSize);
        Board.createBoard(board, gameDifficult);
        return board;
    }

    public static int selectLenght(){
        Scanner sc = new Scanner(System.in);
        String length;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"What size do you want the board to be (LARGE), (BIG), (ENORMOUS) or (EXTREMELY ENORMOUS)? "+Colors.ANSI_RESET);
        length = sc.nextLine();
        while (boardLength(length)==-1){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Please write (LARGE), (BIG), (ENORMOUS) or (EXTREMELY ENORMOUS): "+Colors.ANSI_RESET);
            length = sc.nextLine();
        }

        return boardLength(length);
    }
    public static int boardLength(String length){
        switch (length.toUpperCase()){
            case ("LARGE"):
                return 2;
            case ("BIG"):
                return 4;
            case ("ENORMOUS"):
                return 8;
            case("EXTREMELY ENORMOUS"):
                return 16;
            default:
                return -1;
        }
    }
    public static int selectDificult(int boardLength){
        Scanner sc = new Scanner(System.in);
        String lvlDificult;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"What level of dificult do you want to be (EASY), (MEDIUM), (HARD) OR (IMPOSIBLE)?"+Colors.ANSI_RESET);
        lvlDificult = sc.nextLine();
        while (partyDificulty(lvlDificult,boardLength)==-1){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Please write (EASY), (MEDIUM), (HARD) OR (IMPOSIBLE):"+Colors.ANSI_RESET);
            lvlDificult = sc.nextLine();
        }
        return partyDificulty(lvlDificult,boardLength);
    }
    public static int partyDificulty(String lvlDificult, int boardLength){
        switch (lvlDificult.toUpperCase()){
            case ("EASY"):
                return (int)(boardLength/4);
            case ("MEDIUM"):
                return (int)(boardLength/3);
            case ("HARD"):
                return (int) (boardLength/2);
            case ("IMPOSIBLE"):
                return boardLength-1;
            default:
                return -1;
        }
    }


    public static boolean activateHacks(){
        Scanner sc = new Scanner(System.in);
        String yesOrNo;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Do you want to activate the hacks to see the bombs (yes or no)?"+Colors.ANSI_RESET);
        yesOrNo = sc.nextLine();
        yesOrNo = returnYesOrNo(yesOrNo);
        return yesOrNo.compareToIgnoreCase("yes") == 0;
    }


    public static String returnYesOrNo(String yesOrNo){
        Scanner sc = new Scanner(System.in);
        while (yesOrNo.compareToIgnoreCase("yes")!=0&&yesOrNo.compareToIgnoreCase("no")!=0){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Are you kidding me? Can you write (yes or no) for active the hacks pls?"+Colors.ANSI_RESET);
            yesOrNo = sc.nextLine();
        }
        return yesOrNo;
    }
}

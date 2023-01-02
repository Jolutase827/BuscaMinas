package es.ieslavereda.tools;

import java.util.Scanner;

public class Game {

    public static void startGame(char[][] board, char[][] boardWithout, boolean hacks){
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("Do you want to start the game yes or no?");
        answer = sc.nextLine();
        while (answer.compareToIgnoreCase("yes")!=0&&answer.compareToIgnoreCase("no")!=0){
            System.out.println("I going to repeate another time, do you want to start the game yes or no?");
            answer = sc.nextLine();
        }
        ScreenOptions.eraseScreen();
        if (answer.compareToIgnoreCase("yes")==0)
            letsPlay(board, hacks,boardWithout);
        else {
            ScreenOptions.eraseScreen();
            System.out.println("Bye bye!!!!");
        }
    }

    public static void letsPlay(char[][] board,boolean hacks, char[][] boardWithout){
        Scanner sc = new Scanner(System.in);
        int numberFlags = Board.countBombs(board);
        Board.showBoard(board, hacks, boardWithout);
        numberFlags = playerAction(board,boardWithout,numberFlags);
        Board.showBoard(board,hacks, boardWithout);
        
    }

    public static int playerAction(char[][] board,char[][] boardWithOut,int numberFlags){
        if (askPlantFlagOrSelectPlace(numberFlags)) {
            plantFlag(boardWithOut, Coordinate.askCoordinate(boardWithOut));
            return numberFlags--;
        }

        return numberFlags;
    }

    public static void plantFlag(char[][] boardWithOut,int[] coordinate){
        boardWithOut[coordinate[0]][coordinate[1]] = 'F';
    }



    public static boolean askPlantFlagOrSelectPlace(int numberOfFlags){
        Scanner sc = new Scanner(System.in);
        String zeroOne;
        System.out.println("Do you want to plant a flag(0) or select one coordinate(1)?");
        zeroOne = sc.nextLine();
        while (zeroOne.compareTo("0")!=0&&zeroOne.compareTo("1")!=0){
            System.out.println("Please write '0' to plant a flag or  '1' for select one coordinate");
            zeroOne = sc.nextLine();
        }
        return zeroOne.compareTo("0")==0;
    }
}

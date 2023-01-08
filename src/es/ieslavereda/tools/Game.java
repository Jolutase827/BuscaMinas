package es.ieslavereda.tools;

import java.util.Scanner;

public class Game {

    public static void startGame(char[][] board, char[][] boardWithout, boolean hacks){
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Do you want to start the game yes or no?"+Colors.ANSI_RESET);
        answer = sc.nextLine();
        while (answer.compareToIgnoreCase("yes")!=0&&answer.compareToIgnoreCase("no")!=0){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"I going to repeate another time, do you want to start the game yes or no?"+Colors.ANSI_RESET);
            answer = sc.nextLine();
        }
        ScreenOptions.eraseScreen();
        if (answer.compareToIgnoreCase("yes")==0)
            letsPlay(board, hacks,boardWithout);
        else {
            ScreenOptions.eraseScreen();
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Bye bye!!!!"+Colors.ANSI_RESET);
        }
    }

    public static void letsPlay(char[][] board,boolean hacks, char[][] boardWithout){
        Scanner sc = new Scanner(System.in);
        int numberFlags = Board.countBombs(board);
        while (numberFlags!=-1&&!winTheGame(boardWithout,board)) {
            Board.showBoard(board, hacks, boardWithout);
            System.out.println();
            numberFlags = playerAction(board, boardWithout, numberFlags);
            ScreenOptions.eraseScreen();
        }
        if (winTheGame(boardWithout, board)) {
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"You won good job!!!!"+Colors.ANSI_RESET);
            System.out.println();
            Board.showBoard(board, false, boardWithout);
        }
        else {
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"You lost, you touched a bomb :("+Colors.ANSI_RESET);
            System.out.println();
            Board.showBoard(board, false, board);
        }

        
    }

    public static boolean winTheGame(char[][] boardWithout,char[][] board){
        for (int i = 0; i< board.length;i++)
            for (int j = 0; j < board[i].length;j++)
                if (boardWithout[i][j] == ' ' && board[i][j]=='B')
                    return false;
        return true;
    }
    public static int playerAction(char[][] board,char[][] boardWithOut,int numberFlags){
        int action =askPlantFlagSelectPlaceOrRemoveFlag(numberFlags,Board.countBombs(board));
        if ( action == 0) {
            plantFlag(boardWithOut, Coordinate.askCoordinateFlag(boardWithOut));

            return numberFlags-1;
        }else if (action == 2){
            removeFlag(boardWithOut, Coordinate.askCoordinateRemoveFlag(boardWithOut));
            return numberFlags+1;
        }
        if (selectPlace(boardWithOut,Coordinate.askCoordinateFlag(boardWithOut),board))
            return numberFlags;
        else
            return -1;
    }

    public static boolean selectPlace(char[][]boardWithOut,int[] coordinate,char[][] board){
        if (board[coordinate[0]][coordinate[1]]=='B')
            return false;
        else
            PlaceSelector.selectionRecursive(boardWithOut,coordinate[0],coordinate[1],board);
        return true;
    }



    public static void removeFlag(char[][] boardWithOut,int[] coordinate){
        boardWithOut[coordinate[0]][coordinate[1]] = ' ';
    }

    public static void plantFlag(char[][] boardWithOut,int[] coordinate){
        boardWithOut[coordinate[0]][coordinate[1]] = 'F';
    }



    public static int askPlantFlagSelectPlaceOrRemoveFlag(int numberOfFlags,int allBombs){
        Scanner sc = new Scanner(System.in);
        String number;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Do you want to plant a flag(0), select one coordinate(1) or remove a flag(2)?"+Colors.ANSI_RESET);
        number = sc.nextLine();
        while (!zeroOneTwo(number)||noFlags(number,numberOfFlags)||noPutFlags(number, numberOfFlags, allBombs)){
            if (noPutFlags(number, numberOfFlags, allBombs)) {
                System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error 2.2: You can't REMOVE flags because you don't plant any flag"+Colors.ANSI_RESET);
                number = "";
            } else if(noFlags(number,numberOfFlags)){
                System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error 2.3: You don't have flags to plant, remove one for plant in another place."+Colors.ANSI_RESET);
                number = "";
            }else
                System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error 2.1: Unknown value"+Colors.ANSI_RESET);
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Please write '0' to plant a flag,  '1' for select one coordinate or '2' for remove a flag"+Colors.ANSI_RESET);
            number = sc.nextLine();

        }
        return Integer.parseInt(number);
    }

    public static boolean zeroOneTwo(String number){
        return (number.compareTo("0")==0||number.compareTo("1")==0||number.compareTo("2")==0);
    }
    public static boolean noFlags(String number,int numberOfFlags){
        return (numberOfFlags<=0 && number.compareTo("0")==0);
    }
    public static boolean noPutFlags(String number, int numberOfFlags, int allBombs){
        return (numberOfFlags>=allBombs && number.compareTo("2")==0);
    }

}

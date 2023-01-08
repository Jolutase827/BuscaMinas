package es.ieslavereda.tools;

import java.awt.*;

public class Board {
    public static void createBoard(char[][] board, int gameDifficult){
        for (int i=0;i< board.length;i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = ' ';
        layMines(board,gameDifficult);
    }
    public static char[][] createBoardWithoutBombs(int boardLength){
        char[][] boardWithoutBombs = new char[boardLength][boardLength];
        for (int i=0;i< boardWithoutBombs.length;i++)
            for (int j = 0; j < boardWithoutBombs[i].length; j++)
                boardWithoutBombs[i][j] = ' ';
        return boardWithoutBombs;
    }
    public static void layMines(char[][] board, int gameDifficult){
        int x;
        int y;
        do {
            y = (int)(Math.random()*board.length);
            x = (int)(Math.random()*board.length);
            if (board[x][y]!='B'){
                board[x][y]= 'B';
                gameDifficult--;
            }
        }while (gameDifficult>0);
    }

    public static void showBoardSmall(char[][] board){
        for (int i = 0; i<board.length;i++){
            System.out.print(Colors.ANSI_BLACK_BACKGROUND+" "+(char)('A'+i)+" "+Colors.ANSI_RESET);
            for (int j =0; j < board.length;j++) {
                if (board[i][j] == ' ')
                    System.out.print(Colors.ANSI_PURPLE_BACKGROUND + " " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='0')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + "   " + Colors.ANSI_RESET);

                if (board[i][j]=='1')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_BLUE + " " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='2')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_GREEN + " " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='F')
                    System.out.print(Colors.ANSI_PURPLE_BACKGROUND + Colors.ANSI_RED + " " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='B')
                    System.out.print(Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_RED + " " + board[i][j] + " " + Colors.ANSI_RESET);
                if (board[i][j]>'2'&&board[i][j]<='8')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_WHITE + " " + board[i][j] + " " + Colors.ANSI_RESET);

            }
            System.out.println();
        }
        System.out.print(Colors.ANSI_BLACK_BACKGROUND+"   "+Colors.ANSI_RESET);
        for (int x = 0;x<board.length;x++)
            System.out.print(Colors.ANSI_BLACK_BACKGROUND+" "+(x+1)+" "+Colors.ANSI_RESET);
        System.out.println();
    }

    public static void showBoardBig(char[][] board){
        for (int i = 0; i<board.length;i++){
            System.out.print(Colors.ANSI_BLACK_BACKGROUND+" "+(char)('A'+i)+"  "+Colors.ANSI_RESET);
            for (int j =0; j < board.length;j++){
                if (board[i][j] == ' ')
                    System.out.print(Colors.ANSI_PURPLE_BACKGROUND + "  " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='0')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + "    " + Colors.ANSI_RESET);

                if (board[i][j]=='1')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_BLUE + "  " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='2')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_GREEN + "  " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='F')
                    System.out.print(Colors.ANSI_PURPLE_BACKGROUND + Colors.ANSI_RED + "  " + board[i][j] + " " + Colors.ANSI_RESET);

                if (board[i][j]=='B')
                    System.out.print(Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_RED + "  " + board[i][j] + " " + Colors.ANSI_RESET);
                if (board[i][j]>'2'&&board[i][j]<='8')
                    System.out.print(Colors.ANSI_YELLOW_BACKGROUND + Colors.ANSI_WHITE + "  " + board[i][j] + " " + Colors.ANSI_RESET);

            }
            System.out.println();
        }
        System.out.print(Colors.ANSI_BLACK_BACKGROUND+"    "+Colors.ANSI_RESET);
        for (int x = 0;x<board.length;x++)
            if (x<9)
                System.out.print(Colors.ANSI_BLACK_BACKGROUND+"  "+(x+1)+" "+Colors.ANSI_RESET);
            else
                System.out.print(Colors.ANSI_BLACK_BACKGROUND+" "+(x+1)+" "+Colors.ANSI_RESET);
        System.out.println();
    }

    public static void showBoard(char[][] board,boolean showWithHacks, char[][] boardWithout, int numberOfFlags){
        if (showWithHacks){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"     BOARD WITH BOMBS: "+Colors.ANSI_RESET);
            showBoardSize(board);
            System.out.println();
            System.out.println();
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+ Colors.ANSI_RED+"\uD83D\uDEA9: "+ numberOfFlags+"    "+Colors.ANSI_RESET+Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"     BOARD WITHOUT BOMBS "+Colors.ANSI_RESET);
            showBoardSize(boardWithout);
        }else {
            System.out.println(Colors.ANSI_BLACK_BACKGROUND + Colors.ANSI_RED + "\uD83D\uDEA9: " + numberOfFlags + Colors.ANSI_RESET);
            showBoardSize(boardWithout);
        }

    }

    public static void showBoardSize(char[][] board){
        if (board.length>10)
            Board.showBoardBig(board);
        else
            Board.showBoardSmall(board);
    }

    public static int countBombs(char[][] board){
        int numberBombs=0;

        for (char[] i : board)
            for (char j : i)
                if (j=='B')
                    numberBombs++;

        return numberBombs;
    }
}

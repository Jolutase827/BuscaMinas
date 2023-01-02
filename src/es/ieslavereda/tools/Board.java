package es.ieslavereda.tools;

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
            System.out.print(" "+(char)('A'+i)+" ");
            for (int j =0; j < board.length;j++)
                System.out.print(" " + board[i][j]+ " ");
            System.out.println();
        }
        System.out.print("   ");
        for (int x = 0;x<board.length;x++)
            System.out.print(" "+(x+1)+" ");
        System.out.println();
    }

    public static void showBoardBig(char[][] board){
        for (int i = 0; i<board.length;i++){
            System.out.print(" "+(char)('A'+i)+"  ");
            for (int j =0; j < board.length;j++)
                System.out.print("  " + board[i][j]+ " ");
            System.out.println();
        }
        System.out.print("    ");
        for (int x = 0;x<board.length;x++)
            if (x<9)
                System.out.print("  "+(x+1)+" ");
            else
                System.out.print(" "+(x+1)+" ");
        System.out.println();
    }

    public static void showBoard(char[][] board,boolean showWithHacks, char[][] boardWithout){
        if (showWithHacks){
            System.out.println("BOARD WITH BOMBS: ");
            showBoardSize(board);
            System.out.println();
            System.out.println();
            System.out.println("BOARD WITHOUT BOMBS: ");
            showBoardSize(boardWithout);
        }else
            showBoardSize(boardWithout);

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

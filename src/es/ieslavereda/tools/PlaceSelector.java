package es.ieslavereda.tools;

public class PlaceSelector {
    public static boolean selectionRecursive(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1][coor2]=='B'||boardWithOut[coor1][coor2]!=' ')
            return false;

        boardWithOut[coor1][coor2]='0';


        if (coor1<=0&&coor2<=0)
            return cornerLeftTop(boardWithOut,coor1,coor2,board);

        if (coor1<=0 && coor2>=board.length-1)
            return cornerLeftBot(boardWithOut,coor1,coor2,board);

        if ((coor1>=board.length-1&&coor2>=board.length-1))
            return cornerRightBot(boardWithOut,coor1,coor2,board);

        if (coor1>=board.length-1 && coor2<=0)
            return cornerRightTop(boardWithOut,coor1,coor2,board);


        if (coor1<=0)
            return borderLeft(boardWithOut,coor1,coor2,board);

        if (coor2<=0)
            return borderTop(boardWithOut,coor1,coor2,board);

        if (coor1 >= board.length-1)
            return borderRight(boardWithOut,coor1,coor2,board);

        if (coor2>= board.length-1)
            return borderBot(boardWithOut,coor1,coor2,board);


        return midle(boardWithOut,coor1,coor2,board);




    }

    public static boolean midle(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 + 1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1][coor2 + 1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1+1][coor2] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1 - 1][coor2 - 1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1][coor2-1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1-1][coor2] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1+1][coor2-1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (board[coor1-1][coor2+1] == 'B')
            boardWithOut[coor1][coor2]++;

        if (boardWithOut[coor1][coor2]!='0')
            return false;



        return selectionRecursive(boardWithOut,coor1,coor2+1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board)
                || selectionRecursive(boardWithOut,coor1,coor2-1, board)
                || selectionRecursive(boardWithOut,coor1-1,coor2, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2+1,board)
                || selectionRecursive(boardWithOut,coor1+1,coor2-1,board)
                || selectionRecursive(boardWithOut,coor1-1,coor2+1,board)
                || selectionRecursive(boardWithOut,coor1-1,coor2-1,board);
    }
    public static boolean cornerLeftTop(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2+1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board);
    }
    public static boolean cornerLeftBot(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 - 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 - 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2-1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board);
    }
    public static boolean cornerRightBot(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1 - 1][coor2 - 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2-1, board)||
                selectionRecursive(boardWithOut,coor1-1,coor2, board);
    }

    public static boolean cornerRightTop(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1 - 1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1 - 1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2+1, board)||
                selectionRecursive(boardWithOut,coor1-1,coor2, board);
    }

    public static boolean borderLeft(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2-1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board)
                || selectionRecursive(boardWithOut,coor1,coor2+1, board);
    }

    public static boolean borderTop(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2+1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2+1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board)
                || selectionRecursive(boardWithOut,coor1-1,coor2, board);
    }

    public static boolean borderRight(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1-1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 + 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2+1, board)
                || selectionRecursive(boardWithOut,coor1,coor2-1, board)
                || selectionRecursive(boardWithOut,coor1-1,coor2, board);
    }
    public static boolean borderBot(char[][] boardWithOut, int coor1, int coor2, char[][] board){
        if (board[coor1+1][coor2 - 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1][coor2 - 1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1+1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2] == 'B') {
            boardWithOut[coor1][coor2]++;
        }
        if (board[coor1-1][coor2-1] == 'B') {
            boardWithOut[coor1][coor2]++;
        }

        if (boardWithOut[coor1][coor2]!='0')
            return false;

        return selectionRecursive(boardWithOut,coor1,coor2-1, board)
                || selectionRecursive(boardWithOut,coor1+1,coor2, board)
                || selectionRecursive(boardWithOut,coor1-1,coor2, board);
    }

}

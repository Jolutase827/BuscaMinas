import es.ieslavereda.tools.Board;
import es.ieslavereda.tools.Game;
import es.ieslavereda.tools.Menu;
import es.ieslavereda.tools.ScreenOptions;

public class Main {
    public static void main(String[] args) {
        char[][] board = Menu.boardRequeriments();
        char[][] boardWihtOutBombs = Board.createBoardWithoutBombs(board.length);
        ScreenOptions.eraseScreen();
        boolean hacks = Menu.activateHacks();
        ScreenOptions.eraseScreen();
        Game.startGame(board, boardWihtOutBombs , hacks);


    }
}
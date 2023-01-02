import es.ieslavereda.tools.Coordinate;

public class Tester {
    public static void main(String[] args){
        char[][] board = new char[4][4];
        int[] coordinate =Coordinate.askCoordinate(board);
        System.out.println(coordinate[0]);
        System.out.println(coordinate[1]);

    }
}

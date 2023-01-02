package es.ieslavereda.tools;

import java.util.Scanner;

public class Coordinate {
    public static boolean comproveLength(String coordinate){
        if (coordinate.length()==2)
            return true;
        System.out.println("Error:1.1 too much valors in the string");
        return false;
    }
    public static boolean comproveLetter(String coordinate, int boardLength){
        if (coordinate.charAt(0)>='A'&& coordinate.charAt(0)<'A'+boardLength)
            return true;
        System.out.println("Error:1.2 the letter is invalid");
        return false;
    }
    public static boolean comproveNumber(String coordinate, int boardLength){
        if (coordinate.charAt(1)>='1'&&coordinate.charAt(1)<'1'+boardLength)
            return true;
        System.out.println("Error:1.3 the number is invalid");
        return false;
    }
    public static boolean comproveCoordinateUse(String coordinate, char[][] board){
        if (board[coordinate.charAt(0)-'A'][coordinate.charAt(1)-'1']==' ')
            return true;
        System.out.println("Error:1.4 the coordinate was select");
        return false;
    }
    public static int[] askCoordinate(char[][] board){
        Scanner sc = new Scanner(System.in);
        int[] coordinateNumber = new int[2];
        String coordinate;
        System.out.println("Plese tell me a coordinate with this format 'A1'");
        coordinate = sc.nextLine().toUpperCase();
        while (!validRequeriments(coordinate, board)){
            System.out.println("Another time, tell me a coordinate with this format 'A1'");
            coordinate = sc.nextLine().toUpperCase();
        }
        coordinateNumber[0]=coordinate.charAt(0)-'A';
        coordinateNumber[1]= coordinate.charAt(1)-'1';
        return coordinateNumber;
    }
    public static boolean validRequeriments(String coordinate,char[][] board) {
        if (!comproveLength(coordinate))
            return false;
        if (!comproveLetter(coordinate,board.length))
            return false;
        if (!comproveNumber(coordinate,board.length))
            return false;
        return comproveCoordinateUse(coordinate, board);
    }
}

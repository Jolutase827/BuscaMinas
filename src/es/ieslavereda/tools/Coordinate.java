package es.ieslavereda.tools;

import java.util.Scanner;

public class Coordinate {

    public static boolean comproveLengthBig(String coordinate){
        if (coordinate.length()==3)
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.6 too much values in the string or too little, the length has to be three, if the number is less than 10 write a 0 between the number and the letter like this 'A03'"+Colors.ANSI_RESET);
        return false;
    }

    public static boolean comproveLength(String coordinate){
        if (coordinate.length()==2)
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.1 too much values in the string or too little"+Colors.ANSI_RESET);
        return false;
    }


    public static boolean comproveLetter(String coordinate, int boardLength){
        if (coordinate.charAt(0)>='A'&& coordinate.charAt(0)<'A'+boardLength)
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.2 the letter is invalid"+Colors.ANSI_RESET);
        return false;
    }


    public static boolean comproveNumber(String coordinate, int boardLength){
        if (coordinate.charAt(1)>='1'&&coordinate.charAt(1)<'1'+boardLength)
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.3 the number is invalid"+Colors.ANSI_RESET);
        return false;
    }

    public static boolean comproveNumberBig(String coordinate){
        if ((coordinate.charAt(1)=='0'||coordinate.charAt(1)=='1')&&((coordinate.charAt(1)>='0'&&coordinate.charAt(1)<='6')))
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.7 the number is invalid, there are only numbers from 1 to 16"+Colors.ANSI_RESET);
        return false;
    }

    public static boolean comproveCoordinateUse(String coordinate, char[][] board){
        if (board[coordinate.charAt(0)-'A'][Integer.parseInt(coordinate.substring(1))-1]==' ')
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.4 the coordinate was select"+Colors.ANSI_RESET);
        return false;
    }


    public static int[] askCoordinateFlag(char[][] board){
        Scanner sc = new Scanner(System.in);
        int[] coordinateNumber = new int[2];
        String coordinate;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Plese tell me a coordinate with this format 'A1'"+Colors.ANSI_RESET);
        coordinate = sc.nextLine().toUpperCase();
        while (!validRequerimentsFlag(coordinate, board)){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Another time, tell me a coordinate with this format 'A1'"+Colors.ANSI_RESET);
            coordinate = sc.nextLine().toUpperCase();
        }
        coordinateNumber[0]=coordinate.charAt(0)-'A';
        coordinateNumber[1]= Integer.parseInt(coordinate.substring(1))-1;
        return coordinateNumber;
    }

    public static int[] askCoordinateRemoveFlag(char[][] board){
        Scanner sc = new Scanner(System.in);
        int[] coordinateNumber = new int[2];
        String coordinate;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Plese tell me a coordinate with this format 'A1'"+Colors.ANSI_RESET);
        coordinate = sc.nextLine().toUpperCase();
        while (!validRequerimentsRemoveFlag(coordinate, board)){
            System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_GREEN+"Another time, tell me a coordinate with this format 'A1'"+Colors.ANSI_RESET);
            coordinate = sc.nextLine().toUpperCase();
        }
        coordinateNumber[0]=coordinate.charAt(0)-'A';
        coordinateNumber[1]= Integer.parseInt(coordinate.substring(1))-1;
        return coordinateNumber;
    }


    public static boolean validRequerimentsRemoveFlag(String coordinate,char[][] board) {
        if (board.length<11) {
            if (!comproveLength(coordinate))
                return false;
            if (!comproveLetter(coordinate, board.length))
                return false;
            if (!comproveNumber(coordinate, board.length))
                return false;
            return comproveCoordinateHaveFlag(coordinate, board);
        }
        if (!comproveLengthBig(coordinate))
            return false;
        if (!comproveLetter(coordinate, board.length))
            return false;
        if (!comproveNumberBig(coordinate))
            return false;

        return comproveCoordinateHaveFlag(coordinate, board);
    }


    public static boolean comproveCoordinateHaveFlag(String coordinate, char[][] board){
        if (board[coordinate.charAt(0)-'A'][Integer.parseInt(coordinate.substring(1))-1]=='F')
            return true;
        System.out.println(Colors.ANSI_BLACK_BACKGROUND+Colors.ANSI_RED+"Error:1.5 the coordinate doesn't have a Flag"+Colors.ANSI_RESET);
        return false;
    }


    public static boolean validRequerimentsFlag(String coordinate,char[][] board) {
        if (board.length<11) {
            if (!comproveLength(coordinate))
                return false;
            if (!comproveLetter(coordinate, board.length))
                return false;
            if (!comproveNumber(coordinate, board.length))
                return false;
            return comproveCoordinateUse(coordinate, board);
        }
        if (!comproveLengthBig(coordinate))
            return false;
        if (!comproveLetter(coordinate, board.length))
            return false;
        if (!comproveNumberBig(coordinate))
            return false;

        return comproveCoordinateUse(coordinate, board);
    }
}

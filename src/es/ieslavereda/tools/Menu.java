package es.ieslavereda.tools;

public class Menu {
    public static int boardLength(String length){
        switch (length){
            case ("LARGE"):
                return 2;
            case ("BIG"):
                return 4;
            case ("ENORMOUS"):
                return 8;
            default:
                return 16;
        }
    }

    public static int partyDificulty(String lvlDificulty, int boardLength){
        int numberMines;
        switch (lvlDificulty){
            case ("EASY"):
                numberMines = boardLength-(int)(boardLength/3);
                break;
            case ("MEDIUM"):
                numberMines = boardLength-(int)(boardLength/2);
            case ("HARD"):


        }

        return numberMines;
    }
}

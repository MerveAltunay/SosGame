package org.kodluyoruz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean startSosGame = true;

        int[] horizontalValues=new int[100];
        int[] verticalValues=new int[100];

        int[] horizontalCount=new int[1];
        int[] verticalCount=new int[1];

        int[] playerScore = new int[1];
        int[] aiScore = new int[1];

        while (startSosGame) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter the panel size you want to play the game: ");
            int sizePanel = input.nextInt();
            Random random = new Random();

            String playerLetter;
            String computerLetter;

            String panel[][] = new String[sizePanel][sizePanel];

            if (sizePanel < 3 || sizePanel > 7) {

                System.out.println("You entered the wrong size!");
                continue;
            }

            int startPerson = random.nextInt(2);
            int letters=random.nextInt(2);

            if(letters==0){

                playerLetter="o";
                computerLetter="s";

            }
            else {
                playerLetter="o";
                computerLetter="s";
            }

            if (startPerson == 0) {

                for (int i = 0; i <= sizePanel * sizePanel; i++) {

                    System.out.println("Enter the row: ");
                    int row = input.nextInt();

                    System.out.println("Enter the column: ");
                    int column = input.nextInt();

                    if (row >= panel.length || column >= panel.length) {
                        System.out.println("Out of index!Try again...");
                        continue;
                    }

                    if (!(panel[row][column] == null)) {
                        System.out.println("This field is occupied...");
                        continue;
                    }

                    writePlayer(row, column, panel,playerLetter);

                    vertical(panel,verticalValues,verticalCount,playerScore);
                    horizontal(panel,horizontalValues,horizontalCount,playerScore);

                    showPanel(panel);
                    showScoreTable(playerScore,aiScore);

                    writeComputer(panel,computerLetter);
                    vertical(panel,verticalValues,verticalCount,aiScore);
                    horizontal(panel,horizontalValues,horizontalCount,aiScore);

                    showPanel(panel);
                    showScoreTable(playerScore,aiScore);

                }

            }

            else {

                boolean startPlayer = true;
                int counter = 0;

                int i = 0;

                while (startPlayer) {

                    writeComputer(panel,computerLetter);
                    vertical(panel,verticalValues,verticalCount,aiScore);
                    horizontal(panel,horizontalValues,horizontalCount,aiScore);
                    showScoreTable(playerScore,aiScore);
                    showPanel(panel);

                    if (sizePanel % 2 == 1) {
                        for (i = 0; i < panel.length; i++) {
                            for (int j = 0; j < panel[0].length; j++) {
                                if (panel[i][j] != null) {
                                    counter++;
                                }
                            }
                        }
                    }

                    if (counter == sizePanel * sizePanel) {
                        startPlayer = false;
                    }
                    int playerCounter = 0;

                    while (playerCounter != 1 && startPlayer) {

                        System.out.println("Enter the row: ");
                        int row = input.nextInt();

                        System.out.println("Enter the column: ");
                        int column = input.nextInt();

                        if (row >= panel.length || column >= panel.length) {
                            System.out.println("Out of index!Try again...");
                            continue;
                        }

                        if (!(panel[row][column] == null)) {
                            System.out.println("This field is occupied...");
                            continue;
                        }

                        writePlayer(row, column, panel,playerLetter);

                        vertical(panel,verticalValues,verticalCount,playerScore);
                        horizontal(panel,horizontalValues,horizontalCount,playerScore);

                        showPanel(panel);
                        showScoreTable(playerScore,aiScore);
                        playerCounter++;

                    }
                    i++;

                }

            }

            startSosGame = false;
        }


    }

    private static void showPanel(String panel[][]) {

        for (int i = 1; i < panel.length +1; i++) {
            System.out.print("  " + i);
        }

        System.out.println();

        for (int i = 0; i < panel.length; i++) {

            for (int j = 0; j < panel.length; j++) {

                if (j < 1) {

                    System.out.print(i+1);
                    System.out.print(" "+panel[i][j] +" ");

                }

                else {

                    System.out.print(" " +panel[i][j] +" ");
                }
            }

            System.out.println();
        }
    }

    public static void showScoreTable(int[] playerScore,int[] computerScore){

        for (int i:playerScore)
            System.out.println("Player score:"+i);

        for (int j:computerScore)
            System.out.println("Computer score:"+j);

    }

    private static void writeComputer(String panel[][],String computerLetter) {

        Random random = new Random();

        for(int i=1;i<=1;){

            int rowIndex = random.nextInt((panel.length - 1 - 0) + 1) + 0;
            int columnIndex = random.nextInt((panel.length - 1 - 0) + 1) + 0;

            if(panel[rowIndex][columnIndex] != null)
                continue;

            panel[rowIndex][columnIndex] = computerLetter;
            i++;

        }
    }

    private static void writePlayer(int row, int column, String[][] panel,String playerLetter) {

        panel[row][column] = playerLetter;

    }

    public static void vertical(String mat[][],int[] values,int[] verticalCount,int[] score){


        int control=0;

        for(int i=0;i<mat.length;i++){

            for (int j=0;j<mat[0].length;j++){

                if(j<mat.length-2){

                    if(("s".equals(mat[j][i])&&"o".equals(mat[j+1][i])&&"s".equals(mat[j+2][i]))){

                        if(verticalCount[0]==0){

                            values[verticalCount[0]]=j+i+i+1+i+2;
                            verticalCount[0]++;
                            score[0]++;

                        }
                        else{

                            int sayi=verticalCount[0];
                            int staticValue=verticalCount[0];
                            int number=0;


                            values[verticalCount[0]]=j+i+i+1+i+2;

                            verticalCount[0]++;


                            while (sayi!=0){

                                if(  ( values[staticValue]==values[sayi-1])){

                                    number++;

                                }
                                sayi--;
                            }
                            if(number==0){
                                score[0]++;
                            }
                        }
                    }
                }
            }
        }
    } public static void horizontal(String mat[][],int[] values,int[] horizontalCount,int[] score){

        int control=0;

        for(int i=0;i<mat.length;i++){

            for (int j=0;j<mat[0].length;j++){

                if(j<mat.length-2){

                    if(("s".equals(mat[i][j])&&"o".equals(mat[i][j+1])&&"s".equals(mat[i][j+2]))){

                        if(horizontalCount[0]==0){

                            values[horizontalCount[0]]=i+j+j+1+j+2;
                            horizontalCount[0]++;
                            score[0]++;

                        }
                        else{

                            int sayi=horizontalCount[0];
                            int staticValue=horizontalCount[0];
                            int number=0;


                            values[horizontalCount[0]]=i+j+j+1+j+2;

                            horizontalCount[0]++;


                            while (sayi!=0){

                                if(  ( values[staticValue]==values[sayi-1])){

                                    number++;

                                }
                                sayi--;
                            }
                            if(number==0){
                                score[0]++;
                            }
                        }

                    }
                }

            }
        }

    }
}

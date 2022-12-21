//Fernando Vargas
//Project 3: Generalize Binary/Bisection Search
//12/12/22
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Project3 {


    public static int I;
    public static int J;
    public static boolean found = false;
    public static boolean[][] reached;


    public static void search(int target, int[][] arr, int row, int col) {
        if ( row >= I || col >= J ){
            return;
        }
        if(reached[row] [col]){

            return;


        }

        reached[row][col] = true;


        if (target == arr[row][col]){

            System.out.println("row= " + (row + 1));
            System.out.println("\ncol=" + (col + 1));
            found = true;
            return;
        }

        if (found){
            return;
        }

        if(target > arr[row][col]){
            //bottom right
            search(target, arr, (I + row)/2, (J + col)/2);
            //bottom left
            search(target, arr, (I + row)/2, col/2);
            //top right
            search(target, arr, row/2,(J + col)/2 );


        }

        if(target < arr[row][col]){

            //top right
            search(target, arr, row /2, col/2);
            //bottom right
            search(target, arr, row/2, (J + col)/2);
            //bottome left
            search(target, arr, (I + row)/2, col/2);

        }



    }

    public static void main (String[]args)throws Exception{
        Scanner input = new Scanner(new File("input.txt"));
        //calc start time
        long startTime = System.nanoTime();

        I = Integer.parseInt(input.next());
        J = Integer.parseInt(input.next());
        int target = Integer.parseInt(input.next());

        int[][] arr = new int[I][J];
        for(int i = 0; i < I ; i++){
            for( int j = 0; j < J; j++){
                arr[i][j] = Integer.parseInt(input.next());
            }
        }

        reached = new boolean[I][J];
        search(target, arr, I/2, J/2);

        if(!found){
            System.out.println("NOT FOUND!");
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nTime in nanoseconds: " + totalTime);

    }
}
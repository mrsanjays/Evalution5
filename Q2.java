package E4;

import java.util.Scanner;

public class Q2 {
    // Man can reach or not
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row Size and Col Size: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        System.out.println("Enter Starting Point of Man: ");
        int startRowOfMan = sc.nextInt();
        int startColOfMan = sc.nextInt();
        System.out.println("Enter Starting Point of Monster : ");
        int startRowOfMons = sc.nextInt();
        int startColOfMons = sc.nextInt();
        System.out.println("Enter Gold Position: ");
        int goldr = sc.nextInt();
        int goldc = sc.nextInt();

        char[][] matrix = new char[row][col];
        matrix[goldr-1][goldc-1] = 'G';
        int minPathForMan = Q1.findMinPath(startRowOfMan-1, startColOfMan-1, row, col, matrix);
        int minPathForMons = Q1.findMinPath(startRowOfMons-1, startColOfMons-1,row, col, matrix);
        //System.out.println(minPathForMan +" "+ minPathForMons);
        if(minPathForMons < minPathForMan){ 
            System.out.println("\nNo Possible Solution");
        }
        else{
            System.out.println("\nPossible " + minPathForMan);
        }
    }
}

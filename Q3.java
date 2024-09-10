package E4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {
    // print the path
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
        
        if(minPathForMons < minPathForMan){ 
            System.out.println("\nNo Possible Solution");
        }
        else{
            System.out.println("\nPossible " + minPathForMan);
            String path = "";
            printPath(startRowOfMan - 1, startColOfMan - 1, row, col, matrix ,path);
            
            
        }
    }
   

    static boolean printPath(int iRow, int iCol, int row, int col, char[][] matrix, String path) {
        if (iCol < 0 || iCol >= col || iRow < 0 || iRow >= row || matrix[iRow][iCol] == 'v') {
            return false;
        }
        if (matrix[iRow][iCol] == 'G') {
            System.out.println(path);
            System.out.println();
            return true;
        }
    
        char temp = matrix[iRow][iCol];
        matrix[iRow][iCol] = 'v';
        if (printPath(iRow - 1, iCol, row, col, matrix, path + " "+iRow + iCol+" ")) { 
            return true;
        }
        if (printPath(iRow + 1, iCol, row, col, matrix, path + " "+iRow + iCol + " ")) { 
            return true;
        }
        if (printPath(iRow, iCol + 1, row, col, matrix, path + " "+iRow + iCol + " ")) { 
            return true;
        }
        if (printPath(iRow, iCol - 1, row, col, matrix, path + " "+iRow + iCol + " ")) { 
            return true;
        }
    
        matrix[iRow][iCol] = temp; 
        return false; 
    }
    
    
    
}
    
    

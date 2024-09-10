package E4;

import java.util.Scanner;

public class Q1 {
    // find Min Path
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int row = sc.nextInt();
        // int col = sc.nextInt();
        // System.out.println("Enter Starting position: ");
        // char matrix[][] = new char[row][col];
        // int startRow = sc.nextInt();
        // int startCol = sc.nextInt();
        // System.out.println("Enter gold position: ");
        // int goldRow = sc.nextInt();
        // int goldCol = sc.nextInt();
        // matrix[goldRow-1][goldCol-1] = 'G';
        int row = 5;
        int col = 4;
        int startRow = 5;
        int startCol = 1;
        int goldr = 1;
        int goldc = 4;
        char[][] matrix = new char[row][col];
        matrix[goldr-1][goldc-1] = 'G';

        int res = findMinPath(startRow-1,startCol-1,row,col,matrix);
        System.out.println(res);
    }
    static int findMinPath(int iRow , int iCol , int row,int col,char[][] matrix){
        if(iCol < 0 || iCol >= col || iRow < 0 || iRow >= row || matrix[iRow][iCol] == 'v'){
            return 100000; // max value
        }
        if(matrix[iRow][iCol] == 'G'){
            return 0;
        }
        
        char temp = matrix[iRow][iCol];
        matrix[iRow][iCol] = 'v';
        int up = findMinPath(iRow-1, iCol, row, col, matrix) + 1;
        int down = findMinPath(iRow+1, iCol, row, col, matrix) + 1;
        int right = findMinPath(iRow, iCol+1, row, col, matrix) + 1;
        int left = findMinPath(iRow, iCol-1, row, col, matrix) + 1;
        matrix[iRow][iCol] = temp;
        return Math.min(up,Math.min(down, Math.min(right, left)));

    }
}

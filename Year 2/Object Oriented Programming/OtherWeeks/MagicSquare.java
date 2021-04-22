
/**  Write a Java program to construct a 4x4 magic square using a sum(which is divisible by 2)inputed by  inputed user

 * The start will be determined by (sum/4)-7.5
 * The range of the number is Start, Start+1, Start +2,...,Start+15
 * Place the numbers in the cell in the cell such that row,column, and diagonal are equal to sum
 *
 * @author Shrey Nathur
 * @since 01/10/2017
 */

import java.util.*;

class MagicSquare {
    public static void main(String args[]) {
        double sum, start;
        double magic[][] = new double[4][4];
        System.out.println("Enter the sum");
        Scanner sc = new Scanner(System.in);
        sum = sc.nextDouble();
        start = (sum / 4) - 7.5;

        for (int i = 0, k = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++, k++) {
                if ((i == j) || ((i + j) == 3))
                    // Diagonals are going from higest to lowest
                    magic[i][j] = (sum / 2) - (start + k);
                else
                    // Remaing are going from lowest to highest
                    magic[i][j] = start + k;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(magic[i][j] + "\t");
            System.out.println();
        }
        sc.close();
    }
}

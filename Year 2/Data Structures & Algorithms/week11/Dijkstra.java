/*
 Write a Java program to calculate the shortest path using the Djikstr's Algorithm 
 @author Shrey Mathur
 */

import java.util.Scanner;

class Dijkstra {
	static Scanner scan;

	public static void main(String[] args) {
		int[] preD = new int[3];
		int min = 999, nextNode = 0;
		scan = new Scanner(System.in);
		int[] distance = new int[3];
		int[][] matrix = new int[3][3];
		int[] visited = new int[3];

		System.out.println("Enter the cost matrix");

		for (int i = 0; i < distance.length; i++) {
			visited[i] = 0;
			preD[i] = 0;

			for (int j = 0; j < distance.length; j++) {
				matrix[i][j] = scan.nextInt();
				if (matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}

		distance = matrix[0];
		visited[0] = 1;
		distance[0] = 0;

		for (int counter = 0; counter < 3; counter++) {
			min = 999;
			for (int i = 0; i < 3; i++) {
				if (min > distance[i] && visited[i] != 1) {
					min = distance[i];
					nextNode = i;
				}
			}

			visited[nextNode] = 1;
			for (int i = 0; i < 3; i++) {
				if (visited[i] != 1) {
					if (min + matrix[nextNode][i] < distance[i]) {
						distance[i] = min + matrix[nextNode][i];
						preD[i] = nextNode;
					}
				}
			}
		}

		for (int i = 0; i < 3; i++)
			System.out.print("|" + distance[i]);

		System.out.println("|");

		int j;
		for (int i = 0; i < 3; i++) {
			if (i != 0) {
				System.out.print("Path = " + i);
				j = i;
				do {
					j = preD[j];
					System.out.print(" <- " + j);
				} while (j != 0);
			}
			System.out.println();
		}
	}
}

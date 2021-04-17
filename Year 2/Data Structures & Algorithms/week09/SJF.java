
/*
  Write a Java program to implement the Shortest Job First style of Job
  Scheduling using a BST with the height of 5
  @author Shrey Mathur
 */
import java.util.*;

class Job {
	public String ID;
	public int Time;

	public Job(String id, int t) {
		this.ID = id;
		this.Time = t;
	}
}

class SJF {
	static Scanner sc = new Scanner(System.in);
	static Job[] JobQueue = new Job[9]; // Assuming Tree of height 5, nodes = 2*h-1

	public static void populateQueue() {
		// Adding entries to list
		for (int i = 0; i < 9; i++) {
			System.out.print("Please enter the ID for Job " + i + ": ");
			String a = sc.next();
			System.out.print("PLease enter the Burst Time for Job " + i + ": ");
			int b = sc.nextInt();
			Job node = new Job(a, b);
			JobQueue[i] = node;
		}
	}

	public static void BuildMaxHeap(int n, int i) {
		int lrg = i;
		int lft = 2 * i + 1;
		int Right = 2 * i + 2;
		if ((Right < n) && (JobQueue[Right].Time > JobQueue[lrg].Time))
			lrg = Right;
		if ((lft < n) && (JobQueue[lft].Time > JobQueue[lrg].Time))
			lrg = lft;

		if (lrg != i) {
			Job Temp = new Job("Temp", 0);
			Temp = JobQueue[lrg];
			JobQueue[lrg] = JobQueue[i];
			JobQueue[i] = Temp;
			BuildMaxHeap(n, lrg);
		}
	}

	public static void HeapSort(int n) {
		for (int i = n / 2 - 1; i >= 0; i--)
			BuildMaxHeap(n, i);
		for (int i = n - 1; i >= 0; i--) {
			Job Temp = new Job("Temp", 0);
			Temp = JobQueue[0];
			JobQueue[0] = JobQueue[i];
			JobQueue[i] = Temp;
			BuildMaxHeap(i, 0);
		}
	}

	public static void printJobs() {
		for (int i = 0; i < 9; i++)
			System.out.println("ID: " + JobQueue[i].ID + ";Time: " + JobQueue[i].Time);
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void pak() {
		sc.nextLine();
		System.out.println("Press any key to continue!");
		sc.nextLine();
	}

	public static void main(String[] args) {
		int opt;
		do {
			clearScreen();
			System.out.println("Press 1 to Populate entries");
			System.out.println("Press 2 to Sort entries");
			System.out.println("Press 0 to exit");
			System.out.print("Enter your choice: ");
			opt = sc.nextInt();
			switch (opt) {
			case 1:
				SJF.populateQueue();
				break;

			case 2:
				if (JobQueue.length != 9) {
					System.out.println("Array is not populated correctly! Please re-populate the entries!");
				} else {
					System.out.println("Current Job Queue:");
					SJF.printJobs();
					HeapSort(9);
					System.out.println("Optimized Job Queue:");
					SJF.printJobs();
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Option");
			}
			pak();
		} while (opt != 0);
		System.out.println("Program Execution End");
	}
}

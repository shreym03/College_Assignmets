
/*
  Write a Java program to read a set of student records (at least 20) from
  file. Assume that each student record contains Student name, ID no.,
  enrollment year, and GPA Sort the record based on Student name using merge
  sort and display the result Use iterative insertion sort and sort the record
  based on decreasing value of enrollment year and display the result.
  
  @author Shrey Mathur
 */
import java.util.*;
import java.io.*;

class Student {
	String name;
	String ID;
	int year;
	double gpa;

	Student(String n, String id, int yr, double g) {
		name = n;
		ID = id;
		year = yr;
		gpa = g;
	}
}

class StudentList {
	int alSize = 0;

	/**
	 * Fetch the list from file
	 * 
	 * @return List of students from array
	 */
	public static ArrayList<Student> FetchList(String dataFile) {
		ArrayList<Student> l = new ArrayList<Student>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			String a;
			String info[] = new String[4];
			a = br.readLine();
			while (a != null) {
				info = a.split(",");
				String n = info[0];
				String id = info[1];
				int yr = Integer.parseInt(info[2]);
				double g = Double.parseDouble(info[3]);
				Student s = new Student(n, id, yr, g);
				l.add(s);
				a = br.readLine();
				br.close();
			}
		} catch (IOException e) {
			System.out.println("Bad Input Caught");
		}
		return l;
	}

	int getSize() {
		return alSize;
	}
}

class MSort {
	/* Insertion sort starts */
	static void SortYear(ArrayList<Student> list) {
		int yr[][] = new int[list.size()][2];
		int n = 0;
		// Storing all values of year
		for (Student s : list) {
			yr[n][0] = s.year;// Stores year
			yr[n++][1] = n;// Stores position
		}
		/* Insertion sort code */
		yr = insertionSort(yr, n);
		System.out.println("The list in Descending order of year is:");
		for (int i = 0; i < n; i++) {
			Student s = list.get(yr[i][1]);
			System.out.println("Name:" + s.name + ", ID:" + s.ID + ", Year:" + s.year + ", GPA:" + s.gpa);
		}
	}

	static int[][] insertionSort(int[][] a, int num) {
		for (int i = 1; i < num; i++) {
			int key[] = new int[2];
			key[0] = a[i][0];// value
			key[1] = a[i][1];
			int j = i - 1;
			while (j > 0 && a[j][0] < key[0]) {
				a[j + 1][0] = a[j][0];
				a[j + 1][1] = a[j][1];
				j--;
			}
			a[j + 1][0] = key[0];
			a[j + 1][1] = key[1];
		}
		return a;
	}

	/**
	 * Method to sort Array using Merge sort
	 * 
	 * @param a     Array to be sorted
	 * @param left  Startpoint of Array to be sorted
	 * @param right Endpoint of Array to be sorted
	 * @return Sorted array or partly sorted array
	 */
	static String[] mergeSort(String a[], int left, int right) {
		if (left == right)
			return a;
		int mid = left + right / 2;
		a = mergeSort(a, left, mid);
		a = mergeSort(a, mid + 1, right);
		merge(a, left, mid, right);
		return a;
	}

	/**
	 * Sub-method oof merge sort. Merges the two partly sorted arrays and fixes and
	 * unnsorted elements in it.
	 * 
	 * @param a     Array to be sorted
	 * @param left  Startpoint of Array to be sorted
	 * @param mid   point of partition
	 * @param right Endpoint of Array to be sorted
	 */
	static void merge(String[] a, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid; // Find sizes of two subarrays to be merged
		String L[] = new String[n1];
		String R[] = new String[n2]; // Create temp arrays
		for (int i = 0; i < n1; ++i)
			L[i] = a[left + i];
		for (int i = 0; i < n2; ++i)
			R[i] = a[mid + 1 + i]; // Copy data to temp arrays
		int i = 0, j = 0;
		int k = left; // Initial index of merged subarry array
		while (i < n1 && j < n2) {
			int c = L[i].compareTo(R[j]);
			if (c <= 0) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		} /* Copy remaining elements of L[] if any */
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		} /* Copy remaining elements of R[] if any */
	}

	static void SortName(ArrayList<Student> list) {
		String nme[] = new String[list.size()];
		int n = 0;
		for (Student s : list)
			nme[n++] = s.name;// Setting the string array
		nme = mergeSort(nme, 0, n - 1);
		System.out.println("The list sorted in Ascending order using merge sort is:");
		for (int i = 0; i < n; i++) {
			for (Student s : list) {
				if ((nme[i].compareTo(s.name)) <= 0) {
					System.out.println("Name: " + s.name + ", ID: " + s.ID + ", Year: " + s.year + ", GPA: " + s.gpa);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> students = StudentList.FetchList("data_w5.txt");
		for (Student s : students)
			System.out.println(s.name);
	}
}

/*
  Write a Java program to create a Min Heap that stores and handles different
  Processes
  
  @author Shrey Mathur
 */

class Process {
	String pid;
	int btime;

	public Process(String p, int b) {
		this.pid = p;
		this.btime = b;
	}
}

class MinHeap {
	public Process[] data;
	public int heapSize;

	/**
	 * Constructor to create a MinHeap of a particular size
	 * 
	 * @param size Max Size of the Heap
	 */
	public MinHeap(int size) {
		data = new Process[size];
		heapSize = 0;
	}

	public int getmin() {
		if (heapSize == 0) {
			throw new RuntimeException("Size full");
		} else
			return data[0].btime;
	}

	/**
	 * @return the Left Child Index
	 * @param i index of node
	 */
	public int getLCI(int i) {
		return 2 * i + 1;
	}

	/**
	 * @return the Right Child Index
	 * @param i index of node
	 */
	public int getRCI(int i) {
		return 2 * i + 2;
	}

	/**
	 * @return the Parent Index
	 * @param i index of node
	 */
	public int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Insert Process into heap directly
	 * 
	 * @param p process name
	 * @param b Buffer Time
	 */
	public void Insert(String p, int b) {
		if (heapSize == data.length)
			System.out.println("Heap Full");
		else {
			Process pr = new Process(p, b);
			heapSize++;
			data[heapSize - 1] = pr;
			Upheap(heapSize - 1);
		}
	}

	/**
	 * Move the value of the Index up the bottom of the Heap until it is at the
	 * highest pssible position
	 * 
	 * @param last
	 */
	public void Upheap(int last) {
		int parent;
		Process temp;

		if (last != 0) {
			parent = getParentIndex(last);
			if (data[parent].btime > data[last].btime) {
				temp = data[parent];
				data[parent] = data[last];
				data[last] = temp;
				Upheap(parent);
			}
		}
	}

	/**
	 * Move the value of the Index down the Heap until it is at the lowest position
	 * 
	 * @param first
	 */
	public void DownHeap(int first) {
		int left, right, min;
		Process temp;
		left = getLCI(first);
		right = getRCI(first);

		if (right >= heapSize) {
			if (left >= heapSize)
				return;
			else
				min = left;
		} else {
			if (data[left].btime <= data[right].btime)
				min = left;
			else
				min = right;
		}

		if (data[first].btime > data[min].btime) {
			temp = data[min];
			data[min] = data[first];
			data[first] = temp;
			DownHeap(min);
		}
	}

	/** Remove the smallest process */
	public void removeMin() {
		if (heapSize == 0)
			throw new RuntimeException("Heap is empty");
		else {
			data[0] = data[heapSize - 1];
			data[heapSize - 1] = data[0];
			heapSize--;
			if (heapSize > 0)
				DownHeap(0);
		}
	}

	/** Sort Heap using Heap Sort methodology` */
	public void HeapSort() {
		int i;
		int k = heapSize;
		Process arr[] = new Process[heapSize];

		for (i = 0; i < k; i++) {
			arr[i] = data[0];
			removeMin();
		}
		heapSize = k;
		for (i = 0; i < k; i++)
			data[i] = arr[i];

		System.out.print("SJF Scheduling : ");
		for (i = 0; i < k; i++)
			System.out.print(arr[i].pid + " ");
		System.out.println();

	}

	/** Print the current Heap */
	public void printHeap() {
		System.out.print("(Process_ID,Burst_Time) : ");
		for (int i = 0; i < heapSize; i++)
			System.out.print("(" + data[i].pid + "," + data[i].btime + ")");

		System.out.println();
	}
}

public class HeapProg {
	public static void main(String[] args) {
		MinHeap n = new MinHeap(7);
		// Process[] s = new Process[7];

		n.Insert("Process1", 45);
		n.Insert("Process2", 56);
		n.Insert("Process3", 12);
		n.Insert("Process4", 22);
		n.Insert("Process5", 54);
		n.Insert("Process6", 36);
		n.Insert("Process7", 15);

		n.printHeap();
		System.out.println("Min removal...");
		n.removeMin();
		n.printHeap();
		n.HeapSort();
	}
}


import java.util.*;

/**
 * Write a Java program to create a hashtable for a list of DNS addresses,
 * insert a set of Domains, and find a few of them
 * 
 * @author Shrey Mathur
 */
class DNS {
	String host;
	String IP;

	/**
	 * Constructor
	 * 
	 * @param host URL of the Host
	 * @param IP   IP address of the host
	 */
	DNS(String host, String IP) {
		this.host = host;
		this.IP = IP;
	}
}

class DNSHashTable {
	ArrayList<DNS>[] table = new ArrayList[50];

	DNSHashTable() {
		for (int i = 0; i < table.length; i++)
			table[i] = new ArrayList<DNS>();
	}

	/**
	 * Compress Hash Value to fit in Table
	 * 
	 * @param key Hashed Key
	 * @return Compressed Table number
	 */
	public static long compressMap(long key) {
		return key % 63L;
	}

	/**
	 * Method to Hash the value of hostname
	 * 
	 * @param host Hostname
	 * @return Hashed value
	 */
	public static long hashHost(String host) {
		char[] data = host.toCharArray();
		long value = 0;
		int a = 33;
		int len = data.length;
		for (int i = 0; i < len; i++) {
			value *= a;
			value += (int) data[len - 1 - i];
		}
		return value;
	}

	public void insert(DNS dns) {
		int index = (int) compressMap(hashHost(dns.host));
		table[index].add(dns);
	}

	public void Find(String hostname) {
		System.out.println();
		int index = (int) compressMap(hashHost(hostname));
		System.out.println(hostname + " May be found at table index : " + index);

		if (table[index] == null) {
			System.out.println(hostname + " Index not in mapping");
			return;
		}
		ArrayList<DNS> tableList = table[index];
		for (int i = 0; i < tableList.size(); i++) {
			if (tableList.get(i).host.compareTo(hostname) == 0) {
				System.out.println("IP Address of " + hostname + " is: " + tableList.get(i).IP);
				return;
			}
		}
		System.out.println(hostname + " Not found in mapping index");
	}

	public static void main(String[] args) {
		DNSHashTable map = new DNSHashTable();

		map.insert(new DNS("google.com", "172.217.11.174"));
		map.insert(new DNS("bbc.co.uk", "212.58.241.131"));
		map.Find("google.com");
		map.Find("bbc.co.uk");
		map.Find("youtube.com");
	}
}
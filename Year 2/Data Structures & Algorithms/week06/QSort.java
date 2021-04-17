
/*
  Write a Java program to WAP to read a set of student records (at least 20) from a file. 
  Assume that each student record contain student name, Id no., enrollment year and GPA Sort the records based on Student name using quick sort and display the resullt 

  @author Shrey Mathur
  */
import java.util.*;
import java.io.*;

class QSStudent implements Serializable {
  private static final long serialVersionUID = 1L;
  String name;
  String id;
  String year;
  Double gpa;

  /**
   * Constructor to initialise the student Object
   * 
   * @param name Name of the Student
   * @param id   Unique ID to the student
   * @param year Year of Admission
   * @param gpa  Grade Point Average of the student
   */
  public QSStudent(String name, String id, String year, Double gpa) {
    this.name = name;
    this.id = id;
    this.year = year;
    this.gpa = gpa;
  }

  /** Method to print the Info of the student */
  public void print() {
    System.out.println(" Name : " + name + " |  ID : " + id + " |  Year : " + year + " |  GPA : " + gpa);
  }

  /**
   * Method to swap the order of Stdents and their information in the list
   * 
   * @param other the Student that is to be swapped
   */
  public void swap(QSStudent other) {
    String temp;
    temp = this.name;
    this.name = other.name;
    other.name = temp;

    temp = this.id;
    this.id = other.id;
    other.id = temp;

    temp = this.year;
    this.year = other.year;
    other.year = temp;

    Double fake = this.gpa;
    this.gpa = other.gpa;
    other.gpa = fake;
  }
}

class QSort {
  static ArrayList<QSStudent> students;
  static Scanner input;

  /** Clears the display screen where code is runniing */
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Method asks to press a key. Generally used for waiting at a point before
   * continuing with the rest of the programme
   */
  public static void pak() {
    System.out.println("Press any key to continue!");
    input.nextLine();
  }

  /** Method to add a new Student */
  public static void addStudent() {
    System.out.print("Name        : ");
    String name = input.nextLine();

    System.out.print("ID          : ");
    String id = input.nextLine();

    System.out.print("Enroll Year : ");
    String year = input.nextLine();

    System.out.print("GPA         : ");
    Double gpa = input.nextDouble();

    QSStudent temp = new QSStudent(name, id, year, gpa);
    students.add(temp);
    updateStudents();
  }

  /** Mrthod to read student from a file */
  public static void readStudents() {
    try {
      students.clear();
      File studentFile = new File("students.ser");
      if (!studentFile.exists())
        studentFile.createNewFile();

      ObjectInputStream studentStream = new ObjectInputStream(new FileInputStream(studentFile));
      QSStudent student = null;
      while ((student = (QSStudent) studentStream.readObject()) != null)
        students.add(student);

      studentStream.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  /** Method to update the student file */
  public static void updateStudents() {
    File studentFile = new File("students.ser");
    File temp = new File("temp.ser");
    try {
      if (!studentFile.exists())
        studentFile.createNewFile();

      if (!temp.exists())
        temp.createNewFile();

      ObjectOutputStream studentStream = new ObjectOutputStream(new FileOutputStream(temp));

      for (int i = 0; i < students.size(); i++)
        studentStream.writeObject(students.get(i));
      studentStream.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    studentFile.delete();
    temp.renameTo(studentFile);
  }

  /**
   * Method to sort the students in the list by using Quick Sort Method
   * 
   * @param slist List of the Students
   * @param start Starting point *where the sorting starts from)
   * @param end   Ending point (where the sorting ends from)
   */
  public static void quickSort(ArrayList<QSStudent> slist, int start, int end) {
    if (start < end) {
      int i = partition(slist, start, end);
      quickSort(slist, start, i - 1);
      quickSort(slist, i + 1, end);
    }
  }

  /**
   * Sub-method of quick sort<br>
   * Sorts the list from start to end as much as it can. When it reaches an end
   * point, it returns a point where partition should occur
   * 
   * @param slist List of the Students
   * @param start Starting point *where the sorting starts from)
   * @param end   Ending point (where the sorting ends from)
   * @return point of partition
   */
  public static int partition(ArrayList<QSStudent> slist, int start, int end) {
    int r = end;
    int j = start;
    int i = j - 1;

    while (j < end) {
      if ((slist.get(j).name.compareTo(slist.get(r).name)) < 0) {
        i++;
        slist.get(j).swap(slist.get(i));
      }
      j++;
    }
    i++;
    slist.get(i).swap(slist.get(r));
    return i;
  }

  /** Prints the info of Students` */
  public static void printStudents() {
    for (int i = 0; i < students.size(); i++)
      students.get(i).print();
    System.out.println();
  }

  public static void main(String args[]) {
    input = new Scanner(System.in);
    students = new ArrayList<QSStudent>();
    int opt;
    do {
      readStudents();
      clearScreen();
      System.out.println("Student System");
      System.out.println("Press 1 for Adding New Student");
      System.out.println("Press 2 for Sorting via Name");
      System.out.println("Press 0 for Exit");
      System.out.print("Enter Choice : ");
      opt = input.nextInt();
      input.nextLine();
      switch (opt) {
      case 1:
        System.out.println("New Student : ");
        addStudent();
        break;
      case 2:
        System.out.println("Students sorted by name : ");
        quickSort(students, 0, students.size() - 1);
        printStudents();
        break;
      case 0:
        break;
      }
      pak();
    } while (opt != 0);
  }
}

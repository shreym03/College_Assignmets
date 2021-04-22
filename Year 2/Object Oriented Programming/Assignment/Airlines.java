
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.ArrayList;

public class Airlines {
  static ArrayList<String> myrecords = new ArrayList<>();
  public static String departure, destination;
  static String firstName, lastName, age, gender, date;
  static String[][] dataread = new String[2][7];

  public static void setDestination(String a) {
    destination = a;
  }

  public static void setDeparture(String a) {
    departure = a;
  }

  /**
   * @return if given String is blank
   * @param ele String variable
   */
  static boolean isBlank(String ele) {
    return ele.equals("");
  }

  /**
   * Method to search file for Existing files that match Input
   * 
   * @throws IOException prevents input error
   */
  public static void fileSearch() throws IOException {
    int h = 0;
    JOptionPane searchPane = new JOptionPane();
    String[] columns = { "Flight No", "Flight Name", "From", "To", "Depart Time", "Destination Time", "Fare" };

    searchPane.setSize(300, 500);
    searchPane.setMessage("Passenger Details: " + "\n" + "First Name: " + firstName + "\n" + "Last Name: " + lastName
        + "\n" + "Age: " + age + "\n" + "Gender: " + gender + "\n" + "Departure: " + departure + "\n" + "Destination: "
        + destination + "\n" + "Date of Journey: " + date);

    try (BufferedReader locfile = new BufferedReader(new FileReader("locations.txt"))) {
      for (int l = 0; l < 24; l++) {
        String detail = locfile.readLine();
        String details[] = detail.split(",");
        if (details[2].equals(departure) && details[3].equals(destination)) {
          h++;
          myrecords.add(detail);
        }
      }

      if (h == 0) {
        JOptionPane errorPane = new JOptionPane();
        errorPane.setMessage("Sorry, No flights found from your search result!");
        errorPane.setVisible(true);

        JDialog errorDlg = errorPane.createDialog(null);
        errorDlg.add(errorPane);
        errorDlg.setVisible(true);
        return;
      }
      String[] l1 = myrecords.get(0).split(",");
      String[] l2 = myrecords.get(1).split(",");

      for (int i = 0; i < 7; i++)
        dataread[0][i] = l1[i];
      for (int i = 0; i < 7; i++)
        dataread[1][i] = l2[i];

      JTable showTable = new JTable(dataread, columns);
      JScrollPane scrollPane = new JScrollPane(showTable);
      scrollPane.setViewportView(showTable);
      // forflights.add(scrollPane);
      searchPane.add(showTable);
      JButton reserveBtn = new JButton("Reserve my Seat");
      searchPane.add(reserveBtn);
      reserveBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (showTable.isRowSelected(0) || showTable.isRowSelected(1)) {
            JOptionPane lmn = new JOptionPane();
            lmn.setMessage("Thank you for booking with us!!!!!");
            lmn.setVisible(true);

            JDialog hij = lmn.createDialog(null, null);
            hij.setVisible(true);
          } else {
            JOptionPane errorPane = new JOptionPane();
            errorPane.setMessage("Please select any of the flights!");
            errorPane.setVisible(true);
            JDialog errorWindow = errorPane.createDialog("Message");
            errorWindow.setVisible(true);
          }
        }
      });

      JDialog jdk = searchPane.createDialog(null, "Details");
      jdk.setSize(800, 400);
      searchPane.setVisible(true);
      jdk.setVisible(true);
    } catch (IOException ioe) {
      ioe.getMessage();
    } catch (ArrayIndexOutOfBoundsException oobe) {
      System.out.println("This is the culprit...");
    }
  }

  public static void main(String[] args) throws IOException {

    // Initialise UI Elements
    // Welcome Screen
    JOptionPane.showMessageDialog(null, "Welcome to AirLines Reservation");

    // Input Screen
    JFrame inputFrame = new JFrame("Airline Reservation");
    inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    inputFrame.setSize(500, 400);

    JLabel fNameLabel = new JLabel("First Name: ");
    fNameLabel.setBounds(-100, 100, 20, 10);
    JTextField fNameField = new JTextField(40);
    fNameField.setBounds(35, 100, 200, 10);

    JLabel lNameLabel = new JLabel("Last Name:	");
    lNameLabel.setBounds(-100, 150, 20, 10);
    JTextField LNameField = new JTextField(40);
    LNameField.setBounds(35, 150, 200, 10);

    JLabel ageLabel = new JLabel("Age:	    ");
    ageLabel.setBounds(-200, 200, 20, 10);
    JTextField ageField = new JTextField(40);
    ageField.setBounds(35, 200, 200, 10);

    // Gender Field with Radio Buttons for selection
    JLabel genderLabel = new JLabel("Gender:		");
    genderLabel.setBounds(-200, 250, 20, 10);
    JRadioButton maleSelect = new JRadioButton("Male");
    maleSelect.setBounds(35, 250, 200, 10);
    JRadioButton femaleSelect = new JRadioButton("Female");
    femaleSelect.setBounds(55, 250, 200, 10);
    ButtonGroup selectGroup = new ButtonGroup();
    selectGroup.add(maleSelect);
    selectGroup.add(femaleSelect);

    JButton bookBtn = new JButton("Book Flight");
    bookBtn.setBounds(-100, 500, 20, 10);
    JButton cancelBtn = new JButton("Cancel");
    cancelBtn.setBounds(-50, 500, 20, 10);

    // Date Field with Self Built Date Picker
    JLabel dateLabel = new JLabel("Selected Date:");
    final JTextField dateField = new JTextField(20);
    JButton selectBtn = new JButton("Select");
    JPanel dateSection = new JPanel();
    dateSection.add(dateLabel);
    dateSection.add(dateField);
    dateSection.add(selectBtn);

    selectBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        dateField.setText(new DatePicker(inputFrame).setPickedDate());
      }
    });

    bookBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        // extract all data
        firstName = fNameField.getText();
        lastName = LNameField.getText();
        age = ageField.getText();
        date = dateField.getText();

        if (maleSelect.isSelected())
          gender = "Male";
        else if (femaleSelect.isSelected())
          gender = "Female";
        else
          gender = "";

        // Make sure all fields are filled
        if (isBlank(firstName) || isBlank(lastName) || isBlank(age) || isBlank(gender) || isBlank(date)) {
          JOptionPane errorPane = new JOptionPane();
          errorPane.setMessage("Please enter value for all the fields!");
          errorPane.setVisible(true);
          JDialog errorWindow = errorPane.createDialog("Fields Empty");
          errorWindow.setVisible(true);
        } else {
          // Show a Fight Selection Window next
          JOptionPane flightPane = new JOptionPane();

          flightPane.setPreferredSize(new Dimension(500, 200));
          flightPane.setMessage(null);

          JLabel dprtLabel = new JLabel("Departure Airport");
          dprtLabel.setBounds(-100, -100, 20, 10);

          JLabel destLabel = new JLabel("Destination Airport");
          dprtLabel.setBounds(-100, -100, 20, 10);

          String[] dprtOpt = { "--- CHOOSE DEPARTURE ---", "Dubai", "Singapore", "Mumbai", "Hyderabad" };
          String[] destOpt = { "--- CHOOSE DESTINATION ---", "Dubai", "Singapore", "Mumbai", "Hyderabad" };
          // Fropdown Boxes
          JComboBox<String> dprtComboBox = new JComboBox<>(dprtOpt);
          JComboBox<String> destComboBox = new JComboBox<>(destOpt);

          dprtComboBox.setBounds(0, -400, 20, 10);

          dprtComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Object slctCty = dprtComboBox.getSelectedItem();
              setDeparture(slctCty.toString());
            }
          });

          destComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Object slctCty = destComboBox.getSelectedItem();
              setDestination(slctCty.toString());
            }
          });

          JButton showFlightBtn = new JButton("Show Flights");
          showFlightBtn.setLocation(100, 100);

          flightPane.add(dprtLabel);
          flightPane.add(dprtComboBox);
          flightPane.add(destLabel);
          flightPane.add(destComboBox);
          flightPane.add(showFlightBtn);

          showFlightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                fileSearch();
              } catch (IOException ioe) {
                ioe.printStackTrace();
              } catch (NullPointerException npe) {
                System.out.println("There is an error");
              } catch (ArrayIndexOutOfBoundsException oobe) {
                System.out.println("Out of Bounds");
              }
            }
          });
          JDialog d = flightPane.createDialog(null, "Flight Booking");
          flightPane.setVisible(true);
          d.setVisible(true);
        }
      }
    });

    cancelBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    // Diisplaying the Info Screen
    inputFrame.setLayout(new FlowLayout());
    inputFrame.add(fNameLabel);
    inputFrame.add(fNameField);
    inputFrame.add(lNameLabel);
    inputFrame.add(LNameField);
    inputFrame.add(ageLabel);
    inputFrame.add(ageField);
    inputFrame.add(genderLabel);
    inputFrame.add(maleSelect);
    inputFrame.add(femaleSelect);
    inputFrame.getContentPane().add(dateSection);
    inputFrame.add(bookBtn);
    inputFrame.add(cancelBtn);
    inputFrame.setVisible(true);
  }

}

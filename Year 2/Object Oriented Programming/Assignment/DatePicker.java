
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class DatePicker {
    String day = "";
    /** month from Calender */
    int month = Calendar.getInstance().get(Calendar.MONTH);
    /** year from the Calender */
    int year = Calendar.getInstance().get(Calendar.YEAR);
    JLabel l = new JLabel("", JLabel.CENTER);
    JDialog datePickWindow;
    JButton[] dateBtns = new JButton[49];

    /** create constructor */
    public DatePicker(JFrame parent) {
        String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
        JPanel datePickPanel = new JPanel(new GridLayout(7, 7));
        datePickWindow = new JDialog();

        datePickWindow.setModal(true); // Set modal true
        datePickPanel.setPreferredSize(new Dimension(430, 120));
        for (int x = 0; x < dateBtns.length; x++) {
            // Initialising all date buttons of the calender
            dateBtns[x] = new JButton();
            dateBtns[x].setFocusPainted(false); // Sets all buttons not to be highlightd
            dateBtns[x].setBackground(Color.white); // set background colour
            final int selection = x;
            if (x < 7) {
                dateBtns[x].setText(header[x]);
                dateBtns[x].setForeground(Color.red);
            } else {
                dateBtns[x].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        day = dateBtns[selection].getActionCommand();
                        datePickWindow.dispose(); // call dispose() method
                    }
                });
            }
            // Add day and date section of date picker
            datePickPanel.add(dateBtns[x]);
        }
        // create JPanel object with grid layout
        JPanel monthPanel = new JPanel(new GridLayout(1, 3));

        JButton prvBtn = new JButton("<< Previous");
        prvBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month--;
                displayDate();
            }
        });

        JButton nxtBtn = new JButton("Next >>");
        nxtBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                month++;
                displayDate();
            }
        });
        // Add Month section of Date picker
        monthPanel.add(prvBtn);
        monthPanel.add(l);
        monthPanel.add(nxtBtn);

        // Set border alignment
        datePickWindow.add(datePickPanel, BorderLayout.CENTER);
        datePickWindow.add(monthPanel, BorderLayout.SOUTH);
        datePickWindow.pack();

        datePickWindow.setLocationRelativeTo(parent);
        // call method
        displayDate();
        // set visible true
        datePickWindow.setVisible(true);
    }

    public void displayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        for (int x = 7; x < dateBtns.length; x++)
            dateBtns[x].setText("");// set text

        cal.set(year, month, 1); // set year, month and date
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
            dateBtns[x].setText("" + day);
        l.setText(sdf.format(cal.getTime()));
        datePickWindow.setTitle("Date Picker");
    }

    public String setPickedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        if (day.equals(""))
            return day;
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
}

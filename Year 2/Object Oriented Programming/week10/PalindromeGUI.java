import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
class PalindromeGUI
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("PAL GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final int feild_width=20;
        final JTextField inpField=new JTextField(feild_width);
        final JTextField outField=new JTextField(feild_width);
        JButton checkpal=new JButton("OK");
        checkpal.addActionListener(new ActionListener()
        {
                public void actionPerformed(ActionEvent e)
                {
                    String s =inpField.getText();
                    boolean isPal=true;
                    for (int i=0,j=s.length();i<j;i++,j-- )
                    {
                        if(s.charAt(i)!=s.charAt(j-1))
                        {
                            isPal=false;
                            break;
                        }
                    }
                    outField.setText(""+isPal);
                }
            }
        );
        frame.setLayout(new FlowLayout());
        frame.add(inpField);
        frame.add(checkpal);
        frame.add(outField);
        frame.setVisible(true);
    }
}

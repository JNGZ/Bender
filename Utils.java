package WordAssoc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.Spring.height;
import javax.swing.SpringLayout;


/**
 *
 * @author student
 */
public class Utils 
{ 
    
    
    public static JLabel LocateALabel(SpringLayout myLabelLayout, JLabel myLabel, String  LabelCaption, int x, int y, JFrame myFrame)
    {
        myLabel = new JLabel(LabelCaption);
        myFrame.add(myLabel);   
        myLabel.setOpaque(true);
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, myFrame);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, myFrame);
        return myLabel;
    }
    
        public static Label LocateHeader(SpringLayout myLabelLayout, Label myLabel, String  LabelCaption, int x, int y, JFrame myFrame)
    {
        myLabel = new Label(LabelCaption);
        myFrame.add(myLabel);        
        myLabelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, myLabel, x, SpringLayout.HORIZONTAL_CENTER, myFrame);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, myFrame);
        return myLabel;
    }
    

    public static JTextField LocateATextField(SpringLayout myTextFieldLayout, JTextField myJTextField, int w, int h, int x, int y, JFrame myFrame)
    {
        myJTextField = new JTextField();
        myFrame.add(myJTextField);
        myJTextField.setPreferredSize(new Dimension(w,h));
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myJTextField, x, SpringLayout.WEST, myFrame);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myJTextField, y, SpringLayout.NORTH, myFrame);
        myJTextField.setBorder(BorderFactory.createLineBorder(Color.black));
        return myJTextField;
    }
    
    public static JTextArea LocateATextArea(SpringLayout myJTextAreaLayout, JTextArea myJTextArea, int w, int h, int x , int y, JFrame myFrame)
    {
        myJTextArea = new JTextArea();
        myFrame.add(myJTextArea);
        myJTextArea.setPreferredSize(new Dimension(w,h));
        myJTextAreaLayout.putConstraint(SpringLayout.WEST, myJTextArea, x, SpringLayout.WEST, myFrame);
        myJTextAreaLayout.putConstraint(SpringLayout.NORTH, myJTextArea, y, SpringLayout.NORTH, myFrame);
        myJTextArea.setBorder(BorderFactory.createLineBorder(Color.black));
        return myJTextArea;
    }
    
   public static JButton LocateAButton(SpringLayout myButtonLayout, JButton myButton, String  ButtonCaption, int x, int y, int w, int h, JFrame myFrame, ActionListener al)
    {    
        myButton = new JButton(ButtonCaption);
        myFrame.add(myButton);
        myButton.addActionListener(al);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, myFrame);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, myFrame);
        myButton.setPreferredSize(new Dimension(w,h));
        return myButton;
    }
   public static JPanel LocateAPanel(SpringLayout myPanelLayout, JPanel myJPanel, JFrame myFrame, int x, int y, int w, int h)
   {
       myJPanel = new JPanel();
       myFrame.add(myJPanel);
       myPanelLayout.putConstraint(SpringLayout.WEST, myJPanel, x, SpringLayout.WEST, myFrame);
       myPanelLayout.putConstraint(SpringLayout.NORTH, myJPanel, y, SpringLayout.NORTH, myFrame);
       myJPanel.setPreferredSize(new Dimension (w,h));
       myJPanel.setBorder(BorderFactory.createLineBorder(Color.black));
       return myJPanel;
   }
   
   public static JTable LocateJTable(SpringLayout myJTableLayout, JTable myJTable, JPanel myJPanel)
   {
    myJTable = new JTable();
    myJPanel.add(myJTable);
    return myJTable;
   }
   
    
}

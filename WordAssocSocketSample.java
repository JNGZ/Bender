
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SpringLayout;


public class WordAssocSocketSample extends Frame implements ActionListener, WindowListener
{  

    Label lblWord1, lblWord2;
    TextField txtWord1, txtWord2;
    Button btnSend, btnExit;


    public static void main(String[] args)
    {        
        Frame myFrame = new WordAssocSocketSample();
        myFrame.setSize(470,150);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);       
    }
        
    

    public WordAssocSocketSample()
    {
        setTitle("Word Association Socket Sample");
        setBackground(Color.lightGray);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
        
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateButtons(myLayout);

        this.addWindowListener(this);
    }

    
//<editor-fold defaultstate="collapsed" desc="GUI Construction">

    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblWord1 = LocateALabel(myLabelLayout, lblWord1, "Word 1: ", 30, 25);
        lblWord2 = LocateALabel(myLabelLayout, lblWord2, "Word 2: ", 30, 50);
    }

    public Label LocateALabel(SpringLayout myLabelLayout, Label myLabel, String  LabelCaption, int x, int y)
    {
        myLabel = new Label(LabelCaption);
        add(myLabel);        
        myLabelLayout.putConstraint(SpringLayout.WEST, myLabel, x, SpringLayout.WEST, this);
        myLabelLayout.putConstraint(SpringLayout.NORTH, myLabel, y, SpringLayout.NORTH, this);
        return myLabel;
    }
   
    public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtWord1  = LocateATextField(myTextFieldLayout, txtWord1, 20, 130, 25);
        txtWord2 = LocateATextField(myTextFieldLayout, txtWord2, 20, 130, 50);
    }

    public TextField LocateATextField(SpringLayout myTextFieldLayout, TextField myTextField, int width, int x, int y)
    {
        myTextField = new TextField(width);
        add(myTextField);        
        myTextFieldLayout.putConstraint(SpringLayout.WEST, myTextField, x, SpringLayout.WEST, this);
        myTextFieldLayout.putConstraint(SpringLayout.NORTH, myTextField, y, SpringLayout.NORTH, this);
        return myTextField;
    }

    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnSend = LocateAButton(myButtonLayout, btnSend, "Send", 320, 25, 80, 25);
        btnExit = LocateAButton(myButtonLayout, btnExit, "Exit", 320, 50, 80, 25);
    }

   public Button LocateAButton(SpringLayout myButtonLayout, Button myButton, String  ButtonCaption, int x, int y, int w, int h)
    {    
        myButton = new Button(ButtonCaption);
        add(myButton);
        myButton.addActionListener(this);
        myButtonLayout.putConstraint(SpringLayout.WEST, myButton, x, SpringLayout.WEST, this);
        myButtonLayout.putConstraint(SpringLayout.NORTH, myButton, y, SpringLayout.NORTH, this);
        myButton.setPreferredSize(new Dimension(w,h));
        return myButton;
    }
//</editor-fold>

   
   public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnSend)
        {
        }

        if(e.getSource() == btnExit)
        {
            System.exit(0);
        }

    }



//<editor-fold defaultstate="collapsed" desc="WindowListener">
    
    public void windowClosing(WindowEvent we)  {  System.exit(0);  }
    public void windowIconified(WindowEvent we) {  }
    public void windowOpened(WindowEvent we)  {  }
    public void windowClosed(WindowEvent we)  {  }
    public void windowDeiconified(WindowEvent we)  {  }
    public void windowActivated(WindowEvent we)  {  }
    public void windowDeactivated(WindowEvent we)  {  }
   
//</editor-fold>
    
}


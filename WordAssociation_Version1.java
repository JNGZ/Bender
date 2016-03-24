package WordAssoc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class WordAssociation_Version1 extends JFrame implements ActionListener, WindowListener
{  
    JFrame frame;
    Container contentPane;
    JPanel mode;
    JPanel LL;
    JPanel bT;
    JPanel preOrder;
    JPanel inOrder;
    JPanel postOrder;
    JPanel gridPanel;
    JPanel tablePanel;
        
        //TextBoxes
    JTextField tfFW;
    JTextField tfAW;
    
        //Buttons
    JButton btnSend;
    JButton btnExit;
    JButton btnCompare;
    
    //LABELS
    JLabel lblWord1, lblWord2;
    TextField txtWord1, txtWord2;


    public static void main(String[] args)
    {        
        Frame myFrame = new WordAssociation_Version1();
        myFrame.setSize(320,320);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);       
    }
        
    

    public WordAssociation_Version1()
    {
        setTitle("Word Association Socket Sample PLAYER 2");
        setBackground(Color.LIGHT_GRAY);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
        
        LocateLabels(myLayout);
        LocateAButton(myLayout);

        this.addWindowListener(this);
    }

    
//<editor-fold defaultstate="collapsed" desc="GUI Construction">

public void LocateLabels(SpringLayout myLayout)
{
    lblWord1 = Utils.LocateALabel(myLayout,lblWord1, "First Word:", 10, 100, this);
    lblWord2 = Utils.LocateALabel(myLayout,lblWord2, "Associated Word:", 10, 120, this);
            
}

public void LocateATextField(SpringLayout myJTextAreaLayout)
{
    tfFW = Utils.LocateATextField(myJTextAreaLayout, tfFW, 20, 10, 5,10, this);
    tfAW = Utils.LocateATextField(myJTextAreaLayout, tfAW, 20, 20, 5,10, this);
}

public void LocateAButton(SpringLayout myButtonLayout)
{
    btnSend = Utils.LocateAButton(myButtonLayout, btnSend, "Send", 35, 200, 250, 25, this, this);
    btnCompare = Utils.LocateAButton(myButtonLayout, btnSend, "Compare", 35, 225, 250, 25, this, this);
    btnExit = Utils.LocateAButton(myButtonLayout, btnExit, "Exit", 35, 250, 250, 25, this, this);
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


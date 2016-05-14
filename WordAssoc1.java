package WordAssoc;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import javax.swing.*;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import java.lang.Comparable;
import java.util.Comparator;



public class WordAssoc1 extends JFrame implements ActionListener, WindowListener
{  

    JLabel lblFW, lblAW, lblHeader, lblModeHeader, lblLinked, lblBinary, lblSort, lblPreOrder, lblInOrder, lblPostOrder;
    
    JPanel mode, words, PanelLinkedList, panelBinary, preOrder, inOrder, postOrder; 
    
    JTextField txtFW, txtAW;
    
    JTextArea txtaBinary, txtaLL;
    
    JButton btnSend, btnCompare, btnExit , btn1, btn2, btn3, btnDisplay, btnDisplay1, btnDisplay2, btnDisplay3, btnSave1, btnSave2, btnSave3 ;
    
    JTable tableArray;
    
          
    ArrayList<Object[]> list;
    
    
   
        // the Model in instance variable so we can access it
        MyModel wordModel;

    public static void main(String[] args)
    {        
        JFrame myFrame = new WordAssoc1();
        myFrame.setSize(620,650);
        myFrame.setLocation(400, 200);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        
        
       //WordAssociation_Version1.main(args);
         
    }
        
    public WordAssoc1()
    {
        setTitle("Word Association Socket Sample PLAYER 1");
        setBackground(Color.lightGray);

        SpringLayout myLayout = new SpringLayout();
        setLayout(myLayout);
        
        LocateLabels(myLayout);
        LocateTextFields(myLayout);
        LocateButtons(myLayout);
        WordAssociationTable(myLayout);
        LocateAPanel(myLayout);
        LocateATextArea(myLayout);
        LocateJTable(myLayout);
        
 
        this.addWindowListener(this);
    }

   
    
    
//<editor-fold defaultstate="collapsed" desc="GUI Construction">
     class MyModel extends AbstractTableModel
    {
        // to store our elements it will be great to avoid parallel array and use 
        // an ArrayList<Animal> but for simplicity and not to have to add a new 
        // class with will use an ArrayList<Object> for each row
        ArrayList<Object[]> al;
        // the headers
        String[] header;

        // constructor 
        MyModel(ArrayList<Object[]> obj, String[] header)
        {
            // save the header
            this.header = header;
            // and the rows
            al = obj;
            //al = new ArrayList<Object[]>();
            // copy the rows into the ArrayList
            
        }

        // method that needs to be overload. The row count is the size of the ArrayList
        public int getRowCount()
        {
            return al.size();
        }

        // method that needs to be overload. The column count is the size of our header
        public int getColumnCount()
        {
            return header.length;
        }

        // method that needs to be overload. The object is in the arrayList at rowIndex
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            return al.get(rowIndex)[columnIndex];
        }

        // a method to return the column name 
        public String getColumnName(int index)
        {
            return header[index];
        }

        // a method to add a new line to the table
        void add(String word1, String word2)
        {
            // make it an array[2] as this is the way it is stored in the ArrayList
            // (not best design but we want simplicity)
            String[] str = new String[2];
            str[0] = word1;
            str[1] = word2;
            al.add(str);
            // inform the GUI that I have change
            fireTableDataChanged();
        }
    }
    
       public void WordAssociationTable(SpringLayout myPanelLayout)
    {
        // Sources: http://www.cs.cf.ac.uk/Dave/HCI/HCI_Handout_CALLER/node167.html
        //     and: http://www.cs.cf.ac.uk/Dave/HCI/HCI_Handout_CALLER/node168.html
        
        // Create a panel to hold all other components
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.red);
        add(topPanel);

        // Create column names
        String columnNames[] =
        { "Word 1", "Word 2" };

        // Create some data
        list = new ArrayList<Object[]>();
        {
         list.add(new Object[] {"Yes","No"});
         list.add(new Object[] {"cat","dog"});
         list.add(new Object[] {"food","water"});          
        }
        
        // constructor of JTable model
	wordModel = new MyModel(list, columnNames);
        
        
        
        // Create a new table instance
        tableArray = new JTable(wordModel);

        // Configure some of JTable's paramters
        tableArray.isForegroundSet();
        tableArray.setShowHorizontalLines(false);
        tableArray.setRowSelectionAllowed(true);
        tableArray.setColumnSelectionAllowed(true);
        add(tableArray);

        // Change the text and background colours
        tableArray.setSelectionForeground(Color.white);
        tableArray.setSelectionBackground(Color.red);

        // Add the table to a scrolling pane, size and locate
        JScrollPane scrollPane = tableArray.createScrollPaneForTable(tableArray);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        topPanel.setPreferredSize(new Dimension(300, 150));
        myPanelLayout.putConstraint(SpringLayout.WEST, topPanel, 310, SpringLayout.WEST, this);
        myPanelLayout.putConstraint(SpringLayout.NORTH, topPanel, 10, SpringLayout.NORTH, this);


        wordModel.add("tall","short");
        tableArray.repaint();
    }
    
       
   // <editor-fold defaultstate="collapsed" desc=" ${BUBBLE SORT} ">
    public static void bubbleSort(ArrayList<Object[]> arr) 
    {
        
        for(int j=0; j<arr.size(); j++) 
        {  
            for(int i=j+1; i<arr.size(); i++)
            {  
                if((arr.get(i)[0]).toString().compareToIgnoreCase(arr.get(j)[0].toString()) < 0)
                {  
                   Object[] words = arr.get(j); 
                   arr.set(j, arr.get(i));
                   arr.set(i, words);
                }  
            }  
            System.out.println(arr.get(j)[0] + " - " + arr.get(j)[1]);  
        }  
    }  
       // </editor-fold>
 
    // <editor-fold defaultstate="collapsed" desc=" ${INSERTION SORT} ">

public void insertionSort(ArrayList<Object[]> arr)
        
{
    for(int i = 1; i < arr.size(); i++)
    {
        Object[] temp = arr.get(i);
        int j;
        
        for(j = i - 1; j >= 0 && ((temp[0]).toString().compareToIgnoreCase(arr.get(j)[0].toString()))<0; j--) 

            arr.set(j + 1, arr.get(j));
            arr.set(j + 1, temp);
    }
}

   // </editor-fold>
    
     // <editor-fold defaultstate="collapsed" desc=" ${SELECTION SORT} ">
public static void SelectionSort ( ArrayList<Object[]> arr )
{
     int i;
     int j;
     int first;
     Object[] temp;
             
     for ( i = arr.size() - 1; i > 0; i -- )  
     {
          first = 0;   //initialize to subscript of first element
          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
          {
               if((arr.get(j)[0]).toString().compareToIgnoreCase(arr.get(first)[0].toString())<0)         
                 first = j;
          }
          temp = arr.get(first);   //swap smallest found with element in position i.
          arr.set(first, arr.get(i));
          arr.set(i, temp);
      }           
}
     // </editor-fold>
    
    
   
   
    
    
    public void LocateAPanel(SpringLayout myPanelLayout)
    {
        mode = Utils.LocateAPanel(myPanelLayout, mode, this, 5, 10, 300, 200);
        words = Utils.LocateAPanel(myPanelLayout, words, this, 310, 10, 300, 200);
        
  
        preOrder = Utils.LocateAPanel(myPanelLayout, preOrder, this, 5, 550, 195, 50);
        inOrder = Utils.LocateAPanel(myPanelLayout, inOrder, this, 210, 550, 195, 50);
        postOrder = Utils.LocateAPanel(myPanelLayout, postOrder, this, 415, 550, 195, 50);
        
        
    }
    
    public void LocateLabels(SpringLayout myLabelLayout)
    {
        lblModeHeader = Utils.LocateALabel(myLabelLayout, lblModeHeader, "Game Mode", 20, 0, this);        
        lblFW = Utils.LocateALabel(myLabelLayout, lblFW, "First Word:", 20, 30, this);
        lblAW = Utils.LocateALabel(myLabelLayout, lblAW, "Associated Word:", 20, 50, this);        
        
        lblSort = Utils.LocateALabel(myLabelLayout, lblAW, "Sort Systems", 320, 160, this);
        
        lblLinked = Utils.LocateALabel(myLabelLayout, lblLinked, "Linked List (of all unmatched pairs):", 20, 225, this);  
        lblBinary = Utils.LocateALabel(myLabelLayout, lblBinary, "Binary Tree (of all words):", 20, 365, this);
        
        lblPreOrder = Utils.LocateALabel(myLabelLayout, lblPreOrder, "Pre-Order", 70, 555, this);
        lblInOrder = Utils.LocateALabel(myLabelLayout, lblInOrder, "In-Order", 290, 555, this);
        lblPostOrder = Utils.LocateALabel(myLabelLayout, lblPostOrder, "Post-Order", 480, 555, this);
        
        
    }
    
     public void LocateTextFields(SpringLayout myTextFieldLayout)
    {
        txtFW  = Utils.LocateATextField(myTextFieldLayout, txtFW,164, 22, 130, 25, this);
        txtAW = Utils.LocateATextField(myTextFieldLayout, txtAW,164 ,22, 130, 50, this);
    }
    
    public void LocateButtons(SpringLayout myButtonLayout)
    {
        btnSend = Utils.LocateAButton(myButtonLayout, btnSend, "Send", 130, 90, 165, 25, this, this);
        btnCompare = Utils.LocateAButton(myButtonLayout, btnCompare, "Compare", 130, 115, 165, 25, this, this);
        btn1 = Utils.LocateAButton(myButtonLayout, btn1, "Bubble", 315, 175, 75, 25, this, this);
        btn2 = Utils.LocateAButton(myButtonLayout, btn1, "Slct.", 390, 175, 75, 25, this, this);
        btn3 = Utils.LocateAButton(myButtonLayout, btn1, "Inser.", 465, 175, 75, 25, this, this);
        btnExit = Utils.LocateAButton(myButtonLayout, btn1, "Exit", 540, 175, 67, 25, this, this);
        btnDisplay = Utils.LocateAButton(myButtonLayout, btnDisplay, "Display", 530, 500, 80, 25, this, this);
        
        btnDisplay1 = Utils.LocateAButton(myButtonLayout, btnDisplay1, "Display", 5, 575, 98, 25, this, this);
        btnDisplay2 = Utils.LocateAButton(myButtonLayout, btnDisplay2, "Display", 210, 575, 98, 25, this, this);
        btnDisplay3 = Utils.LocateAButton(myButtonLayout, btnDisplay3, "Display", 415, 575, 98, 25, this, this);
        btnSave1 = Utils.LocateAButton(myButtonLayout, btnSave1, "Save", 103, 575, 97, 25, this, this);
        btnSave2 = Utils.LocateAButton(myButtonLayout, btnSave2, "Save", 308, 575, 97, 25, this, this);
        btnSave3 = Utils.LocateAButton(myButtonLayout, btnSave3, "Save", 513, 575, 97, 25, this, this);
       
    }

    public void LocateATextArea(SpringLayout myJTextAreaLayout)
    {
        txtaLL = Utils.LocateATextArea(myJTextAreaLayout, txtaLL, 605, 115, 5,245, this);
        txtaBinary = Utils.LocateATextArea(myJTextAreaLayout, txtaBinary, 605, 115, 5,385, this);
    }
    
   public void LocateJTable(SpringLayout myJTableLayout)
   {
       
   }

    
//</editor-fold>
    
    // Source: http://www.dreamincode.net/forums/topic/231112-from-basic-jtable-to-a-jtable-with-a-tablemodel/
    // class that extends the AbstractTableModel
   

   
   
   public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnSend)
        {
            wordModel.add(txtFW.getText(), txtAW.getText());
            tableArray.repaint();
            
        }

        if(e.getSource() == btnExit)
        {
            System.exit(0);
        }
        
        if(e.getSource() == btnCompare)
        {
         
        }
        if(e.getSource() == btn1)
        {
           bubbleSort(list);
           tableArray.repaint();
        }
        if(e.getSource() == btn2)
        {
            SelectionSort(list);
            tableArray.repaint();
        }
        if(e.getSource() == btn3)
        {
         
           insertionSort(list);
           tableArray.repaint();
        }
        if(e.getSource() == btnDisplay)
        {
           
        }
        if(e.getSource() == btnDisplay1)
        {
           
        }
        if(e.getSource() == btnDisplay2)
        {
           
        }
        if(e.getSource() == btnDisplay3)
        {
           
        }
        if(e.getSource() == btnSave1)
        {
            
        }
        if(e.getSource() == btnSave2)
        {
           
        }
        if(e.getSource() == btnSave3)
        {
          
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


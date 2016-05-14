
/****************************************************************
   PROGRAM:   Word Association Game
   AUTHOR:    Johnathan Gonzalez
   DUE DATE:  SEMESTER 2 - SOFTWARE DEVELOPMENT DIPLOMA COURSE TAFE BRISBANE

   FUNCTION:  This program exists as an example of accumulated skills developed
   * during the software development course. 
       
   INPUT:     location of input, i.e.  standard input, a file on
              disk

   OUTPUT:    location and type of output, i.e.  a report
              containing a detail record for each city processed
              containing city id, Celsius temperature, Fahrenheit
              temperature and wind chill temperature.

   NOTES:     any relevant information that would be of
              additional help to someone looking at the program.
****************************************************************/

package WordAssoc;


public class LL {

    class Node                                                                  // Class for nodes in Linked List
    { 
        Node prev;                                                              // previous node in Linked List
        Node next;                                                              // next node in Linked List
        Object data;
        
            Node()                                                              // Constructor for head node
            {
                prev = this;                                                    // of an empty doubly-linked list
                next = this;
                data = 'H';                                                     // not used except for printing datat in list head
            }
        
            Node(char data)                                                     //constructor for a Node with data
            {
                prev = null;
                next = null;
                this.data = data; 
            }
            
/****************************************************************
   FUNCTION:   append

   ARGUMENTS:  newNode of type Node

   RETURNS:    VOID

   NOTES:      attach newNode AFTER this node
****************************************************************/
            public void append(Node newNode)
            {
                newNode.prev = this;
                newNode.next = next;
                next.prev = newNode;
                prev = newNode;        
                
                System.out.println("Node with data " + newNode.data + 
                        " appended after Node with data " + data);
            }
                
/****************************************************************
   FUNCTION:   Insert

   ARGUMENTS:  newNode of type Node

   RETURNS:    VOID

   NOTES:      attach newNode BEFORE this node
****************************************************************/ 
            public void insert(Node newNode)
            {
                newNode.prev = prev;
                newNode.next = this;
                prev.next = newNode;
                prev = newNode;
                
                System.out.println("Node with data " + newNode.data + 
                        " inserted before Node with data " + data);
            }
            
/****************************************************************
   FUNCTION:   remove

   ARGUMENTS:  

   RETURNS:    VOID

   NOTES:      remove this node / bypass this node
****************************************************************/
            public void remove()
            {
                next.prev = prev;
                prev.next = next;
                
                System.out.println("Node with data " + data + " removed.");
            }
    }
    
    
    
    
    
    
    
    
    
 class DList
    {

        Node head = new Node();                                                 // head Node of doubly-linked list

    /****************************************************************
       FUNCTION:   print

       ARGUMENTS:  N/A

       RETURNS:    VOID

       NOTES:      print contents of list 
    ****************************************************************/
        public void print()                                                         
        {
            if(head.next == head)
            {
                System.out.println("list is empty");
            }

            System.out.println("list contents = ");
            for(Node current = head.next; current != head; current = current.next)
            {
                System.out.println(" " + current.data);
            }

            System.out.println("");
        }

    }
    
}

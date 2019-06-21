/*
* Create a program that arrives and is given a numbered ticket which 
* indicates their number in the queue. Every 5 seconds a sales assistant 
* is ready to see a customer if there are any. Customers are then seen 
* in the order of their arrival to the shop. simulates queueing in the shop.
* Every 3 seconds a new customer
*/


package ticketingsystem;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;


/**
 * @date 21/6/2019.
 * @author Antony Jones 92019124.
 * 
 **/


public class TicketingSystem {
    
    //appropriate fields set to Queue, String, int.
    
    public static Queue<Integer> customerInLine = new LinkedList();
    public static String newCustomer;
    public static int placeInLine = 0;
    
    
    /**
     * @param args the command line arguments.
     */
    
    public static void main(String[] args) {
        
        nextCustomer();
        
        Timer fiveSeconds = new Timer();
        
        /*run code. 
        in the SalesAssistantTask class run() method every 5 seconds.*/
        fiveSeconds.schedule(new SalesAssisstantTask(), 0, 5000);
        
        
        addNewCustomer();
        
        Timer threeSeconds = new Timer();
        
        /*run code.
        in the addNewCustomer class run() method every 3 seconds.*/
        threeSeconds.schedule(new addNewCustomer(), 0, 3000);
        
    }//End of main Method.
   
    
     //nextCustomer method set to increnment while less than 1.
    
     public static void nextCustomer(){
         
        for (int i=1; i<1; i++){
                
            customerInLine.add(i);

        }
        
        
    }//End of next customer Method
     
     
      //Method addNewCustomer set to increnment while less than 2.
    
     public static void addNewCustomer(){
         
         for (int i=2; i<11; i++){

         }
       
    }//End of addNewCustomer method.
         

    public static class SalesAssisstantTask extends TimerTask { //inner class.
        
        /*Add code to the run() method of the inner 
        SalesAssisstantTask class to simulate customer being served:*/
        
        @Override
        public void run() {   
             
            //print out message.
            System.out.println("\nSales assistant is ready to"
                    + " see the next Customer. ");
            
            /*use of if statement to check if queue is empty via 
            .isEmpty function from library.*/
            
            if (customerInLine.isEmpty()) {
                
                //Print out below message if no customers in queue.
                System.out.println("There are no customers to be seen.\n");
                   
            }
                   
            //else if statement to check the clientInQueue is equal to 1.
            else if (customerInLine.size() ==1) {
                System.out.println("Customer number: "
                        + customerInLine.poll()
                        + " is currently being served.\n");
                
                //Print out no more clients to be seen
                System.out.println("There are no more clients to see.\n");
            }
            
            /*else print the client currently being served 
            via clientInQueue.poll()*/
            else {
                
                /*Print out Client ticket number with customerQueue.poll()
                removes client in the queue from the top. Or show null
                if none and show the next client to be seen.*/
                
                /*The poll() method of Queue Interface returns and removes 
                the element at the front the container*/
                
                System.out.println("Customer with ticket number: " +
                        customerInLine.poll() + " will be seen ");
                
                
                  System.out.println("Customers with the following ticket"
                        + " numbers are in the queue:" + customerInLine + "\n");
            
            }

        }//End of run.

    }//End of SalesAssisstantTask method.
   
    
    public static class addNewCustomer extends TimerTask { //2nd inner class.
        
        /*Add code to the run() method of the inner 
        addNewCustomer class to simulate customer added to queue:*/
        
        @Override
        
        public void run() {
                
                addNewCustomer();
                
                placeInLine++;
                customerInLine.add(placeInLine);
                        
                
                 System.out.println("Customer with ticket number: " 
                         + placeInLine
                + " added to the queue.");
       
        }//End of run.
 
    }//End of aaddNewCustomer method.
    
}//End of TicketingSystem class.
    


   
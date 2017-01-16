/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;
import java.util.Random;
import static os.Demo.printInf;
/**
 *
 * @author apple
 */
public class InThread extends Thread {
    private boolean active;
	private int number;
	private int step;
	private int temp1;
        private int temp2;
	
	public InThread(int num) {
		active = true;
	   	number = num;
	   	step = 0;
	}
	    
	public void setActive(boolean active) {
	    this.active = active;
	}

	public boolean isActive() {
	    return active;
	}
        static private Object obj = new Object();
        public static void staticWait() {
            synchronized (obj) {
            try {
                obj.wait();
            } catch (Exception e) {}
        }    
    }

        public static void staticNotify() {
            synchronized (obj) {
                obj.notify();
            }
        }
    
	public static void leave(){
		Demo.basket--;
		staticNotify();
	}
	public void run () {
            while(Demo.basket > Demo.BASKETS.length-1){
                    System.out.println("No BASKET! NO."+ number +" SEND TO WAITLIST ");
			staticWait();
		}
	    Demo.basket++;		
	    while(step<5) {
	        	
	      	switch(step) {
	            	
	      		case 0:{
	        		System.out.println("No."+number + " Finding BASKET");
	        		
	        		
	        		for(int avalivable=0; avalivable<Demo.BASKETS.length; avalivable++) {
	        			if(Demo.BASKETS[avalivable] == 0) {
	        				Demo.BASKETS[avalivable] = number;
	        				temp2 = avalivable+1;
	        				step++;
                                                
	        				System.out.println("USE NO."+ temp2 + " BASKET");
	        				break;
	        			}
	        			if(avalivable==Demo.BASKETS.length-1)
		        			System.out.println("!!!NO Basket for "+number+"!!!");
	        		}
	 	        	break;
	        	}
	        	case 1:{
                                System.out.println("NO."+ number + " Finding ROOM");
	        		for(int avalivable =0; avalivable<Demo.ROOMS.length; avalivable++) {
	        			if(Demo.ROOMS[avalivable] == 0) {
	        				Demo.ROOMS[avalivable] = number;
	        				temp1 = avalivable+1;
	        				step++;
                                                System.out.println("USE NO."+ temp1 + " ROOM");
	        				break;
	        			}
	        			if(avalivable==Demo.ROOMS.length-1)
	        				System.out.println("!!!NO Room for "+number+"!!!");
	        		}
	        		break;
	        		
	        	}
	        	case 2:{
	        		System.out.println("NO."+number + " SWIMMING");
                                System.out.println("NO."+ temp1 + " ROOM EMPTY");
                                Demo.ROOMS[temp1-1] = 0;
	        		step++;
	        		
	        		break;
	        	}
	        	case 3:{
	        		System.out.println("NO."+number + " Finding ROOM(2ND)");
	        		for(int i=0; i<Demo.ROOMS.length; i++) {
	        			if(Demo.ROOMS[i] == 0) {
	        				//Demo.basket[temp] = 0;
	        				Demo.ROOMS[i] = number;
	        				temp1 = i+1;
	        				step++;
                                                System.out.println("USE NO."+ temp1 + " ROOM");
	        				break;
	        			}
	        			if(i==Demo.ROOMS.length-1)
	        				System.out.println("!!!NO Room for "+number +"!!!");
	        		}
	        		break;
	        	}
	        	case 4:{
	        		System.out.println("NO."+ number + " LEAVE POOL");
                                System.out.println("NO."+ temp1 + " ROOM EMPTY");
                                System.out.println("NO."+ temp2 + " BASKET EMPTY");
	        		Demo.BASKETS[temp2-1] = 0;
	        		step++;
                                //step=1;
	        		Demo.ROOMS[temp1-1] = 0;
	        		leave();
	        		break;
	        	}
	        }
	      	try {
                              Thread.currentThread();
	      		      Thread.sleep(Demo.getPoissonRandom(number+10)*300);
            } 
            catch(InterruptedException e) {
                 e.printStackTrace();
            }
                
	    }
	}
}

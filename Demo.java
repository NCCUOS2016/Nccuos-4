/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;
import java.util.*;
/**
 *
 * @author apple
 */
public class Demo {
    public static int[] cubicle = new int[10];
	public static int[] basket = new int[15];
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String name;
		int number = 0; 
		
		LinkedList<InThread> inThreadList = null;
                printInf();
        while(true) {
        
        	
        	
        	
        	
                Thread.sleep(2000);
        	
                number++;
                InThread inThread = new InThread(number);
        	inThread.start();
        	
        	
        }
    }
	
	public static void printInf() {
		
		System.out.println("淋浴間:");
		for(int b:cubicle) {
			System.out.print(b + " ");	
		}
		System.out.println();
		
		System.out.println("籃子:");
		for(int b:basket) {
			System.out.print(b + " ");	
		}
		System.out.println();
	}
    
}

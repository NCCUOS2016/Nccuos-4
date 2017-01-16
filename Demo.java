/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;
import static java.lang.Math.random;
import java.util.*;
import java.util.Scanner;
/**
 *
 * @author apple
 */
public class Demo {
        public static int[] ROOMS = new int[5];
	public static int[] BASKETS = new int[10];
        public static int basket=0;//public static int num1=4;
        //public static int num2=4;
        
        //public static int num1=4;
	
	
        
	public static void main(String[] args) throws InterruptedException {
                 int num1;
                 int num2;
                 int cu;
		//Scanner scanner = new Scanner(System.in);
                
		java.util.Scanner scanner = new java.util.Scanner(System.in);
                System.out.println("ENTER ROOMS NUMBER:");
                num1 = scanner.nextInt();
                System.out.println("ENTER BASKETS NUMBER:");
                num2 = scanner.nextInt();
                System.out.println("ENTER CUSTOMERS NUMBER:");
                cu   = scanner.nextInt();
               //int num1=7;
               Demo.ROOMS = new int[num1];
               Demo.BASKETS = new int[num2];
                
                 
		String name;
		int number = 0; 
		LinkedList<InThread> inThreadList = null;
                printInf(ROOMS,BASKETS);
        while(true) {
        	
                Thread.sleep(getPoissonRandom(4000));
        	//number=1;
                number++;
                if(number>cu)
                    break;
                InThread inThread = new InThread(number);
        	inThread.start();
                
        	
        	
        }
    }
	
	public static void printInf(int[] ROOMS,int[] BASKETS) {
		
		System.out.println("ROOMS:");
		for(int num:ROOMS) {
			System.out.print(num + " ");	
		}
		System.out.println();
		
		System.out.println("BASKETS:");
		for(int num:BASKETS) {
			System.out.print(num + " ");	
		}
		System.out.println();
	}
public static int getPoissonRandom(double mean) {
    Random r = new Random();
    double L = Math.exp(-mean);
    int k = 0;
    double p = 1.0;
    do {
        p = p * r.nextDouble();
        k++;
    } while (p > L);
    return k - 1;
}

    
}
 
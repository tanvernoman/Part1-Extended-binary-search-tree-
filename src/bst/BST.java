/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;



import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author thnom
 */
public class BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Inserting item in order
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        //Test 1 : Inserting item in tree  between 1 and 100 in order
//        for(int i=0; i<100; i++){
//            bst.add(new Item(i));
//        }
//        
//        
//        bst.BFT();
//        
//       System.out.println(Item.getCompCount()); 
//       System.out.println(bst.height());
       //End Test 1
       //Test 2 : Inserting item in tree between 1 and 100 in random
       Random rnd= new Random();
       
       System.out.println("--------------Inserting Random Integer");
       for(int i =1; i<=100; i++){
           bst.add(new Item(ThreadLocalRandom.current().nextInt(0,100+1)));
       }
       
       bst.BFT();
       System.out.println("Total number of comparison "+Item.getCompCount()); 
       System.out.println(" Tree height "+bst.height());
       System.out.println("Size "+bst.size);
       
       //End test 2 

//       // bst.add(-1);
//        List<Integer> dataSet = new LinkedList<>();
//        Random ran = new Random();
//        System.out.print("Please enter the size of the data set: ");
//        try (Scanner keyboard = new Scanner(System.in)) {
//            int size = keyboard.nextInt();
//            final int N = size*2; // to ensure duplicates generated on most runs
//            System.out.printf("The size of the dataSet for this run is %d \n",
//                    size);
//            int count = 0;
//            while (bst.size() < size) {
//                int candidate = ran.nextInt(N)*2+1;  // add odd values only
//                count++;
//                if (bst.add(candidate)) {
//                    dataSet.add(candidate);
//                }
//            }
//            System.out.printf("Added %d elements from %d random numbers.\n",
//                    size, count);
//            int errorCount = 0;
//            
//            //bst.BFT();
//            System.out.println("Testing contains() method:");
//            for (int d : dataSet) {
//                if (!bst.contains(d)) {
//                    errorCount++;
//                    System.out.printf(
//                            "Error %d: contains(%d) returns false.\n",
//                            errorCount, d);
//                }
//                if (bst.contains((d/2)*2)) { // even number tests for absence
//                    errorCount++;
//                    System.out.printf(
//                            "Error %d: contains(%d) returns true.\n",
//                            errorCount, (d/2)*2);
//                }
//            }
//            System.out.printf("Testing contents complete with %d errors ",
//                    errorCount);
//            System.out.println();
//            
//            
//            System.out.println("Testing enumerator throws an exception " +
//                    "if tree is modified while in use.");
//            try {
//                for (Object i : bst.toArray()) {
//                    bst.add(-1);
//                }
//                errorCount++;
//            }
//            catch (ConcurrentModificationException e) {}
//            System.out.println("Testing exception throwing complete.");
//            System.out.printf( "Errors now %d.\n", errorCount);
//            System.out.println();
//            //bst.BFT();
//            bst.remove(-1);
//            if (bst.size() <= 25) {
//                int counter = 1;
//                System.out.println("Tree contents are:");
//                for (Object i : bst.toArray()) {
//                    System.out.printf("Item number %d is: %d\n", counter++, i);
//                }
//            }
//            System.out.println("Removing tree contents:");
//            count = bst.size();
//            errorCount = 0;
//            for (int d : dataSet) {
//                if (bst.remove(d)) {
//                    count--;
//                    if (count != bst.size()) {
//                        errorCount++;  // tree size was not updated
//                    }
//                }
//                else  { // d was not removed
//                    errorCount++;
//                }
//            }
//            System.out.printf("%d items removed with %d errors.\n", 
//                    size, errorCount);
//            System.out.printf("Tree size = %d\n", bst.size());
//            System.out.println("Any remaining contents listed below:");
//            for (Object i : bst.toArray()) {
//                System.out.println(i);
//            }
//            System.out.println("Testing complete....");
//            
//            
//        }
//
//    }
    }
}

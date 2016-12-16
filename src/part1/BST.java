/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;

import java.util.*;

/**
 *
 * @author thnom
 */
public class BST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.BFT();
        System.out.println(tree.remove(100));
        System.out.println(tree.height());
        System.out.println(tree.contains(200));
        System.out.println(tree.contains(90));
        part1_test(); // Test 
        test2(); // Adding  item in the tree between 1 and 100 in the tree in order
        test3(); // Adding item in the tree between 1 and 100 items in random order 
        test3();
        test3();

        test4(); // Adding item in the tree between 1 and 1000 in order
        test5(); // Adding item in the tree between 1 and 1000 in random order
        test5();
        test5();

        test6(); // Adding item in the tree between 1 and 10000 in order
        test7(); // Adding item in the tree between 1 and 10000 in random order
        test7();
        test7();
        // test8(); // Adding item in the tree between 1 and 100000 in order 
        test9();  // Adding item in the tree between 1 and 100000 in random order
        test9();
        test9();
        test10(); // Adding odd item between 1 and 200 in order
        test11(); // Adding odd item between 1 and 200 in random order 
        test11();
        test11();
        test12(); // Adding odd item betwwen 1 and 2000 in order
        test13(); // Adding odd item between 1 and 2000 in random order
        test13();
        test13();
        test14(); // Adding odd item between 1 and 20000 in order
        test15(); // Adding odd item  between 1 and 20000 in random order
        test15();
        test15();
        // test16(); // Adding odd item between 1 and 200000 in order
        test17(); // Adding odd item  between 1 and 200000 in random order
        test17();
        test17();

    }

    private static void part1_test() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> dataSet = new LinkedList<>();
        Random ran = new Random();
        System.out.print("Please enter the size of the data set: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            int size = keyboard.nextInt();
            final int N = size * 2; // to ensure duplicates generated on most runs
            System.out.printf("The size of the dataSet for this run is %d \n",
                    size);
            int count = 0;
            while (bst.size() < size) {
                int candidate = ran.nextInt(N) * 2 + 1;  // add odd values only
                count++;
                if (bst.add(candidate)) {
                    dataSet.add(candidate);
                }
            }
            System.out.printf("Added %d elements from %d random numbers.\n",
                    size, count);
            int errorCount = 0;
            System.out.println("Testing contains() method:");
            for (int d : dataSet) {
                if (!bst.contains(d)) {
                    errorCount++;
                    System.out.printf(
                            "Error %d: contains(%d) returns false.\n",
                            errorCount, d);
                }
                if (bst.contains((d / 2) * 2)) { // even number tests for absence
                    errorCount++;
                    System.out.printf(
                            "Error %d: contains(%d) returns true.\n",
                            errorCount, (d / 2) * 2);
                }
            }
            System.out.printf("Testing contents complete with %d errors ",
                    errorCount);
            System.out.println();
            System.out.println("Testing enumerator throws an exception "
                    + "if tree is modified while in use.");
            try {
                for (int i : bst) {
                    bst.add(-1);
                }
                errorCount++;
            } catch (ConcurrentModificationException e) {
            }
            System.out.println("Testing exception throwing complete.");
            System.out.printf("Errors now %d.\n", errorCount);
            System.out.println();
            bst.remove(-1);
            if (bst.size() <= 25) {
                int counter = 1;
                System.out.println("Tree contents are:");
                for (int i : bst) {
                    System.out.printf("Item number %d is: %d\n", counter++, i);
                }
            }
            System.out.println("Removing tree contents:");
            count = bst.size();
            errorCount = 0;
            for (int d : dataSet) {
                if (bst.remove(d)) {
                    count--;
                    if (count != bst.size()) {
                        errorCount++;  // tree size was not updated
                    }
                } else { // d was not removed
                    errorCount++;
                }
            }
            System.out.printf("%d items removed with %d errors.\n",
                    size, errorCount);
            System.out.printf("Tree size = %d\n", bst.size());
            System.out.println("Any remaining contents listed below:");
            for (int i : bst) {
                System.out.println(i);
            }
            System.out.println("Testing complete....");

        }

    }

    private static void test2() {
        //Adding 1 .. 100 items in the tree in that order 

        System.out.println("--------------------- Testing 2 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 100; i++) {
            bst.add(new Item(i));
        }
        bst.BFT();
        Item.resetCompCount();

        for (int i = 0; i <= 100; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of comaprison " + Item.getCompCount());

        bst.removeAll();
        System.out.println("Size " + bst.size());
        bst.BFT();
        System.out.println("\n");

    }

    private static void test3() {
        // Inserting item in tree between 1 and 100 in random

        System.out.println("-------------Test 3 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        while (bst.size() != 100) {
            bst.add(new Item(rnd.nextInt(100 - 1 + 1)));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 100; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size);
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }

    private static void test4() {
        //Adding 1 .. 1000 items in the tree in that order 

        System.out.println("--------------------- Testing 4 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 1000; i++) {
            bst.add(new Item(i));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 1000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println("Size " + bst.size);
        System.out.println("Number of comaprison " + Item.getCompCount());
    }

    private static void test5() {
        // Inserting item in tree between 1 and 1000 in random
        System.out.println("-------------Test 5 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        while (bst.size() != 1000) {
            bst.add(new Item(rnd.nextInt(1000 - 1 + 1)));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 1000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }

    private static void test6() {
        // Adding item between 1 and 10000 in order

        System.out.println("--------------------- Testing 6 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 10000; i++) {
            bst.add(new Item(i));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 10000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println(" Size " + bst.size());
        System.out.println(" Number of comaprison " + Item.getCompCount());
    }

    private static void test7() {
        // Adding item between 1 and 10000 in random order

        System.out.println("-------------Test 7 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        while (bst.size() != 10000) {
            bst.add(new Item(rnd.nextInt(10000 - 1 + 1)));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 10000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());

    }

    private static void test8() {
        // Adding item between 1 and 100000 in order
        System.out.println("--------------------- Testing 8 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 100000; i++) {
            bst.add(new Item(i));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 100000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        // System.out.println("Tree Height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of comaprison " + Item.getCompCount());
    }

    private static void test9() {
        // Adding item between 1 and 100000 in random order

        System.out.println("-------------Test 9 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        while (bst.size() != 100000) {
            bst.add(new Item(rnd.nextInt(100000 - 1 + 1)));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 0; i <= 100000; i++) {
            bst.contains(new Item(i));
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());

    }

    private static void test10() {
        //Adding odd item in the tree between 1 and 200 in order 

        System.out.println("--------------------- Testing 10 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 1) {
                bst.add(new Item(i));
            }
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of comaprison " + Item.getCompCount());

    }

    private static void test11() {
        // Adding odd item in the tree between 1 and 200 in random order
        System.out.println("-------------Test 11 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        final int N = 100; // to ensure duplicates generated on most runs

        while (bst.size() != 100) {
            int candidate = rnd.nextInt(N) * 2 + 1;  // add odd values only
            bst.add(new Item(candidate));
        }
        bst.BFT();

        Item.resetCompCount();
        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }

        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }

    private static void test12() {
        //Adding odd item in the tree between 1 and 2000 in order
        System.out.println("--------------Testing 12 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 2000; i++) {
            if (i % 2 == 1) {
                bst.add(new Item(i));
            }
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 2000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println(" Size " + bst.size());
        System.out.println(" Number of comaprison " + Item.getCompCount());
    }

    private static void test13() {
        // Inserting odd item in the tree between 1 and 2000 in random order
        System.out.println("-------------Test 13 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        final int N = 1000; // to ensure duplicates generated on most runs

        while (bst.size() != 1000) {
            int candidate = rnd.nextInt(N) * 2 + 1;  // add odd values only
            bst.add(new Item(candidate));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 2000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }

    private static void test14() {
        //Adding odd item in the tree between 1 and 20000 in order
        System.out.println("--------------Testing 14 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 20000; i++) {
            if (i % 2 == 1) {
                bst.add(new Item(i));
            }
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 20000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree Height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of comaprison " + Item.getCompCount());
    }

    private static void test15() {
        // Inserting odd item in the tree between 1 and 2000 in random order

        System.out.println("-------------Test 15 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        final int N = 10000;

        while (bst.size() != 10000) {
            int candidate = rnd.nextInt(N) * 2 + 1;
            bst.add(new Item(candidate));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 20000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }

    private static void test16() {
        //Adding odd item in the tree between 1 and 20000 in order
        System.out.println("--------------Testing 16 -----------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        for (int i = 1; i <= 200000; i++) {
            if (i % 2 == 1) {
                bst.add(new Item(i));
            }
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 200000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        // System.out.println("Tree Height " + bst.height());
        System.out.println(" Size " + bst.size());
        System.out.println(" Number of comaprison " + Item.getCompCount());
    }

    private static void test17() {
        // Inserting odd item in the tree between 1 and 2000 in random order
        System.out.println("-------------Test 17 ----------------");
        BinarySearchTree<Item> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        final int N = 100000; // to ensure duplicates generated on most runs

        while (bst.size() != 100000) {
            int candidate = rnd.nextInt(N) * 2 + 1;  // add odd values only
            bst.add(new Item(candidate));
        }
        bst.BFT();
        Item.resetCompCount();
        for (int i = 1; i <= 200000; i++) {
            if (i % 2 == 0) {
                bst.contains(new Item(i));
            }
        }
        System.out.println("\n");
        System.out.println("Tree height " + bst.height());
        System.out.println("Size " + bst.size());
        System.out.println("Number of Comparisons " + Item.getCompCount());
    }
}

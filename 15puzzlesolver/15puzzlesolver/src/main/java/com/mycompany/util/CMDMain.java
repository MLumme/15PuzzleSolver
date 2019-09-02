
package com.mycompany.util;

import com.mycompany.domain.PuzzleState;
import com.mycompany.domain.Solver;
import com.mycompany.structs.Pair;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 *
 */
public class CMDMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter out = null;
        
        System.out.println("Give output file");       
        while (true) {
            String outFile = scanner.nextLine();
            try {
                out = new FileWriter(new File(outFile));
                break;
            } catch (IOException ex) {
                System.out.println("Error opening file, try again:");
            }
        }

        int size = 0;
        int repeats = 0;
        int maxDepth = 0;
        int algo = 0;
        
        System.out.println("Give edge length of the puzzle");
        while (true) {
            try {
                size = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Unable to parse, try again");
            }
        }
        
        System.out.println("Give number of repeats for sampling");
        while (true) {
            try {
                repeats = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Unable to parse, try again");
            }
        }
        
        System.out.println("Give targeted maximum depth for comparison");
        while (true) {
            try {
                maxDepth = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Unable to parse, try again");
            }
        }
        
        System.out.println("Give wanted algorithm, 1 for IDA*, 2 for IDDFS");
        while (true) {
            try {
                algo = Integer.parseInt(scanner.nextLine());
                
                if (algo != 1 & algo != 2) {
                    System.out.println("unacceptable choice, try again");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Unable to parse, try again");
            }
        }
            
        Pair<Integer, Double>[] pairs = new Pair[maxDepth]; 
        
        for (int i = 1; i <= maxDepth; i++) {
            
            int counter = 0;
            Double average = 0.0;
            
            while (counter < repeats) {                
                PuzzleState init = PuzzleGen.generate(size * size, i);
  
                //PuzzleState init = new PuzzleState(createKnownDistance(size, i));
                             
                if (init.getManhattanHeuristic() == 0) {
                    continue;
                }
                
                Pair<Long, PuzzleState[]> res = Solver.solve(init, algo);

                if (res.getValue().length == i + 1) {
                    average += res.getKey();
                    counter++;
                }
            }
            
            average /= counter;
            
            pairs[i - 1] = new Pair(i, average);
        }
        
        try {
            for (Pair<Integer, Double> pair : pairs) {
                out.write(pair.getKey() + "\t" + pair.getValue() + "\n");
            }
            
            out.close();
            
            System.out.println("Done");
        } catch (IOException ex) {                
            System.out.println("error writing to file");
        }
    }

    private static int[] createKnownDistance(int size, int dist) {
        int[] board = new int[size * size];
        int empty = board.length - 1;
        
        board[empty] = 0;
        
        for (int i = 0; i < empty; i++) {
            board[i] = i + 1;
        }
        
        for (int i = 0; i < dist; i++) {            
            if (i % 2 == 0) {
                swap(board, empty, empty - size);
                empty -= size;
            } else {
                swap(board, empty, empty - 1);
                empty--;
            }            
        }
        
        return board;
    }
    
    private static void swap(int[] board, int first, int second) {
        int temp = board[first];
        board[first] = board[second];
        board[second] = temp;
    }
}

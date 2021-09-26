import java.util.*;
import java.io.*;

public class nasir_p2 {
    private static String X1 = "L";
    private static String X2 = "L";
    private static String X3 = "L";
    private static String X4 = "L";
    
    public static void processInput(String input) {
        String out = "B";
        if (X1.equals("L")) {
            if (X2.equals("L")) {
                out = "B";
                X2 = "R";
            }
            else if (X2.equals("R")) {
                out = "C";
                X2 = "L";
            }
        }
        else if (X1.equals("C")) {
            if (X3.equals("L")) {
                out = "C";
                X3 = "R";
            }
            else if (X3.equals("R")) {
                out = "D";
                X3 = "L";
            }
        }
        else if (X1.equals("R")) {
            if (X4.equals("L")) {
                out = "D";
                X4 = "R";
            }
            else if (X4.equals("R")) {
                out = "E";
                X4 = "L";
            }
        }

        // Toggle gate X1
        if (input.charAt(0) == '0') {
            if (X1.equals("L")) {X1 = "R";}
            else if (X1.equals("R")) {X1 = "C";}
            else if (X1.equals("C")) {X1 = "L";}
        }
        else if (input.charAt(0) == '1') {
            if (X1.equals("L")) {X1 = "C";}
            else if (X1.equals("C")) {X1 = "R";}
            else if (X1.equals("R")) {X1 = "L";}
        }
        
        System.out.print("->" + X1 + X2 + X3 + X4);
        input = input.substring(1);
        if (input.length() <= 0) {
            System.out.println(" " + out);
            return;
        }
        processInput(input);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Error: Not enough args provided!");
            System.exit(1);
        }
        if (args[0].length() < 4) {
            System.out.println("Error: Initial gate configuration not provided!");
            System.exit(1);
        }
        X1 = args[0].substring(0,1);
        X2 = args[0].substring(1,2);
        X3 = args[0].substring(2,3);
        X4 = args[0].substring(3,4);
        System.out.print(X1 + X2 + X3 + X4);
        processInput(args[1]);
    }
}
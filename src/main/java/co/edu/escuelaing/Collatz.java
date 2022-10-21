package co.edu.escuelaing;

import java.util.ArrayList;
import java.util.List;

public class Collatz {
    static List<Integer> seq = new ArrayList<>();
    static int num = 0;

    static String resp="";
    public static String calculate(int input){
        System.out.println(input);
        resp = String.valueOf(input);
        while (input > 1) {
            if (input%2 == 0) {
                num = input/2;
            } else {
                num = input*3+1;
            }
            seq.add(num);
            input = num;
            resp += "->"+num;
            System.out.println(num);
        }
        System.out.println(resp);
        return resp;
    }
}

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.*;

class Array01MinLength{
    public static int minlen(int[] A, int[] B, int len){
        int minIdx = -1;
        int maxIdx = -1;
        for(int i =0; i< len; i++){
            if(A[i] != B[i]){
                if(minIdx == -1){
                    minIdx = i;
                }
                if(maxIdx < i){
                    maxIdx = i;
                }
            }
        }
        return maxIdx-minIdx+1;
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i =0; i< T; i++){
            int N = s.nextInt();
            int [] A = new int[N];
            int [] B = new int[N];
            for(int j = 0; j<N; j++){
                A[j] = s.nextInt();
            }
            for(int j = 0; j<N; j++){
                B[j] = s.nextInt();
            }

            int res = minlen(A, B, N);
            System.out.println(res);
        }

        
        

        // Write your code here

    }
}

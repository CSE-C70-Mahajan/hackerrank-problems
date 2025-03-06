import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int start = Integer.parseInt(br.readLine().trim());
         int finish = Integer.parseInt(br.readLine().trim());
         String[] arr_Ticket_cost = br.readLine().split(" ");
         int[] Ticket_cost = new int[N];
         for(int i_Ticket_cost = 0; i_Ticket_cost < arr_Ticket_cost.length; i_Ticket_cost++)
         {
         	Ticket_cost[i_Ticket_cost] = Integer.parseInt(arr_Ticket_cost[i_Ticket_cost]);
         }

         long out_ = solve(N, start, finish, Ticket_cost);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static long solve(int N, int start, int finish, int[] Ticket_cost){
       // Write your code here
        long result1 = 0;
        long result2 = 0;
        int i = start -1;

        do{
            if(i == N){
                i = 0;
            }
            if(i == finish -1){
                break;
            }
            result1 += Ticket_cost[i];
            i++;
        }while(i != start -1);

        i = start -1;
        do{
            if(i == 0){
                i = N-1;
            }
            if(i != start -1){

                result2 += Ticket_cost[i];
                }
            if(i == finish-1){
                break;
            }
            
            i--;
        }while(i != start - 1);
        if(result1 <= result2){
            return result1;
        }else{
            return result2;
        }
    
    }
}
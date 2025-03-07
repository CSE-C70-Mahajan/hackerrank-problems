package Arrays;
import java.io.*;

public class Array03ArrayQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());
            
            int[] A = new int[N];
            String[] arr_A = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(arr_A[i]);
            }
            
            int[] B = new int[M];
            String[] arr_B = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(arr_B[i]);
            }
            
            int Q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[Q][3];
            for (int i = 0; i < Q; i++) {
                String[] arr_queries = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    queries[i][j] = Integer.parseInt(arr_queries[j]);
                }
            }

            int[] out_ = array_queries(N, M, A, B, Q, queries);
            System.out.print(out_[0]);
            for (int i = 1; i < out_.length; i++) {
                System.out.print(" " + out_[i]);
            }
            System.out.println();
        }

        wr.close();
        br.close();
    }

    static long f(int[] A, int[] B, int N, int M) {
        long total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                total += (long) A[i] * B[j] * (i + 1 + j + 1); 
            }
        }
        return total % 998244353;
    }

    static void implement_query(int[] query, int[] A, int[] B) {
        int type = query[0], x = query[1] - 1, y = query[2] - 1; 

        if (type == 1) { 
            if (x >= 0 && x < A.length && y >= 0 && y < B.length) {
                int temp = A[x];
                A[x] = B[y];
                B[y] = temp;
            }
        } else if (type == 2) { 
            if (x >= 0 && x < A.length && y >= 0 && y < A.length) {
                int temp = A[x];
                A[x] = A[y];
                A[y] = temp;
            }
        } else if (type == 3) { 
            if (x >= 0 && x < B.length && y >= 0 && y < B.length) {
                int temp = B[x];
                B[x] = B[y];
                B[y] = temp;
            }
        }
    }

    static int[] array_queries(int N, int M, int[] A, int[] B, int Q, int[][] queries) {
        int[] result = new int[Q + 1];
        result[0] = (int) f(A, B, N, M);

        for (int i = 0; i < Q; i++) {
            implement_query(queries[i], A, B);
            result[i + 1] = (int) f(A, B, N, M);
        }

        return result;
    }
}

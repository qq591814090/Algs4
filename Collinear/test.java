import java.util.*;
import java.io.*;
import java.lang.*;
 
public class test {
 
    public static void main(String[] args) {
         {  
            String filename = args[0];
            In in = new In(filename);
            int N = in.readInt();
            //System.out.println(N);
 
            Point[] points = new Point[N];
            int[][] base_points = new int[N][2];
            //StdDraw.setXscale(0, 32768);
            //StdDraw.setYscale(0, 32768);
 
            //String testline = " 10000      0";
            //Scanner s = new Scanner(testline);
            //StdOut.println(s.nextInt());
            //StdOut.println(s.nextInt());
            for( int i = 0; i < N; i++) {
                 
                base_points[i][0] = in.readInt();
                base_points[i][1] = in.readInt();
                 
 
                points[i] =new Point(base_points[i][0],base_points[i][1]);
                 
                System.out.println(base_points[i][0]);
                System.out.println(base_points[i][1]);  
            }
 
            Arrays.sort(points);
            System.out.println(N);
 
            for (int i = 0; i < N ; i++) {
                System.out.println(points[i]);
            }
 
         
        }
    }
}

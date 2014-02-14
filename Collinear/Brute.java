import java.util.*;
import java.io.*;
import java.lang.*;
 
public class Brute {
 
    public static void main(String[] args) {
        {
            String filename = args[0];
            In in = new In(filename);
            int N = in.readInt();
            //System.out.println(N);
 
            Point[] points = new Point[N];
            int[][] base_points = new int[N][2];
            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
 
            //String testline = " 10000      0";
            //Scanner s = new Scanner(testline);
            //StdOut.println(s.nextInt());
            //StdOut.println(s.nextInt());
            for( int i = 0; i < N; i++) {
                 
                base_points[i][0] = in.readInt();
                base_points[i][1] = in.readInt();
                 
                points[i] =new Point(base_points[i][0],base_points[i][1]);
                points[i].draw();
            }
 
            //System.out.println(N);
 
            //for (int i = 0; i < N ; i++) {
            //  System.out.println(points[i]);
            //}
            Point[] line = new Point[4];
            Point temp_max = new Point(0,0);
            Point temp_min = new Point(0,0);
 
            for (int i = 0; i < N -3; i++) {
                for (int j = i + 1; j< N -2; j ++){
                    for ( int k = j + 1; k < N -1; k++) {
                        for ( int p =  k + 1; p < N; p ++){
                            if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[k]) && points[j].slopeTo(points[k]) == points[k].slopeTo(points[p])) {
                                line[0] = points[i].compareTo(points[j]) <= 0 ? points[i]: points[j];
                                line[1] = points[k].compareTo(points[p]) <= 0 ? points[k]: points[p];
                                temp_max = line[0].compareTo(line[1]) > 0 ? line[0]: line[1];
                                temp_min = line[0].compareTo(line[1]) <= 0 ? line[0]: line[1];
 
                                line[0] = temp_min;
                                line[1] = temp_max;
 
                                line[2] = points[i].compareTo(points[j]) > 0 ? points[i]: points[j];
                                line[3] = points[k].compareTo(points[p]) > 0 ? points[k]: points[p];
                                temp_max = line[2].compareTo(line[3]) > 0 ? line[2]: line[3];
                                temp_min = line[2].compareTo(line[3]) <= 0 ? line[2]: line[3];
 
                                line[2] = temp_min;
                                line[3] = temp_max;
 
 
                                temp_max = line[1].compareTo(line[2]) > 0 ? line[1]: line[2];
                                temp_min = line[1].compareTo(line[2]) <= 0 ? line[1]: line[2];
 
                                line[1] = temp_min;
                                line[2] = temp_max;
 
                                line[0].drawTo(line[3]);
                                //line[1].drawTo(line[2]);
                                //line[2].drawTo(line[3]);
                                StdOut.println(line[0]+" -> "+ line[1] +" -> "+ line[2] +" -> "+ line[3]);
                            }
                        }
                    }
                }
            }
            StdDraw.show(0);        
        }
    }
}

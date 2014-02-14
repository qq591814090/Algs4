import java.util.*;
import java.io.*;
import java.lang.*;
 
public class Fast {
    public static void main(String[] args) {
        {
            String filename = args[0];
            In in = new In(filename);
            int N = in.readInt();
 
            Point[] points = new Point[N];
            int[][] base_points = new int[N][2];
            StdDraw.setXscale(0, 32768);
            StdDraw.setYscale(0, 32768);
 
            for (int i = 0; i < N; i++) {
                 
                base_points[i][0] = in.readInt();
                base_points[i][1] = in.readInt();
                 
                points[i] =new Point(base_points[i][0],base_points[i][1]);
                points[i].draw();
             
            }
 
            for (int i = 0; i < N -3; i++) {
                for ( int k = 0; k< N; k++) {
                    points[k] = new Point(base_points[k][0],base_points[k][1]);
                }
                Arrays.sort(points,i + 1, N, points[i].SLOPE_ORDER);
 
                for (int j = i + 1  ; j < N - 2; j ++){
                    if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[j+1]) && points[i].slopeTo(points[j+1]) == points[i].slopeTo(points[j+2])) {
                        String result = points[i]+" -> "+ points[j] +" -> "+ points[j+1] +" -> "+ points[j+2];
                        points[i].drawTo(points[j]);
                        points[j].drawTo(points[j+1]);
                        points[j+1].drawTo(points[j+2]);
                        for (int y = j + 3; y < N ; y++) {
                            if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[y])) {
                                points[j+2].drawTo(points[y]);
                                result +=  " -> "+ points[y];
                            } else {
                                j = y - 1;
                                break;
                            }
                        }
                        StdDraw.show(0);
                        StdOut.println(result);
                    }
                }   
            }
         
        }
    }
}

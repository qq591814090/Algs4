/*************************************************************************
 * Name: Di Liu
 * Email:liudi1990@gmail.com
 *  
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/
 
import java.util.Comparator;
import java.util.Arrays;
 
public class Point implements Comparable<Point> {
 
    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        public int compare(Point p1, Point p2){ 
            double flag = Point.this.slopeTo(p1) - Point.this.slopeTo(p2);
            if (Point.this.slopeTo(p1) == Point.this.slopeTo(p2)) {
                return p1.compareTo(p2);
            }
            return flag > 0 ? 1 : -1;
        }
 
    };       // YOUR DEFINITION HERE
 
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
 
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }
 
    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }
 
    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }
 
    // slope between this point and that point
    public double slopeTo(Point that) {
        if (this.x == that.x) {
            return that.y != this.y ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        } else if (that.y == this.y) {
            return +0.0; 
        } else {
            return (double)(that.y - this.y) / (that.x - this.x);
        }
 
    }
 
    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if(this.y != that.y) {
            return this.y > that.y ? 1 : -1;
        } else {
            return this.x > that.x ? 1 : (this.x == that.x ? 0 : -1);
        }
         
    }
 
    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
 
    // unit test
    public static void main(String[] args) {
        //Point[] points = new Point[4];
        //points[0] = new Point(3,2);
        //points[1] = new Point(1,4);
        //points[2] = new Point(5,7);
        //points[3] = new Point(1,3);
        //Point refPoint = points[2];
        //StdOut.println("Sorted by slope to: " + refPoint);
        //Arrays.sort(points, refPoint.SLOPE_ORDER);
 
        //for ( Point p : points) {
        //   System.out.println("This is the point: "+ p +" And its slope is "+ refPoint.slopeTo(p));
        //}
    }
}

public class PercolationStats {
    private double[] exp;
    
    public PercolationStats(int N, int T)  { // perform T independent computational experiments on an N-by-N grid
         Percolation p;
          if( N < 1|| T < 1 ) {
           throw new IllegalArgumentException(" out of bounds"); 
       }    
        exp = new double[T];
        int i = 0;
        int j = 0;
       
        for(int k = 0 ; k < T; k++ ) {
             p =new Percolation(N);
            int left = 0;
                   while(!p.percolates()) {
                   i = StdRandom.uniform(0,N) +1;
                   j = StdRandom.uniform(0,N) +1;
                   if(!p.isOpen(i,j)) {
                       p.open(i,j);
                       left++;
                   }
               }
               exp[k] = (double)left/N/N;
               }
    }
                           
    public double mean() {                    // sample mean of percolation threshold
         double sum = 0;
        for( int i =0;i<exp.length;i++) {
            sum += exp[i];
        }
        return sum/exp.length;
    }
    
    public double stddev() {                  // sample standard deviation of percolation threshold
        double sum = 0;
        for( int i =0;i<exp.length;i++) {
            sum += (exp[i]-mean())*(exp[i]-mean());
        }
        if (exp.length ==1 ) return Double.NaN;
        return Math.sqrt(sum/(exp.length-1));
    }
        
    public double confidenceLo() {            // returns lower bound of the 95% confidence interval
        return mean()-1.96*stddev()/Math.sqrt(exp.length);
    }
    public double confidenceHi()  {           // returns upper bound of the 95% confidence interval
              return mean()+1.96*stddev()/Math.sqrt(exp.length);
    }
    public static void main(String[] args) {  // test client, described below
       int N = Integer.parseInt(args[0]);
       int T = Integer.parseInt(args[1]);
             
        PercolationStats test = new PercolationStats(N,T);
        System.out.printf("%-24s= %f\n","mean",test.mean());
        System.out.printf("%-24s= %f\n","stddev",test.stddev());
     // System.out.printf("%-24s= %f\n","stddev",test.stddev());
        System.out.printf("%-24s= %f , %f\n","95% confidence interval",test.confidenceLo(),test.confidenceHi());
       }
}
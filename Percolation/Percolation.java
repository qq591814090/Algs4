public class Percolation {
    
    private byte[] state;
    private int size; 
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uff;
    public Percolation(int N) {             // create N-by-N grid, with all sites blocked
        uf = new WeightedQuickUnionUF(N * N + 2);
        uff = new WeightedQuickUnionUF(N * N + 1);
        state = new byte[ N * N + 2 ];
        size = N;
        for (int i = 0; i < N * N; i++) {
            state[ i ] = 0;
        }
        state[ N * N ] = 1;
        state[ N * N + 1] = 1;
    }
    
    private int xyto1D(int i, int j) {
        if (i < 1 || i > size || j < 1 || j > size) throw new IndexOutOfBoundsException();
        return (i-1)*size+j-1;
    }
    
    public void open(int i, int j) {        // open site (row i, column j) if it is not already
        state[xyto1D(i, j)] = 1;
        if (i == 1) {
            uf.union(xyto1D(i, j), size*size);
            uff.union(xyto1D(i, j), size*size);
        } else
        { 
            if (isOpen(i-1, j)) {
                uf.union(xyto1D(i, j), xyto1D(i-1, j));
                uff.union(xyto1D(i, j), xyto1D(i-1, j));
            }
        }
            if (i == size) {
            uf.union(xyto1D(i, j), size*size + 1);
        } else
        { 
            if (isOpen(i+1, j)) {
                uf.union(xyto1D(i, j), xyto1D(i+1, j));
                uff.union(xyto1D(i, j), xyto1D(i+1, j));

            }
        }
        if (j != size) {
            if (isOpen(i, j+1)) {
                uf.union(xyto1D(i, j), xyto1D(i, j + 1));
                uff.union(xyto1D(i, j), xyto1D(i, j + 1));
            }
        }
        if (j != 1) {
            if (isOpen(i, j-1)) {
                uf.union(xyto1D(i, j), xyto1D(i, j - 1));
                uff.union(xyto1D(i, j), xyto1D(i, j - 1));
            }
        }
    }
        
    public boolean isOpen(int i, int j) {   // is site (row i, column j) open?
        return (state[xyto1D(i, j)] == 1);
    }
           
    public boolean isFull(int i, int j) {   // is site (row i, column j) full?
        return uff.connected(xyto1D(i, j), size*size) && (isOpen(i, j));
    }
    
    public boolean percolates() {           // does the system percolate?
      return uf.connected(size*size, size*size+1);
    }     
}
class Solution {
    public long coloredCells(int n) {
        long c = n;
        return 2*c*c-2*c+1L;
    }
}
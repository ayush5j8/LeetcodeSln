class Solution {
    public int numberOfSpecialChars(String word) {
        int [] count = new int[128];
        for(int i = 0;i<word.length();i++)
        {
            int idx = (int)word.charAt(i);
            count[idx]++;
        }

        int spl = 0;
        for(int i=65;i<=90;i++)
        if(count[i] !=0 && count[(i+32)]!=0)
        spl++;

        return spl;
    }
}
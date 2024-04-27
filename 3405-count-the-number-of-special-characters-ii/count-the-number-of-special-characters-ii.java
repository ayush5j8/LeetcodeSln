class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;

for (char ch = 'A'; ch <= 'Z'; ch++) {
    char lowerCase = (char) (ch + 32);
    if (word.indexOf(lowerCase) != -1 && word.lastIndexOf(lowerCase) < word.indexOf(ch)) {
        count++;
    }
}

return count;
    }
}
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
  String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int n1 = words1.length;         //for smaller one
        int n2 = words2.length;         //for larger one
        if(words1.length== words2.length){
            return sentence1.equals(sentence2);
        }
        if (n1 > n2)
            return areSentencesSimilar(sentence2, sentence1);

        int i = 0; // words1's index
        while (i < n1 && words1[i].equals(words2[i]))
            ++i;
        while (i < n1 && words1[i].equals(words2[i + n2 - n1]))
            ++i;

        return i == n1;
}
}
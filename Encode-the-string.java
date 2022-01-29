// Q.  You are given a string ‘S’ of length ‘N’. The string can be encoded using the following rules:
//     1) If the ‘i-th’ character is a vowel, change it to the next character in the alphabetical sequence. For example, the next character of ‘o’ is ‘p’.
//     2) If the ‘i-th’ character is a consonant, change it to the previous character in the alphabetical sequence. For example, the previous character of ‘h’ is ‘g’.
//     3) The next character of ‘z’ is ‘a’.
//     4) The previous character of ‘a’ is ‘z’.
//     Find the encoded string.
  
// Example :
// ‘N’ = 4, ‘S’ = “code”
// Character ‘c’ gets changed to ‘b’.
// Character ‘o’ gets changed to ‘p’.
// Character ‘d’ gets changed to ‘c’.
// Character ‘e’ gets changed to ‘f’.

// Encoded string = “bpcf”

// Code:

TIME COMPLEXITY = O(n)
SPACE COMPLEXITY = O(n)

public static String encodeString(int n, String s) {
      char[] ch = s.toCharArray();
      int i = 0;
      while(i < ch.length){
          if(ch[i]=='a' || ch[i] =='e' ||ch[i] == 'i' ||ch[i]=='o'||ch[i]=='u'){
              ch[i] = (char) (ch[i]+1);
          }else{
              ch[i] = (char) (ch[i]-1);
          }
          i++;
      }
      return String.valueOf(ch);
    }

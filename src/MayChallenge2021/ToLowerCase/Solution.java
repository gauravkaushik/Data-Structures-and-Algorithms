package MayChallenge2021.ToLowerCase;

// @author : Gaurav Kaushik
// Leetcode : https://leetcode.com/kaushikgaurav08/
// LinkedIn : https://www.linkedin.com/in/gvk28/
// GitHub : https://github.com/gauravkaushik
// ProblemLink : https://leetcode.com/problems/to-lower-case/

class Solution {
  public String toLowerCase(String s) {
    StringBuilder sbr = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= 'A' && c <= 'Z') {
        c = (char) (c + 'a' - 'A');
      }
      sbr.append(c);
    }
    return sbr.toString();
  }
}

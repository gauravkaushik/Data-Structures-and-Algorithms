package MayChallenge2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Gaurav Kaushik
 * @Leetcode : https://leetcode.com/kaushikgaurav08/
 * @LinkedIn : https://www.linkedin.com/in/gvk28/
 * @GitHub : https://github.com/gauravkaushik
 * @ProblemLink : https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
  public List<String> findAndReplacePattern(String[] words, String pattern) {

    List<String> result = new ArrayList<>();

    String transformedPattern = transformString(pattern);
    // System.out.println("Pattern " + pattern + " -> " + transformedPattern);

    for (String word : words) {
      String transformedWord = transformString(word);
      // System.out.println("Word " + word + " -> " + transformedWord);
      if (transformedWord.equals(transformedPattern)) {
        result.add(word);
      }
    }
    return result;
  }

  String transformString(String str) {
    char[] charMp = new char[26];
    Arrays.fill(charMp, '0');
    boolean[] usedChar = new boolean[26];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      char curChar = str.charAt(i);
      char targetChar = charMp[curChar - 'a'];
      if (targetChar == '0') {
        int j = 0;
        while (usedChar[j]) {
          j++;
        }
        usedChar[j] = true;
        targetChar = (char) (j + 'a');
        charMp[curChar - 'a'] = targetChar;
      }

      sb.append(targetChar);
    }
    return sb.toString();
  }
}

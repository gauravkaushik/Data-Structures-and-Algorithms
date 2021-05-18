package MayChallenge2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @author :
 Gaurav Kaushik
 https://leetcode.com/kaushikgaurav08/
 https://www.linkedin.com/in/gvk28/
 https://github.com/gauravkaushik

 https://leetcode.com/problems/find-duplicate-file-in-system/

 */

public class FindDuplicateFileInSystem {

  /*
  Let N : number of files (including duplicates)
  Time Complexity :
  build hashmap : O(N)
  iterate over all hashmap entries once to create result : O(N)
  So, total : O(N)

  Space Complexity : O(N) to store the hashmap
  */
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> mp = new HashMap<>();

    for (String path : paths) {
      String[] tokens = path.split(" ");
      String rootDir = tokens[0];
      for (int i = 1; i < tokens.length; i++) {
        int contentStartIdx = tokens[i].indexOf("(");
        int contentEndIdx = tokens[i].indexOf(")");
        String fileName = tokens[i].substring(0, contentStartIdx);
        String fileContent = tokens[i].substring(contentStartIdx + 1, contentEndIdx);
        String filePath = rootDir + "/" + fileName;
        if (!mp.containsKey(fileContent)) {
          mp.put(fileContent, new ArrayList<String>());
        }
        List<String> files = mp.get(fileContent);
        files.add(filePath);
      }
    }

    List<List<String>> result = new ArrayList<>();
    for (String fileContent : mp.keySet()) {
      List<String> filePaths = mp.get(fileContent);
      if (filePaths.size() > 1) {
        result.add(filePaths);
      }
    }

    return result;
  }
}

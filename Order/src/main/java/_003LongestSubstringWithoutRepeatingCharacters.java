import constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : glw
 * @date : 2020/10/12
 * @time : 22:49
 * @Description :
 * 3. 无重复字符的最长子串
 */
public class _003LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int len = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            len = Math.max(len, i - j + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.print(Constant.MY_ANSWER);
        System.out.println(lengthOfLongestSubstring(s1));
    }
}

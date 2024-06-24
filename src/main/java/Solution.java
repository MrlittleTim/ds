/**
 * @author tim
 * @date 2024/6/21
 */

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param operators string字符串二维数组 the ops
     * @return string字符串一维数组
     */
    TrieNode root;

    class TrieNode {
        int pass;
        int end;
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    public Solution() {
        root = new TrieNode();
    }

    public String[] trieU(String[][] operators) {
        // write code here
        int n = operators.length;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = operators[i][1];
            switch (operators[i][0]) {
                case "1":
                    insert(word);
                    break;
                case "2":
                    delete(word);
                    break;
                case "3":
                    boolean search = search(word);
                    ans.add(search ? "YES" : "NO");
                    break;
                case "4":
                    ans.add(String.valueOf(prefixNumber(word)));
                    break;
            }
        }
        return ans.toArray(new String[0]);
    }

    void insert(String word) {

    }

    void delete(String word) {

    }

    boolean search(String word) {
        return false;
    }

    int prefixNumber(String pre) {
        return 0;
    }
}
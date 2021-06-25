package remaining200_gt.medium;

import jdk.internal.icu.impl.Trie;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 
 * 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，
则返回 true ；否则，返回  false 。
word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 */

 //类似208题，用一个字典树
class WordDictionary {

    class Trie{
        private boolean isEnd;
        Trie[] next;
        public Trie(){
            isEnd = false;
            next = new Trie[26];
        }
    }
    private Trie root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.next[index] == null){
                curr.next[index] = new Trie();
                
            }
            curr = curr.next[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root);  
    }

    public boolean searchHelper(String word,Trie root){
        //其实这里word.length()就是边界条件，
        //即使匹配字符串全是'.'，也会在最后substring得到一个长度为0的子串
        //从而达到边界条件递归回去
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if(temp == '.'){
                //因为'.'匹配所有字母，所以要依次遍历26个字母
                for (int j = 0; j < 26; j++) {
                    if(root.next[j] != null){
                        //如果有一个对应的字母找到匹配字符串，那么就是true 
                        if(searchHelper(word.substring(i+1), root.next[j])){
                            return true;
                        }
                    }
                }
                //此时递归没有找到匹配的字符串
                return false;
            }else{
                int index = temp - 'a';
                if(root.next[index] == null){
                    return false;
                }
                root = root.next[index];
            }
            
        }
        return root.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public class Question211 {
    
}

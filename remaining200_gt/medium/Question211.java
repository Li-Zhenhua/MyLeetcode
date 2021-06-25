package remaining200_gt.medium;

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
    

    /** Initialize your data structure here. */
    public WordDictionary() {
        isEnd =false;
        next = new WordDictionary[26];
    }
    
    public void addWord(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.next[index] == null){
                curr.next[index] = new WordDictionary();
                
            }
            curr = curr.next[index];
        }
    }
    
    public boolean search(String word) {
        WordDictionary curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index;
            if(word.charAt(i) != '.'){
                index = word.charAt(i) - 'a';
                if(curr.next[index] == null){
                    return false;
                }
                curr = curr.next[index];
            }else{

            }
            

        }
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

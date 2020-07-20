package com.problems;

public class _2_PrefixTrie {

    private class TrieNode{
        private char val;
        protected TrieNode[] children;
        private boolean isWord;

        public TrieNode(char val){
            this.val = val;
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public boolean getIsWord(){
            return this.isWord;
        }

        public char getVal(){
            return this.val;
        }
    }


    private TrieNode root;

    public _2_PrefixTrie(){
        root = new TrieNode(' ');
    }

    public void insert(String word){

        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TrieNode(word.charAt(i));
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }


    public boolean contains(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
             return false;
            }
            curr = curr.children[idx];
        }
        return curr.isWord;
    }



    public boolean containsPrefix(String prefix){
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }



    public static void main(String[] args) {

        _2_PrefixTrie trie = new _2_PrefixTrie();


        trie.insert("abc");
        trie.insert("ace");
        trie.insert("adc");
        trie.insert("dog");
        trie.insert("dat");

        System.out.println(trie.containsPrefix("ut"));
    }

}

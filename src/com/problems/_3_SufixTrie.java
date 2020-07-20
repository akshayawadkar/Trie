package com.problems;

public class _3_SufixTrie {

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

    public _3_SufixTrie(){
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



    public boolean containsSufix(String suffix){
        TrieNode curr = root;
        return helper(suffix, 0, curr);
    }

    private boolean helper(String suffix, int index, TrieNode curr) {

        if(index == suffix.length()){
            return curr.isWord;
        }

        if(suffix.charAt(index) == '*'){

            for(int i = 0; i < 26; i++){
                if(curr.children[i] != null){
                    if(helper(suffix, index + 1, curr.children[i])){
                        return true;
                    }
                }
            }

            return false;
        }else{
            int idx = suffix.charAt(index) - 'a';
            return curr.children[idx] != null && helper(suffix, index + 1, curr.children[idx]);
        }
    }


    public static void main(String[] args) {

        _3_SufixTrie trie = new _3_SufixTrie();

        trie.insert("akshay");
        trie.insert("aniket");
        trie.insert("abhijeet");


        System.out.println(trie.containsSufix("**hay"));
    }

}


/*

akshay





 */
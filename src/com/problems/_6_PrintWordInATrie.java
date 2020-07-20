package com.problems;

import java.util.*;

public class _6_PrintWordInATrie {

    private class TrieNode{
        protected char val;
        protected TrieNode[] children;
        protected boolean isWord;

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

    public _6_PrintWordInATrie(){
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


    public void dfs(){
        TrieNode curr = root;

        List<String> result = new ArrayList<>();

        helper(curr, result, "");

        System.out.println(result);
    }

    private void helper(TrieNode curr, List<String> result, String currString) {

        if(curr.isWord){
            result.add(currString);
            return;
        }


        for(int i = 0; i < 26; i++){
            if(curr.children[i] != null){
                String tmp = currString;
                currString += curr.children[i].val;
                helper(curr.children[i], result, currString);
                currString = tmp;
            }
        }

    }


    public static void main(String[] args) {

        _6_PrintWordInATrie trie = new _6_PrintWordInATrie();

        trie.insert("akshay");
        trie.insert("bhijeet");
        trie.insert("aniket");
        trie.insert("ijeet");
        trie.insert("abhijeet");


        trie.dfs();
    }

}


/*

akshay





 */
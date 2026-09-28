class WordDictionary {
    class Node{
        Node ch[] = new Node[26];
        boolean isE;
    }
    Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            int idx= ch-'a';
            if(curr.ch[idx]==null){
                curr.ch[idx]= new Node();

            }
            curr= curr.ch[idx];
        }
        curr.isE= true;
    }

    public boolean search(String word) {
        return search(root,word,0);
    }
    private boolean search(Node curr,String word,int i){
        if(i == word.length()){
            return curr.isE;
        }
        char ch = word.charAt(i);
        if(ch !='.'){
            int idx = ch-'a';
            if(curr.ch[idx]==null){
                return false;

            }
            return search(curr.ch[idx],word,i+1);
        }
        for(int j =0;j<26;j++){
            if(curr.ch[j]!=null){
                if(search(curr.ch[j] ,word,i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}

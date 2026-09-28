class PrefixTree {
    class Node{
        Node[] ch = new Node[26];
        boolean isE;
    }
    Node root = new Node();
    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node curr =root;
        for(char ch: word.toCharArray()){
            int idx= ch-'a';
            if(curr.ch[idx]==null){
                curr.ch[idx]= new Node();
            }
            curr= curr.ch[idx];
        }
        curr.isE=true;
    }

    public boolean search(String word) {
        Node curr = root;
        
        for(char ch : word.toCharArray()){
            int idx= ch-'a';
            if(curr.ch[idx]==null){
                return false;
            }
            curr = curr.ch[idx];
        }
        return curr.isE;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(char ch : prefix.toCharArray()){
            int idx= ch-'a';
            if(curr.ch[idx]==null){
                return false;
            }
            curr = curr.ch[idx];
        }
        return true;
    }
}

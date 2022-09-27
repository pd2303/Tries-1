Insertion->
Time complexity : O(n), where n is the word length.
In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of the word. This takes only n operations.

Space complexity : O(n)
In the worst case newly inserted word doesn't share a prefix with the the keys already inserted in the trie. We have to add m new nodes, which takes us O(m) space.

Searching->
Time complexity : O(n), where n is the length of the word we are searching for.
Space complexity: O(1), no extra space is used for searching

Implementation using Array of Nodes->

class Node{
        public boolean isEnd;
        public char val;
        public Node[] children = new Node[26];
    public Node(){}
    public Node(char c){
        Node node = new Node();
        node.val = c;
        }    
    }
public class Trie {
    private Node root; //declare root node 
    public Trie() {
        this.root = new Node(); //created root object from class Node's blueprint
        this.root.val = '/';
    }
    
    public void insert(String word) {
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);   
            if(current.children[c-'a'] == null){
                current.children[c-'a'] = new Node(c);
            }
            current = current.children[c-'a'];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Node current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);   
            if(current.children[c-'a'] == null){
            return false;}
            current = current.children[c-'a'];
        }
        return current.isEnd; 
    }
    public boolean startsWith(String prefix) {
        Node current = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);   
            if(current.children[c-'a'] == null){
            return false;}
            current = current.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

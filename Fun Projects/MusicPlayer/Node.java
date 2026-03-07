public class Node {
    // node class is fior linked list sttructure 
    Song song;  
    Node next;          
    Node prev;
                            
    public Node(Song song) {
        this.song = song;
        this.next = null;
        this.prev = null;
    }
}

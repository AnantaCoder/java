import java.util.Scanner;

public class Playlist {
    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public Playlist() {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.size = 0;
    }

    // TODO: Implement methods here
    // - addSong()
    // - displayAll()
    // - removeSong()
    // - play(), next(), previous()

    // Add song to end of playlist
    public void addSong(String title, String artist, int duration) {
        Song song = new Song(title, artist, duration);
        Node newNode = new Node(song);

        if (head == null) {
            if (head == null) {
                head = newNode; // head and tail pointing to a new song at begining
                tail = newNode;
            } else {
                // next -> song <--> song <- tail
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("Playlist is empty :( ");
            return;
        }
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;

        }
    }

    public void removeSong(String title) {

        if (head == null) {
            System.out.println("The playlist is empty there is nothing to delete here . ");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title)) {
                // song found -> update head and tail
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.prev;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.next;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                System.out.println("removed : " + current.song);
                return;
            }
            current = current.next;
        }
        System.out.println("Song  '" + title + "' not found in the playlist.");

    }

    public void play() {
        if (head == null) {
            System.out.println("The playlist is empty there is nothing to play here . ");
            return;
        }
        if (current == null) {
            current = head;

        }
        System.out.println("Now playing  '" + current.song + "'");
    }

    public void next() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current == null) {
            current = head;
            System.out.println("Starting from the beginning: " + current.song);
        } else if (current.next != null) {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("You're at the last song. No next song available.");
        }
    }

    public void previous() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (current == null) {
            current = head;
            System.out.println("Starting from the beginning: " + current.song);
        } else if (current.prev != null) {
            current = current.prev;
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("You're at the first song. No previous song available.");
        }
    }

    public void displayNowPlaying() {
        if (current == null) {
            System.out.println("Nothing is playing. Use play() to start.");
        } else {
            System.out.println("♪ Now playing: " + current.song);
        }
    }
}
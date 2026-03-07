import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Music Player Manager ===\n");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add song");
            System.out.println("2. Display playlist");
            System.out.println("3. Play");
            System.out.println("4. Next");
            System.out.println("5. Previous");
            System.out.println("6. Remove song");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (seconds): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    playlist.addSong(title, artist, duration);
                    System.out.println("Song added!");
                    break;

                case 2:
                    playlist.displayAll();
                    break;

                case 3:
                    playlist.play();
                    break;

                case 4:
                    playlist.next();
                    break;

                case 5:
                    playlist.previous();
                    break;

                case 6:
                    System.out.print("Enter song title to remove: ");
                    String removeTitle = scanner.nextLine();
                    playlist.removeSong(removeTitle);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}

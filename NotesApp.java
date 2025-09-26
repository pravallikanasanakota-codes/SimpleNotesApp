import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "notes.txt";
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter your note: ");
                String note = sc.nextLine();
                try {
                    FileWriter fw = new FileWriter(filename, true); // append mode
                    fw.write(note + "\n");
                    fw.close();
                    System.out.println("Note added!");
                } catch (IOException e) {
                    System.out.println("Error writing file.");
                }
            } else if (choice == 2) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filename));
                    String line;
                    System.out.println("\n--- Your Notes ---");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
                } catch (IOException e) {
                    System.out.println("No notes found.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}

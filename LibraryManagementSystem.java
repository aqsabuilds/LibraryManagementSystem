import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] bookID = new int[10];
        String[] bookName = new String[10];
        String[] authorName = new String[10];
        boolean[] issued = new boolean[10];

        int books = 0;

        System.out.println("--------------- Library Management ---------------");

        while (true) {

            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // 1. Add Book
            if (choice == 1) {

                if (books < 10) {

                    System.out.print("Enter Book ID: ");
                    bookID[books] = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Name: ");
                    bookName[books] = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    authorName[books] = sc.nextLine();

                    issued[books] = false;

                    books++;

                    System.out.println("Book added successfully!");

                } else {
                    System.out.println("Library is full!");
                }
            }

            // 2. View Books
            else if (choice == 2) {

                if (books == 0) {

                    System.out.println("There are no books in the library.");

                } else {

                    System.out.println("\n---------------- BOOKS ----------------");

                    for (int i = 0; i < books; i++) {

                        System.out.println(
                            (i + 1) + ". " +
                            bookID[i] + " | " +
                            bookName[i] + " | " +
                            authorName[i] + " | Status: " +
                            (issued[i] ? "Issued" : "Available")
                        );
                    }

                    System.out.println("---------------------------------------");
                }
            }

            // 3. Search Book
            else if (choice == 3) {

                System.out.print("Enter Book Name to search: ");
                String nameBook = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < books; i++) {

                    if (nameBook.equalsIgnoreCase(bookName[i])) {

                        System.out.println("Book Found!");
                        System.out.println("Book ID: " + bookID[i]);
                        System.out.println("Book Name: " + bookName[i]);
                        System.out.println("Author: " + authorName[i]);

                        if (issued[i]) {
                            System.out.println("Status: Issued");
                        } else {
                            System.out.println("Status: Available");
                        }

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book not found!");
                }
            }

            // 4. Issue Book
            else if (choice == 4) {

                System.out.print("Enter Book Name to issue: ");
                String bookIssue = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < books; i++) {

                    if (bookIssue.equalsIgnoreCase(bookName[i])) {

                        found = true;

                        if (issued[i]) {

                            System.out.println("Book is already issued!");

                        } else {

                            issued[i] = true;

                            System.out.println(
                                bookName[i] +
                                " issued successfully!"
                            );
                        }

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book not found in the library!");
                }
            }

            // 5. Return Book
            else if (choice == 5) {

                System.out.print("Enter Book Name to return: ");
                String returnBook = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < books; i++) {

                    if (returnBook.equalsIgnoreCase(bookName[i])) {

                        found = true;

                        if (issued[i]) {

                            issued[i] = false;

                            System.out.println(
                                bookName[i] +
                                " returned successfully!"
                            );

                        } else {

                            System.out.println(
                                "This book is already available."
                            );
                        }

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book not found in the library!");
                }
            }

            // 6. Delete Book
            else if (choice == 6) {

                System.out.print("Enter Book Name to delete: ");
                String deleteBook = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < books; i++) {

                    if (deleteBook.equalsIgnoreCase(bookName[i])) {

                        found = true;

                        // Shift elements to the left
                        for (int j = i; j < books - 1; j++) {

                            bookID[j] = bookID[j + 1];
                            bookName[j] = bookName[j + 1];
                            authorName[j] = authorName[j + 1];
                            issued[j] = issued[j + 1];
                        }

                        books--;

                        System.out.println("Book deleted successfully!");

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Book not found!");
                }
            }

            // 7. Exit
            else if (choice == 7) {

                System.out.println(
                    "Thank you for using Library Management System!"
                );

                break;
            }

            // Invalid Choice
            else {

                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

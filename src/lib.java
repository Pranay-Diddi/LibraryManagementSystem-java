import java.util.HashMap;
import java.util.Scanner;

public class lib {
    public static void main(String[] args) throws Exception {
        HashMap<String, Books> booksMap = new HashMap<>();
        HashMap<String, LibMem> membersMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Choose one of the Below Options: \n");
            System.out.println("1. Add a new Book");
            System.out.println("2. Add a new Library Member");
            System.out.println("3. Get Book Details through BookId");
            System.out.println("4. Get Library Member Details through UserId");
            System.out.println("5. Borrow Book");
            System.out.println("6. Set the copies of a Book (Only Librarian)");
            System.out.println("7. Exit");

            int option = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (option) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Book Id: ");
                    String bookId = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Cost: ");
                    int cost = sc.nextInt();
                    Books book = new Books(name, bookId, author, genre, cost);
                    booksMap.put(bookId, book);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Member Name: ");
                    String memberName = sc.nextLine();
                    System.out.print("Enter Member Id: ");
                    String memberId = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();
                    LibMem member = new LibMem(memberName, memberId, position);
                    membersMap.put(memberId, member);
                    System.out.println("Library member added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Book Id: ");
                    String searchBookId = sc.nextLine();
                    Books foundBook = booksMap.get(searchBookId);
                    if (foundBook != null) {
                        foundBook.printDetails();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter User Id: ");
                    String searchUserId = sc.nextLine();
                    LibMem foundMember = membersMap.get(searchUserId);
                    if (foundMember != null) {
                        foundMember.printDetails();
                    } else {
                        System.out.println("Library member not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter the Book Id of the Book: ");
                    searchBookId = sc.nextLine();
                    Books bk = booksMap.get(searchBookId);
                    if (bk != null && bk.getCopiesAvailable() > 0) {
                        int av = bk.getCopiesAvailable();
                        bk.setCopiesAvailable(av - 1);
                        System.out.println("Book is successfully borrowed!");
                    } else {
                        System.out.println("Either Book Id is incorrect or no copies are available!");
                    }
                    break;

                case 6:
                    System.out.print("Enter the Book Id to set the copies: ");
                    searchBookId = sc.nextLine();
                    Books bookToSetCopies = booksMap.get(searchBookId);
                    if (bookToSetCopies != null) {
                        System.out.print("Enter the Password to access the book: ");
                        String tempPassword = sc.nextLine();
                        if (PasswordManager.validatePassword(tempPassword)) {
                            System.out.print("Enter the number of new copies: ");
                            int tempCopies = sc.nextInt();
                            bookToSetCopies.setCopiesAvailable(tempCopies);
                            System.out.println("Copies updated successfully!");
                        } else {
                            System.out.println("Incorrect Password!");
                        }
                    } else {
                        System.out.println("Book not found! Recheck the Book Id.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
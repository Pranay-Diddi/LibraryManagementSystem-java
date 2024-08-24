public class Books {
    private String bookName;
    private String bookId;
    private String author;
    private String genre;
    private int cost;
    private int CopiesAvailable = 1;

    public Books(String bookName, String bookId, String author, String genre, int cost) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCopiesAvailable(int available) {
        this.CopiesAvailable = getCopiesAvailable() + available;
    }

    public int getCopiesAvailable() {
        return this.CopiesAvailable;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void printDetails() {
        System.out.println("Title: " + this.getBookName());
        System.out.println("Book Id: " + this.getBookId());
        System.out.println("Genre: " + this.getGenre());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Cost: " + getCost());
        System.out.println("Copies Available: " + getCopiesAvailable());
    }
}
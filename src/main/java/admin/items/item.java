package admin.items;

public class Item {
    private int bookId;
    private String bookTitle;
    private String bookCategory;
    private double price;
    private int availableQuantity;
    private String bookImage;

    public Item() {}

    public Item(int bookId, String bookTitle, String bookCategory, double price, int availableQuantity, String bookImage) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.bookImage = bookImage;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
}

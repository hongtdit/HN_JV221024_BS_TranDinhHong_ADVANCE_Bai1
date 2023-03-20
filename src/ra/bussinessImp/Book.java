package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.Scanner;

public class Book implements IShop {

    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private int quantity;
    private Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, int quantity, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return getImportPrice() * RATE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookStatus() {
        return bookStatus ? "Còn hàng" : "Hết hàng";
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.print("Mã sách: ");
        setBookId(new Scanner(System.in).nextInt());

        System.out.print("Tên sách: ");
        setBookName(new Scanner(System.in).nextLine());

        System.out.print("Tiêu đề sách: ");
        setTitle(new Scanner(System.in).nextLine());

        System.out.print("Số trang sách: ");
        setNumberOfPages(new Scanner(System.in).nextInt());

        System.out.print("Giá nhập: ");
        setImportPrice(new Scanner(System.in).nextFloat());

        System.out.print("Số lượng: ");
        setQuantity(new Scanner(System.in).nextInt());

        System.out.print("Trạng thái: ");
        String inputSex = new Scanner(System.in).next();
        if (inputSex != null) {
            inputSex = inputSex.toLowerCase();
            setBookStatus(inputSex.equals("còn hành") || inputSex.equals("available") || inputSex.equals("true") || inputSex.equals("1") || inputSex.equals("con"));
        }

        Author.DisplayAuthorList();
        if (!Author.AUTHORS.isEmpty()) {
            System.out.print("Chọn tác giả: ");
            setAuthor(Author.GetByIndex(new Scanner(System.in).nextInt()));
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + getBookId() + "\tTên sách: " + getBookName());
        System.out.println("Tên tác giả: " + (getAuthor() != null ? getAuthor().getAuthorName() : "Không xác định") + "\tGiá bán: " + getExportPrice());
        System.out.println("Số lượng: " + getQuantity() + "\tTrạng thái: " + getBookStatus());
    }
}

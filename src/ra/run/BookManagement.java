package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BookManagement {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();

        while (true) {
            String action;
            System.out.println("\n\t-----Menu-----");
            System.out.println("1. Nhập số tác giả và nhập thông tin các tác giả");
            System.out.println("2. Nhập số sách và nhập thông tin các sách ");
            System.out.println("3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sách theo tên tác giả sách");
            System.out.println("5. Thoát");
            System.out.print("Vui lòng chọn: ");
            action = new Scanner(System.in).next();

            int tmpIndexToDisplay = 1;
            switch (action) {
                case "1":
                    System.out.println("\n---Nhập tác giả---");
                    System.out.print("Số tác giả muốn nhập: ");
                    int countAuthor = new Scanner(System.in).nextInt();

                    while (countAuthor > 0) {
                        System.out.println("\n---Tác giả " + tmpIndexToDisplay + "---");
                        Author author = new Author();
                        author.inputData();
                        Author.AddAuthorToList(author);
                        countAuthor--;
                        tmpIndexToDisplay++;
                    }
                    break;
                case "2":
                    System.out.println("\n---Nhập sách---");
                    System.out.print("Số sách muốn nhập: ");
                    int countBook = new Scanner(System.in).nextInt();
                    while (countBook > 0) {
                        System.out.println("\n---Sách số " + tmpIndexToDisplay + "---");
                        Book book = new Book();
                        book.inputData();
                        bookList.add(book);
                        countBook--;
                        tmpIndexToDisplay++;
                    }
                    break;
                case "3":
                    System.out.println("\n---Sắp xếp sách theo giá tăng dần");
                    bookList = bookList.stream().sorted(Comparator.comparingInt(a -> (int) a.getExportPrice())).collect(Collectors.toList());
                    bookList.forEach(Book::displayData);
                    break;
                case "4":
                    System.out.print("\n---Tìm theo tác giả: ");
                    String keyword = new Scanner(System.in).nextLine();
                    List<Book> books = searchBookByAuthorName(keyword, bookList);
                    System.out.println("\nSách của tác giả: " + keyword);
                    for (Book book : books) {
                        book.displayData();
                        System.out.println();
                    }
                    break;
                case "5":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
                    break;
            }
        }
    }

    private static List<Book> searchBookByAuthorName(String authorName, List<Book> bookList) {
        if (authorName != null) {
            return bookList.stream().filter(t -> t.getAuthor().getAuthorName().toLowerCase().contains(authorName.toLowerCase())).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

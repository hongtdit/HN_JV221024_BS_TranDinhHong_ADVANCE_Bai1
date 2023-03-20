package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Author implements IShop {

    public static List<Author> AUTHORS = new ArrayList<>();

    public static void DisplayAuthorList() {
        if (AUTHORS.isEmpty()) {
            System.out.println("\n--Không có tác giả nào--");
            return;
        }

        for (int i = 0; i < AUTHORS.size(); i++) {
            Author author = AUTHORS.get(i);
            System.out.println((i + 1) + ". Tác giả " + author.authorName);
        }
    }

    public static Author GetByIndex(int index) {
        index--;
        if (index < AUTHORS.size()) {
            return AUTHORS.get(index);
        } else {
            return null;
        }
    }

    public static void AddAuthorToList(Author author) {
        AUTHORS.add(author);
    }

    private int authorId;
    private String authorName;
    private Boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, Boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSex() {
        return sex ? "Nam" : "Nữ";
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        System.out.print("Mã tác giả: ");
        setAuthorId(new Scanner(System.in).nextInt());

        System.out.print("Tên tác giả: ");
        setAuthorName(new Scanner(System.in).nextLine());

        System.out.print("Giới tính: ");
        String inputSex = new Scanner(System.in).next();
        if (inputSex != null) {
            inputSex = inputSex.toLowerCase();
            setSex(inputSex.equals("nam") || inputSex.equals("male") || inputSex.equals("true") || inputSex.equals("1"));
        }

        System.out.print("Năm sinh: ");
        setYear(new Scanner(System.in).nextInt());
    }

    @Override
    public void displayData() {
        System.out.println("Mã tác giả: " + getAuthorId() + "\tTên tác giả: " + getAuthorName());
    }
}

package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.model.Book;

public class BookBus {
  private BookBus() {}
  public static boolean insertBook(Book newBook) {
    Scanner input = new Scanner(System.in);
    System.out.println("ma sach:");
    String masach = input.nextLine();
    System.out.println("ten sach:");
    String name = input.nextLine();
    System.out.println("ten tac gia: ");
    String tacgia = input.nextLine();
    System.out.println("nha xuat ban:");
    String nxb = input.nextLine();
    System.out.println("gia tien:");
    Integer giatien = input.nextInt();
    System.out.println("so luong:");
    Integer sl = input.nextInt();
    newBook.setMaSach(masach);
    newBook.setTenSach(name);
    newBook.setTenTacGia(tacgia);
    newBook.setNhaXB(nxb);
    newBook.setGiaTien(giatien);
    newBook.setSoLuong(sl);
    System.out.println(newBook);
    BookDao.insertSach(newBook);
    return true;
  }

  public static boolean deleteBook() {
    Scanner input = new Scanner(System.in);
    System.out.println("ma sach:");
    String masach = input.nextLine();
    BookDao.deleteSach(masach);
    System.out.println("Delete successfull");
    return true;
  }

  public static boolean updateBook(Book newBook) {
    Scanner input = new Scanner(System.in);
    System.out.println("ma sach:");
    String masach = input.nextLine();
    System.out.println("ten sach:");
    String name = input.nextLine();
    System.out.println("ten tac gia: ");
    String tacgia = input.nextLine();
    System.out.println("nha xuat ban:");
    String nxb = input.nextLine();
    System.out.println("gia tien:");
    Integer giatien = input.nextInt();
    System.out.println("so luong:");
    Integer sl = input.nextInt();
    newBook.setMaSach(masach);
    newBook.setTenSach(name);
    newBook.setTenTacGia(tacgia);
    newBook.setNhaXB(nxb);
    newBook.setGiaTien(giatien);
    newBook.setSoLuong(sl);
    System.out.println(newBook);
    BookDao.updateSach(newBook);
    return true;
  }
}

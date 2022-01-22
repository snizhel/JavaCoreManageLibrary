package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.BookDao;
import LibraryManagement.java.model.Book;

public class MenuAdmin {
  public MenuAdmin() {
    try {
      int choice;
      Scanner sc = new Scanner(System.in);
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Danh sach sach trong thu vien \n");
        System.out.printf("2/Them sach \n");
        System.out.printf("3/Xoa sach \n");
        System.out.printf("4/Cap nhat sach trong thu vien \n");
        System.out.printf("5/Tim kiem sach \n");
        System.out.printf("6/Thong ke \n");
        System.out.printf("7/Thoat\n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(BookDao.getBook());
            break;
          case 2:
            insertBook();
            break;
          case 3:
            deleteBook();
            break;
          case 4:
            updateBook();
            break;
          case 5:
            BookDao.search();
            break;
          case 6:
            StatisticalBus.statistical();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
            break;
        }
      } while (choice != 7);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private boolean deleteBook() {
    Scanner input = new Scanner(System.in);
    System.out.println("ma sach:");
    String masach = input.nextLine();
    BookDao.deleteSach(masach);
    System.out.println("Delete successfull");
    return true;
  }

  private void updateBook() {
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
    Book newBook = new Book();
    newBook.setMaSach(masach);
    newBook.setTenSach(name);
    newBook.setTenTacGia(tacgia);
    newBook.setNhaXB(nxb);
    newBook.setGiaTien(giatien);
    newBook.setSoLuong(sl);
    BookBus.updateBook(newBook);
  }

  public void insertBook() {
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
    Book newBook = new Book();
    newBook.setMaSach(masach);
    newBook.setTenSach(name);
    newBook.setTenTacGia(tacgia);
    newBook.setNhaXB(nxb);
    newBook.setGiaTien(giatien);
    newBook.setSoLuong(sl);
    BookBus.insertBook(newBook);
  }


}



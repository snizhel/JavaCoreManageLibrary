package LibraryManagement.java.bus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import LibraryManagement.java.dao.PhieuMuonDao;
import LibraryManagement.java.model.PhieuMuon;

public class MenuPhieuMuon {
  public MenuPhieuMuon() {
    try {

      int choice;
      do {
        System.out.printf("======MENU=======\n");
        System.out.printf("1/Danh sach phieu muon sach \n");
        System.out.printf("2/Dang ky muon sach \n");
        System.out.printf("3/Xoa phieu muon \n");
        System.out.printf("4/Cap nhat phieu muon \n");
        System.out.printf("5/Tim kiem phieu muon \n");
        System.out.printf("6/Thoat\n");
        System.out.printf("------------------\n");
        System.out.printf("Chon chuc nang thuc hien:");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
          case 1:
            System.out.println(PhieuMuonDao.getPhieuMuon());
            break;
          case 2:
            addPhieuMuon();
            break;
          case 3:
            deletePhieuMuon();
            break;
          case 4:
            editPhieuMuon();
            break;
          case 5:
            PhieuMuonDao.search();
            break;
          default:
            System.out.println("chon sai chuc nang\n");
            break;
        }
      } while (choice != 6);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private boolean deletePhieuMuon() {
    Scanner input = new Scanner(System.in);
    System.out.println("ID:");
    String idPhieu = input.nextLine();
    PhieuMuonDao.deletePhieu(idPhieu);
    System.out.println("Delete successfull");
    return true;
  }

  private void editPhieuMuon() {
    PhieuMuon phieuMuon = new PhieuMuon();
    Scanner input = new Scanner(System.in);
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    java.sql.Date doBorrow;
    java.sql.Date paymentTerm;
    Date apptDay1 = null;
    Date apptDay = null;
    System.out.println("ID Phieu Muon:");
    String id = input.nextLine();
    System.out.println("ID User:");
    String idUser = input.nextLine();
    System.out.println("ID Book:");
    String idBook = input.nextLine();
    System.out.println("Borrow day(dd-MM-yyyy):");
    while (apptDay == null) {
      try {
        String borrowDay = input.nextLine();
        apptDay = (Date) format.parse(borrowDay);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
      }
    }
    doBorrow = new java.sql.Date(apptDay.getTime());
    System.out.println("Payment Term(dd-MM-yyyy):");
    while (apptDay1 == null) {
      try {
        String payTermDay = input.nextLine();
        apptDay1 = (Date) format.parse(payTermDay);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
      }
    }
    paymentTerm = new java.sql.Date(apptDay1.getTime());
    phieuMuon.setMaMuon(id);
    phieuMuon.setMaKhach(idUser);
    phieuMuon.setMaSach(idBook);
    phieuMuon.setNgayMuon(doBorrow);
    phieuMuon.setHanTra(paymentTerm);
    PhieuMuonBus.editPhieuMuon(phieuMuon);
    
  }

  private void addPhieuMuon() {
    PhieuMuon phieuMuon = new PhieuMuon();
    Scanner input = new Scanner(System.in);
    DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    java.sql.Date doBorrow;
    java.sql.Date paymentTerm;
    Date apptDay1 = null;
    Date apptDay = null;
    System.out.println("ID Phieu Muon:");
    String id = input.nextLine();
    System.out.println("ID User:");
    String idUser = input.nextLine();
    System.out.println("ID Book:");
    String idBook = input.nextLine();
    System.out.println("Borrow day(dd-MM-yyyy):");
    while (apptDay == null) {
      try {
        String borrowDay = input.nextLine();
        apptDay = (Date) format.parse(borrowDay);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");

      }
    }
    doBorrow = new java.sql.Date(apptDay.getTime());
    System.out.println("Payment Term(dd-MM-yyyy):");
    while (apptDay1 == null) {
      try {
        String payTermDay = input.nextLine();
        apptDay1 = (Date) format.parse(payTermDay);
      } catch (ParseException e) {
        System.out.println("Please enter a valid date! Format is yyyy/mm/dd");

      }
    }
    paymentTerm = new java.sql.Date(apptDay1.getTime());
    phieuMuon.setMaMuon(id);
    phieuMuon.setMaKhach(idUser);
    phieuMuon.setMaSach(idBook);
    phieuMuon.setNgayMuon(doBorrow);
    phieuMuon.setHanTra(paymentTerm);
    PhieuMuonBus.addPhieuMuon(phieuMuon);
    
  }
}

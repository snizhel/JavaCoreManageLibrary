package LibraryManagement.java.bus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import LibraryManagement.java.dao.PhieuMuonDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.PhieuMuon;
import LibraryManagement.java.model.User;

public class PhieuMuonBus {

  public static boolean addPhieuMuon(PhieuMuon newPhieuMuon) {
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
        return false;
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
        return false;
      }
    }
    paymentTerm = new java.sql.Date(apptDay1.getTime());
    newPhieuMuon.setMaMuon(id);
    newPhieuMuon.setMaKhach(idUser);
    newPhieuMuon.setMaSach(idBook);
    newPhieuMuon.setNgayMuon(doBorrow);
    newPhieuMuon.setHanTra(paymentTerm);
    PhieuMuonDao.insertPhieu(newPhieuMuon);

    return true;
  }
  public static boolean editPhieuMuon(PhieuMuon newPhieuMuon) {
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
        return false;
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
        return false;
      }
    }
    paymentTerm = new java.sql.Date(apptDay1.getTime());
    newPhieuMuon.setMaMuon(id);
    newPhieuMuon.setMaKhach(idUser);
    newPhieuMuon.setMaSach(idBook);
    newPhieuMuon.setNgayMuon(doBorrow);
    newPhieuMuon.setHanTra(paymentTerm);
    PhieuMuonDao.updatePhieu(newPhieuMuon);

    return true;
  }
  public static boolean deletePhieuMuon() {
    Scanner input = new Scanner(System.in);
    System.out.println("ID:");
    String idPhieu = input.nextLine();
    PhieuMuonDao.deletePhieu(idPhieu);
    System.out.println("Delete successfull");
    return true;
  }
}

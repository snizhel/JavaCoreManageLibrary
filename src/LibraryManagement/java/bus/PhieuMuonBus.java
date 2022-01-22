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
    PhieuMuonDao.insertPhieu(newPhieuMuon);
    return true;
  }

  public static boolean editPhieuMuon(PhieuMuon newPhieuMuon) {
    PhieuMuonDao.updatePhieu(newPhieuMuon);
    return true;
  }
}

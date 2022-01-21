package LibraryManagement.java.bus;

import java.util.Scanner;
import LibraryManagement.java.dao.PhieuMuonDao;
import LibraryManagement.java.dao.UserDao;
import LibraryManagement.java.model.PhieuMuon;
import LibraryManagement.java.model.User;

public class MenuPhieuMuon {
  public MenuPhieuMuon() {
    try {
      PhieuMuon phieuMuon=new PhieuMuon();
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
            PhieuMuonBus.addPhieuMuon(phieuMuon);
            break;
          case 3:
            PhieuMuonBus.deletePhieuMuon();
            break;
          case 4:
            PhieuMuonBus.editPhieuMuon(phieuMuon);
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
}

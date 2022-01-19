package LibraryManagement.java.model;

import java.sql.Date;

public class User {
  private String maKhachHang;
  private String password;
  private String name;
  private Date birth;
  private String diaChi;
  private String phone;

  public User() {

  }

  public User(String maKH, String password, String name, Date birth, String diaChi, String phone) {
    this.maKhachHang = maKH;
    this.password = password;
    this.name = name;
    this.birth = birth;
    this.diaChi = diaChi;
    this.phone = phone;
  }

  public String getMaKH() {
    return maKhachHang;
  }

  public void setMaKH(String maKH) {
    this.maKhachHang = maKH;
  }

  public String getPass() {
    return password;
  }

  public void setPass(String pass) {
    this.password = pass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name1) {
    this.name = name1;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getDiaChi() {
    return diaChi;
  }

  public void setDiaChi(String diachi) {
    this.diaChi = diachi;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {

    return "User = {" + "ma khach hang:" + " " + getMaKH() + " " + ", ten khach hang:" + " "
        + getName() + " " + ", mat khau:" + " " + getPass() + " " + ", sdt:" + " " + getPhone()
        + " " + ", ngay sinh:" + " " + getBirth() + '}';
  }
}


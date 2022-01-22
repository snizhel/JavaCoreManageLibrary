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
    StringBuffer str = new StringBuffer("\nUser = {");
    str.append("\nma khach hang:").append(getMaKH()).append("\n").append("\nten khach hang:")
        .append(getName()).append("\n").append("\nmat khau:").append(getPass()).append("\n")
        .append("\nsdt:").append(getPhone()).append("\nngay sinh:").append(getBirth()).append('}');
    return str.toString();

  }
}


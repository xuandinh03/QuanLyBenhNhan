/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhoadon;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author XUAN DINH
 */
public class BENHNHANBAOHIEMYTE extends  BENHNHAN{
    private  String MaBaoHiemYTe;   

    public String getMaBaoHiemYTe() {
        return MaBaoHiemYTe;
    }

    public void setMaBaoHiemYTe(String MaBaoHiemYTe) {
        this.MaBaoHiemYTe = MaBaoHiemYTe;
    }
    
    public BENHNHANBAOHIEMYTE() {
         super();
    }

    public BENHNHANBAOHIEMYTE(String MaBaoHiemYTe, String LoaiBaoHiem, String MaBenhNhan, String HoTen, Date NgayNhap, boolean PhongTheoYeuCau) {
        super(LoaiBaoHiem, MaBenhNhan, HoTen, NgayNhap, PhongTheoYeuCau);
        this.MaBaoHiemYTe = MaBaoHiemYTe;
    }     
    @Override
    public long Tinhhoadonvienphi() {       
        if( super.PhongTheoYeuCau)
            return (long) ((super.tinhSoNgayNhapVien()*super.DonGiaPhong *200000)-
                    (super.tinhSoNgayNhapVien()*super.DonGiaPhong)*70 /100);
        else
            return  (long) ((super.tinhSoNgayNhapVien()*super.DonGiaPhong)-
                    (super.tinhSoNgayNhapVien()*super.DonGiaPhong)*70 /100);            
    }
    @Override
    public String toString() {//lấy thông tin nghi vào tệp banhnhan.txt
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        return "Mã bệnh nhân:"+super.MaBenhNhan + "\n" 
                + "Họ tên:"+super.HoTen +"\n"
                + "Ngày nhập:"+d.format(super.NgayNhap) +"\n"
                + "Phòng theo yêu cầu:"+super.PhongTheoYeuCau +"\n"
                + "Loại bảo hiểm:"+super.LoaiBaoHiem + "\n" 
                + "Mã bảo hiểm:"+this.MaBaoHiemYTe + "\n" 
                + "Viện phí:"+this.Tinhhoadonvienphi() + "\r\n"
                + "Số ngày nhập viện:"+this.tinhSoNgayNhapVien() + "\r\n"
                + "------------------------------------" + "\n"; 
    }      
    public void Nhap(){
      super.Nhap();
        System.out.println("Nhập mã bảo hiểm y tế:");
        this.MaBaoHiemYTe=super.sc.nextLine();      
    }
    public void Xuat(){
        super.Xuat();
        System.out.println("Ma Bao hiem y te"+this.MaBaoHiemYTe);
         System.out.println("Tong tien thanh toan:"+this.Tinhhoadonvienphi());
    }    
}

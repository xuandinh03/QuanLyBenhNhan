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
public class BENHNHANBAOHIEMXAHOI extends BENHNHAN{
    private  String MaBaoHiemXaHoi;   

    public String getMaBaoHiemXaHoi() {
        return MaBaoHiemXaHoi;
    }

    public void setMaBaoHiemXaHoi(String MaBaoHiemXaHoi) {
        this.MaBaoHiemXaHoi = MaBaoHiemXaHoi;
    }

    public BENHNHANBAOHIEMXAHOI() {
        super();
    }
   
    public BENHNHANBAOHIEMXAHOI(String MaBaoHiemXaHoi, String LoaiBaoHiem, String MaBenhNhan, String HoTen, Date NgayNhap, boolean PhongTheoYeuCau) {
        super(LoaiBaoHiem, MaBenhNhan, HoTen, NgayNhap, PhongTheoYeuCau);
        this.MaBaoHiemXaHoi = MaBaoHiemXaHoi;
    }
    
    @Override
    public long Tinhhoadonvienphi() {
        if(super.PhongTheoYeuCau)
            return (long) (super.tinhSoNgayNhapVien()* super.DonGiaPhong * 200000);
        else
            return (long) (super.tinhSoNgayNhapVien()* super.DonGiaPhong);
    }
    @Override
     public String toString() {//lấy thông tin nghi vào tệp banhnhan.txt
         SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");       
        return "Mã bệnh nhân:"+super.MaBenhNhan + "\r\n" 
                + "Họ tên:"+super.HoTen +"\r\n"
                + "Ngày nhập:"+ d.format(NgayNhap) +"\r\n"
                + "Phòng theo yêu cầu:"+super.PhongTheoYeuCau +"\r\n"
                + "Loại bảo hiểm:"+super.LoaiBaoHiem + "\r\n" 
                + "Mã bảo hiểm:"+this.MaBaoHiemXaHoi + "\r\n" 
                + "Viện phí:"+this.Tinhhoadonvienphi() + "\r\n"
                + "Số ngày nhập viện:"+this.tinhSoNgayNhapVien() + "\r\n"
                + "------------------------------------" + "\r\n" ;
    }      
    public void  Nhap(){     
        super.Nhap();
        System.out.println("Nhap Ma bao hiem xa hoi:");
        this.MaBaoHiemXaHoi= super.sc.nextLine();           
    }
    public void Xuat(){
        super.Xuat();
        System.out.println("Ma bao hiem xa hoi:"+this.MaBaoHiemXaHoi);
        System.out.println("Tien Thanh toan vien phi:"+this.Tinhhoadonvienphi());
    }  
}

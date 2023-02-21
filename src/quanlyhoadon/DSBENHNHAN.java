/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyhoadon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author XUAN DINH
 */
public class DSBENHNHAN {
    Hashtable<String, BENHNHAN> danhsachbennhan = new Hashtable<String, BENHNHAN>();
    BufferedReader br; 
    
    public Hashtable<String, BENHNHAN> getDanhsachbennhan() {
        return danhsachbennhan;
    }
    public void setDanhsachbennhan(Hashtable<String, BENHNHAN> danhsachbennhan) {
        this.danhsachbennhan = danhsachbennhan;
    }
    public void GhiFile()throws IOException {
        FileWriter  fw=null;
        try {
            fw = new FileWriter("DSBENHNHAN.txt");  
            String str="";
            for(BENHNHAN benhnhan:danhsachbennhan.values()){
                str +=benhnhan.toString();
            } 
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            fw.close();
        }       
    }
    public void Docfile(){
        try {
                danhsachbennhan.clear();
                Scanner scr=new Scanner(new FileReader("DSBENHNHAN.txt"));
                String mabenhnhan=null,hoten=null,mabaohiem=null;
                Date Ngaynhap=null;
                Double vienphi=null;
                boolean phongtheoyeucau=false;
                String loaibaohiem=" ";
                boolean flag=false;
                while(scr.hasNextLine()) {
                    String thongtin=scr.nextLine();
                    String thuoctinh=" ";
                    String value=null;
                    int vitri=thongtin.indexOf(":");
                    if( vitri>0){    
                        thuoctinh=thongtin.substring(0, vitri);
                        value=thongtin.substring(vitri+1, thongtin.length());            
                    }
                    switch(thuoctinh)
                    {
                        case "Mã bệnh nhân":{
                            mabenhnhan=value;
                            break;
                        }
                        case "Họ tên":{
                            hoten=value;
                            break;
                        }
                        case "Ngày nhập":{
                            SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
                            Ngaynhap=d.parse(value);  
                            break;
                        }
                        case "Phòng theo yêu cầu":{
                            phongtheoyeucau=Boolean.parseBoolean(value);
                            break;
                        }
                        case "Loại bảo hiểm":{
                            loaibaohiem=value;
                            break;
                        }
                        case "Mã bảo hiểm":{
                            mabaohiem= value;
                            break;
                        }    
                        case "Viện phí":{
                            vienphi = Double.parseDouble(value);
                        }
                    }
                    if(thongtin.equals("------------------------------------")) {
                        BENHNHAN benhnhan=null;
                        if(loaibaohiem.equalsIgnoreCase("Y tế")){
                            benhnhan=new BENHNHANBAOHIEMYTE(mabaohiem, loaibaohiem,
                                    mabenhnhan, hoten, Ngaynhap, phongtheoyeucau) ;
                        }
                        else
                            benhnhan=new BENHNHANBAOHIEMXAHOI(mabaohiem, loaibaohiem,
                                    mabenhnhan, hoten, Ngaynhap, phongtheoyeucau);
                        danhsachbennhan.put(benhnhan.getMaBenhNhan(), benhnhan);
                        flag=false;
                    }
                }
                scr.close();                           
        } catch (Exception e) {
        }       
    }
    
    public void Themmoi(BENHNHAN benhnhan) {
        danhsachbennhan.put(benhnhan.getMaBenhNhan(), benhnhan);
    }
    
    public  void Capnhat(BENHNHAN benhnhan){
        danhsachbennhan.replace(benhnhan.getMaBenhNhan(), benhnhan);
    }  
    
    public BENHNHAN  Tim(String mabenhnhan) { 
        return this.danhsachbennhan.get(mabenhnhan);
    }
    
    public void Xoa(String mabenhnhan){        
        this.danhsachbennhan.remove(mabenhnhan);       
    }
    
    public long[] tienvienphi()
    {
        long[] sum = new long[2];
        for (BENHNHAN bn : danhsachbennhan.values()) {
            if (bn instanceof BENHNHANBAOHIEMYTE)
                sum[0] += bn.Tinhhoadonvienphi();
            else
                sum[1] += bn.Tinhhoadonvienphi();
        }
        return sum;
    }
    
    // kiểm tra xem có trùng mã hay không
    public boolean checkExist(String id)
    {
        for (BENHNHAN bn : danhsachbennhan.values()) {
            if (bn.getMaBenhNhan().equalsIgnoreCase(id.trim()))
                return true;
        }
        return false;
    }
}

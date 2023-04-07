package board.vo;

/*
이름       널?       유형           
-------- -------- ------------ 
CUSTNO   NOT NULL NUMBER(6)    
CUSTNAME          VARCHAR2(20) 
PHONE             VARCHAR2(13) 
ADDRESS           VARCHAR2(60) 
JOINDATE          DATE         
GRADE             CHAR(1)      
CITY              CHAR(2)        
*/

public class BoardVO {
   private String custno;
   private String custname;
   private String phone;
   private String address;
   private String joindate;
   private String grade;
   private String city;
   
   public BoardVO() { }
   
   public BoardVO(String custno, String custname, String phone, String address, String joindate,String grade, String city) {
      this.custno = custno;
      this.custname = custname;
      this.phone = phone;
      this.address = address;
      this.joindate = joindate;
      this.grade = grade;
      this.city = city;
      
   }

public String getCustno() {
	return custno;
}

public void setCustno(String custno) {
	this.custno = custno;
}

public String getCustname() {
	return custname;
}

public void setCustname(String custname) {
	this.custname = custname;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getJoindate() {
	return joindate;
}

public void setJoindate(String joindate) {
	this.joindate = joindate;
}

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

  
   
   
   
   
}
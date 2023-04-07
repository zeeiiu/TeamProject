package board.vo;

/*
                    
*/

public class SalesBoardVO {
   private String custno;
   private String custname;
   private String grade;
   private String total;
   
   public SalesBoardVO() { }
   
   public SalesBoardVO(String custno, String custname, String grade, String total) {
      this.custno = custno;
      this.custname = custname;
      this.grade = grade;
      this.total = total;
      
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

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

public String gettotal() {
	return total;
}

public void settotal(String total) {
	this.total = total;
}
   
   

}


  
   
   
   
   
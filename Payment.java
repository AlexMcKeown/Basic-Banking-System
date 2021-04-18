public class Payment{
	protected String paymentID;
	protected String loanID;
	protected double amount;
	protected String date;
	
	public Payment(){
		this.paymentID = null;
		this.loanID = "";
		this.amount = 0.0;
		this.date = ""; // yyyy/mm/dd
	}
	public Payment(String paymentID, String loanID, double amount, String date){
		this.paymentID = paymentID;
		this.loanID = loanID;
		this.amount = amount;
		this.date = date;
	}
	
	public String getPaymentID(){
		return paymentID;
	}
	
	public String getLoanID(){
		return loanID;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public String getDate(){
		return date;
	}
	
	public void paymentInformation(){ //print method
		System.out.println("PaymentID: "+paymentID+" | LoanID: "+loanID+" | Amount: "+amount+" | Date: "+date+" ");
	}
	
}
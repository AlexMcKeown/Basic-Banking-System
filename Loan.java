
public class Loan{
	protected String loanID;
	protected String suburb;
	protected double balance;
	protected int term; // months left
	protected Payment lastPayment; //last payment made by customer

	public Loan(){
		this.loanID = "";
		this.suburb = "";
		this.balance = 0.0;
		this.term = 0;
		this.lastPayment = null;	
	}
	
	public Loan(String loanID, String suburb, double balance, int term, Payment lastPayment){
		this.loanID = loanID;
		this.suburb = suburb;
		this.balance = balance;
		this.term = term;
		this.lastPayment = lastPayment;
	}
	
	public String getLoanID(){
		return loanID;
	}
	
	public String getSuburb(){
		return suburb;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getTerm(){
		return term;
	}
	
	public Payment getLastPayment(){
		return lastPayment;
	}
	
	public String getLastPaymentID(){
		return lastPayment.getPaymentID();
	}
	
	public String getLastPaymentDate(){
		return lastPayment.getDate();
	}
	
	public double getLastPaymentAmount(){
		return lastPayment.getAmount();
	}
	
	public void setBalance(double balance){
		this.balance = balance;
	}
	
	public void setTerm(int term){
		this.term = term;
	}
	
	public void setLastPayment(Payment lastPayment){
		this.lastPayment = lastPayment;
	}

	public double calculatingInterest(){
		return 0.0;
	}
	
	public boolean getOffsetChecker(){
		return false;
	}
	
	public double getOffset(){
		return 0.0;
	}
	
	public void setOffset(double offset){
	}
	
	public void loanInformation(){ //print loan infomation 
		System.out.println("LoanID: "+loanID+" | Suburb: "+suburb+" | Balance: $"+balance+" | Months/terms remaining: "+term);
		if(lastPayment !=null){
			System.out.print("Latest Payement: ");
			lastPayment.paymentInformation();	
		}else{
			System.out.println("Yet to make a payment");	
		}
	}
}


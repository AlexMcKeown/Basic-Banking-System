public class FixedLoan extends Loan{
	protected double rate;//the interest rate
	
	public FixedLoan(){
		this.loanID = "";
		this.suburb = "";
		this.balance = 0.0;
		this.term = 0;
		this.lastPayment = null;	
		this.rate = 0.0;
	}
	
	public FixedLoan(String loanID, String suburb, double balance, int term, Payment lastPayment, double rate){
		super(loanID, suburb, balance, term, lastPayment);
		this.rate = rate;
	}
	
	public void loanInformation(){ //print loan infomation 
		super.loanInformation();
		System.out.println("Interest: "+calculatingInterest()+" | Rate: "+rate);		
	}
	
	public double calculatingInterest(){
		return (rate * balance);
	}
}
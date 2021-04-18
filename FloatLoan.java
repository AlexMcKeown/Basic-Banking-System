public class FloatLoan extends Loan{
	protected double offset;//the offset account balance
	
	public FloatLoan(){
		this.loanID = "";
		this.suburb = "";
		this.balance = 0.0;
		this.term = 0;
		this.lastPayment = null;	
		this.offset = 0.0;
	}
	
	public FloatLoan(String loanID, String suburb, double balance, int term, Payment lastPayment, double offset){
		super(loanID, suburb, balance, term, lastPayment);
		this.offset = offset;
	}
	
	public double getOffset(){
		return offset;
	}
	
	public boolean getOffsetChecker(){
		return true;
	}
	
	public void setOffset(double offset){
		this.offset = offset;
	}

	
	public void loanInformation(){ //print loan infomation 
		super.loanInformation();
		System.out.println("Interest: "+calculatingInterest()+" | Offset: "+ offset);
	}

	
	public double calculatingInterest(){
		double floatingRate = InterestRate.getFloatRate();
		return floatingRate * (balance-offset);
	}
	
}
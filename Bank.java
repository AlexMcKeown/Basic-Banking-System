import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Bank{
	public static void main(String [] args){		
		InterestRate interestRate = new InterestRate(); 
		interestRate.setFloatRate(5);
		
		String currentYearString = "2018";
		String currentMonthString = "08";
		int currentYear = Integer.parseInt(currentYearString);
		int currentMonth = Integer.parseInt(currentMonthString);
		
		Payment jerryPayment = new Payment("1","1",500,"2018/02/01");
		Payment alexPayment = new Payment("1","2",1,"2018/02/30");
		Payment carlyPayment = new Payment("1","7",20,"2018/03/29");	
		Payment charliePayment = new Payment("1","8",30,"2018/03/04");
		Payment donalDuckPayment = new Payment("1","5",10,"2018/03/01") ;
		Payment tomPayment = new Payment("1","3",100,"2018/03/01");  
		Payment kwonPayment = new Payment("1","4",20,"2018/03/01"); 
		Payment jamesPayment = new Payment("1","9",50,"2018/03/19");  
		
		
		
		FixedLoan jerry = new FixedLoan("1", "Sutherland", 2000, 12, jerryPayment, 5); 
		FixedLoan alex = new FixedLoan("2", "Sutherland", 2, 3, alexPayment, 19); 
		FixedLoan tom = new FixedLoan("3", "Miranda", 300, 8, tomPayment, 22);
		FixedLoan kwon = new FixedLoan("4", "Miranda", 22000, 6, kwonPayment, 13);
		FixedLoan donaldDuck = new FixedLoan("5", "Miranda", 22000, 6, donalDuckPayment, 13); 
		
		FloatLoan harry = new FloatLoan("6", "Canberra", 77000, 4, null, 12); 
		FloatLoan carly = new FloatLoan("7", "Parramatta", 55300, 2, carlyPayment, 30); 
		FloatLoan charlie = new FloatLoan("8", "Wollongong", 11300, 2, charliePayment, 4); 
		FloatLoan james = new FloatLoan("9", "New York", 100, 2, jamesPayment, 4); 
		
		ArrayList<Loan> collectionOfLoans = new ArrayList<Loan>();
		collectionOfLoans.add(jerry); // fixed
		collectionOfLoans.add(alex);
		collectionOfLoans.add(tom);
		collectionOfLoans.add(kwon);
		collectionOfLoans.add(donaldDuck);
		
		collectionOfLoans.add(harry); //float loans
		collectionOfLoans.add(carly);
		collectionOfLoans.add(charlie);
		collectionOfLoans.add(james);
	 
		
	
		Scanner input = new Scanner(System.in);
		int option;
		do{
			System.out.println("################# MAINMENU #################");
			System.out.println("1: Create a loan");
			System.out.println("2: Make a payment");
			System.out.println("3: Deposit money into the offset account (FLOAT LOAN ONLY)");
			System.out.println("4: Withdraw money from the offset account (FLOAT LOAN ONLY)");
			System.out.println("5: Apply interest to all loans");
		    System.out.println("6: Total amount of loans");
			System.out.println("7: Loan amount per Suburb");
			System.out.println("8: Payments made in the last 6 Months");
			System.out.println("9: Exit this program");
			System.out.println("############################################");
			System.out.print("Please select an action from above: ");
			option=input.nextInt(); //Takes user input
			
			switch(option){
				case 1: // Choose what loan to create (fixed or float)
				do{
					System.out.println(" ");
					System.out.println("---------- Create a loan ---------");
					System.out.println("Please choose which type of loan ");
					System.out.println("1: Fixed rate loan");
					System.out.println("2: Float rate loan");
					System.out.println("3: Return to mainmenu");
					System.out.println("----------------------------------");
					System.out.print("Please select an action from above: ");
					option=input.nextInt(); //Takes user input
					
					switch(option){ //Choosing the type of loan
						case 1: //Fixed Rate
						System.out.println(" ");
						System.out.println("---------- Fixed Rate Loan ---------");
						String loanIDNumber = Integer.toString(collectionOfLoans.size()+1);
						
						System.out.print("Please enter your Suburb: ");
						String suburb = input.next(); 
						System.out.print("Please enter your Balance: ");
						double balance = input.nextDouble();
						System.out.print("Please enter the months left before the loan is FULLY paid: ");
						int term = input.nextInt();
						
						System.out.print("Please enter the Loan Rate: ");
						double rate = input.nextDouble();
				
					    FixedLoan createFixedLoan = new FixedLoan(loanIDNumber, suburb, balance, term, null, rate);
						collectionOfLoans.add(createFixedLoan);
						System.out.println(" ");
					    System.out.println("-----------------------------------------------------------------------------------");
						createFixedLoan.loanInformation();
					    System.out.println("-----------------------------------------------------------------------------------");
						
						option = 3; // Quits out of switch loop and rebounds back to "MainMenu"
						break;
					
						case 2: // Float Rate
						System.out.println("---------- Float Rate Loan ---------");
						loanIDNumber = Integer.toString(collectionOfLoans.size()+1);
						
						System.out.print("Please enter your Suburb: ");
						suburb = input.next(); 
						System.out.print("Please enter your Balance: ");
						balance = input.nextDouble();
						System.out.print("Please enter the months left before the loan is FULLY paid: ");
						term = input.nextInt();
						System.out.print("Please enter the Loan Offset: ");
						double offset = input.nextDouble();
						
					    FloatLoan createFloatLoan = new FloatLoan(loanIDNumber, suburb, balance, term, null, offset);
						collectionOfLoans.add(createFloatLoan);
						System.out.println(" ");
						
					    System.out.println("-----------------------------------------------------------------------------------");
						createFloatLoan.loanInformation();
					    System.out.println("-----------------------------------------------------------------------------------");
	
						option = 3; // Quits out of switch loop and rebounds back to "MainMenu"
						break;
					
						case 3: // takes user back to mainmenu 
						break;
				
						default: 
						System.out.println("Sorry! The following action was invalid. Please try again.");
					}
				}while(option != 3);
				System.out.println(" ");
				break;
				
				case 2: // make a payment
				System.out.println(" "); 
			    System.out.println("-------------------------- Make a Payment -------------------------------------------------");
				for(Loan printAllLoans : collectionOfLoans){
					printAllLoans.loanInformation();
				    System.out.println("-------------------------------------------------------------------------------------------");
				}
				System.out.print("Please enter the loanID of your loan: ");
				int userLoanID = input.nextInt(); // using an int rather then a string as i'll be minusing it with numerical operators (Line 178 if..else statement)
				
				System.out.println(" ");
				System.out.println("-------------------------------------- LoanID "+userLoanID+"------------------------------------------");
				collectionOfLoans.get(userLoanID-1).loanInformation();
			    System.out.println("-------------------------------------------------------------------------------------------");
				
				System.out.print("Please enter the amount your paying to the loan: ");
				double userAmount = input.nextDouble();
				
				System.out.print("Please enter the date (yyyy/mm/dd): ");
				String year = input.next();
				String month = input.next();
				String day = input.next(); 
				String userDate = year+"/"+month+"/"+day;
				
				double previousBalance = collectionOfLoans.get(userLoanID-1).getBalance(); // balance before the payment is made
				
				if(collectionOfLoans.get(userLoanID-1).getLastPayment().equals(null)){
					Payment newPayment = new Payment("1",Integer.toString(userLoanID),userAmount,userDate); // creates first payment 
					collectionOfLoans.get(userLoanID-1).setLastPayment(newPayment); // sends first payment to Loan super class setLastPayment Method
				}
				else{
					int newPaymentID = Integer.parseInt(collectionOfLoans.get(userLoanID-1).getLastPaymentID()); // converts String to int so that +1 can be added to the paymentID 		
					Payment newPayment = new Payment(Integer.toString(newPaymentID+1),Integer.toString(userLoanID),userAmount,userDate); // converts int to string adding 1 to the new PaymentID which is added to the newPayment object
					collectionOfLoans.get(userLoanID-1).setLastPayment(newPayment); // sends newPayment to Loan super class setLastPayment Method
				}
				collectionOfLoans.get(userLoanID-1).setBalance(collectionOfLoans.get(userLoanID-1).getBalance()-userAmount); //set the new balance of (balance - amount)
				System.out.println(" ");
				System.out.println("------------------------------ UPDATED: LoanID "+userLoanID+"------------------------------------------");	
				System.out.println("Amount payed: $"+userAmount);
				System.out.println("Previous Balance: $"+ previousBalance);
				System.out.println("Current Balance: $"+collectionOfLoans.get(userLoanID-1).getBalance());
			    System.out.println("-------------------------------------------------------------------------------------------");
				System.out.print("");
				break;
				
				case 3:  //Deposit money into the offset account (ONLY for a FLOAT LOAN)
				System.out.println(" ");
				System.out.println("---------- Deposit money into the offset account ---------");
				System.out.println("------------------ (ONLY FOR FLOAT LOANS) -----------------");
				for(Loan printAllLoans: collectionOfLoans){ //printAllLoans is a Loan object
					if(printAllLoans.getOffsetChecker() != false){
						printAllLoans.loanInformation();
					    System.out.println("--------------------------------------------------------------");
					}
				}
			 
				System.out.print("Please enter the loanID of your loan: ");
				userLoanID = input.nextInt(); // using an int rather then a string as i'll be minusing it with numerical operators (Line 212) 
				
				System.out.println(" ");
				System.out.println("-------------------------------------- LoanID "+userLoanID+"------------------------------------------");
				collectionOfLoans.get(userLoanID-1).loanInformation();
			    System.out.println("-------------------------------------------------------------------------------------------");
			
				System.out.print("Please enter the amount your depositing to your OFFSET account: ");
				double depositingOffset = input.nextDouble();
			
				double offsetBeforeDeposit = collectionOfLoans.get(userLoanID-1).getOffset();
				collectionOfLoans.get(userLoanID-1).setOffset(offsetBeforeDeposit+depositingOffset); // adds the original offset to the deposit
			
				System.out.println(" ");
				System.out.println("------------------------------ UPDATE: LoanID "+userLoanID+"------------------------------------------");	
				collectionOfLoans.get(userLoanID-1).loanInformation();
			    System.out.println("-------------------------------------------------------------------------------------------");
				System.out.println(" ");
				break;
				
				case 4: // Withdraw money from the offset account (ONLY for a FLOAT LOAN)
				System.out.println(" ");
				System.out.println("---------- Withdraw money from the offset account ---------");
				System.out.println("------------------ (ONLY FOR FLOAT LOANS) -----------------");
				
				for(Loan printAllLoans: collectionOfLoans){ //printAllLoans is a Loan object
					if(printAllLoans.getOffsetChecker() != false){
						printAllLoans.loanInformation();
					    System.out.println("--------------------------------------------------------------");
					}
				}
			 
				System.out.print("Please enter the loanID of your loan: ");
				userLoanID = input.nextInt(); // using an int rather then a string as i'll be minusing it with numerical operators (Line 235)
				System.out.println(" ");
				System.out.println("-------------------------------------- LoanID "+userLoanID+"------------------------------------------");
				collectionOfLoans.get(userLoanID-1).loanInformation();
			    System.out.println("-------------------------------------------------------------------------------------------");
				double offsetBeforeWithdrawal = collectionOfLoans.get(userLoanID-1).getOffset();
				if(offsetBeforeWithdrawal == 0.0){
					System.out.println("You currently cannot withdraw money from your offset account as you it is currently at zero");
					System.out.println("If you'd like to change this please make a deposite to your offset");
				}
				else{
					System.out.print("Please enter the amount your withdrawing from your OFFSET account: ");
					double withdrawOffset = input.nextDouble();
			
					while(withdrawOffset>offsetBeforeWithdrawal){
						System.out.println("Invaild Amount!");
						System.out.print("Please an amount your ABLE to withdrawing from your OFFSET account: ");
						withdrawOffset = input.nextDouble();
					}
							
					collectionOfLoans.get(userLoanID-1).setOffset(offsetBeforeWithdrawal-withdrawOffset);// Offset (before withdrawal)-withdrawOffset
			
					System.out.println(" ");
					System.out.println("------------------------------ UPDATE: LoanID "+userLoanID+"------------------------------------------");	
					collectionOfLoans.get(userLoanID-1).loanInformation();
				    System.out.println("-------------------------------------------------------------------------------------------");
				}
				System.out.print(" ");
				break;
				
				case 5: //Apply interest to all loans
				System.out.println(" ");
				for(Loan addInterest: collectionOfLoans){
					double interest = addInterest.getBalance() * addInterest.calculatingInterest();// balance * interest rate
					addInterest.setBalance(addInterest.getBalance()+interest); // added interest to balance
					addInterest.setTerm(addInterest.getTerm()-1); //update terms
				}
				System.out.println("Interest has been ADDED to ALL LOANS!");
				for(Loan printAllLoans : collectionOfLoans){
					printAllLoans.loanInformation();
				}
				System.out.println(" ");
				break;
				
				case 6://Total ammount of loans
				System.out.println(" ");
				double total = 0; // stores total of loans
				for(Loan listOfLoans: collectionOfLoans){
					total+=listOfLoans.getBalance();
				}
				
			    System.out.println("-------------------------------------------------------");
				System.out.println("The total amount of ALL loans is: $"+total);
			    System.out.println("-------------------------------------------------------");
				System.out.print(" ");
				break;
			
				case 7: // Loan amount per Suburb
				System.out.println(" ");
				System.out.println("---------- Loan Amount Per Suburb ---------");	
				
				ArrayList<String> listOfSuburbs = new ArrayList<>();
				for(Loan loanLoopOne : collectionOfLoans){
					double balancePerSuburb = 0.0;
					for(Loan loanLoopTwo : collectionOfLoans){
						if(loanLoopTwo.getSuburb().equals(loanLoopOne.getSuburb())){
							balancePerSuburb += loanLoopTwo.getBalance(); 
						}
					}
				    if(listOfSuburbs.contains(loanLoopOne.getSuburb()) == false){
 					   System.out.println(loanLoopOne.getSuburb() + "'s Total Loans: $" + balancePerSuburb);
 					   listOfSuburbs.add(loanLoopOne.getSuburb());				
				    }
				}
				listOfSuburbs.clear();
				System.out.print(" ");
				break;
				
				case 8://Loan report of payments made in the last 6+ Months
				System.out.println(" ");	
				String headingLeftAlignFormat = "| %-15s | %-15s | %-15s |%n";
				String leftAlignFormat = "| %-15s | %-15d | %-15.2f |%n";
				
				System.out.println("------- No Payments made in the last 6+ Months --------");
				
				System.out.printf(headingLeftAlignFormat,"Months:","Count:","Total:");
				
				ArrayList<Payment> recentPayments = new ArrayList<>();
				for(Loan listOfLoans : collectionOfLoans){
					if(listOfLoans.getLastPayment() != null){//removes all Loan objects that havent made a payment 
						recentPayments.add(listOfLoans.getLastPayment());
					}
				}
				
				double totalAmountOfAllLoans = 0; 
				for(Loan totalOfAllLoans : collectionOfLoans){
					totalAmountOfAllLoans+=totalOfAllLoans.getBalance();
					
					
				}
				
				for(int i = 0; i < recentPayments.size()-1;i++){   // sort bubble loop
					for(int j=0; j < recentPayments.size()-1-i; j++){
						int paymentYear = Integer.parseInt(recentPayments.get(j).getDate().substring(0,4));
						int paymentYear2 = Integer.parseInt(recentPayments.get(j+1).getDate().substring(0,4));
						if(paymentYear<paymentYear2){ //if paymentYear is greater than paymentYear2 fix
							Collections.swap(recentPayments, j,(j+1));
						}
						if(paymentYear==paymentYear2){
							int paymentMonth = Integer.parseInt(recentPayments.get(j).getDate().substring(5,7));
							int paymentMonth2 = Integer.parseInt(recentPayments.get(j+1).getDate().substring(5,7));
							if(paymentMonth<paymentMonth2){
								Collections.swap(recentPayments, j,(j+1));
							}
						}
					} 
				}
				
				int counter=0;
				
				int counterMonth1 = 0;
				int counterMonth2 = 0;
				int counterMonth3 = 0;
				int counterMonth4 = 0;
				int counterMonth5 = 0;
				int counterMonth6 = 0;
				
				double totalAmountMonth1 = 0;
				double totalAmountMonth2 = 0;
				double totalAmountMonth3 = 0;
				double totalAmountMonth4 = 0;
				double totalAmountMonth5 = 0;
				double totalAmountMonth6 = 0;
				
				for(Payment paymentLoopOne : recentPayments){ // paymentLoopOne
					double totalAmount = 0.0;
					counter = 0;
					for(Payment paymentLoopTwo : recentPayments){ // paymentLoopTwo
						int paymentYear = Integer.parseInt(paymentLoopTwo.getDate().substring(0,4));
						int paymentMonth = Integer.parseInt(paymentLoopTwo.getDate().substring(5,7));
						int paymentYear2 = Integer.parseInt(paymentLoopOne.getDate().substring(0,4));
						int paymentMonth2 = Integer.parseInt(paymentLoopOne.getDate().substring(5,7));
						if(paymentYear == currentYear & (currentMonth-paymentMonth) < 6 ){// currentYear and currentMonth is written in batch code at the start of main
							if((currentMonth-paymentMonth) == 0){
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmountOfAllLoans-=loanTotal.getBalance();
									}
								}
							}
							else if((currentMonth-paymentMonth) > 0){
								if(paymentMonth == paymentMonth2 & (currentMonth-paymentMonth) == 1){
									++counter;
									for(Loan loanTotal: collectionOfLoans){
										if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
											totalAmount+=loanTotal.getBalance();
										}
									}
								}
								else if(paymentMonth == paymentMonth2 & (currentMonth-paymentMonth) == 2){
									++counter;									
									for(Loan loanTotal: collectionOfLoans){
										if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
											totalAmount+=loanTotal.getBalance();
										}
									}
								}
								else if(paymentMonth == paymentMonth2 & (currentMonth-paymentMonth) == 3){
									++counter;
									for(Loan loanTotal: collectionOfLoans){
										if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
											totalAmount+=loanTotal.getBalance();
										}
									}
								}
								else if(paymentMonth == paymentMonth2 & (currentMonth-paymentMonth) == 4){
									++counter;									
									for(Loan loanTotal: collectionOfLoans){
										if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
											totalAmount+=loanTotal.getBalance();
										}
									}
								}
								else if(paymentMonth == paymentMonth2 & (currentMonth-paymentMonth) == 5){
									++counter;									
									for(Loan loanTotal: collectionOfLoans){
										if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
											totalAmount+=loanTotal.getBalance();
										}
									}
								}
							}
						}
						else if((currentYear - paymentYear) == 1 && (paymentMonth-currentMonth) > 6){ // only a year ago
							if(paymentMonth == paymentMonth2 & (paymentMonth-currentMonth) == 11){ // month 1
								++counter;
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmountOfAllLoans-=loanTotal.getBalance();
									}
								}
							}
							else if(paymentMonth == paymentMonth2 & (paymentMonth-currentMonth) == 10){ //month 2
								++counter;
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmount+=loanTotal.getBalance();
									}
								}
							}
							else if(paymentMonth == paymentMonth2 & (paymentMonth-currentMonth) == 9){ // month3
								++counter;
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmount+=loanTotal.getBalance();
									}
								}
							}
							else if(paymentMonth == paymentMonth2 & (paymentMonth-currentMonth) == 8){ // month 4
								++counter;
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmount+=loanTotal.getBalance();
									}
								}
							}
							else if(paymentMonth == paymentMonth2 & (paymentMonth-currentMonth) == 7){ //month 5
								++counter;
								for(Loan loanTotal: collectionOfLoans){
									if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
										totalAmount+=loanTotal.getBalance();
									}
								}
							}
						} 
						else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) >= 6 || (currentYear-Integer.parseInt(paymentLoopOne.getDate().substring(0,4))) >1 || (currentYear-Integer.parseInt(paymentLoopOne.getDate().substring(0,4))) == 1 && (Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) <=6 ){
							++counter;
							for(Loan loanTotal: collectionOfLoans){
								if(loanTotal.getLoanID().equals(paymentLoopTwo.getLoanID())){
									totalAmount+=loanTotal.getBalance();
								}
							}
						}
					}
						
					if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) == 1){ 
						counterMonth1=collectionOfLoans.size()-counter;
						totalAmountMonth1=totalAmountOfAllLoans-totalAmount;
					} 
					else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) == 2){
						if(totalAmountMonth1==0){
							totalAmountMonth2=totalAmountOfAllLoans-totalAmount;		
						}else{
							totalAmountMonth2=totalAmountMonth1-totalAmount;	
						}	
						
						if(counterMonth1 == 0){
							counterMonth2=collectionOfLoans.size()-counter;
						}else{
							counterMonth2=counterMonth5-counter;
						}
					}
					else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) == 3){
						if(totalAmountMonth2 == 0){
							if(totalAmountMonth1 == 0){
								totalAmountMonth3=totalAmountOfAllLoans-totalAmount;		
								
							}else{
								totalAmountMonth3 = totalAmountMonth1 - totalAmount;
							}
						}else{
							totalAmountMonth3=totalAmountMonth2-totalAmount;
						}
						if(counterMonth2 == 0){
							if(counterMonth1 == 0){
								counterMonth3=collectionOfLoans.size()-counter;
							}else{
								counterMonth3=counterMonth1-counter;
							}
						}else{
							counterMonth3=counterMonth2-counter;
						}
								
					}
					else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) == 4){
						if(totalAmountMonth3 == 0){
							if(totalAmountMonth2 == 0){
								if(totalAmountMonth1 == 0){
									totalAmountMonth4=totalAmountOfAllLoans-totalAmount;
								}else{
									totalAmountMonth4=totalAmountMonth1-totalAmount;
								}
								
							}else{
								totalAmountMonth4=totalAmountMonth2-totalAmount;
							}
							
						}else{
							totalAmountMonth4=totalAmountMonth3-totalAmount;
						}
						
						if(counterMonth3 == 0){
							if(counterMonth2 == 0){
								if(counterMonth1 == 0){
									counterMonth4=collectionOfLoans.size()-counter;
								}else{
									counterMonth4=counterMonth1-counter;
									
								}
							}else{
								counterMonth4=counterMonth2-counter;
								
							}
							
						}else{
							counterMonth4=counterMonth3-counter;
						}
						
					}
					else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) == 5 ){
						if(totalAmountMonth4 == 0){
							if(totalAmountMonth3 == 0){
								if(totalAmountMonth2 == 0){
									if(totalAmountMonth1 == 0){
										totalAmountMonth5=totalAmountOfAllLoans-totalAmount;
									}else{
										totalAmountMonth5=totalAmountMonth1-totalAmount;
										
									}
								}else{
									totalAmountMonth5=totalAmountMonth2-totalAmount;
									
								}
							}else{
								totalAmountMonth5=totalAmountMonth3-totalAmount;
							}
						}else{
							totalAmountMonth5=totalAmountMonth4-totalAmount;
						}
						
						if(counterMonth4 == 0){
							if(counterMonth3 == 0){
								if(counterMonth2==0){
									if(counterMonth1==0){
										counterMonth5=collectionOfLoans.size()-counter;
									}else{
										counterMonth5=counterMonth1-counter;
									}
								}else{
									counterMonth5=counterMonth2-counter;
								}
							}else{
								counterMonth5=counterMonth3-counter;
							}
						}else{
							counterMonth5=counterMonth4-counter;
						}
					}
					else if((currentMonth-Integer.parseInt(paymentLoopOne.getDate().substring(5,7))) >= 6 || (currentYear-Integer.parseInt(paymentLoopOne.getDate().substring(0,4))) >1 || (currentYear-Integer.parseInt(paymentLoopOne.getDate().substring(0,4))) == 1 && (Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) <=6 ){
						if(totalAmountMonth5 == 0){
							if(totalAmountMonth4 == 0){
								if(totalAmountMonth3 == 0){
									if(totalAmountMonth2 == 0){
										if(totalAmountMonth1==0){
											totalAmountMonth6=totalAmountOfAllLoans-totalAmount;
										}else{
											totalAmountMonth6=totalAmountMonth1-totalAmount;
										}
									}else{
										totalAmountMonth6=totalAmountMonth2-totalAmount;
									}
								}else{
									totalAmountMonth6=totalAmountMonth3-totalAmount;
								}
							}else{
								totalAmountMonth6=totalAmountMonth4-totalAmount;								
							}
						}else{
							totalAmountMonth6=totalAmountMonth5-totalAmount;
						}
						
						if(counterMonth5 == 0){
							if(counterMonth4==0){
								if(counterMonth3==0){
									if(counterMonth2==0){
										if(counterMonth1==0){
											counterMonth6=collectionOfLoans.size()-counter;
										}else{
											counterMonth6=counterMonth4-counter;
											
										}
									}else{
										counterMonth6=counterMonth2-counter;
										
									}
								}else{
									counterMonth6=counterMonth3-counter;
									
								}
							}else{
								counterMonth6=counterMonth4-counter;
							}
							
						}else{
							counterMonth6=counterMonth5-counter;
						}
					}
					
					else if((Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) == 11){
						if(totalAmountMonth1==0){
							totalAmountMonth2=totalAmountOfAllLoans-totalAmount;		
						}else{
							totalAmountMonth2=totalAmountMonth1-totalAmount;	
						}	
						
						if(counterMonth1 == 0){
							counterMonth2=collectionOfLoans.size()-counter;
						}else{
							counterMonth2=counterMonth5-counter;
						}
					}
					else if((Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) == 10){// month 2
						if(totalAmountMonth2 == 0){
							if(totalAmountMonth1 == 0){
								totalAmountMonth3=totalAmountOfAllLoans-totalAmount;		
								
							}else{
								totalAmountMonth3 = totalAmountMonth1 - totalAmount;
							}
						}else{
							totalAmountMonth3=totalAmountMonth2-totalAmount;
						}
						if(counterMonth2 == 0){
							if(counterMonth1 == 0){
								counterMonth3=collectionOfLoans.size()-counter;
							}else{
								counterMonth3=counterMonth1-counter;
							}
						}else{
							counterMonth3=counterMonth2-counter;
						}
					} 
					else if((Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) == 9){// month 3
						if(counterMonth2 == 0){
							totalAmountMonth3 = totalAmountMonth1-totalAmount;
						}else{
							totalAmountMonth3=totalAmountMonth2-totalAmount;
						}
						if(counterMonth2 == 0){
							counterMonth3=counterMonth1-counter;
							
						}else{
							counterMonth3=counterMonth2-counter;
						}
					} 
					else if((Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) == 8){ // month 4
						if(totalAmountMonth3 == 0){
							if(totalAmountMonth2 == 0){
								if(totalAmountMonth1 == 0){
									totalAmountMonth4=totalAmountOfAllLoans-totalAmount;
								}else{
									totalAmountMonth4=totalAmountMonth1-totalAmount;
								}
								
							}else{
								totalAmountMonth4=totalAmountMonth2-totalAmount;
							}
							
						}else{
							totalAmountMonth4=totalAmountMonth3-totalAmount;
						}
						
						if(counterMonth3 == 0){
							if(counterMonth2 == 0){
								if(counterMonth1 == 0){
									counterMonth3=collectionOfLoans.size()-counter;
								}else{
									counterMonth4=counterMonth1-counter;
									
								}
							}else{
								counterMonth4=counterMonth2-counter;
								
							}
							
						}else{
							counterMonth4=counterMonth3-counter;
						}
					}
					else if((Integer.parseInt(paymentLoopOne.getDate().substring(5,7))-currentMonth) == 7){ // month 5
						if(totalAmountMonth4 == 0){
							if(totalAmountMonth3 == 0){
								if(totalAmountMonth2 == 0){
									if(totalAmountMonth1 == 0){
										totalAmountMonth5=totalAmountOfAllLoans-totalAmount;
									}else{
										totalAmountMonth5=totalAmountMonth1-totalAmount;
										
									}
								}else{
									totalAmountMonth5=totalAmountMonth2-totalAmount;
									
								}
							}else{
								totalAmountMonth5=totalAmountMonth3-totalAmount;
							}
						}else{
							totalAmountMonth5=totalAmountMonth4-totalAmount;
						}
						
						if(counterMonth4 == 0){
							if(counterMonth3 == 0){
								if(counterMonth2==0){
									if(counterMonth1==0){
										counterMonth5=collectionOfLoans.size()-counter;
									}else{
										counterMonth5=counterMonth1-counter;
									}
								}else{
									counterMonth5=counterMonth2-counter;
								}
							}else{
								counterMonth5=counterMonth3-counter;
							}
						}else{
							counterMonth5=counterMonth4-counter;
						}
					}
				}
				
				if(counterMonth1== 0){
					counterMonth1=collectionOfLoans.size();
					totalAmountMonth1 = totalAmountOfAllLoans;
				}
				
				if(counterMonth2 == 0){
					counterMonth2 = counterMonth1;
					totalAmountMonth2=totalAmountMonth1;
				}
				
				if(counterMonth3 == 0){
					counterMonth3 = counterMonth2;
					totalAmountMonth3=totalAmountMonth2;
				}
				if(counterMonth4 == 0){
					counterMonth4 = counterMonth3;
					totalAmountMonth4=totalAmountMonth3;
				}
				if(counterMonth5 == 0){
					counterMonth5 = counterMonth4;
					totalAmountMonth5=totalAmountMonth4;
				}
				if(counterMonth6 == 0){
					counterMonth6 = counterMonth5;
					totalAmountMonth6=totalAmountMonth5;
				}
				
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"1",counterMonth1,totalAmountMonth1);
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"2",counterMonth2,totalAmountMonth2);
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"3",counterMonth3,totalAmountMonth3);
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"4",counterMonth4,totalAmountMonth4);
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"5",counterMonth5,totalAmountMonth5);
				System.out.printf("-------------------------------------------------------%n");
				System.out.printf(leftAlignFormat,"6+",counterMonth6,totalAmountMonth6);
				System.out.printf("-------------------------------------------------------%n");
				System.out.println(" ");
				
				recentPayments.clear();
				break;
					
				case 9: //exit
				System.out.println("Goodbye!");
				break;
				
				default:
				System.out.println("Sorry! The following action was invalid. Please try again");
			}
		}while(option!=9);	
	}
}
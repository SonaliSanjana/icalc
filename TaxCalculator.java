import java.util.*;
class TaxCalculator{
	
	public final static void clearConsole(){
		try{   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		boolean valid=true;
		while(valid){
		int optionMainWindow=mainWindow();		
		clearConsole();
		switch(optionMainWindow){
			case 1:
			clearConsole();
			int optionWithHolding=withHoldingTax();
			switch(optionWithHolding){
					case 1:
					clearConsole();
					char anotherRent=rentTax();	
					while(anotherRent=='Y'){
						clearConsole();
						anotherRent=rentTax();
					}if(anotherRent=='N'){
						valid=true;
						break;
						}
					break;
					case 2:
					clearConsole();
					char anotherBankInterest=bankInterest();
					while(anotherBankInterest=='Y'){
						clearConsole();
						anotherBankInterest=bankInterest();
					}if(anotherBankInterest=='N'){
						valid=true;
						break;
						}
					break;
					case 3:
					clearConsole();
					char anotherDividend=dividendTax();
					while( anotherDividend=='Y'){
						clearConsole();
						anotherDividend=dividendTax();
					}if( anotherDividend=='N'){
						valid=true;
						break;
						}
					break;
					case 4:
					System.exit(0);
					break;
			}
			break;
			case 2:
			clearConsole();
			char anotherPayable=payableTax();
			while(anotherPayable=='Y'){
				clearConsole();
				anotherPayable=payableTax();
			}if( anotherPayable=='N'){
				valid=true;
				break;
				}
			break;
			case 3:
			clearConsole();
			char anotherIncome=incomeTax();
			while(anotherIncome=='Y'){
				clearConsole();
				 anotherIncome=incomeTax();
			}if( anotherIncome=='N'){
				valid=true;
				break;
				}
			break;
			case 4:
			clearConsole();
			//sscl method
			case 5:
			clearConsole();
			//leasing method
			case 6:
			System.exit(0);
			}
		}
	}

	public static int withHoldingTax(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("|                       WITHHOLDING TAX                         |");
		System.out.println("+---------------------------------------------------------------+\n");
		System.out.printf("%s[1] Rent Tax\n\n",space8);
		System.out.printf("%s[2] Bank Interest Tax\n\n",space8);
		System.out.printf("%s[3] Dividend Tax\n\n",space8);
		System.out.printf("%s[4] Exit\n\n\n",space8);
		System.out.print(" Enter an option to continue -> ");
		int optionWithHolding=input.nextInt();
		return optionWithHolding;
	}

	public static char rentTax(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("|                       RENT TAX                               |");	
		System.out.println("+--------------------------------------------------------------+\n");
		System.out.print("  Enter your rent		: ");
		double rentTax=input.nextDouble();
		double tempRent=0;
		double tax=0;
		if(rentTax<=0){
			space8=("        ");
			System.out.printf("\n%sInvalid input...\n\n\n",space8);
			System.out.print("Do you want to enter the correct value again (Y/N) : ");
		}else if(rentTax<=100000 && rentTax>0){
			System.out.printf("\n%sYou dont have to pay rent tax...",space8);
			System.out.print("\n\n\nDo you want to calculate another Rent Tax (Y/N) : ");
		}else if(rentTax>100000 && rentTax>0){
			tempRent=rentTax;
			tempRent-=100000;
			tax=(tempRent*0.1);
			System.out.printf("\n  You have to pay Rent Tax	: %.2f",tax);
			System.out.print("\n\n\nDo you want to calculate another Rent Tax (Y/N) : ");
		}
		char anotherRent=input.next().charAt(0);
		return anotherRent;
	}

	public static char bankInterest(){
		Scanner input=new Scanner(System.in);
		System.out.println("+---------------------------------------------------------------+ ");
		System.out.println("|                       BANK INTEREST TAX                       |");	
		System.out.println("+---------------------------------------------------------------+\n");
		System.out.print("  Enter your bank interest per year          : ");
		double bankInterest=input.nextDouble();
		if(bankInterest<=0){
			String space8=("        ");
			System.out.printf("\n%sInvalid input...\n\n\n",space8);
			System.out.print("Do you want to enter the correct value again (Y/N) : ");
		}else{
			bankInterest*=0.05;
			System.out.printf("\n  You have to pay Bank Interest Tax per year : %.2f\n",bankInterest);
			System.out.print("\n\n\nDo you want to calculate another Bank Interest Tax (Y/N) : ");
		}	
		char anotherBankInterest=input.next().charAt(0);
		return anotherBankInterest;
	}

	public static char dividendTax(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("+----------------------------------------------------------+");
		System.out.println("|                       DIVIDEND TAX                       |");	
		System.out.println("+----------------------------------------------------------+\n");
		System.out.print("  Enter your total dividend per year    : ");
		double dividendPerYear=input.nextDouble();
		if(dividendPerYear<=0){
			space8=("        ");
			System.out.printf("\n%sInvalid input...\n\n\n",space8);
			System.out.print("Do you want to enter the correct value again (Y/N) : ");
		}else if(dividendPerYear<=100000 && dividendPerYear>0){
			System.out.printf("\n%sYou don't have to pay Dividend Tax...",space8);
			System.out.print("\n\n\nDo you want to calculate another Bank Interest Tax (Y/N) : ");
		}else if(dividendPerYear>100000 && dividendPerYear>0){
			dividendPerYear-=100000;
			dividendPerYear*=0.14;
			System.out.printf("\n  You have to pay Dividend Tax per year : %.2f",dividendPerYear);
			System.out.print("\n\n\nDo you want to calculate another Bank Interest Tax (Y/N) : ");
		}
		char anotherDividend=input.next().charAt(0);
		return anotherDividend;
	}


	public static char payableTax(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("+---------------------------------------------------------+");
		System.out.println("|                       PAYABLE TAX                       |");	
		System.out.println("+---------------------------------------------------------+\n");
		System.out.print("  Enter your employee payment per month : ");
		double payableTax=input.nextDouble();
		double tempPayable=payableTax;
		double tax=0;
		if(payableTax<=0){
			space8=("        ");
			System.out.printf("\n%sInvalid input...\n\n\n",space8);
			System.out.print("Do you want to enter the correct value again (Y/N) : ");
		}else if(tempPayable<=100000 && tempPayable>0){
			System.out.printf("\n%sYou don't have to pay Payable Tax...",space8);
			System.out.print("\n\n\nDo you want to calculate another Payable Tax (Y/N) : ");
		}else{
			if(tempPayable<=141667){
				tempPayable-=100000;
				tax=tempPayable*0.06;
			}else if(tempPayable<=183333){
				tempPayable-=141667;
				tax=(tempPayable*0.12)+(41667*0.06);
			}else if(tempPayable<=225000){
				tempPayable-=183333;
				tax=(tempPayable*0.18)+(41667*0.06)+(41667*0.12);
			}else if(tempPayable<=266667){
				tempPayable-=225000;
				tax=(tempPayable*0.24)+(41667*0.06)+(41667*0.12)+(41667*0.18);
			}else if(tempPayable<=308333){
				tempPayable-=266667;
				tax=(tempPayable*0.30)+(41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24);
			}else if(tempPayable>308333){
				tempPayable-=308333;
				tax=(tempPayable*0.36)+(41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+(41667*0.3);
			}if((tax*100)%100!=0){
				tax*=100;
				double rem=tax%100;
				if(rem>=50 && rem<=100){
					tax+=(100-rem);
					tax/=100;
				}else if(rem<=50 && rem>0){
					tax-=rem;
					tax/=100;	
				}
			}			
			System.out.printf("\n  You have to pay Payable Tax per month : %.2f",tax);	
			System.out.print("\n\n\nDo you want to calculate another Payable Tax (Y/N) : ");
		}
		char anotherPayable=input.next().charAt(0);		
		return anotherPayable;		
	}

	public static char incomeTax(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("+--------------------------------------------------------+");
		System.out.println("|                       INCOME TAX                       |");	
		System.out.println("+--------------------------------------------------------+\n");
		System.out.print("  Enter your total income per year : ");
		double totalIncome=input.nextDouble();
		double tax=0;
		double tempTotal=totalIncome;
		if(totalIncome<=0){
			space8=("        ");
			System.out.printf("\n%sInvalid input...\n\n\n",space8);
			System.out.print("Do you want to enter the correct value again (Y/N) : ");
		}else if(totalIncome<=1200000 && totalIncome>0){
			System.out.printf("\n%sYou don't have to pay Income Tax...",space8);
			System.out.print("\n\n\nDo you want to calculate another Income Tax (Y/N) : ");
		}else{
			if(totalIncome<=1700000){
				tempTotal-=1200000;
				tax=tempTotal*0.06;
			}else if(totalIncome<=2200000){
				tempTotal-=1700000;
				tax=(tempTotal*0.12)+(500000*0.06);
			}else if(totalIncome<=2700000){
				tempTotal-=2200000;
				tax=(tempTotal*0.18)+(500000*0.06)+(500000*0.12);
			}else if(totalIncome<=3200000){
				tempTotal-=2700000;
				tax=(tempTotal*0.24)+(500000*0.06)+(500000*0.12)+(500000*0.18);
			}else if(totalIncome<=3700000){
				tempTotal-=3200000;
				tax=(tempTotal*0.3)+(500000*0.06)+(500000*0.12)+(500000*0.18)+(500000*0.24);
			}else if (totalIncome>3700000){
				tempTotal-=3700000;
				tax=(tempTotal*0.36)+(500000*0.06)+(500000*0.12)+(500000*0.18)+(500000*0.24)+(500000*0.3);
			}
			System.out.printf("\n  You have to pay Income Tax per year : %.2f",tax);
			System.out.print("\n\n\nDo you want to calculate another Income Tax (Y/N) : ");		
		}
		char anotherIncome=input.next().charAt(0);	
		return anotherIncome;
	}	

	public static int mainWindow(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.println("\n                                                __  ______  ________ ________      ");
		System.out.println("                                               |  \\/      \\|        |        \\    ");  
		System.out.println("                                                \\$|  $$$$$$| $$$$$$$$\\$$$$$$$$     ");
		System.out.println("                                               |  | $$   \\$| $$__      | $$         ");
		System.out.println("                                               |  | $$     | $$  \\     | $$         ");
		System.out.println("                                               | $| $$   __| $$$$$     | $$          ");
		System.out.println("                                               | $| $$__/  | $$_____   | $$          ");
		System.out.println("                                               | $$\\$$    $| $$     \\  | $$        ");
		System.out.println("                                                \\$$ \\$$$$$$ \\$$$$$$$$   \\$$      ");
		System.out.println("    _______             __   __    _____              _         _____   _    _   _                   _______    ____    _____                       ");
		System.out.println("   |__   __|     /\\     \\ \\ / /   / ____|     /\\     | |       / ____| | |  | | | |          /\\     |__   __|  / __ \\  |  __ \\               ");
		System.out.println("      | |       /  \\     \\ V /   | |         /  \\    | |      | |      | |  | | | |         /  \\       | |    | |  | | | |__) |                 ");
		System.out.println("      | |      / /\\ \\     > <    | |        / /\\ \\   | |      | |      | |  | | | |        / /\\ \\      | |    | |  | | |  _  /                ");
		System.out.println("      | |     / ____ \\   / . \\   | |____   / ____ \\  | |____  | |____  | |__| | | |____   / ____ \\     | |    | |__| | | | \\ \\                ");
		System.out.println("      |_|    /_/    \\_\\ /_/ \\_\\   \\_____| /_/    \\_\\ |______|  \\ ____|  \\____/  |______| /_/    \\_\\    |_|     \\____/  |_|  \\_\\\n\n   ");
		System.out.println("===================================================================================================================================\n\n\n           ");
		System.out.printf("%s[1] Withholding Tax\n\n",space8);
		System.out.printf("%s[2] Payable Tax\n\n",space8);
		System.out.printf("%s[3] Income Tax\n\n",space8);
		System.out.printf("%s[4] Social Security Contribution Levy (SSCL) Tax\n\n",space8);
		System.out.printf("%s[5] Leasing Tax\n\n",space8);
		System.out.printf("%s[6] Exit\n\n\n",space8);
		System.out.print(" Enter an option to continue -> ");
		int optionMainWindow=input.nextInt();
		return optionMainWindow;
	}
	
	public static char invalid(){
		Scanner input=new Scanner(System.in);
		String space8=("        ");
		System.out.printf("\n%sInvalid input...\n\n\n",space8);
		System.out.print("Do you want to enter the correct value again (Y/N) : ");
		char again=input.next().charAt(0);
		return again;
	}
}	


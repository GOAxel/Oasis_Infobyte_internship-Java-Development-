import java.util.Scanner;

public class Atm
{
	public static void main(String[] args) 
	{
	
		
		Scanner sc = new Scanner(System.in);

		double balance =0,deposit=0,withdraw=0;

		int choice, pass=0;
		int Id ;
		String history ="";
		
		 do{
		 	System.out.println("Enter your ID : ");
			Id = sc.nextInt();
			System.out.println("Enter your password : ");
			pass = sc.nextInt();
			

			if((Id != 1234 )&& (pass!=1507))
				System.out.println("Invalid username or password please re-enter correct one");
		 }

		while(Id != 1234 || pass !=1507);
		
		do
		{
			System.out.println("*********************************");
			System.out.println("\n------ATM SERVICES-----\n");
			System.out.println(" 1)Transaction History \n 2)Withdraw \n 3)Deposit \n 4)Transfer \n 5)Check Current balance \n 6)Quit\n\n");
			System.out.println("*********************************");
			System.out.println("\n Enter your choice : ");
			choice = sc.nextInt();

			switch(choice)
			{
				
				
				case 1:
					System.out.println(" Transaction History: \n"+history);
					break;

				case 2:
					System.out.println("\nEnter the amount to withdraw");
					int w = sc.nextInt();

					if(w % 100 != 0)
					{
						System.out.println("\n Enter the amount that is in multiple of 100 ");
					}

					// 500 rs is necessary balance in account

					else if(w > (balance  - 500))
					{
						System.out.println("\n Insufficent Balance");
					}

					else
					{
						balance  = balance  - w;
						System.out.println("\nPlease receive cash");
						System.out.println("Your current account balance is "+balance );
					}
					break;

				case 3:
					System.out.println("\nEnter the amount that you have to Deposit ");
					int d = sc.nextInt();
					balance  = balance  + d;
					System.out.println("Your balance is: "+balance );
					break;

				case 4:
					System.out.println(" ******** Transaction ********");
					{
					
					System.out.print("\n Enter Receipent's Name : ");
					String recpt = sc.next();
					System.out.print("\n Enter amount that you want to transfer : ");
					double amount = sc.nextDouble();
		
				try {
					if ( balance  >= amount ) 
					{
						if ( amount <= 1000000 )
						{
			
							balance -= amount;
							System.out.println("\nSuccessfully Transfered to " + recpt+"\n");
							String str = amount + " Rs transfered to " + recpt + "\n";
							history = history.concat(str);
						}
						else 
						{
							System.out.println("\nInvalid transfer..Limit is 1000000 .00 only");
						}
					}
					else 
					{
						System.out.println("\n Insufficient Balance");
					}
				}
					catch ( Exception e) 
					{
					}
				}

				break;

			case 5: 
				System.out.println("Current balance is "+balance+"\n");
				break;
			case 6:
				System.out.println("Thank you  Visit again ! ");
				break;

			default:
				System.out.println("Invalid choice");

				}

			
		}while(choice!=6);
	}
}
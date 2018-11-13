package com.cg.ui;

import java.util.Scanner;

import com.cg.dto.Customer;
import com.cg.exception.WalletException;
import com.cg.service.WalletServiceImpl;

public class Client {
	public static void main(String args[]) throws WalletException{

		WalletServiceImpl service = new WalletServiceImpl();

		Scanner sc = new Scanner(System.in);

		String name,mobileNo;
		float age;
		double amount;
		int ch = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer;
			switch(ch){
			case 1 :do{
				System.out.println("Enter customer name : ");
				name = sc.next();

				System.out.println("Enter mobile no. : ");
				mobileNo = sc.next();

				System.out.println("Enter age : ");
				age = sc.nextFloat();

				System.out.println("Enter initial amount : ");
				amount = sc.nextDouble();
				if( service.validateMobileNo(mobileNo) && service.validateName(name)&&service.validateAmount(amount)){
					break;
				}
				}while(true);

				System.out.println("data added" );

			customer = new Customer();

			customer.setCuName(name);
			customer.setCuMobileNo(mobileNo);
			customer.setCuAge(age);
			customer.setCuInitBalance(amount);

			service.createAccount(customer);	
			
			break;


		case 2 :
			do{
				System.out.println("Enter your mobile number : ");
				mobileNo = sc.next();

				System.out.println("Enter the amount you want to deposit");
				amount = sc.nextDouble();
				if(service.validateMobileNo(mobileNo)&&service.validateAmount(amount)){
					if(service.validateAccount(mobileNo))
						break;
				}
			}while(true);

			service.deposit(mobileNo, amount);						

			break;

		case 3 :
			do{
				System.out.println("Enter your mobile number : ");
				mobileNo = sc.next();

				System.out.println("Enter the amount you want to withdraw : ");
				amount = sc.nextDouble();
				if(service.validateMobileNo(mobileNo) &&service.validateAmount(amount)){
					if(service.validateAccount(mobileNo))
						break;
				}
			}while(true);

			service.withdraw(mobileNo, amount);

			break;

		case 4 :
			String mobNoRec;
			do{
				System.out.println("Enter your mobile number : ");
				mobileNo = sc.next();

				System.out.println("Enter the amount you want to transfer : ");
				amount = sc.nextDouble();

				System.out.println("Enter receivers mobile number : ");
				mobNoRec = sc.next();
				if(service.validateMobileNo(mobileNo) && service.validateMobileNo(mobNoRec) &&service.validateAmount(amount)){
					if(service.validateAccount(mobNoRec) && service.validateAccount(mobileNo))
						break;
				}
			}while(true);
			service.fundTransfer(mobileNo, mobNoRec, amount);

			break;

		case 5 :
			do{
				System.out.println("Enter the moible id to check balance");
				mobileNo = sc.next();
				if(service.validateMobileNo(mobileNo)&&service.validateAccount(mobileNo))
					break;
			}while(true);

			System.out.println("Current Amount "+service.checkBalance(mobileNo));

			break;

		case 6 :
			System.out.println("exit");
			break;
		default : System.out.println("Invalid input!");
		}

	}while(ch != 6);

}
}

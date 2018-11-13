package com.cg.dao;

import java.util.ArrayList;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.dto.Customer;
import com.cg.exception.WalletException;

public class WalletDAOImpl implements WalletDAO{
	
	
	EntityManager manager;
	public WalletDAOImpl(){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU-Oracle");
		manager =emf.createEntityManager();
	}
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();	
		System.out.println("Customer Details\nName: "+customer.getCuName()+"\nMobile number: "+customer.getCuMobileNo()+"\nAge: "+customer.getCuAge()+"\nBalance: "+customer.getCuInitBalance());
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getCuInitBalance();
		amt=amt+amount;
		cust.setCuInitBalance(amt);
		manager.getTransaction().commit();
		System.out.println("Amount deposited! New balance: "+amt);
	}

	@Override
	public void withdraw(String mobileNo, double withdrawAmount) {
		// TODO Auto-generated method stub
		manager.getTransaction().begin();
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getCuInitBalance();
		if(amt-withdrawAmount>=00){
			amt=amt-withdrawAmount;
			System.out.println(amt);
			cust.setCuInitBalance(amt);
			manager.getTransaction().commit();
			System.out.println("Amount withdrawn! New balance: "+amt);
		}
		else{
			System.out.println("Cannot withdraw! Minimum balance of Rs.500 should be maintained");
		}
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		Customer cust = manager.find(Customer.class, mobileNo);
		double amt =cust.getCuInitBalance();
		System.out.println(amt);
		return amt;
		
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		
		manager.getTransaction().begin();
		Customer cust1 = manager.find(Customer.class, sender);
		double amt1 =cust1.getCuInitBalance();
		Customer cust2 = manager.find(Customer.class, reciever);
		double amt2 =cust2.getCuInitBalance();
		if(amt1-amount>=00){
			amt1=amt1-amount;
			amt2=amt2+amount;
			cust1.setCuInitBalance(amt1);
			cust2.setCuInitBalance(amt2);
			manager.getTransaction().commit();
			System.out.println("Amount transferred!\nNew balance in "+sender+" account is "+amt1+"\nBalance in "+reciever+" account is "+amt2);
		}
		else{
			System.out.println("Cannot tranfer! Sender has to maintain minimum balance of Rs.500");
		}
		
		
		
	}

	@Override
	public boolean validateAccount(String mobileNo) throws WalletException {
		// TODO Auto-generated method stub
		Customer cust3=manager.find(Customer.class, mobileNo);
		if(cust3==null)
			return false;
		return true;
	}
	
}

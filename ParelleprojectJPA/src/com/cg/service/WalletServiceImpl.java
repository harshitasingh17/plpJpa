package com.cg.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.dao.WalletDAO;
import com.cg.dao.WalletDAOImpl;
import com.cg.dto.Customer;
import com.cg.exception.WalletException;


public class WalletServiceImpl implements WalletService{

	WalletDAO dao  = new WalletDAOImpl();
	
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		dao.createAccount(customer);		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.deposit(mobileNo, amount);
		
	}

	@Override
	public void withdraw(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		dao.withdraw(mobileNo, amount);
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		return dao.checkBalance(mobileNo);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		dao.fundTransfer(sender, reciever, amount);
		
	}

	@Override
	public boolean validateName(String name) throws WalletException {
		// TODO Auto-generated method stub
		if(name == null)
			throw new WalletException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,10}");
		Matcher m = p.matcher(name); 
		if(m.matches()){
			return true;
		}
		else{
			return false;
		}
		
	}

	

	@Override
	public boolean validateMobileNo(String mobileNo) throws WalletException{
		try{
			// TODO Auto-generated method stub
			if(mobileNo == null)
				throw new WalletException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(m.matches()){
				return true;
			}
			else{
				return false;
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	

	@Override
	public boolean validateAccount(String mobileNo) throws WalletException {
		// TODO Auto-generated method stub
		
		if(!dao.validateAccount(mobileNo)){
			System.out.println("Mobile Number not found!");
			return false;
		}
		return true;
	}

	@Override
	public boolean validateAmount(double amount) throws WalletException {			//Checking for valid transaction amount
		String am = String.valueOf(amount);
		if(amount < 0){
			return false;
		}
		else
		{
			return true;
			}
		}
}

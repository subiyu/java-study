package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		this.balance = 0;
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
	}

	public void save(int depositAmount) {
		this.balance += depositAmount;
		System.out.println(accountNo + " 계좌에 " + depositAmount + "만원이 입금되었습니다.");
	}
	
	public void deposit(int WithdrawalAmount) {
		this.balance -= WithdrawalAmount;
		System.out.println(accountNo + " 계좌에 " + WithdrawalAmount + "만원이 출금되었습니다.");
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

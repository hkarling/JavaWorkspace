package ch06q19;

public class Account {
	private static final int MIN_BALANCE = 0;
	private static final int MAX_BALANCE = 1000000;
	private int balance;

	public int getBalance() {

		return this.balance;
	}

	public void setBalance(int balance) {
		if (balance >= MIN_BALANCE && balance <= MAX_BALANCE)
			this.balance = balance;
	}
}

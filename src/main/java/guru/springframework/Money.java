package guru.springframework;

public class Money {
	
	protected int amount;
	
	public Money(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount
				       && this.getClass().equals(obj.getClass());
	}
}

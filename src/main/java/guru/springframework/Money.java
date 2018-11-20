package guru.springframework;

public abstract class Money {
	
	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency) {
   		this.amount = amount;
		this.currency = currency;
	}
	
	protected String currency(){
		return this.currency;
	}
	
	public static Money dollar(int amount) {
		return new Dollar(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Franc(amount, "CHF");
	}
	
	public abstract Money times(int multiplier);
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return this.amount == money.amount
				       && this.getClass().equals(obj.getClass());
	}
}

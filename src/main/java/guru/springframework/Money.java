package guru.springframework;

import java.util.Objects;

public class Money implements Expression {
	
	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	protected String currency() {
		return this.currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Money reduce(Bank bank, String toCurrency) {
		return new Money(amount / bank.rate(this.currency, toCurrency), toCurrency);
	}
	
	@Override
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		Money money = (Money) o;
		return amount == money.amount &&
				       this.currency.equals(money.currency);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(amount, currency);
	}
	
	@Override
	public String toString() {
		return "Money{" +
				       "amount=" + amount +
				       ", currency='" + currency + '\'' +
				       '}';
	}
}

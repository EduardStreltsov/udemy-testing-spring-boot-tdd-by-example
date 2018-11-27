package guru.springframework;

public class Sum implements Expression{
	Expression augment;
	Expression addend;
	
	public Sum(Expression augment, Expression addend) {
		this.augment = augment;
		this.addend = addend;
	}
	
	@Override
	public Money reduce(Bank bank, String toCurrency) {
		int amount = augment.reduce(bank, toCurrency).amount + addend.reduce(bank, toCurrency).amount;
		return new Money(amount, toCurrency);
	}
}

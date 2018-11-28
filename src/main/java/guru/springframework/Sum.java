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
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Expression times(int multiplier) {
		return new Sum(augment.times(multiplier), augment.times(multiplier));
	}
}

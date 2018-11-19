package guru.springframework;

public class Dollar extends Money {
	
	public int getAmount() {
		return amount;
	}
	
	public Dollar(int amount){
		super(amount);
	}
	
	public Dollar times(int multiplier) {
		return new Dollar(amount * multiplier);
	}
	
}

package ex0516.test.exam;

public class Tv extends Elec implements ElecFunction {

	private int channel;

	public Tv() {
	}

	public Tv(int channel) {
		this.channel = channel;
	}

	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel = channel;
	}

	@Override
	public void start() {
		System.out.println(this.toString());
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void display() {
		
	}

	@Override
	public String toString() {
		String str = this.getCode() + "\t"  + this.getCost() + "\t" + this.channel;
		return str;
	}
}

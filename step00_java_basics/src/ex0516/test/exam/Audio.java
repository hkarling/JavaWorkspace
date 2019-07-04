package test.exam;

public class Audio extends Elec implements ElecFunction {
	
	private int volumn;
	
	public Audio() {}	

	public Audio(int volumn) {
		this.volumn = volumn;
	}

	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn = volumn;
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
		String str = this.getCode() + "\t"  + this.getCost() + "\t" + this.volumn;
		return str;
	}
}

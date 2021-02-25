package oopsdesign;

public class AdapterPattern {
	
	public static void main(String[] args) {
		
		Voltage5w voltage5w = new VoltageAdapter();
		System.out.println(voltage5w.volatge5w());
		
	}

}

interface IVoltage220w{
	int getVoltage220();
}


class Voltage220WImp implements IVoltage220w{

	@Override
	public int getVoltage220() {
		return 220;
	}
	
}

interface Voltage5w{
	int volatge5w();
	
}

class VoltageAdapter extends Voltage220WImp implements Voltage5w{

	@Override
	public int volatge5w() {
		return getVoltage220()/44;
	}

}
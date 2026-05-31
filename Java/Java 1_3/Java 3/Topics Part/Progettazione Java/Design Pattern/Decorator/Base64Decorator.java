package java3.design_pattern.decorator;

import java.util.Base64;

public class Base64Decorator extends DataSourceDecorator {
	public Base64Decorator(DataSource source) {
		super(source);
	}

	@Override
	public void writeData(String data) {
		// System.out.println("[Base64]: Sto per scrivere -> " + Base64.getEncoder().encodeToString(data.getBytes()));
		getSource().writeData(Base64.getEncoder().encodeToString(data.getBytes()));
	}

	@Override
	public String readData() {
		// System.out.println("[Base64]: Ho letto -> " + getSource().readData());
		// System.out.println("[Base64]: (read) Ritornerò -> " + new String(Base64.getDecoder().decode(getSource().readData())) + " - return cls: " + getSource().getClass().getSimpleName());
		return new String(Base64.getDecoder().decode(getSource().readData()));
		
	}
}
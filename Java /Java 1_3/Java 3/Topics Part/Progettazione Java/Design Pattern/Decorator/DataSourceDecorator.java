package eserciziLezione13;

public abstract class DataSourceDecorator implements DataSource {
		
	    @SuppressWarnings("unused")
		private DataSource source;
	    
	    @Override
		public abstract void writeData(String data);
	    
	    @Override
	    public abstract String readData();
	    
	    
}

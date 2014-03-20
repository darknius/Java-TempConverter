
public class TempConverter {

	/**
	 * instance variables to calculate temperatures
	 */
	//Holds temp celcius
	private double tempC;
	//holds temp fahrenheit
	private double tempF;
	//holds temp kelvin
	private double tempK;
	
	//retrieves celsius temp value
	//return a double value containing celsius temp
	public double getTempC(){
		return tempC;
	}
	
	public double getTempK(){
		return tempK;
	}
	
	public double getTempF(){
		return tempF;
	}
	
	public boolean setTempF(double tempIn){
		if (tempIn < -459.67)
			return false;
		//set fahrenheit value
		tempF = tempIn;
		//calculate celsius temp
		tempC = (tempF - 32.0) * 5.0 / 9.0;
		//calculate kelvin temp
		tempK = tempC + 273.15;
		return true;
	}
	
	public boolean setTempC(double tempIn){
		if (tempIn < -273.15)
			return false;
		tempC = tempIn;
		tempF = tempC * 9.0 / 5.0 + 32.0;
		tempK = tempC + 273.15;
		return true;
	}
	
	public boolean setTempK(double tempIn){
		if (tempIn < 0)
			return false;
		tempK = tempIn;
		tempC = tempK -273.15;
		tempF = tempC * 9.0 / 5.0 + 32.0;
		return true;
	}
	
	//constructor sets fahrenheit value to the value in tempIn
	//then calculates equivalent celsius and kelvin values.
	public TempConverter(double tempIn){
		if (!setTempF(tempIn))
			setTempF(tempIn);
	}
	
	//default constructor
	public TempConverter(){
		this(0.0);
	}

}

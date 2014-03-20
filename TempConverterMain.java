import java.util.Scanner;

public class TempConverterMain extends TempConverter{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputType = "";
		double inputTemp = 0.0;
		Scanner keyInput = new Scanner(System.in);
		TempConverter tc1 = new TempConverter();
		//boolean variables for use with while statements
		boolean anotherTemp = true;
		boolean goodType = false;
		boolean goodTemp = false;
		
		//while anotherTemp is true, execute code below it
		while (anotherTemp){
			System.out.print("Enter a Temperature type (F for fahrenheit, C for celsius, K for kelvin, or Q to quit): ");
			inputType = keyInput.nextLine();
			
			//goodType set to false
			goodType = false;
			//while not goodType, execute if statement below
			while (!goodType){
				//checks if input type is either F, C, K, or Q
				if (inputType.equalsIgnoreCase("F") || inputType.equalsIgnoreCase("C") || inputType.equalsIgnoreCase("K") || inputType.equalsIgnoreCase("Q")){
					//set goodType to true if input is one of the above
					goodType = true;
				}else{
					System.out.print("Please enter a valid temperature type, either F, C, K, or Q to quit: ");
					inputType = keyInput.nextLine();
					continue;
				}
			}
			//if user input is Q, print out "ok, goodbye" then set anotherTemp to false
			if (inputType.equalsIgnoreCase("Q")){
				System.out.println("\nOk, Goodbye");
				anotherTemp = false;
			}
			else {
				goodTemp = true;
				do{
					System.out.print("Enter a Temperature: ");
					if (keyInput.hasNextDouble()){
						inputTemp = keyInput.nextDouble();
					}else {
						System.out.println("\nValue entered is not an acceptable format");
						System.out.println("Please enter a valid numerical Temperature value");
						break;
					}				
					keyInput.nextLine();
					
					if (inputType.equalsIgnoreCase("F")){			
						
						System.out.println("\nYou entered: " + inputTemp + " degrees fahrenheit.");
						tc1.setTempF(inputTemp);
						
						System.out.println("Which is " + tc1.getTempC() + " degrees Celsius.");
						System.out.println("and " + tc1.getTempK() + " degrees Kelvin.");
						System.out.println("*****************************************************");
					}
					else if (inputType.equalsIgnoreCase("C") && tc1.setTempC(inputTemp)){			
						
						System.out.println("\nYou entered: " + inputTemp + " degrees celsius.");
						tc1.setTempC(inputTemp);
						
						System.out.println("Which is " + tc1.getTempF() + " degrees fahrenheit.");
						System.out.println("and " + tc1.getTempK() + " degrees Kelvin.");
						System.out.println("*****************************************************");
						
					}
					else if (inputType.equalsIgnoreCase("K")){			
						
						System.out.println("\nYou entered: " + inputTemp + " degrees kelvin.");
						tc1.setTempK(inputTemp);
						
						System.out.println("Which is " + tc1.getTempC() + " degrees Celsius.");
						System.out.println("and " + tc1.getTempF() + " degrees Fahrenheit.");
						System.out.println("*****************************************************");
					}
					else{
						System.out.println("\nPlease enter a valid temperature type.");
						System.out.println("It must be greater than absolute 0" + " (OK, -273.15C, -459.67F). Try again.");
					
					}
					//goodTemp = false;
				}while (!goodTemp);
				
			}
		}
	}
}

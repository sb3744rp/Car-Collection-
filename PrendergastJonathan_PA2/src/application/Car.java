
/**
 * 
 * 'Car' Java class is a basic blueprint for a Car. It allows the user to create Car objects with limited customization 
 *
 * @author: Jon Prendergast
 * @since: 06/10/2019
 * @version: 1.0
 * 
 */

package application;

public class Car implements Cloneable, Comparable<String>{
	
	private String carMake;
	private String carModel;
	private String carColor;
	private int makeAndModelYear;
	private int mpg;
	private String licensePlate;
	
	/**
	 * 'Car' constructor instantiates a Car object with user selected parameter arguments
	 * 
	 * Source of borrowed code: https://beginnersbook.com/2013/12/java-string-tochararray-method-example/
	 * 
	 * @param desiredCarMake
	 * @param desiredCarModel
	 * @param desiredCarColor
	 * @param desiredMakeAndModelYear
	 * @param desiredMpg
	 * @param desiredLicensePlate
	 */
	
	public Car(String desiredCarMake, String desiredCarModel, String desiredCarColor, int desiredMakeAndModelYear,int desiredMpg, String desiredLicensePlate) {
			this.mpg = desiredMpg;
			
			try 
			{
				if(desiredMakeAndModelYear < 1940 ||desiredMakeAndModelYear > 2019) throw new IllegalArgumentException();
				if(desiredMpg < 5 || desiredMpg > 99) throw new IllegalArgumentException();
				if(desiredLicensePlate.equalsIgnoreCase("null")) throw new IllegalArgumentException();
				containsOnlyLetters(desiredCarMake);//only need to ensure 'car make' contains all letters
				
			}
			catch(Exception a) 
			{
				throw new RuntimeException();
			}
			
			this.carMake = desiredCarMake;
			this.carModel = desiredCarModel;
			this.carColor = desiredCarColor;
			this.makeAndModelYear = desiredMakeAndModelYear;
			this.licensePlate = desiredLicensePlate.toLowerCase();
	}
	
	
	/**
	 * 'containsOnlyLetters' method tests a String to see if it contains only letters of the alphabet
	 * @param: target
	 */
	public static void containsOnlyLetters(String target) {
		for(char c: target.toCharArray()) {
			if(!Character.isAlphabetic(c)) {throw new IllegalArgumentException();}
		}
	}
	
	/**
	 * 'getCarMake' method accesses the 
	 *  private instance variable carMake
	 * 
	 * @return: carMake
	 */
	public String getCarMake() {
		return carMake;
	}


	/**
	 * 'getCarModel' method accesses the 
	 *  private instance variable carModel
	 * 
	 * @return: carModel
	 */
	public String getCarModel() {
		return carModel;
	}
	
	

	/**
	 * 'getCarColor' method accesses the 
	 *  private instance variable carColor
	 * 
	 * @return: carColor
	 */
	public String getCarColor() {
		return carColor;
	}


	/**
	 * 'getCarMakeAndModelYear' method accesses the 
	 *  private instance variable makeAndModelYear
	 * 
	 * @return: makeAndModelYear
	 */
	public int getMakeAndModelYear() {
		return makeAndModelYear;
	}
	
	/**
	 * 'getMpg' method accesses the 
	 *  private instance variable mpg
	 * 
	 * @return: mpg
	 */
	public int getMpg() {
		return mpg;
	}


	/**
	 * 'getLicensePlate' method accesses the 
	 *  private instance variable licensePlate
	 * 
	 * @return: licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	@Override
	public int compareTo(String arg) {
			if(this.licensePlate.equalsIgnoreCase(arg))
				return 0;
			
			else
				return this.licensePlate.compareToIgnoreCase(arg);
	}
	
	/**
	 * 'clone' method produces a full copy of an IntArrayBag instance along with a proper copy of 
	 * the array contained in the bag.
	 */
	public Car clone() {
		Car answer;
		
		try {
			answer = (Car)super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new RuntimeException("Class does not implement cloneable interface");
		}
		return answer;
	}
}
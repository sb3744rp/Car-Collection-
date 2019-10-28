/**
 * 'CarCollection' Java Class is a collection class that utilizes an array to manage the collection
 *  of Car type objects.  
 *  
 *  Source of borrowed code:
 *  
 *  URL: https://gist.github.com/jnwhiteh/68d095c630dfcaddffd1
 * 
 * @author: Jon Prendergast
 * @since: 06/10/2019
 * @version: 1.0
 * 
 */

package application;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CarCollection implements Iterator<Car>, Cloneable, Comparable<String>{

	private Car[] data;
	private int initialCapacity = 10;
	private int manyItems;
	private int currentIndex;
	private String collectionName;
	

	/**
	 * 'CarCollection' constructor is a no arguments constructor that
	 * initializes the collection with a starting capacity of 10 cars. 
	 * 
	 */
	public CarCollection() {
		data = new Car[initialCapacity];
		currentIndex = 0;
		manyItems = 0;
		collectionName = "collection";
	}

	/**
	 * 'CarCollection' constructor allows the user to specify a starting
	 *  capacity for the car collection.
	 *  
	 * @param: initialCapacity
	 */
	public CarCollection(int initialCapacity, String name) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Cannot have a negative capacity.");
		}
		data = new Car[initialCapacity];
		currentIndex = 0;
		manyItems = 0;
		collectionName = name;
	}

	/**
	 * 'displayList' method displays information on each Car object stored in the Car Collection
	 * array. The displays information on the year, make, model, mpg, and unique
	 * serial number.
	 * 
	 * @return: result
	 * 
	 */
	public String displayList() {
		String result;
		result = "";
		for (int i = 0; i < manyItems; i++) {
			result += displayCarInfo(i)+"\n";
		}
		return result;
	}

	/**
	 * 'retrieveAndDisplayCarInfo' method displays information on a 
	 *  car identified by a given searchKey
	 * 
	 * @param searchKey
	 */
	public void retrieveAndDisplayCarInfo(String searchKey) {
		int index;
		index = getCarIndexInCollection(searchKey);

		if (index < 0) {
			System.out.println("Car not found in collection.");
		} else {
			displayCarInfo(index);
		}
	}

	/**
	 * 
	 * 'getCarIndexInCollection' method finds the index of a car in the car collection 
	 *  when given a valid searchKey.  
	 *  
	 *  METHOD UPDATED USING ITERATOR
	 * 
	 * @param: searchKey
	 * @return: index
	 */
	public int getCarIndexInCollection(String searchKey) {
		String caseInsensitive;
		
		caseInsensitive = searchKey.toLowerCase();
		resetCurrentIndex();
		

		while ((hasNext()) && !(caseInsensitive.equals(data[currentIndex].getLicensePlate())))
			next();

		if (currentIndex == manyItems)
			return -1;

		else
			return currentIndex;
	}

	/**
	 * Method 'displayCarInfo' returns car info in the form of a string 
	 *
	 * @param: index
	 * @return: result
	 */
	public String displayCarInfo(int index) {
		String result = "Car Year: " + data[index].getMakeAndModelYear() + "\n" + "Car Make: "
				+ data[index].getCarMake() + "\n" + "Car Model: " + data[index].getCarModel() + "\n" + "Car Color: "
				+ data[index].getCarColor() + "\n" + "Car Mpg: " + data[index].getMpg() + "\n"
				+ "Serial Number(Search Key): " + data[index].getLicensePlate() + "\n";
		return result;
	}
	
	
	/**
	 * Method 'getCollectionName' returns collection name instance variable
	 * 
	 * @return: collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

		
	/**
	 * starting at manyItems = 0, the add method adds Car objects incrementally
	 * until data.lengt-1 is reached. At this point the data array is extended
	 * 
	 * @param: value
	 */
	public void add(Car value) {
		if (manyItems == data.length)
			ensureCapacity((manyItems + 1) * 2);

		if (!isNullReference(value)) {
			data[manyItems] = value;
			manyItems++;
		} else
			throw new IllegalArgumentException("Car collection cannot have a null reference.");
	}

	/**
	 * 'ensureCapacity' method checks to see if minimumCapacity exceeds data.length
	 * 
	 * @param: minimumCapacity
	 */
	public void ensureCapacity(int minimumCapacity) {
		if (data.length < minimumCapacity) {
			Car[] biggerArray;
			biggerArray = new Car[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}

	/**
	 * 'isNullReference' method checks parameter object to see if it has a null reference.
	 * 
	 * @param element
	 * @return: true or false
	 */
	public boolean isNullReference(Car element) {
		return element == null;
	}

	/**
	 * 'remove' method is a boolean method that returns true/false depending on the
	 * existence of the target parameter. If the parameter exists the method will
	 * remove the value from the bag and return true to indicate it was found. If
	 * false, nothing will be removed and the method will return false.
	 * 
	 * @param: target
	 * @return: true/false
	 */
	public boolean remove(String searchKey) {
		int index;
		index = getCarIndexInCollection(searchKey);

		if (index < 0)
			return false;

		else {
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}
	}

	/**
	 * 'getCurrentCapacity' method returns the total size of the bag (length of the
	 * array)
	 * 
	 * @return: data.length
	 */
	public int getCurrentCapacity() {
		return data.length;
	}
	
	
	/**
	 * Method 'setCollectionName' modifies the collectionName instance variable
	 * 
	 * @param: collectionName
	 */
	
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	/**
	 * 'getBag' method returns a reference to the data array contained in the
	 * IntArrayBag instance.
	 * 
	 * @return: data
	 */
	public Car[] getCarCollection() {
		return data;
	}

	/**
	 * 'size' method returns a count of the total number of elements contained in
	 * the bag at the current time this method is called
	 * 
	 * @return: manyItems
	 */
	public int size() {
		return manyItems;
	}

	
	/**
	 * Method 'hasNext' tests car collection array to see if it contains another Car
	 * 
	 * @return: boolean true/false
	 */
	@Override
	public boolean hasNext() {
		if(currentIndex < size()) {
			return true;
		}
		return false;
	}

	/**
	 * Method 'next' returns the current Car in collection while indexing the the next Car object
	 * 
	 * @return: data[currentIndex++]
	 */
	@Override
	public Car next() {
		
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		else {
			return data[currentIndex++];
		}
	}
	
	/**
	 * 'resetCurrentIndex' method resets the current index of the Car collection back to element 0
	 * 
	 */
	public void resetCurrentIndex() {
		currentIndex = 0;
	}
	
	
	/**
	 * Method 'clone' provides a deep clone of a given Car collection
	 * 
	 * @return: answer
	 */
	public CarCollection clone() {
		CarCollection answer;
		
		try {
			answer = (CarCollection)super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new RuntimeException("Class does not implement cloneable interface");
		}
		
		answer.data = data.clone();
		
		return answer; 
	}

	/**
	 * Method 'compareTo' returns an integer indicating the comparison between two Car collection names
	 * 
	 * @param: comparison
	 * @return: int
	 */
	@Override
	public int compareTo(String comparison) {
		if(this.collectionName.equalsIgnoreCase(comparison))
			return 0;
		
		else
			return this.collectionName.compareToIgnoreCase(comparison);
	}
	
	/**
	 * Method 'hasDuplicatPlates'returns an integer indicating whether or not a collection contains a duplicate plate
	 * 
	 * @param: searchKey
	 * @return: int
	 */
	public int hasDuplicatePlates(String searchKey) {
		String caseInsensitive;	
		caseInsensitive = searchKey.toLowerCase();
		resetCurrentIndex();
		
		while((hasNext()) && !(data[currentIndex].getLicensePlate().compareTo(caseInsensitive)==0))
			next();

		if (currentIndex == manyItems)
			return -1;

		else
			return 0;
	}
	
}

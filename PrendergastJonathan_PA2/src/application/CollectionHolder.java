/**
 * 
 * @author: Jon Prendergast
 * @since: 06/17/2019
 * @version: 1.0
 * 
 * /**
 * 'CollectionHolder' Java Class is a collection class that utilizes an array to manage the collection
 *  of CarCollection type objects.  
 *  
 *  Source of Borrowed Code:
 *  
 *  URL: https://gist.github.com/jnwhiteh/68d095c630dfcaddffd1
 * 
 * @author: Jon Prendergast
 * @since: 06/19/2019
 * @version: 1.0
 * 
 */

package application;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class CollectionHolder implements Iterator<CarCollection>{

	private CarCollection[] data;
	private int initialCapacity = 10;
	private int manyItems;// number of elements currently entered in the array
	private int currentIndex;

	/**
	 * 'CarCollection' constructor is a no arguments constructor that
	 * initializes the collection with a starting capacity of 10 cars. 
	 * 
	 */
	public CollectionHolder() {
		data = new CarCollection[initialCapacity];
		currentIndex = 0;
		manyItems = 0;
	}

	/**
	 * 'CarCollection' constructor allows the user to specify a starting
	 *  capacity for the car collection.
	 *  
	 *  
	 * @param: initialCapacity
	 */
	public CollectionHolder(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Cannot have a negative capacity.");
		}
		data = new CarCollection[initialCapacity];
		currentIndex = 0;
		manyItems = 0;
	}

	
	/**
	 * 
	 * 'getCarIndexInCollection' method finds the index of a car in the car collection 
	 *  when given a valid searchKey.  
	 *  
	 * 
	 * @param: searchKey
	 * @return: index
	 */
	public int getCarCollectionIndex(String searchKey) {
		String caseInsensitive;	
		caseInsensitive = searchKey.toLowerCase();
	
		resetCurrentIndex();
		
		while((hasNext()) && !(caseInsensitive.equals(data[currentIndex].getCollectionName())))
			next();

		if (currentIndex == manyItems)
			return -1;

		else
			return currentIndex;
	}

	/**
	 * starting at manyItems = 0, the add method adds Car objects incrementally
	 * until data.lengt-1 is reached. At this point the data array is extended
	 * 
	 * @param: value
	 */
	public void add(CarCollection value) {
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
			CarCollection[] biggerArray;
			biggerArray = new CarCollection[minimumCapacity];
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
	public boolean isNullReference(CarCollection element) {
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
		index = getCarCollectionIndex(searchKey);

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
	 * 'getBag' method returns a reference to the data array contained in the
	 * IntArrayBag instance.
	 * 
	 * @return: data
	 */
	public CarCollection[] getCollectionHolder() {
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
	 * Method 'hasNext' checks list collection hold to see if it contains another collection
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
	 * Method 'next' returns the current collection in the collection holder array
	 * and shifts to the next index
	 * 
	 * @return: data[currentIndex++]
	 */
	@Override
	public CarCollection next() {
		
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
	 * Method 'setCurrentIndex' sets current index to a desired location in the array
	 * 
	 * @throws: IndexOutOfBounds
	 * @param: desiredIndex
	 */
	public void setCurrentIndex(int desiredIndex) {
		currentIndex = desiredIndex;
	}
	
	/**
	 * Method 'hasDuplicateList' searches collection array to see if a duplicate collection name exists 
	 * 
	 * @param: searchKey
	 * @return: int
	 */
	public int hasDuplicateList(String searchKey) {
		String caseInsensitive;	
		caseInsensitive = searchKey.toLowerCase();
		resetCurrentIndex();
		
		while((hasNext()) && !(data[currentIndex].getCollectionName().compareTo(caseInsensitive)==0))
			next();

		if (currentIndex == manyItems)
			return -1;

		else
			return 0;
	}
	
}

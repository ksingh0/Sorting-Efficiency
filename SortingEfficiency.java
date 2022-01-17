import java.util.Scanner;
public class SortingEfficiency 
{
	static int checkCounter = 0, loopCounter = 0, shiftCounter = 0, highCheckCounter = 0, highLoopCounter = 0, highShiftCounter = 0;
	static String highCheck, highLoop, highShift, highTime;
	public static void main(String[] args) 
	{
		//Declarations and Initializations
		int orderChoice = 1, reset = 0, arraySize = 0;
		Scanner sc = new Scanner(System.in);
		long time = -1, highTimeNum = -1;
		do
		{
			//Populate array
			System.out.println("How would you like to sort? 1 for ascending, 2 for descending.");
			orderChoice = sc.nextInt();
			System.out.println("How many random numbers would you like to generate?");
			arraySize = sc.nextInt();
			int randNums[] = new int[arraySize], numStorage[] = new int[arraySize];
			for(int i = 0; i < randNums.length; i++)
			{
				randNums[i] = ((int)(Math.random() * 1001));
				numStorage[i] = randNums[i];
				System.out.print(randNums[i] + " ");
			}//end for
			System.out.println();
			System.out.println();
			//Sorting and output
			for(int i = 1; i <= 4; i++)
			{
				switch (i)
				{
				case 1:
					System.out.println("Selection sort");
					time = System.nanoTime();
					selectionSort(randNums, orderChoice);
					time = System.nanoTime() - time;
					highCheckCounter = checkCounter;
					highCheck = "Selection sort";
					highLoopCounter = loopCounter;
					highLoop = "Selection sort";
					highShiftCounter = shiftCounter;
					highShift = "Selection sort";
					highTimeNum = time;
					highTime = "Selection Sort";
					displayValues(time);
					for(int j = 0; j < randNums.length; j++)
					{
						randNums[j] = numStorage[j];
					}//end for
					
					System.out.println();
					break;
				case 2:
					System.out.println("Bubble sort");
					time = System.nanoTime();
					bubbleSort(randNums, orderChoice);
					time = System.nanoTime() - time;
					if(checkCounter < highCheckCounter) {
						highCheckCounter = checkCounter;
						highCheck = "Bubble sort";
					}
					if(loopCounter < highLoopCounter) {
						highLoopCounter = loopCounter;
						highLoop = "Bubble sort";
					}
					if(shiftCounter < highShiftCounter) {
						highShiftCounter = shiftCounter;
						highShift = "Bubble sort";
					}
					if(time < highTimeNum) {
						highTimeNum = time;
						highTime = "Bubble sort";
					}
					displayValues(time);
					for(int j = 0; j < randNums.length; j++)
					{
						randNums[j] = numStorage[j];
					}//end for
					
					System.out.println();
					break;
				case 3:
					System.out.println("Insertion sort");
					time = System.nanoTime();
					insertionSort(randNums, orderChoice);
					time = System.nanoTime() - time;
					if(checkCounter < highCheckCounter) {
						highCheckCounter = checkCounter;
						highCheck = "Insertion sort";
					}
					if(loopCounter < highLoopCounter) {
						highLoopCounter = loopCounter;
						highLoop = "Insertion sort";
					}
					if(shiftCounter < highShiftCounter) {
						highShiftCounter = shiftCounter;
						highShift = "Insertion sort";
					}
					if(time < highTimeNum) {
						highTimeNum = time;
						highTime = "Insertion sort";
					}
					displayValues(time);
					for(int j = 0; j < randNums.length; j++)
					{
						randNums[j] = numStorage[j];
					}//end for
					
					System.out.println();
					break;
				case 4:
					System.out.println("Quick sort");
					time = System.nanoTime();
					quickSort(randNums, 0, randNums.length - 1, orderChoice);
					time = System.nanoTime() - time;
					if(checkCounter < highCheckCounter) {
						highCheckCounter = checkCounter;
						highCheck = "Quick sort";
					}
					if(loopCounter < highLoopCounter) {
						highLoopCounter = loopCounter;
						highLoop = "Quick sort";
					}
					if(shiftCounter < highShiftCounter) {
						highShiftCounter = shiftCounter;
						highShift = "Quick sort";
					}
					if(time < highTimeNum) {
						highTimeNum = time;
						highTime = "Quick sort";
					}
					displayValues(time);
					
					break;
				}//end big for
			}
			System.out.println("\nThe sorted array is: ");
			for(int i = 0; i < randNums.length;i++) {
				System.out.print(randNums[i] + " ");
			}
			System.out.println();
			System.out.println("\n" + highLoop + " had the least amount of loops with " + highLoopCounter + " loops.");
			System.out.println(highCheck + " had the least amount of checks with " + highCheckCounter + " checks.");
			System.out.println(highTime + " had the quickest processing time with " + highTimeNum + "ns.");
			System.out.println(highShift + " had the least amount of shifts with " + highShiftCounter + " shifts.");
			System.out.println("\nEnter 1 to reset. Enter 2 to quit");
			reset = sc.nextInt();
		}while(reset == 1);//end do while
		sc.close();
	}//end main
	public static void selectionSort(int data[], int order) 
	{
		int smallest, largest;
		if(order == 1)
		{
			for (int i = 0; i < data.length - 1; i++) 
			{
				loopCounter++;
				smallest = i;
				for (int index = i + 1; index < data.length; index++) 
				{
					loopCounter++;
					checkCounter++;
					if (data[index] < data[smallest]) 
					{
						swap(data, smallest, index);
					}//end if
				}//end for
			}//end big for
		}//end if(ascending)
		else
		{
			for (int i = 0; i < data.length - 1; i++) 
			{
				loopCounter++;
				largest = i;
				for (int index = i + 1; index < data.length; index++) 
				{
					if (data[index] > data[largest]) 
					{
						loopCounter++;
						checkCounter++;
						swap(data, largest, index);
					}//end if
				}//end for
			}//end big for
		}//end else(descending)
	}//end selection sort
	public static void bubbleSort(int data[], int order) 
	{
		if(order == 1)
		{
			for (int pass = 1; pass < data.length; pass++) 
			{
				loopCounter++;
				for (int element = 0; element < data.length - 1; element++) 
				{
					loopCounter++;
					checkCounter++;
					if (data[element] > data[element + 1]) 
					{
						swap(data, element, element + 1);
					}//end if
				}//end for
			}//end big for
		}//end if(ascending)
		else
		{
			for (int pass = 1; pass < data.length; pass++) 
			{
				loopCounter++;
				for (int element = 0; element < data.length - 1; element++) 
				{
					loopCounter++;
					checkCounter++;
					if (data[element] > data[element + 1]) 
					{
						swap(data, element, element + 1);
					}//end if
				}//end for
			}//end big for
		}//end else(descending)
	}//end bubble sort
	public static void insertionSort(int data[], int order) 
	{
		int insert;
		if(order == 1)
		{
			for (int next = 1; next < data.length; next++) 
			{
				loopCounter++;
				checkCounter++;
				insert = data[next];
				int moveItem = next;
				while (moveItem > 0 && data[moveItem - 1] > insert) 
				{
					shiftCounter++;
					loopCounter++;
					checkCounter++;
					data[moveItem] = data[moveItem - 1];
					moveItem--;
				}//end while
				data[moveItem] = insert;
			}//end for
		}//end if(ascending)
		else
		{
			for (int next = 1; next < data.length; next++) 
			{
				loopCounter++;
				checkCounter++;
				insert = data[next];
				int moveItem = next;
				while (moveItem > 0 && data[moveItem - 1] < insert) 
				{
					shiftCounter++;
					loopCounter++;
					checkCounter++;
					data[moveItem] = data[moveItem - 1];
					moveItem--;
				}//end while
				data[moveItem] = insert;
			}//end for
		}//end else(descending)
	}//end insertionSort
	public static void quickSort(int data[], int low, int high, int order) 
	{
		int partitionLoc;
		checkCounter++;
		if (low < high) 
		{
			partitionLoc = partition(data, low, high, order);
			loopCounter++;
			quickSort(data, low, partitionLoc - 1, order);
			loopCounter++;
			quickSort(data, partitionLoc + 1, high, order);
		}//end if
	}//end 
	public static int partition(int data2[],int left,int right, int order) 
	{
		boolean moveLeft = true;
		int separator = data2[left];
		if(order == 1)
		{
			while (left < right) 
			{
				loopCounter++;
				checkCounter++;
				if (moveLeft == true) 
				{
					while ((data2[right] >= separator) && (left < right)) 
					{
						loopCounter++;
						right--;
					}
					shiftCounter++;
					data2[left] = data2[right];
					moveLeft = false;
				} 
				else 
				{
					while ((data2[left] <= separator) && (left < right)) 
					{
						loopCounter++;
						left++;
					}
					shiftCounter++;
					data2[right] = data2[left];
					moveLeft = true;
				}
			}
			shiftCounter++;
			data2[left] = separator;
			return left;
		}
		else
		{
			while (left < right) 
			{
				loopCounter++;
				checkCounter++;
				if (moveLeft == true) 
				{
					while ((data2[right] <= separator) && (left < right)) 
					{
						loopCounter++;
						right--;
					}
					shiftCounter++;
					data2[left] = data2[right];
					moveLeft = false;
				} 
				else 
				{
					while ((data2[left] >= separator) && (left < right)) 
					{
						loopCounter++;
						left++;
					}
					shiftCounter++;
					data2[right] = data2[left];
					moveLeft = true;
				}
			}
			shiftCounter++;
			data2[left] = separator;
			return left;
		}
	}
	public static void swap(int array2[], int first, int second) 
	{
		shiftCounter++;
		int hold = array2[first];
		array2[first] = array2[second];
		array2[second] = hold;
	}//end swap
	public static void displayValues(long time)
	{
		System.out.println("Loop counter: " + loopCounter);
		System.out.println("Check counter: " + checkCounter);
		System.out.println("Processing time: " + time + "ns");
		System.out.println("Shift counter: " + shiftCounter);
		checkCounter = 0;
		loopCounter = 0;
		shiftCounter = 0;
	}//end displayValues
}

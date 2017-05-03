package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;


public class Calories1 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		// invokers
		
		String file;
		System.out.println("Please provide the name of the file");
		Scanner scanner = new Scanner(System.in);
		file = scanner.nextLine();
		System.out.println("\n" + file);
		int calories[][]= arrayReader(file);
		double totCals = totalCal(calories);
		double dayAveg = dayAvg(calories);
		double mealAveg = mealAvg(calories);
		double maxDa = maxDay(calories);
		double maxMe = maxMeal(calories);
		
		scanner.close();
	} //end of main
	
		public static int[][] arrayReader(String file)throws IOException{	
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			 String currentLine;
			 String[] values;
			 int[][] array=new int[7][3];
			 int i=0;
			 while( (currentLine = br.readLine()) != null){
				   System.out.println(currentLine);
				   values = currentLine.split(" ");
				   //array[i]=new int[values.length];
			 for(int j=0;j<values.length;j++){
				 
				 array[i][j]=Integer.parseInt(values[j]);
			 }
			 i++;
			 }
			 br.close();
			 return array;	 
		}
		
	
	// total calories method
		public static double totalCal(int calories[][]){
			double total = 0;
			for (int row = 0; row < calories.length; row++) {
			for (int column = 0; column < calories[row].length; column++) {
			total += calories[row][column];
			}
			}
			System.out.println("The total number of calories for the whole week is: " + total);
			return total;
		}// end of method
		
		// day average amount method
		public static double dayAvg(int calories[][]){
			double avg = 0;
			for (int row = 0; row < calories.length; row++) {
				double rowSum = 0;
				for (int column = 0; column < calories[row].length; column++) {
				rowSum += calories[row][column] / 3;
				}
				//System.out.println(rowSum);
				System.out.println("\nThe average for day " + row + " is: "
						+ rowSum + " calories");
				}
			return avg;
		}// end of method
		
		// method for meal average
		public static double mealAvg(int calories[][]){
			double  davg= 0;
			for (int column = 0; column < calories[0].length; column++) {
				double total = 0;
				for (int row = 0; row < calories.length; row++)
				total += calories[row][column] / (7);
				System.out.println("\nAverage for meal " + column + " is: "
				+ total + " calories");
				}
			return davg;
		}// end of method
			
		// max amount method
		public static double maxDay(int calories[][])throws IOException{
			double maxM = 0;
			for (int row = 0; row < calories.length; row++) {
				double max = calories[0][0];
			    for (int col = 0; col < calories[row].length; col++)
			    	if (calories[row][col] > max) {
			    		max = calories[row][col];
			    System.out.println("\nThe max amount of calories consumed on day: " + row + " was: "  + max + " calories");
			    }		
			   
			}
			return maxM;
		} // end of method 
		
		public static double maxMeal(int calories[][]){
			double maxM = 0;
		    for (int col = 0; col < calories.length; col++) {
		        int max = Integer.MIN_VALUE;
		        for (int row = 0; row < calories.length; row++)
		            if (col < calories[row].length && calories[row][col] > max){
		                max = calories[row][col];
		                System.out.println("\nThe max amount of calories consumed in meal " + col + " was: " + max + " calories");	
		            }
		    }
		    return maxM;
		}
		
}// end of class

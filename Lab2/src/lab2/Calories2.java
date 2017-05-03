package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Calories2 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		// invokers
		
		String file;
		System.out.println("Please provide the name of the file");
		Scanner scanner = new Scanner(System.in);
		file = scanner.nextLine();
		System.out.println("\n" + file);
		int calories[][]= arrayReader(file);
		double dayAveg = dayAvg(calories);
		double mealAveg = mealAvg(calories);
				
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
				   array[i]=new int[values.length];
			 for(int j=0;j<values.length;j++){
				 
				 array[i][j]=Integer.parseInt(values[j]);
			 }
			 i++;
			 }
			 br.close();
			 return array;	 
		}
		
		public static double dayAvg(int calories[][]){
			double avg = 0;
			for (int row = 0; row < calories.length; row++) {
				double rowSum = 0;
				for (int column = 0; column < calories[row].length; column++) {
				rowSum += calories[row][column] / calories[row].length;
				}
				System.out.println("\nThe average for day " + row + " is: "
						+ rowSum + " calories");
				}
			return avg;
		}// end of method
		
		public static double mealAvg(int calories[][])throws IOException{
			double  davg= 0;
			for (int column = 0; column < calories.length; column++) {
					double total = 0;
				for (int row = 0; row < calories.length; row++){
					
					total += calories[row][column] / calories.length;
					
				}
				System.out.println("\nAverage for meal " + column + " is: "
						+ total + " calories");
				}
			return davg;
		}// end of method
		
		
	}


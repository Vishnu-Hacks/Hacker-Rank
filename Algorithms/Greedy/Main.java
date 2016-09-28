
import java.util.Scanner;

/*
 You and  friends want to buy  flowers. Each flower  has some cost . The florist is greedy and wants to maximize his number of new customers, 
 so he increases the sale price of flowers for repeat customers; more precisely, if a customer has already purchased  flowers, price  for  is .
 Find and print the minimum cost for your group to purchase  flowers.

Note: You can purchase the flowers in any order.

Input Format

The first line contains two integers,  (number of flowers to purchase) and  (the size of your group of friends, including you). 
The second line contains  space-separated positive integers describing the cost () for each flower  .
  
 */
public class Main {

	public static void  main(String...strings)
	{
		int numFlowers =0,groupSize=0;
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter The NUmber Of Flowers " );
		numFlowers=in.nextInt();
	
		System.out.println("Enter The Group Size " );
		groupSize=in.nextInt();
		
		long[]cost=new long[numFlowers];
		System.out.println("Enter The cost of flowers "+in.delimiter().pattern());
		
		int i=0;
		while(i<cost.length)
		{
			cost[i]=in.nextLong();
			++i;
		}
		
		sortDesc(cost); // sorts in descending order.
		
		long price=0;
		
		for(int n=0;n<numFlowers;++n)
		{
		
			int multiple=(n/groupSize)+1;
			price+=(multiple*cost[n]);
			
		}
		
		System.out.println("Minimum Price : "+price);
	}
	
	//todo , change this to a more efficient sorting algorithm
	public static void sortDesc(long[]arr)
	{
		for(int i=0;i<arr.length-1;++i)
		{
			for(int j=i+1;j<arr.length;++j)
			{
				if(arr[j]>arr[i])
				{
					long temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

}

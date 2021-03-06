import java.util.Scanner;

public class Prime_num {

	public static void main(String[] args) {
		try {
			if (args.length > 0) { // condition for finding the user entered the data from command line or not
				int min, max;
				min = Integer.parseInt(args[0]);
				max = Integer.parseInt(args[1]);
				if (validate(min, max))
					calculate(min, max); // function to find choice of algorithm entered by user
			} else {
				System.out.println("Please enter valid minimum and maximum numbers respectivly");
				getdata(); // if not added data by user from command line invoke function to take value
							// from user
			}
		} catch (Exception e) {
			System.out.println("Please enter valid minimum and maximum numbers respectivly");
			getdata();
		}

	}

	public static void calculate(int min, int max) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please select alogorithm from below:\n1.Less performance\n2.High performance\n");
		int n = s.nextInt(); // selection of algorithm
		if (n <= 3) {
			System.out.println("Prime numbers are:");
			long start = System.nanoTime(); // to find execution time (time complexity)
			prime(min, max, n); // for find the prime numbers
			long end = System.nanoTime(); // to find execution time (time complexity)
			long execution = end - start;
			System.out.print("\nExecution time: " + execution + " nanosecond");
		} else {
			System.out.println("Please select valid choice");
			calculate(min, max);
		}
		s.close();
	}

	public static void prime(int pMin, int pMax, int pIndex) {
		if (pMin <= 1) // if entered number starts from 1 it'll count as 2 because of rules of prime
			pMin = 2;
		switch (pIndex) {
		case 1:
			for (int i = pMin; i < pMax; i++) {
				int temp = 0;
				for (int j = 2; j <= pMax; j++) {
					if (i % j == 0)
						temp = temp + 1;
				}
				if (temp == 1)
					System.out.print(i + " "); // if the value divide by themselves and not any other value till maximum
			}
			break;

		case 2:
			for (int i = pMin; i < pMax; i++) {
				int temp = 0;
				int cont = (int) Math.floor(Math.sqrt(i));// finding approximate value of square root of number
				for (int j = 2; j <= 1 + cont; j++) {
					if (i % j == 0) {
						temp = i == 2 ? 1 : 0;
						break;
					}
					temp = 1;
				}
				if (temp == 1)
					System.out.print(i + " "); // if the value not divide by 2 till there square root it is prime
			}
			break;
		}
	}

	public static boolean validate(int min, int max) // function used for validate minimum and maximum data given by
	{
		if (min < max)
			return true;
		else
			return false;
	}

	public static void getdata() { // This function takes data if the command line data are not given or not valid
		Scanner s = new Scanner(System.in);
		int min_Usd, max_Usd; // min_usd and max_usd stands for minimum and maximum user define data
		System.out.println("Please enter valid minimum number");
		min_Usd = s.nextInt();
		System.out.println("Please enter valid maximum number");
		max_Usd = s.nextInt();
		if (validate(min_Usd, max_Usd))
			calculate(min_Usd, max_Usd);
		else {
			System.out.println("Please enter number in valid form");
			getdata();
			s.close();
		}
	}

}

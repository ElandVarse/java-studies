import java.util.Scanner;

public class exercise_3_difference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a,b,c,d, product1, product2;
		
		System.out.println("Tell me the four numbers");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		product1 = a * b;
		product2 = c * d;
		
		System.out.println("Difference is " + (product1 - product2));
		
		sc.close();
	}

}

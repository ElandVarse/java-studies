import java.util.Scanner;

public class exercise2_circle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radius,area;
		
		System.out.println("Tell me the circle radius");
		radius = sc.nextDouble();
		area = (3.14159 * (radius*radius));
		
		System.out.println("The circle area is " + String.format("%.4f", area));
	}

}

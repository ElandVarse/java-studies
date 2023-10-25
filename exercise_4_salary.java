import java.util.Scanner;

public class exercise_4_salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double id, hours, valuePerHour, costOfLiving, total;
		
		System.out.println("Tell me your ID");
		id = sc.nextDouble();
		
		System.out.println("Tell me how many hours do you work");
		hours = sc.nextDouble();
		
		System.out.println("Tell me how much do you earn for hour");
		valuePerHour = sc.nextDouble();
		
		System.out.println("Tell me your cost of living");
		costOfLiving = sc.nextDouble();
		
		total = (valuePerHour * hours);

		if(total < costOfLiving) {
			System.out.println('\n' + "Mister Number " + id + '\n' + '\n' + 
					"I'm sorry sir, but you only earn " + total + "$ a month" + '\n' +
					"It's not enough to pay yout debts that are in total " + costOfLiving + "$"
					);	
		}
		else {
			System.out.println('\n' + "Mister Number " + id + '\n' + '\n' + 
					"Congratulations you earn " + total + "$ a month" + '\n' +
					"It's enough to pay yout debts that are in total " + costOfLiving + "$"
					);	
		}
			
		
		
		
		
		
		
	}

}

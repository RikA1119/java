package j2;

import java.util.Scanner;

public class If_else_test {
	public static void main(String[] args) {
		int num1;
		
		Scanner input = new Scanner( System.in);
		
		num1 = input.nextInt();
		
		if( num1 == 3 ) {
			System.out.println("* * *\n"
					+ "* *\n"
					+ "*\n"//倒三角形
					+ "\t \n"
					+ "*\n"
					+ "* *\n"
					+ "* * *\n"//正三角形
					+ "\t \n"
					+ "* * *\n"
					+ "*   *\n"
					+ "* * *\n"//正方形
					+ "\t \n"
					+ "*\n"
					+ "* *\n"
					+ "*\n");//凸形
		}
		if( num1 == 4 ) {
			System.out.println("* * * *\n"
					+ "* * *\n"
					+ "* *\n"
					+ "*\n"//倒三角形
					+ "\t \n"
					+ "*\n"
					+ "* *\n"
					+ "* * *\n"
					+ "* * * *\n"//正三角形
					+ "\t \n"
					+ "* * * *\n"
					+ "*     *\n"
					+ "*     *\n"
					+ "* * * *\n");//正方形
		}
		if( num1 == 5 ) {
			System.out.println("* * * * *\n"
					+ "* * * *\n"
					+ "* * *\n"
					+ "* *\n"
					+ "*\n"//倒三角形
					+ "\t \n"
					+ "*\n"
					+ "* *\n"
					+ "* * *\n"
					+ "* * * *\n"
					+ "* * * * *\n"//正三角形
					+ "\t \n"
					+ "* * * * *\n"
					+ "*       *\n"
					+ "*       *\n"
					+ "*       *\n"
					+ "* * * * *\n"//正方形
					+ "\t \n"
					+ "*\n"
					+ "* *\n"
					+ "* * *\n"
					+ "* *\n"
					+ "*\n");//凸形
		}
		if( num1 == 7 ) {
			System.out.println("*\n"
					+ "* *\n"
					+ "* * *\n"
					+ "* * * *\n"
					+ "* * *\n"
					+ "* *\n"
					+ "*\n");//凸形
		}
	}

}

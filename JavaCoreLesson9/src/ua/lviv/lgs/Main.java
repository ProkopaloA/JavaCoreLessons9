package ua.lviv.lgs;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws MyException {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		System.out.println("������ ����� �����: ");
		a=sc.nextInt();
		System.out.println("������ ����� �����: ");
		b=sc.nextInt();
		Method calc = new Method(a,b);
		calc.plus();
		calc.minus();
		calc.devide();
		calc.multiply();
		
	}

}

package ua.lviv.lgs;

public class Method {
	private static int a;
	private static int b;

	public Method(int a, int b) {
		this.a = a;
		this.b = b; 
	}

	public int plus() throws MyException {	
		
		System.out.println("Result is " + (a + b));
		check();
		return a + b;
		
	}

	public int minus() throws MyException {
		System.out.println("Result is " + (a - b));
		check();
		return a - b;
	}

	public double multiply() throws MyException {
		System.out.println("Result is " + (a * b));
		check();
		return a * b;
	}

	public double devide() throws MyException {
		System.out.println("Result is " + (a / b));
		check();
		return a / b;
	}

	static void check() throws MyException {
		if ((a < 0) && (b < 0)) {
			throw new IllegalArgumentException();
		}
		if (((a == 0) && (b != 0)) || ((a != 0) && (b == 0))) {
			throw new ArithmeticException();
		}
		if ((a == 0) && (b == 0)) {
			throw new IllegalArgumentException();
		}
		if ((a > 0) && (b > 0)) {
			throw new MyException("MyException");
		}

	}

	public static int getA() {
		return a;
	}

	public static void setA(int a) {
		Method.a = a;
	}

	public static int getB() {
		return b;
	}

	public static void setB(int b) {
		Method.b = b;
	}


}
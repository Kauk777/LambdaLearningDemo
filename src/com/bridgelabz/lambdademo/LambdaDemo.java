package com.bridgelabz.lambdademo;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a,int b);
	static void printResult(int a, int b, String function, IMathFunction fobj) {
		System.out.println("Result of "+function+" is "+fobj.calculate(a, b));
	}
}
public class LambdaDemo {
	
	public static void main(String[] args) {
		IMathFunction add=Integer::sum; //(x,y)->x+y;
		IMathFunction multiply=(x,y)->x*y;
		IMathFunction divide=(x,y)->{
			if(y==0)
				return 0;
			else
				return x/y;
		};
		
		/*System.out.println("Addition: "+add.calculate(4,3));
		System.out.println("Multipication: "+multiply.calculate(4,3));
		System.out.println("Divison: "+divide.calculate(4,3));*/
		
		IMathFunction.printResult(4, 3, "Addition", add);
		IMathFunction.printResult(4, 3, "Multipication", multiply);
		IMathFunction.printResult(4, 3, "Divison", divide);
	}
}

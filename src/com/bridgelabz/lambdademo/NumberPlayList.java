package com.bridgelabz.lambdademo;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class NumberPlayList {
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<5;i++)
			list.add(i);
		//Method 1 traversing using iterator
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext())
			System.out.println("Iterator value "+itr.next());
		//Method 2 Traversing with consumer interface implementation
		class MyConsumer implements Consumer<Integer>{
			public void accept(Integer t) {
				System.out.println("Method2 Consumer impl value "+t);
			}
		}
		MyConsumer action=new MyConsumer();
		list.forEach(action);
		//Method 3 Traversing with anonomys consumer interface
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Method3 Consumer anonomys impl value "+t);
			}
		});
		//Method 4 explicit lamba exp
		Consumer<Integer> listAction=n->{
			System.out.println("Method4 foreach lambda impl value "+n);
		};
		list.forEach(listAction);
		//Method 5 implicit lmbda exp
		list.forEach(n->{System.out.println("Method5 foreach lambda impl value "+n);});
		//Method 6 implicit lambda exp double
		Function<Integer,Double> doubleFun=Integer::doubleValue; //n->n.doubleValue();
		list.forEach(n->{
			System.out.println("Method6 foreach lambda impl value "+doubleFun.apply(n));
			});
		//Method 7 implicit lambda even check
		Predicate<Integer> isEven=n->n>0 && n%2==0;
		list.forEach(n->{
			System.out.println("Method7 foreach lambda check for even "+n+" Check for even "+isEven.test(n));
			});
	}
}

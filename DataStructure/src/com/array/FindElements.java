package com.array;

public class FindElements {

	public static void main(String[] args) {
		int a[]= {10,4,7,2,9};
		
		
		//Bubble Sort
		for(int i=0;i<a.length;i++) {
		System.out.println(a[i]);
		}
		
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		
		System.out.println("After sorting:");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		
		System.out.println("max element is :"+a[a.length-1]);
		System.out.println("min element is :"+a[0]);
		System.out.println("last third max element is :"+a[a.length-3]);
		System.out.println("second min element is :"+a[1]);
			
	}
}

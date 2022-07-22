package com.Ament;

public interface  Vegitable {
   public abstract void carrot();
   public abstract void Tomato();
}
abstract class CarrotOne implements Vegitable
{
	@Override
	public void carrot() {
		System.out.println("it is Orange color");
		System.out.println("it is sweet");
		System.out.println("it help keep blood sugar levels under control");
	}
	   public abstract void Tomato();
}
class Tomoto extends CarrotOne
{
	@Override
	public void Tomato() {
	System.out.println("it is red color");
	System.out.println("it is sweet and sour");
	System.out.println(" it is low in calories and rich in vitamin C");
		
	}
}
class Human implements Vegitable
{
	@Override
	public void carrot() {
		System.out.println("Human eat carrot for good health");
	}
	@Override
	public void Tomato() {
	System.out.println("Human eat Tomato for vitamin C ");
	}
}
class FullOopsConcept
{
	public static void main(String[] args) {
		 Vegitable v=new Human();
		 v.carrot();
		 v.Tomato();
	}
}
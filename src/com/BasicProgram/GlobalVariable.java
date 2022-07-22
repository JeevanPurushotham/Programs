package com.BasicProgram;

public class GlobalVariable {
     String var="Jeevan P";
	public static void main(String[] args) {
		GlobalVariable a=new GlobalVariable();
		GlobalVariable a1=new GlobalVariable();
		GlobalVariable a2=new GlobalVariable();
		GlobalVariable a3=new GlobalVariable(); 
		System.out.println(a.var);
		System.out.println(a1.var);
		
		a.var="jeeva";
		System.out.println(a1.var);
		System.out.println(a.var);
		test();
		
	}
	public static void test() {
		GlobalVariable a=new GlobalVariable();
		System.out.println();
		System.out.println(a.var);
		
	}

}

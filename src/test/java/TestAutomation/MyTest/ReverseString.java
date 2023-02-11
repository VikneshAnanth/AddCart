package TestAutomation.MyTest;

import java.io.BufferedReader;
import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Text="Dahsra – kiahS";
		StringBuffer br=new StringBuffer();
		br.append(Text);
		br.reverse();
		System.out.println(br);	
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		char[] arr=str.toCharArray();
		String rev="";
	for(int i=str.length()-1;i>=0;i--)
	{
		rev=rev+str.charAt(i);
	}
	System.out.println(rev);
	}

}

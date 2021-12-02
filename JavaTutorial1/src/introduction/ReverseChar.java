package introduction;

import java.util.Scanner;

public class ReverseChar {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in) ; // introduce din consola 
		System.out.println("enter an input") ;
		String original = scan.nextLine() ;
		
		while (original.isEmpty() || original == null) {
			
			System.out.println ("enter a valid string: ") ;
			original = scan.nextLine();
		}
		scan.close();
		ReverseChar output = new ReverseChar() ;
		String revChr = output.charReverse(original);
		System.out.println(revChr) ;
	}
	
	private String charReverse(String original) {
		String reverse = "" ;
		
		for ( int i = original.length()-1 ; i >= 0 ; i--) {
			reverse = reverse + original.charAt(i) ;
		}
		return reverse;
	}

}

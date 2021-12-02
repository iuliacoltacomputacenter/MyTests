package introduction;

public class Reverse {

	
	
	
	public static void main(String[] args) {
		String input = "This is my text to reverse" ;
		String output = reverse(input) ;
		System.out.println(output) ;

	}

	private static String reverse(String input) {
		String reverse = "" ;
		
		if(input.isEmpty() || input == null) {
			System.out.println("The string is empty ") ;
		}
		
		if (input.length()<= 1) {
			reverse = input ;
		}else {
			String[] array = input.split("\\s+") ;
			
			for (String item: array) {
			reverse = item + " " +reverse ;
			}
		}
		return reverse ;
	}
}

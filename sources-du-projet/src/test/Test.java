package test;

public class Test {

	private boolean joke;
	public void testmethode(){
		joke = true;
		joke = false;
		if(joke) System.out.println("");
		String aligator = "tata";
		System.out.println(aligator);
		
		System.out.println("Fuck Gitlab");
	}
	
	public static void main(String[] args) {
		System.out.println("Questions sur la diff entre i++ et ++i");
		int i;
		int j;
		 
		i=1;
		j=i++;
		System.out.println("i++: "+j);
		j=i++;
		System.out.println("i++: "+j);
		 
		i=1;
		j=++i;
		System.out.println("++i: "+j);
		j=++i;
		System.out.println("++i: "+j);
		
	}
}

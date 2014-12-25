
public class CatchBlockTest {
	public static void main(String[] args) {
		do {
		    try {
		        helperMethod();
		    } catch (ArithmeticException e) {
		        System.out.print("B");
		    } catch (Exception e1) {
		    	 System.out.print("Z");
		    	break;
		    } finally {
		        System.out.print("C");
		        continue;
		    }
		} while (true);
	}

	private static void helperMethod() {
		System.out.print("A");
		Object o = null;
		o.hashCode();
	}
}

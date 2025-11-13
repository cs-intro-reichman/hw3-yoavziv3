// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.
import javax.swing.*;
public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(0,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(3,4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(2,0));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(169));
		//System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int count = 0;
		if (x1 >= 0)
		{
			for (int i=0; i<x1; i++)
			{
				count++;
			}
		}
		else
		{
			for (int i=0; i>x1; i--)
			{
				count--;
			}
		}
		if (x2 >= 0)
		{
			for (int i=0; i<x2; i++)
			{
				count++;
			}
		}
		else
		{
			for (int i=0; i>x2; i--)
			{
				count--;
			}
		}
		return count;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int count = x1;
		if (x2 > 0)
		{
			for (int i=0; i<x2; i++)
			{
				count--;
			}
		}
		else
		{
			for (int i=0; i<x2; i++)
			{
				count++;
			}
		}
		return count;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int count = 0;
		if (x2 > 0)
		{
			for (int i=0; i<x2;i++)
			{
				count = plus(count, x1);
			}
		}
		else
		{
			for (int i=0; i<x2;i++)
			{
				count = count - x1;
			}
		}
		return count;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int count = 1;
		if (n > 0)
		{
			for (int i=0; i<n; i++)
			{
				count = count * x;
			}
		}
		else if (n == 0)
		{
			count = 1;
		}
		return count;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count = 0;
		while (x1 > 0 && x2 != 0) 
		{
			x1 = x1 - x2;
			count++;
		}
		if (x1 < 0 && x2 != 0)
		{
			count--;
		}
		
		if (x2 == 0 && x1 == 2) {
        ImageIcon image = new ImageIcon("C:\\Users\\yoavz\\OneDrive\\Desktop/try.jpg");
        JOptionPane.showMessageDialog(
            null,
            "אם היית מבין משהו במתמטיקה",
            "Error",
            JOptionPane.ERROR_MESSAGE,
            image
        );
	}

		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int count = 0;
		int newNum = x1;
		while (newNum > 0) 
		{
			newNum = minus(newNum, x2);
		}
		if (newNum ==0)
		{
			count = 0;
			return count;
		}
		count = newNum + x2;
		return count;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int closest = 1;
		for (int i=0; times(i, i) <= x; i++)
		{
			if (times(i, i) <= x) 
			{
				closest = i;
			}
		}
		return closest;
	}
}
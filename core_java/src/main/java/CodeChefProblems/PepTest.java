package CodeChefProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.learn.corejava.DataProvider.Data;

@SuppressWarnings("unused")
public class PepTest {

	public static void main(String[] args) {
		// isPrimeCheck();
		// printFiboTill();
		// countDigitsInNumber(12004020);
		// reverseANumber(754);
		// countDigitInNumber(List.of(1,2,4,1,2,4,7,7,7));
		// decimalToAnyBase(800,8);
		// anyBaseToDecimal(1172,8);
		// anyBaseToAnyBase(172,8,2);
		// spanOfArray();
		// findInArray();
		// printBarOfArray();
		   sumOfTwoArrays();
	}

	private static void sumOfTwoArrays() {
		int[] aryA=new int[] {3,2,9,4,5};
		int[] aryB=new int[] {3,2,9,4,5,8,9,0};
		
	}

	private static void printBarOfArray() {
		int[] ary=new int[] {3,2,9,4,5};
		int maxHeight=-1;
		for(int i=0;i<ary.length;i++)
		{
			if(ary[i]>=maxHeight) {
				maxHeight=ary[i];
			}
		}
		System.out.println("Max height : "+maxHeight);
		
		for(int i=maxHeight;i>0;i--) {
			for(int j=0;j<ary.length;j++) {
				if(ary[j]>=i) {
					System.out.print("*\t");
				}
				else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}

	private static void findInArray() {
		int[] ary=new int[] {1,3,4,1,114,223};
		int toFound=114;
		int index=-1;
		for(int i=0;i<ary.length;i++) {
			if(ary[i]==toFound) {
				index=i;
				break;
			}
		}
		System.out.println(toFound+" found at "+index);
	}

	private static void spanOfArray() {
		int[] ary=new int[] {1,3,4,1,114,223};
		Arrays.sort(ary);
		System.out.println(ary[ary.length-1]-ary[0]);
	}

	private static void anyBaseToAnyBase(int num, int format, int tobase) {
		int x=anyBaseToDecimal(num, format);
		int y=decimalToAnyBase(x, tobase);
		System.out.println(" .. "+y);
	}

	private static int anyBaseToDecimal(int num,int base) {
		int rv=0;
		int p=1;
		while(num>0) {
			int dig=num%10;
			num=num/10;
			rv+=dig*p;
			p=p*base;
		}
		System.out.println(rv);
		return rv;
	}

	private static int decimalToAnyBase(int num, int base) {
		int rv=0;
		int p=1;
		while(num>0) {
			int dig=num%base;
			num=num/base;
			rv+=dig*p;
			p=p*10;
		}
		System.out.println(rv);
		return rv;
	}

	private static void countDigitInNumber(List<Integer> ls) {
		Map<Object, Long> hh = ls.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(hh);

	}

	private static void reverseANumber(int num) {
		int numCalc = 0;
		while (num > 0) {
			int digit = num % 10;
			num = num / 10;
			numCalc = numCalc * 10 + digit;
			System.out.println(digit);
		}
		System.out.println(numCalc);
	}

	private static void countDigitsInNumber(int num) {
		int count = 0;
		while (num > 0) {
			num = num / 10;
			count++;
		}
		System.out.println(count);
	}

	private static void printFiboTill() {
		List<Integer> randomeNumbers = Data.getRandomeNumbers(5, 10);
		randomeNumbers.forEach(e -> {
			System.out.println(e + ",   " + PrintFibo(e));
		});
	}

	private static String PrintFibo(Integer e) {
		int n1 = 0, n2 = 1, n3, i, count = e;
		System.out.print(n1 + " " + n2);// printing 0 and 1

		for (i = 2; i < count; ++i)// loop starts from 2 because 0 and 1 are already printed
		{
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}

		return "";
	}

	private static void isPrimeCheck() {
		List<Integer> randomeNumbers = Data.getRandomeNumbers(10, 100);
		randomeNumbers.forEach(e -> {
			System.out.println("Is Prime : " + e + " : " + isPrime(e));
		});
	}

	public static boolean isPrime(Integer num) {
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}

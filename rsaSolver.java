import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class rsaSolver {

	public static void main(String[] args) {
		//6011 * 6247
		long num = 37550717; 
		long[] res = decryptNum(num);
		System.out.println("Reponse pour " + num + " = " + res[0] + " * " + res[1]);

	}
	
	public static List<Long> findPrime(long nbMax){
		List<Long> list = new ArrayList<Long>();
		Boolean check;
		for (long i = 1; i <= nbMax; i++) {
			check = true;
			for (long j = 1; j <= i; j++) {
				if(i%j == 0 && j != 1 && j != i){
					check = false;
				}
			}
			if(check){
				list.add(i);
			}
		}
		return list;
	}
	
	public static long[] decryptNum(long num){
		List<Long> nbPrimes = findPrime(num);
		long[] twoPrimeNum = new long[2];
		Boolean check = false;
		int i, j = 0;
		for (i = 0; i < nbPrimes.size(); i++) {
			for (j = 0; j < nbPrimes.size(); j++) {
				if(nbPrimes.get(i) * nbPrimes.get(j) == num){
					check = true;
					break;
				}
			}
			if(check){
				break;
			}
		}
		twoPrimeNum[0] = nbPrimes.get(i);
		twoPrimeNum[1] = nbPrimes.get(j);
		return twoPrimeNum;
	}

}


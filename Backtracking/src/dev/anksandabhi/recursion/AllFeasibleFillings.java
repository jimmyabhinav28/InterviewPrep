package dev.anksandabhi.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllFeasibleFillings {

	public static void main(String args[]) {

		Integer array[] = { 1, 2, 3 };
		List<Integer> digits = Arrays.asList(array);
		List<List<Integer>> allnumbers = printAllNumbers(3, digits);
		for (List<Integer> x : allnumbers)
			System.out.println(x.toString());
	}

	private static List<List<Integer>> printAllNumbers(int n, List<Integer> digits) {
		// TODO Auto-generated method stub
		List<List<Integer>> allnumbers = new ArrayList<List<Integer>>();
		;
		if (n == 1) {

			for (Integer digit : digits) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(digit);
				allnumbers.add(list);
			}

		} else {
			List<List<Integer>> smallNumbers = printAllNumbers(n - 1, digits);

			for (Integer digit : digits) {
				for (List<Integer> smallList : smallNumbers) {
					List<Integer> temp = new ArrayList<>(smallList);
					temp.add(0, digit);
					allnumbers.add(temp);

				}
			}

		}
		return allnumbers;
	}

}

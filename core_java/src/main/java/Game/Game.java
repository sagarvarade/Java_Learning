package Game;

import java.util.LinkedList;
import java.util.List;

public class Game {

	static final List<String> toPick = List.of("8", "9", "10", "Jack", "Queen", "King");

	public static void main(String[] args) {
		LinkedList<String> cardSwap = cardSwap();
		if(cardSwap!=null) {
			System.out.println(cardSwap);
		}
	}
	private static LinkedList<String> cardSwap() {
		for (int i = 0; i < 2000; i++) {
			LinkedList<String> sequence = new LinkedList<String>();
			sequence.add("1");
			sequence.add(getRandomString(sequence));
			sequence.add("2");
			sequence.add(getRandomString(sequence));
			sequence.add("3");
			sequence.add(getRandomString(sequence));
			sequence.add("4");
			sequence.add(getRandomString(sequence));
			sequence.add("5");
			sequence.add(getRandomString(sequence));
			sequence.add("6");
			sequence.add(getRandomString(sequence));
			sequence.add("7");
			boolean printSequence = printSequence(sequence);
			if (printSequence) {
				return sequence;
			}
		}
		return null;
	}

	private static String getRandomString(LinkedList<String> sequence) {
		int random = (int) (Math.random() * 100 % toPick.size());
		String string = toPick.get(random);
		if (sequence.contains(string))
			return getRandomString(sequence);
		return string;
	}

	private static boolean printSequence(LinkedList<String> sequence) {
		@SuppressWarnings("unchecked")
		LinkedList<String> dup = (LinkedList<String>) sequence.clone();
		int index = 0;
		StringBuilder str = new StringBuilder();
		while (!sequence.isEmpty()) {
			String pk = sequence.poll();
			String next = sequence.poll();
			str.append(pk + " ");
			sequence.add(next);
			index++;
			if (index == 13)
				break;
		}
		if (str.toString().trim().equals("1 2 3 4 5 6 7 8 9 10 Jack Queen King")) {
			System.out.println(dup);
			System.out.println("Found str : " + str);
			return true;
		}
		return false;
	}
}

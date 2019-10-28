package leetcode;

public class E243 {
	public int shortestDistance(String[] words, String word1, String word2) {
		boolean isOne = true;
		int begin = 0;
		int pOne = 0, pTwo = 0;
		int distance = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (words[i].equals(word2)) {
					isOne = false;
					pTwo = i;
				} else
					pOne = i;
				begin = i + 1;
				break;
			}
		}
		for (int i = begin; i < words.length; i++) {
			if (words[i].equals(word1) && isOne)
				pOne = i;
			else if (words[i].equals(word2) && !isOne)
				pTwo = i;
			else if (words[i].equals(word1) && !isOne) {
				isOne = true;
				pOne = i;
				distance = Math.min(distance, pOne - pTwo);
			} else if (words[i].equals(word2) && isOne) {
				isOne = false;
				pTwo = i;
				distance = Math.min(distance, pTwo - pOne);
			}
		}
		return distance;
	}

	public int shortestDistance2(String[] words, String word1, String word2) {
		int p1 = -1, p2 = -1;
		int distance = words.length;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				p1 = i;
			else if (words[i].equals(word2))
				p2 = i;
			if (p1 != -1 && p2 != -1)
				distance = Math.min(distance, Math.abs(p1 - p2));
		}
		return distance;
	}

	public static void main(String[] args) {
		E243 e243 = new E243();
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		System.out.println(e243.shortestDistance(words, "coding", "practice"));
	}
}

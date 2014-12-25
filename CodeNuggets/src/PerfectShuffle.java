import java.util.Random;


public class PerfectShuffle {
	void shuffleCards(int[] cards) {
		int len = cards.length;
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			int j = rand.nextInt(i);
			swap(cards, i, j);
		}
	}
	
	void swap(int[] cards, int i, int j) {
		int temp = cards[i];
		cards[i] = cards[j];
		cards[j] = temp;
	}
}

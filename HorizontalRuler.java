public class HorizontalRuler {
	public static void drawRuler(int nInches, int majorLength) {

		for (int i = 0; i <= majorLength - 1; i++) {
			drawLine(majorLength, 0); 
			for (int j = 1; j <= nInches; j++) {
				drawInterval(majorLength - 1, majorLength - i);
				drawLine(majorLength, j); 

			}
			System.out.println("\n");
		}

		for (int label = 0; label <= nInches; label++) {
			System.out.print(label);
			int total = 0;
			for (int i = 0; i < majorLength - 1; i++) {
				total = total + (int) Math.pow(2, i);

			}
			for (int j = 0; j < total; j++) {
				System.out.print(" ");
			}
		}

	}

	private static void drawInterval(int centralLength, int depth) {
		if (centralLength >= 1) { // otherwise, do nothing
			drawInterval(centralLength - 1, depth); // recursively draw top interval
			drawLine(centralLength, depth); // draw center tick line (without label)
			drawInterval(centralLength - 1, depth); // recursively draw bottom interval

		}
	}

	private static void drawLine(int tickLength, int depth) {
		if (tickLength >= depth) {
			System.out.print("|");
		} else {
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		System.out.print("Horizontal Ruler - Chong Yi Chin");
		System.out.print("\n\nRuler of length 2 with major tick length 4\n");
		drawRuler(2, 4);
		System.out.print("\n\nRuler of length 1 with major tick length 5\n");
		drawRuler(1, 5);
		System.out.print("\n\nRuler of length 3 with major tick length 3\n");
		drawRuler(3, 3);
	}
}
package game.A;

public class Rule {
	private int hand;
	private String result; 

	public int getHand() {
		return hand;
	};

	public void setHand(int hand) {
		this.hand = hand;
	};

	public String hand_int_to_hand_String(int hand) {
		switch (hand) {
		case 0:
			return "布";
		case 1:
			return "剪刀";
		case 2:
			return "石頭";
		default:
			return "輸入錯誤";
		}
	}

	public void duel(int player_hand, int cpu_hand) {
		if (player_hand == (cpu_hand)) {
			result="平手";
			System.out.println("平手");
		} else if (player_hand == 0 && cpu_hand == 2 || player_hand == 1 && cpu_hand == 0
				|| player_hand == 2 && cpu_hand == 1) {
			result="你贏了";
			System.out.println("你贏了");
		} else {
			result="你輸了";
			System.out.println("你輸了");
		}
	}
	
	public String getResult() {
		return result;
	}	

	/*
	 * public void duel(String player_hand, String cpu_hand) { if
	 * (player_hand.equals(cpu_hand)) { System.out.println("平手"); } else if
	 * (player_hand.equals("布") && cpu_hand.equals("石頭") || player_hand.equals("剪刀")
	 * && cpu_hand.equals("布") || player_hand.equals("石頭") && cpu_hand.equals("剪刀"))
	 * { System.out.println("你贏了"); } else { System.out.println("你輸了"); } }
	 */

}

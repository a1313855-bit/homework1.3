package game.B;

import game.A.Rule;

public class Player extends Rule{
	private String name;
	private int money = 1000;
	private int gamble_money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getGamble_money() {
		return gamble_money;
	}

	public void setGamble_money(int gamble_money) {
		this.gamble_money = gamble_money;
	}

	public int gemble_result(int player_hand, int cpu_hand) {
		if (player_hand == cpu_hand) {
			return money;
		} else if (player_hand == 0 && cpu_hand == 2 || player_hand == 1 && cpu_hand == 0
				|| player_hand == 2 && cpu_hand == 1) {
			return money += gamble_money;
		} else {
			return money -= gamble_money;
		}
	}

}

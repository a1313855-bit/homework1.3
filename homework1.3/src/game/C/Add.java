package game.C;

import game.A.Rule;
import game.B.Cpu;
import game.B.Player;
import java.util.Scanner;
import java.util.Random;

public class Add {

	public static void main(String[] args) {
		Rule rule = new Rule();
		Player player = new Player();
		Cpu cpu = new Cpu();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		// 遊戲設定
		System.out.print("請輸入名稱:");// 輸出框
		String user_name = sc.next();// 輸入框
		player.setName(user_name);
		System.out.println("賭徒:" + player.getName());// 輸出框

		// 開始遊戲(賭注)
		while (player.getMoney() > 0) {
			System.out.println("賭資:" + player.getMoney());// 輸出框
			System.out.print("請下注:");// 輸出框
			int gamble_money = sc.nextInt();
			while (gamble_money > player.getMoney() || gamble_money <= 0) {
				if (gamble_money > player.getMoney()) {
					System.out.print("現有:" + player.getMoney() + "\n金額不足，請重新輸入:");
					gamble_money = sc.nextInt();
				} else {
					System.out.print("現有:" + player.getMoney() + "\n不能白嫖，請重新輸入:");
					gamble_money = sc.nextInt();
				}
			}
			player.setGamble_money(gamble_money);// 輸出框
			System.out.println("賭注:" + player.getGamble_money());// 輸出框

			// 遊戲進行(猜拳)
			System.out.print("0)布, 1)剪刀 , 2)石頭" + "\n請出拳:");// 輸出框
			int player_hand = sc.nextInt();
			while (player_hand > 2 || player_hand < 0) {
				System.out.println("輸入錯誤，請重新輸入:" + "\n0)布, 1)剪刀 , 2)石頭");
				player_hand = sc.nextInt();
			}
			player.setHand(player_hand);// 按鈕
			int cpu_hand = r.nextInt(3);
			cpu.setHand(cpu_hand);// 按鈕

			// 數字轉換文字(猜拳)->按鈕輸出文字
			rule.hand_int_to_hand_String(player.getHand());
			rule.hand_int_to_hand_String(cpu.getHand());

			// 結果(猜拳)
			System.out.println(player.getName() + ":" + player.getHand() + "\t" + "Cpu:" + cpu.getHand());// 輸出框
			rule.duel(player.getHand(), cpu.getHand());// 輸出框

			/*
			 * // 結果(猜拳)(文字版本)
			 * 
			 * System.out.println(player.getName() + ":" +
			 * player.hand_int_to_hand_String(player.getHand()) + "\t" + "Cpu:" +
			 * cpu.hand_int_to_hand_String(cpu.getHand()));// 輸出框
			 * rule.duel(player.hand_int_to_hand_String(player.getHand()),
			 * cpu.hand_int_to_hand_String(cpu.getHand()));// 輸出框
			 */

			// 結果(金額換算)
			player.gemble_result(player.getHand(), cpu.getHand());
			System.out.println("現在金額:" + player.getMoney());
			System.out.println("===================");
		}
		System.out.println("你破產了" + "\n-----Game Over-----");

	}
}

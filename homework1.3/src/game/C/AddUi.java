package game.C;

import java.awt.EventQueue;
import game.A.Rule;
import game.B.Player;
import game.B.Cpu;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

public class AddUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField in_name;
	private JTextField in_gamble_money;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int round = 1;
	// 寫出遊戲狀態變數
	private boolean game_running = true;

	// 強制停止遊戲(做法)
	// 寫出所有按鈕
	private JButton set_name;
	private JButton set_gamble_money;
	private JButton duel;
	private JRadioButton hand_paper;
	private JRadioButton hand_scissors;
	private JRadioButton hand_stone;

	// 製作鎖住按鈕的方法 //setEnabled(false) 可以鎖住按鈕
	private void game_stop() {
		set_name.setEnabled(false);
		set_gamble_money.setEnabled(false);
		duel.setEnabled(false);
		hand_paper.setEnabled(false);
		hand_scissors.setEnabled(false);
		hand_stone.setEnabled(false);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUi frame = new AddUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddUi() {
		Player player = new Player();
		Cpu cpu = new Cpu();
		Rule rule = new Rule();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("賭徒:");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel.setBounds(95, 34, 34, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("下注:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(95, 104, 34, 15);
		contentPane.add(lblNewLabel_1);

		in_name = new JTextField();
		in_name.setFont(new Font("新細明體", Font.PLAIN, 14));
		in_name.setBounds(145, 30, 96, 21);
		contentPane.add(in_name);
		in_name.setColumns(10);

		in_gamble_money = new JTextField();
		in_gamble_money.setFont(new Font("新細明體", Font.PLAIN, 14));
		in_gamble_money.setColumns(10);
		in_gamble_money.setBounds(145, 100, 96, 21);
		contentPane.add(in_gamble_money);

		JLabel show_name = new JLabel("Player");
		show_name.setFont(new Font("新細明體", Font.BOLD, 16));
		show_name.setBounds(170, 130, 47, 21);
		contentPane.add(show_name);

		JLabel show_name_1 = new JLabel("Cpu");
		show_name_1.setFont(new Font("新細明體", Font.BOLD, 16));
		show_name_1.setBounds(175, 250, 34, 21);
		contentPane.add(show_name_1);

		// 顯示現有金額
		JLabel money = new JLabel("金額:");
		money.setFont(new Font("新細明體", Font.BOLD, 14));
		money.setBounds(95, 154, 34, 15);
		contentPane.add(money);
		JTextArea get_money = new JTextArea();
		get_money.setBounds(145, 150, 96, 21);
		contentPane.add(get_money);

		// 輸出欄
		JTextArea print = new JTextArea();
		// 滾動條
		JScrollPane scroll = new JScrollPane(print);
		scroll.setBounds(20, 315, 350, 100);
		contentPane.add(scroll);

		// 時間
		JLabel time = new JLabel("");
		time.setFont(new Font("新細明體", Font.BOLD, 14));
		time.setBounds(10, 10, 341, 15);
		contentPane.add(time);
		
		DateTimeFormatter now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Timer timer = new Timer(1000, e -> time.setText(LocalDateTime.now().format(now)));
		timer.start();

		/*************** event ***************/

		// 設定名稱
		JButton set_name = new JButton("登入名稱");
		set_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是false 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;

				String name = in_name.getText();
				player.setName(name);
				print.append("賭徒:" + player.getName());

			}
		});
		set_name.setFont(new Font("新細明體", Font.PLAIN, 14));
		set_name.setBounds(255, 29, 96, 23);
		contentPane.add(set_name);

		// 遊戲開始
		JButton start = new JButton("開始遊戲");
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是false 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				get_money.setText(player.getMoney() + "");
				print.append("\n=====第" + round + "回合=====");
			}
		});
		start.setFont(new Font("新細明體", Font.PLAIN, 14));
		start.setBounds(145, 65, 96, 23);
		contentPane.add(start);

		// 下注
		JButton set_gamble_money = new JButton("下好離手");
		set_gamble_money.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是false 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				int gamble_money = Integer.parseInt(in_gamble_money.getText());
				if (gamble_money > player.getMoney() || gamble_money <= 0) {
					if (gamble_money > player.getMoney()) {
						print.append("\n現有:" + player.getMoney() + "\n金額不足，請重新輸入:");
					} else {
						print.append("\n現有:" + player.getMoney() + "\n不能白嫖，請重新輸入:");
					}
					return;
				}
				player.setGamble_money(gamble_money);
				print.append("\n下注:" + player.getGamble_money());
			}
		});
		set_gamble_money.setFont(new Font("新細明體", Font.PLAIN, 14));
		set_gamble_money.setBounds(255, 99, 96, 23);
		contentPane.add(set_gamble_money);

		// 猜拳按鈕
		JRadioButton hand_paper = new JRadioButton("布");
		hand_paper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是true 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				int player_Hand = 0;
				player.setHand(player_Hand);
			}
		});
		buttonGroup.add(hand_paper);
		hand_paper.setFont(new Font("新細明體", Font.BOLD, 14));
		hand_paper.setBounds(75, 180, 47, 23);
		contentPane.add(hand_paper);

		JRadioButton hand_scissors = new JRadioButton("剪刀");
		hand_scissors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是true 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				int player_Hand = 1;
				player.setHand(player_Hand);
			}
		});
		buttonGroup.add(hand_scissors);
		hand_scissors.setFont(new Font("新細明體", Font.BOLD, 14));
		hand_scissors.setBounds(160, 180, 63, 23);
		contentPane.add(hand_scissors);

		JRadioButton hand_stone = new JRadioButton("石頭");
		hand_stone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是true 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				int player_Hand = 2;
				player.setHand(player_Hand);
			}
		});
		buttonGroup.add(hand_stone);
		hand_stone.setFont(new Font("新細明體", Font.BOLD, 14));
		hand_stone.setBounds(245, 180, 63, 23);
		contentPane.add(hand_stone);

		// 決鬥結果
		JButton duel = new JButton("決鬥");
		duel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是true 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				Random r = new Random();
				int cpu_hand = r.nextInt(3);
				cpu.setHand(cpu_hand);
				rule.hand_int_to_hand_String(player.getHand());
				rule.hand_int_to_hand_String(cpu.getHand());
				rule.duel(player.getHand(), cpu.getHand());

				player.gemble_result(player.getHand(), cpu.getHand());

				get_money.setText(player.getMoney() + "");
				print.append("\n" + player.getName() + ":" + player.hand_int_to_hand_String(player.getHand()) + "\t"
						+ "Cpu:" + cpu.hand_int_to_hand_String(cpu.getHand()) + "\n" + rule.getResult() + "\n" + "現在金額:"
						+ player.getMoney());
				// 強制結束
				if (player.getMoney() <= 0) {
					print.append("你破產了" + "\n=====Game Over=====");
					game_running = false;

					// 強制停止遊戲(利用方法，鎖住按鈕)->無法遊玩
					game_stop();
				}
			}
		});
		duel.setFont(new Font("新細明體", Font.BOLD, 14));
		duel.setBounds(150, 215, 85, 23);
		contentPane.add(duel);

		// 再來一局
		JButton one_more_game = new JButton("再來一局");
		one_more_game.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 強制停止遊戲 原本是true 當觸發game_stop 變成false，return離開目前的方法
				if (!game_running)
					return;
				round++;
				print.append("\n=====第" + round + "回合=====");
			}
		});
		one_more_game.setFont(new Font("新細明體", Font.PLAIN, 14));
		one_more_game.setBounds(145, 280, 96, 23);
		contentPane.add(one_more_game);

		// 清空紀錄
		JButton clean = new JButton("清空紀錄");
		clean.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				print.setText("");
			}
		});
		clean.setFont(new Font("新細明體", Font.PLAIN, 14));
		clean.setBounds(10, 430, 96, 23);
		contentPane.add(clean);

		// 離開程式
		JButton set_gamble_money_1_1_1 = new JButton("離開");
		set_gamble_money_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		set_gamble_money_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		set_gamble_money_1_1_1.setBounds(280, 430, 96, 23);
		contentPane.add(set_gamble_money_1_1_1);

		// 列印紀錄
		JButton print_out = new JButton("列印紀錄");
		print_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					print.print();// print 是你的 JTextArea
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		print_out.setFont(new Font("新細明體", Font.PLAIN, 14));
		print_out.setBounds(145, 430, 96, 23);
		contentPane.add(print_out);

	}
}

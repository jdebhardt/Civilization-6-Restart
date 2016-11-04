package com.joeebhardt.civ6;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UI extends JFrame {

	private JPanel contentPane;

	private JComboBox civilizations;
	private JComboBox difficulties;
	private JComboBox speeds;
	private JComboBox maps;
	private JComboBox sizes;
	private JLabel lblPauseLength;
	private JSplitPane splitPane;
	private JLabel lblUi;
	private JTextField uiPause;
	private JSplitPane splitPane_1;
	private JLabel lblButton;
	private JTextField buttonPause;
	private JSplitPane splitPane_2;
	private JLabel lblExit;
	private JTextField exitPause;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public UI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblCivilization = new JLabel("Civilization");
		lblCivilization.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCivilization = new GridBagConstraints();
		gbc_lblCivilization.insets = new Insets(0, 0, 5, 5);
		gbc_lblCivilization.gridx = 1;
		gbc_lblCivilization.gridy = 0;
		contentPane.add(lblCivilization, gbc_lblCivilization);

		civilizations = new JComboBox(Civ.values());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPane.add(civilizations, gbc_comboBox);

		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDifficulty = new GridBagConstraints();
		gbc_lblDifficulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblDifficulty.gridx = 1;
		gbc_lblDifficulty.gridy = 2;
		contentPane.add(lblDifficulty, gbc_lblDifficulty);

		difficulties = new JComboBox(Difficulty.values());
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		contentPane.add(difficulties, gbc_comboBox_1);

		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSpeed = new GridBagConstraints();
		gbc_lblSpeed.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpeed.gridx = 1;
		gbc_lblSpeed.gridy = 4;
		contentPane.add(lblSpeed, gbc_lblSpeed);

		speeds = new JComboBox(Speed.values());
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 5;
		contentPane.add(speeds, gbc_comboBox_2);

		JLabel lblMap = new JLabel("Map");
		lblMap.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMap.gridx = 1;
		gbc_lblMap.gridy = 6;
		contentPane.add(lblMap, gbc_lblMap);

		maps = new JComboBox(MapType.values());
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 1;
		gbc_comboBox_3.gridy = 7;
		contentPane.add(maps, gbc_comboBox_3);

		sizes = new JComboBox(MapSize.values());
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 1;
		gbc_comboBox_4.gridy = 8;
		contentPane.add(sizes, gbc_comboBox_4);

	

		lblPauseLength = new JLabel("Pause Length");
		lblPauseLength.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPauseLength = new GridBagConstraints();
		gbc_lblPauseLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblPauseLength.gridx = 1;
		gbc_lblPauseLength.gridy = 9;
		contentPane.add(lblPauseLength, gbc_lblPauseLength);

		splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.anchor = GridBagConstraints.NORTH;
		gbc_splitPane.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_splitPane.gridx = 1;
		gbc_splitPane.gridy = 10;
		contentPane.add(splitPane, gbc_splitPane);

		lblUi = new JLabel("UI:");
		lblUi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUi.setFont(new Font("Arial", Font.PLAIN, 12));
		splitPane.setLeftComponent(lblUi);

		uiPause = new JTextField();
		uiPause.setText("" + Info.Pause.UI);
		splitPane.setRightComponent(uiPause);
		uiPause.setColumns(10);

		splitPane_1 = new JSplitPane();
		GridBagConstraints gbc_splitPane_1 = new GridBagConstraints();
		gbc_splitPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane_1.fill = GridBagConstraints.BOTH;
		gbc_splitPane_1.gridx = 1;
		gbc_splitPane_1.gridy = 11;
		contentPane.add(splitPane_1, gbc_splitPane_1);

		lblButton = new JLabel("Button:");
		splitPane_1.setLeftComponent(lblButton);

		buttonPause = new JTextField();
		buttonPause.setText("" + Info.Pause.button);
		buttonPause.setFont(new Font("Arial", Font.PLAIN, 12));
		splitPane_1.setRightComponent(buttonPause);
		buttonPause.setColumns(10);
		
		splitPane_2 = new JSplitPane();
		GridBagConstraints gbc_splitPane_2 = new GridBagConstraints();
		gbc_splitPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane_2.fill = GridBagConstraints.BOTH;
		gbc_splitPane_2.gridx = 1;
		gbc_splitPane_2.gridy = 12;
		contentPane.add(splitPane_2, gbc_splitPane_2);
		
		lblExit = new JLabel("Exit:");
		splitPane_2.setLeftComponent(lblExit);
		
		exitPause = new JTextField();
		exitPause.setText("" + Info.Pause.exitGame);
		splitPane_2.setRightComponent(exitPause);
		exitPause.setColumns(10);
		
		JButton restartButton = new JButton("Restart");
		restartButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 13;

		restartButton.addActionListener((ActionEvent event) -> {
			Info.Pause.button = Integer.parseInt(buttonPause.getText());
			Info.Pause.UI = Integer.parseInt(uiPause.getText());
			Info.Pause.exitGame = Integer.parseInt(exitPause.getText());
			Info.civ = (Civ) civilizations.getSelectedItem();
			Info.difficulty = (Difficulty) difficulties.getSelectedItem();
			Info.speed = (Speed) speeds.getSelectedItem();
			Info.mapType = (MapType) maps.getSelectedItem();
			Info.mapSize = (MapSize) sizes.getSelectedItem();
			new Restart();
		});

		contentPane.add(restartButton, gbc_btnNewButton);
	}


}

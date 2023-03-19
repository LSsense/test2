package test2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class JFInfo extends JFrame {

	public static JPanel contentPane;
	public static JTextField textField;
	public static JTable table;
	public static JTable table_1;
	public static JTable table_2;
	public static JTable table_3;
	public static JTextArea textArea;
	
	
	public static JTable table_4;
	public static JTable table_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JFInfo frame = new JFInfo();
					frame.setVisible(true);
					JTYX jtyx=new JTYX();
					
					//JTYX.run1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setForeground(Color.RED);
		textField.setEnabled(false);
		textField.setBounds(0, 509, 111, 67);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time.JobRequest();
				Time.Begin_time();
			}
		});
		btnNewButton.setBounds(142, 508, 99, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u7ED3\u675F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(142, 548, 99, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u505C\u6B62");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Time.Stop_time();
			}
		});
		btnNewButton_2.setBounds(265, 548, 99, 28);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\u961F\u5217\u60C5\u51B5");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 150, 66, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u4E1A\u540E\u5907\u961F\u5217");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 1, 99, 17);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("\u7EE7\u7EED");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Time.Continue();
			}
		});
		btnNewButton_3.setBounds(265, 508, 99, 28);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(811, 1, 355, 575);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setEnabled(false);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
		textArea.setText("\u8FDB\u7A0B\u8C03\u5EA6\u4E8B\u4EF6\uFF1A");
		textArea.setToolTipText("");
		textArea.append("\n");
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 25, 183, 113);
		contentPane.add(scrollPane_1);
		
		table_3 = new JTable();
		table_3.setEnabled(false);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Priority", "InTimes", "InstrucNum"
			}
		));
		scrollPane_1.setViewportView(table_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 180, 61, 113);
		contentPane.add(scrollPane_2);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u5C31\u7EEA"
			}
		));
		scrollPane_2.setViewportView(table);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(74, 180, 61, 113);
		contentPane.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u7B49\u5F851"
			}
		));
		scrollPane_3.setViewportView(table_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(142, 180, 61, 113);
		contentPane.add(scrollPane_4);
		
		table_2 = new JTable();
		table_2.setEnabled(false);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u7B49\u5F852"
			}
		));
		scrollPane_4.setViewportView(table_2);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(265, 25, 535, 393);
		contentPane.add(scrollPane_5);
		
		table_4 = new JTable();
		table_4.setEnabled(false);
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
			}
		));
		scrollPane_5.setViewportView(table_4);
		
		JLabel lblNewLabel_2 = new JLabel("\u5185\u5B58\u5206\u914D\u60C5\u51B5");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_2.setBounds(263, 1, 129, 18);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 299, 61, 119);
		contentPane.add(scrollPane_6);
		
		table_5 = new JTable();
		table_5.setEnabled(false);
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u7ED3\u675F\u961F\u5217"
			}
		));
		scrollPane_6.setViewportView(table_5);
		
		JButton btnNewButton_4 = new JButton("\u7EDF\u8BA1\u4FE1\u606F");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file_path="output1/ProcessResults_"+Time.time_now()+"_JTYX.txt";
				//file.writer_to_file(Statistics.string, file_path);
				JTYX.run3(file_path);
			}
		});
		btnNewButton_4.setBounds(707, 548, 99, 28);
		contentPane.add(btnNewButton_4);
		
	}
}

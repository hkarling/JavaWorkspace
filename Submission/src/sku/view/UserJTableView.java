package sku.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sku.controller.UserListController;

@SuppressWarnings("serial")
public class UserJTableView extends JFrame implements ActionListener {
	JMenu m = new JMenu("관리");
	JMenuItem insert = new JMenuItem("가입");
	JMenuItem update = new JMenuItem("수정");
	JMenuItem delete = new JMenuItem("삭제");
	JMenuItem quit = new JMenuItem("종료");
	JMenuBar mb = new JMenuBar();

	String[] name = { "id", "name", "age", "addr" };

	DefaultTableModel dt = new DefaultTableModel(name, 0);
	JTable jt = new JTable(dt);
	JScrollPane jsp = new JScrollPane(jt);

	/*
	 * South 영역에 추가할 Componet들
	 */
	JPanel p = new JPanel();
	String[] comboName = { "  ALL  ", "  ID  ", " name ", " addr " };

	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton serach = new JButton("검색");

	/**
	 * 화면구성 및 이벤트등록
	 * 
	 */
	public UserJTableView() {
		super("DB연동");

		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(quit);
		mb.add(m);

		setJMenuBar(mb);

		// South영역

		p.setBackground(Color.yellow);
		p.add(combo);
		p.add(jtf);
		p.add(serach);

		add(jsp, "Center");
		add(p, "South");

		/** 처음 프로그램이 로딩할시에 디비에서 리스트를 받아오는 부분. */
		List<Vector<Object>> list = UserListController.getSelectAll();
		for (Vector<Object> vec : list) {
			dt.addRow(vec);
		}

		/** 메뉴아이템들에게 클래스에 구현된 actionlistener를 등록한다. */
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		quit.addActionListener(this);

		/** 메인 창에 대한 속성 */

		setSize(500, 400);
		setVisible(true);

		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// 생성자끝

	/**
	 * 가입/수정/삭제/검색기능을 담당하는 메소드
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(insert)) {
			new UserJDialogView(this, "가입");
		} else if (e.getSource().equals(update)) {
			
			// 테이블에 선택된 레코드가 있는지를 확인한다.
			if(this.jt.getSelectedRow() != -1) {
				new UserJDialogView(this, "수정");				
			} else {
				
			}
		} else if (e.getSource().equals(delete)) {

		} else if (e.getSource().equals(quit)) {
			System.exit(0);
		}
	}
}

package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class UserJTableView  extends JFrame implements ActionListener{
	JMenu m = new JMenu("����");
	JMenuItem  insert=new JMenuItem("����");
	JMenuItem  update=new JMenuItem("����");
	JMenuItem  delete=new JMenuItem("����");
	JMenuItem  quit=new JMenuItem("����");
	JMenuBar mb=new JMenuBar();
		
	String [] name={"id","name","age","addr"};
	
	DefaultTableModel dt= new DefaultTableModel(name,0);
	JTable jt=new JTable(dt);
	JScrollPane jsp=new JScrollPane(jt);
	
	/*
		South ������ �߰��� Componet��
	*/
	JPanel p= new JPanel();
	String [] comboName={"  ALL  ","  ID  "," name "," addr "};
	
	JComboBox combo = new JComboBox(comboName);
	JTextField jtf = new JTextField(20);
	JButton serach = new JButton("�˻�");


	
/**
	ȭ�鱸�� �� �̺�Ʈ���

*/
	public UserJTableView(){
		super("DB����");
		
		m.add(insert);
		m.add(update);
		m.add(delete);
		m.add(quit);
		mb.add(m);

		setJMenuBar(mb);
		
		//South����
		
		p.setBackground(Color.yellow);
		p.add(combo);
		p.add(jtf);
		p.add(serach);

		add(jsp, "Center");
		add(p, "South");

		setSize(500,400);
		setVisible(true);

	
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}//�����ڳ�
	
	

    /**
     * ����/����/����/�˻������ ����ϴ� �޼ҵ�
     * */
		
	public void actionPerformed(ActionEvent e) {
		
		
	}

}

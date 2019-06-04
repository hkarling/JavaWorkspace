package test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserJDialogView extends JDialog implements ActionListener{
	JPanel pw=new JPanel(new GridLayout(4,1));
	JPanel pc=new JPanel(new GridLayout(4,1));
	JPanel ps=new JPanel();

	JLabel lableId = new JLabel("ID");
	JLabel lableName=new JLabel("�̸�");
	JLabel lableAge=new JLabel("����");
	JLabel lableAddr=new JLabel("�ּ�");


	JTextField id=new JTextField();
	JTextField name=new JTextField();
	JTextField age=new JTextField();
	JTextField addr=new JTextField();
	

	JButton confirm;
	JButton reset=new JButton("���");

   UserJTableView userJTableView;

   JPanel idCkP =new JPanel(new BorderLayout());
   JButton idCkBtn = new JButton("IDCheck");
   
  
   

	public UserJDialogView(UserJTableView userJTableView, String index){
		super(userJTableView,"���̾�α�");
		
		this.userJTableView=userJTableView;
		
		if(index.equals("����")){
			confirm=new JButton(index);
		}else{
			confirm=new JButton("����");	
			
			
			
			//id text�ڽ� ��Ȱ��
			id.setEditable(false);
	
			//IDCheck��ư ��Ȱ��ȭ
			idCkBtn.setEnabled(false);
		}
		
		
		//Label�߰��κ�
		pw.add(lableId);//ID
		pw.add(lableName);//�̸�
		pw.add(lableAge);//����
		pw.add(lableAddr);//�ּ�
	
		
		idCkP.add(id,"Center");
		idCkP.add(idCkBtn,"East");
		
		//TextField �߰�
		pc.add(idCkP);
		pc.add(name);
		pc.add(age);
		pc.add(addr);
		
		
		
		ps.add(confirm); 
		ps.add(reset);
	
		add(pw,"West"); 
		add(pc,"Center");
		add(ps,"South");
		
		setSize(300,250);
		setVisible(true);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ���
        confirm.addActionListener(this); //����/���� �̺�Ʈ���
        reset.addActionListener(this); //��� �̺�Ʈ���
        idCkBtn.addActionListener(this);// ID�ߺ�üũ �̺�Ʈ ���
		
	}//�����ڳ�
    
	/**
	 * ����/����/���/IDCheck ��ɿ� ���� �κ�
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}//actionPerformed��
	
}//Ŭ������








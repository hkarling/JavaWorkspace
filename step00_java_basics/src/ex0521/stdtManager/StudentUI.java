package ex0521.stdtManager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentUI extends JFrame {
	
	private static final long serialVersionUID = 3378661986585543552L;
	
	JButton btnInsert = new JButton("입력");
	JButton btnSelectAll = new JButton("출력");
	JButton btnDelete = new JButton("삭제");
	JButton btnUpdate = new JButton("수정");	
	JTextArea resultArea = new JTextArea(4, 30);

	StudentListService service = new StudentListService();
	
	StudentUI() {
		super("Student");
		
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		con.fill = GridBagConstraints.HORIZONTAL;
		con.weightx = 0.5;
		con.gridx = 0;
		con.gridx = 0;
		this.add(btnInsert, con);
		con.gridx = 1;
		this.add(btnSelectAll, con);
		con.gridx = 2;
		this.add(btnDelete, con);
		con.gridx = 3;
		this.add(btnUpdate, con);
		con.gridx = 0;
		con.gridy = 1;
		con.gridwidth = 4;
		this.add(resultArea, con);
//		container.add(btnInsert);
//		container.add(btnSelectAll);
//		container.add(btnDelete);
//		container.add(btnUpdate);
//		container.add(resultArea);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = service.insert(new Student("FFF", "바바", 12, "판교"));
				if(result)
					resultArea.setText("등록성공");
				else
					resultArea.setText("등록실패");
				
			}
		});
		
		btnSelectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = "";
				for(Student student : service.selectAll()) {
//					System.out.println(student);
					result += student + "\n";
					
				}
				resultArea.setText(result);
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = service.delete("BBB");
				if(result)
					resultArea.setText("삭제성공");
				else
					resultArea.setText("삭제실패");
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean result = service.update(new Student("AAA", "카카", 20));
				if(result)
					resultArea.setText("삭제성공\n" + service.searchById("AAA"));
				else
					resultArea.setText("삭제실패\n" + service.searchById("AAA"));
			}
		});
	}
	StudentUI(Object[][] data) {
		this();
		service = new StudentListService(data);
	}
	public static void main(String[] args) {
		Object data[][] = {
				{"AAA", "가가", 22, "서울" },
				{"BBB", "나나", 31, "대전" },
				{"CCC", "다다", 49, "대구" },
				{"DDD", "라라", 58, "부산" },
				{"EEE", "마마", 67, "광주" },
		};
		
		new StudentUI(data);
	}

}

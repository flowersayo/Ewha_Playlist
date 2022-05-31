import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class playlist_main extends JFrame {
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "DB2022Team06";//DBMS접속 시 아이디
    private static final String PASSWORD = "DB2022Team06";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/DB2022Team06";
    
    /* 전체 음악 목록 sql*/
    public void Total_musicPlaylist() {
    	try {
    		int i=1;
				Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement(); 
	            //stmt.executeQuery("use DB2022Team06");
	            ResultSet rs = stmt.executeQuery("select title, singer from db2022_music, db2022_singer where db2022_music.music_id=db2022_singer.music_id;");
	            System.out.println("_____________________________");
            	System.out.println("전체 음악 목록 조회");
            	System.out.println("_____________________________");
	            while(rs.next()) {
	            	System.out.printf("%d. %-20s| %-20s\n", i, rs.getString(1), rs.getString(2));
	            	i++;
	            }
    		} 
    		catch (SQLException e) {
				e.printStackTrace();
			}
    }

	public playlist_main(String nickname) {
		
		super("닉네임 확인 완료_플레이리스트");
		
		JPanel jPanel=new JPanel();
		add(jPanel);
		setSize(500,500);
		setVisible(true);
		setLayout(new BorderLayout());	
		
		JLabel jLabel=new JLabel(nickname+"의 플레이리스트");
		jPanel.add(jLabel,BorderLayout.CENTER);
		jLabel.setVisible(true);
		
		/* 플레이리스트에 음악 추가 */
		JButton btn1=new JButton("음악 추가");
		jPanel.add(btn1,BorderLayout.CENTER);
		btn1.setVisible(true);
		btn1.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new music_Info();
				setVisible(false);
			}
		});
		
		/* 플레이리스트에 음악 삭제 */
		JButton btn2=new JButton("음악 삭제");
		jPanel.add(btn2,BorderLayout.CENTER);
		btn2.setVisible(true);
		btn2.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new music_Info();
				setVisible(false);
			}
		});
		
		/* 나만의 플레이리스트 음악 조회 */
		JButton btn3=new JButton("나의 음악 목록 조회");
		jPanel.add(btn3,BorderLayout.CENTER);
		btn3.setVisible(true);
		
		/* 전체 플레이리스트 음악 조회 */
		JButton btn4=new JButton("전체 음악 목록 조회");
		jPanel.add(btn4,BorderLayout.CENTER);
		btn4.setVisible(true);
		
		btn4.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Total_musicPlaylist();
			}
		});
	}

}

package dbase;


import java.sql.*;
public class Dbase1 {

	public static void main(String args[]) throws ClassNotFoundException
   {
	//����mysql���ݿ⣬�������������ݿ���Ҫ�ı��ʽ
	String url = "jdbc:mysql://localhost:3306/mycompany";
    String user ="guoqin";//�滻�������ѵ����ݿ��û���
    String password = "guoqin1234";//�����滻�������ѵ����ݿ��û�����
    String sqlStr = "select ID,Name,Department from person";
    String sqlInsert = "insert into person " +"VALUES (88, 'May', 'R&D')";
    String sqlUpdate = "update person " +"set Department = 'Marketing' where ID in (1,3)";


    try{   //�쳣��������Ǳ����.������ͨ������!   
        Class.forName("org.gjt.mm.mysql.Driver");
        System.out.println( "���������ɹ�!" );

        Connection con = DriverManager.getConnection(url, user, password);

        System.out.println( "�������ݿ�ɹ�!" );

        Statement st = con.createStatement();
        System.out.println( "����Statement�ɹ�!" );
        
        //��������
        st.executeUpdate(sqlInsert);
        System.out.println("���������ݳɹ�");
        
        //��������
        st.executeUpdate(sqlUpdate);
        System.out.println("�������ݳɹ�");

        //��ѯ����
        ResultSet rs = st.executeQuery( sqlStr );
        System.out.println( "��ѯ���ݲ����ɹ�!" );
        System.out.println( "----------------!" );

        while(rs.next())
        {
          System.out.print(rs.getString("ID") + "   ");
          System.out.print(rs.getString("Name") + "   ");
          System.out.println(rs.getString("Department"));
        }
  
        rs.close();
        st.close();
        con.close();
    }
    catch(SQLException e){
    		System.out.println("ErrorCode:"+e.getErrorCode());
    		System.out.println("SQLState:"+e.getSQLState());
    		System.out.println("reason:"+e.getMessage());    
    }
  }
}
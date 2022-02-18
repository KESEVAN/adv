package test;

import java.sql.*;
import java.util.Scanner;

public class bank {
	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		Connection con = null;
		Statement st;
		PreparedStatement ps ;
		ResultSet rs;
		try {
			con = DriverManager.getConnection(jdbcurl,username,password);
			con.setAutoCommit(false);
			Scanner sc = new Scanner(System.in);
			int t=1;
			while(t==1)
			{
				System.out.println("*WELCOME TO BANK*");
				System.out.println("\n1.Create Account\n2.Display Account\n3.Transact amount");
				System.out.println("\nEnter option:");
				int opt = sc.nextInt();
				switch (opt) {
				case 1:
					System.out.println("\nEnter ID:");
					int id = sc.nextInt();
					System.out.println("\nEnter Name:");
					String name = sc.next();
					System.out.println("\nEnter Balance:");
					int bal = sc.nextInt();
					String query="INSERT INTO BANK VALUES (?,?,?)";
					ps = con.prepareStatement(query);
					ps.setInt(1,id);
					ps.setString(2,name);
					ps.setInt(3,bal);
					ps.execute();
					System.out.println("\nCREATED ACCOUNT!");
					con.commit();
					break;
				case 2:
					st = con.createStatement();
					String query1 ="SELECT * FROM BANK";
					rs = st.executeQuery(query1);
					System.out.println("\n ACCOUNT DETAILS\n");
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+"\n");
					}
					break;
				case 3:
					System.out.println("\nEnter Transaction type:\n1.Withdraw\n2.Deposit\n3.Display Details\nElseExit");
					System.out.println("\nEnter option:");
					int tmp = sc.nextInt();
					switch (tmp) {
					case 1:
						System.out.println("\nEnter ID:");
						int aid = sc.nextInt();
						int balance=0;
						String query2="SELECT BALANCE FROM BANK WHERE ID="+aid;
						Savepoint sp1 = con.setSavepoint();
						st = con.createStatement();
						rs = st.executeQuery(query2);
						while(rs.next()) {
							balance = rs.getInt(1);
						}
						System.out.println("\nEnter amount:");
						int amt = sc.nextInt();
						balance -= amt;
						System.out.println("Balance:"+balance);
						String query3 = "UPDATE BANK SET BALANCE= "+balance+" WHERE ID= "+aid;
						st.execute(query3);
						if(balance<0) {
							System.out.println("INSUFFICIENT FUNDS");
							con.rollback(sp1);
						}
						con.releaseSavepoint(sp1);
						con.commit();
						System.out.println("Withdraw is success");
						break;
					case 2:
						System.out.println("Enter Amount to deposit:");
						int dep = sc.nextInt();
						int balance1=0;
						System.out.println("\nEnter ID:");
						int aid1 = sc.nextInt();
						st = con.createStatement();
						String query31="SELECT BALANCE FROM BANK WHERE ID="+aid1;
						rs = st.executeQuery(query31);
						while(rs.next()) {
							balance1 = rs.getInt(1);
						}
						balance1 += dep;
						System.out.println("\n New Balance:"+balance1);
//						String query4 = "UPDATE `bank` SET `Balance`="+balance1+" WHERE `ID`= 101;"
						String query4 = "UPDATE BANK SET BALANCE= "+balance1+" WHERE ID= "+aid1;
						st.execute(query4);
						System.out.println("\n New BalanceUpdate");
						break;
					case 3:
						System.out.println("\nEnter ID:");
						int aid2 = sc.nextInt();
						String query5="SELECT * FROM BANK WHERE ID="+aid2;
						st = con.createStatement();
						rs = st.executeQuery(query5);
						while(rs.next()) {
							System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
						}
						break;
					default:
						break;
					}
				default:
					t=0;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

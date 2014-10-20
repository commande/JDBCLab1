import java.sql.*;

public class jdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String m_driverName = "oracle.jdbc.driver.OracleDriver";
		try {
			Class drvClass = Class.forName(m_driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String m_url = "jdbc:oracle:thin:@gwynne.cs.ualberta.ca:1521:CRS";
		String m_username = "commande";
		String m_password = "Alexsq2014";
		Connection con = null;
		try {
			con = DriverManager.getConnection(m_url, m_username, m_password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String statement;
		
		statement = "drop table movie";
		try {
			stmt.executeUpdate(statement);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		statement = "create table movie(title char(20), movie_number integer, primary key(movie_number))";
		try {
			stmt.executeUpdate(statement);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		statement = "insert into movie values ('chicago', 11)";
		try {
			stmt.executeUpdate(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		statement = "select title, movie_number from movie";
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				System.out.println((rs.getString("title").trim()) + ","
						+ rs.getInt("movie_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

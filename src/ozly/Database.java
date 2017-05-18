package ozly;
/**
 * @author ${geochirayath}
 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hsqldb.Server;

public class Database {
	
	public static ArrayList<String> idList;
	public static ArrayList<String> nameList;
	public static ArrayList<Integer> ageList;
	public static ArrayList<String> stateList;
	public static ArrayList<String> typeList;
	public static ArrayList<Integer> pointsList;
	
	public Database(){
	Server hsqlServer = null;
	Connection connection = null;
	ResultSet rs = null;
	hsqlServer = new Server();
	hsqlServer.setLogWriter(null);
	hsqlServer.setSilent(true);
	hsqlServer.setDatabaseName(0, "AthleteDB");
	hsqlServer.setDatabasePath(0, "file:AthleteDB");
	hsqlServer.start();
	// making a connection
	try {
		Class.forName("org.hsqldb.jdbcDriver");
		connection =
				DriverManager.getConnection("jdbc:hsqldb:AthleteDB", "sa", "");
		connection.prepareStatement("drop table AthleteDB if exists;").execute();
		connection.prepareStatement("CREATE TABLE AthleteDB(id VARCHAR(50) NOT NULL, name VARCHAR(50) NOT NULL,age int NOT NULL, state VARCHAR(50) NOT NULL,type VARCHAR(50) NOT NULL,points int NOT NULL);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1101', 'Albert',21, 'ACT','C',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1102', 'Bijo',22, 'VIC','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1103', 'Carren',23, 'ACT','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1104', 'Donald',24, 'ACT','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1105', 'Erric',25, 'NSW','C',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1106', 'Fletcher',26, 'NSW','C',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1107', 'George',27, 'VIC','C',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1108', 'Harrvy',21, 'NSW','C',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1109', 'Ivan',22, 'NSW','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1110', 'John',24, 'NT','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1111', 'Karman',25, 'NT','A',0);").execute();
//		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
//				+ "values ('Oz1112', 'Lionel',25, 'VIC,'A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1113', 'Messi',23, 'VIC','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1114', 'Neymar',24, 'NT','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1115', 'Orlando',21, 'QLD','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1116', 'Palmer',25, 'QLD','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1117', 'Queen',26, 'VIC','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1118', 'Robin',27, 'QLD','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1119', 'Sattire',24, 'SA','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1120', 'Tommy',27, 'SA','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1121', 'Uvan',28, 'SA','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1122', 'Veronica',29, 'TAS','S',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1123', 'Wytt',21, 'TAS','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1124', 'Xavier',22, 'TAS','A',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1125', 'Yen',24, 'WA','R',0);").execute();
		connection.prepareStatement("insert into AthleteDB(id, name, age, state, type, points)"
				+ "values ('Oz1124', 'Zohan',26, 'WA','R',0);").execute();
		//
		// // query from the db
		// create list
		idList = new ArrayList<String>();
		nameList = new ArrayList<String>();
		ageList = new ArrayList<Integer>();
		stateList = new ArrayList<String>();
		typeList = new ArrayList<String>();
		pointsList = new ArrayList<Integer>();
		rs = connection.prepareStatement("select id, name, age, state, type, points from AthleteDB;").executeQuery();
		while(rs.next())
		{
			//System.out.println("Adding the records to DB");
			//System.out.println(String.format("ID: %1s, Name: %1s, Age: %1d, state: %1s, type: %1s, points: %1d", rs.getString(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5), rs.getInt(6)));
			idList.add(rs.getString(1));
			nameList.add(rs.getString(2));
			ageList.add(rs.getInt(3));
			stateList.add(rs.getString(4));
			typeList.add(rs.getString(5));
			pointsList.add(rs.getInt(6));
		}
		connection.commit();
		connection.close();

		 
//		System.out.println("==> For Loop Example.");
//		for (int i = 0; i < idList.size(); i++) {
//			System.out.println(idList.get(i));
//		}
	} catch (Exception e) {
		//
	} 
}	  
}

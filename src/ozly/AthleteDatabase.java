package ozly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hsqldb.Server;

/**
 * @author ${sreeragsaradesh}
 
 */


public class AthleteDatabase{
	
	private static Athlete athlete[];
	
	public void FileRead(){
		try
		{
		 BufferedReader br = new BufferedReader(new FileReader("participants.txt"));
		    String line = null;

		    while ((line = br.readLine()) != null) {
		      String[] values = line.split(",");
		      for (String str : values) {
		        //System.out.println(str);
		      }
		    }
		    br.close();
		}
		catch (Exception e) 
		{ 
			
		}
		}
	
	// 
	public AthleteDatabase(){
						
		athlete = new Athlete[26];
		
		
		athlete[0] = new Athlete(Database.idList.get(0),Database.nameList.get(0),Database.ageList.get(0),Database.stateList.get(0),'C',0);
		//athlete[0] = new Athlete("Oz1101", "Alb",21, "ACT",'C',0);
		
		athlete[1] = new Athlete(Database.idList.get(1),Database.nameList.get(1),Database.ageList.get(1),Database.stateList.get(1),'C',0);
		//System.out.println(athlete[11]);
		athlete[2] = new Athlete(Database.idList.get(2),Database.nameList.get(2),Database.ageList.get(2),Database.stateList.get(2),'R',0);
		athlete[3] = new Athlete(Database.idList.get(3),Database.nameList.get(3),Database.ageList.get(3),Database.stateList.get(3),'R',0);
		athlete[4] = new Athlete(Database.idList.get(4),Database.nameList.get(4),Database.ageList.get(4),Database.stateList.get(4),'S',0);
		athlete[5] = new Athlete(Database.idList.get(5),Database.nameList.get(5),Database.ageList.get(5),Database.stateList.get(5),'S',0);
		athlete[6] = new Athlete(Database.idList.get(6),Database.nameList.get(6),Database.ageList.get(6),Database.stateList.get(6),'A',0);
		athlete[7] = new Athlete(Database.idList.get(7),Database.nameList.get(7),Database.ageList.get(7),Database.stateList.get(7),'A',0);
		athlete[8] = new Athlete(Database.idList.get(8),Database.nameList.get(8),Database.ageList.get(8),Database.stateList.get(8),'A',0);
		athlete[9] = new Athlete(Database.idList.get(9),Database.nameList.get(9),Database.ageList.get(9),Database.stateList.get(9),'A',0);
		athlete[10] = new Athlete(Database.idList.get(10),Database.nameList.get(10),Database.ageList.get(10),Database.stateList.get(10),'A',0);
		athlete[11] = new Athlete("Oz1112","Messi",23,"VIC",'A',0);
		athlete[12] = new Athlete(Database.idList.get(11),Database.nameList.get(11),Database.ageList.get(11),Database.stateList.get(11),'R',0);
		athlete[13] = new Athlete(Database.idList.get(12),Database.nameList.get(12),Database.ageList.get(12),Database.stateList.get(12),'R',0);
		athlete[14] = new Athlete(Database.idList.get(13),Database.nameList.get(13),Database.ageList.get(13),Database.stateList.get(13),'R',0);
		athlete[15] = new Athlete(Database.idList.get(14),Database.nameList.get(14),Database.ageList.get(14),Database.stateList.get(14),'C',0);
		athlete[16] = new Athlete(Database.idList.get(15),Database.nameList.get(15),Database.ageList.get(15),Database.stateList.get(15),'C',0);
		athlete[17] = new Athlete(Database.idList.get(16),Database.nameList.get(16),Database.ageList.get(16),Database.stateList.get(16),'C',0);
		athlete[18] = new Athlete(Database.idList.get(17),Database.nameList.get(17),Database.ageList.get(17),Database.stateList.get(17),'C',0);
		athlete[19] = new Athlete(Database.idList.get(18),Database.nameList.get(18),Database.ageList.get(18),Database.stateList.get(18),'R',0);
		athlete[20] = new Athlete(Database.idList.get(19),Database.nameList.get(19),Database.ageList.get(19),Database.stateList.get(19),'R',0);
		athlete[21] = new Athlete(Database.idList.get(20),Database.nameList.get(20),Database.ageList.get(20),Database.stateList.get(20),'S',0);
		athlete[22] = new Athlete(Database.idList.get(21),Database.nameList.get(21),Database.ageList.get(21),Database.stateList.get(21),'S',0);
		athlete[23] = new Athlete(Database.idList.get(22),Database.nameList.get(22),Database.ageList.get(22),Database.stateList.get(22),'S',0);
		athlete[24] = new Athlete(Database.idList.get(23),Database.nameList.get(23),Database.ageList.get(23),Database.stateList.get(23),'S',0);
		athlete[25] = new Athlete(Database.idList.get(24),Database.nameList.get(24),Database.ageList.get(24),Database.stateList.get(24),'S',0);
	
	}
	
	public static Athlete[] getAthlete() {
		return athlete;
	}

}

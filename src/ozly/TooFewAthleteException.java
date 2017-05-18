package ozly;
/**
 * @author ${geochirayath}
 
 */
public class TooFewAthleteException extends Exception {
	String s;
	public TooFewAthleteException(String s){
		 this.s= s;
		 }
	
@Override
public String toString()
{
	return(s);
}
	

}

package ozly;
/**
 * @author ${geochirayath}
 
 */

public class NoRefereeException extends Exception {

	String s;
	public NoRefereeException(String s){
		 this.s= s;
		 }
	
@Override
public String toString()
{
	return(s);
}
	

}
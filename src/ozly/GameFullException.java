package ozly;
/**
 * @author ${sreeragsaradesh}
 
 */

public class GameFullException extends Exception {

	String s;
	public GameFullException(String s){
		 this.s= s;
		 }
	
@Override
public String toString()
{
	return(s);
}
	

}

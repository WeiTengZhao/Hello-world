import java.util.*;
public class Name implements Comparable {
	private String firstName;
	private String lastName;
	
	Name(String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
		
	public String getFirstName(){
		return firstName;
	}	
	public String getlastName(){
		return lastName;
	}
	
	public String toString(){
		return lastName + " " +firstName;
	}

	public boolean equals(Object obj){
		if(obj instanceof Name){
			Name name = (Name) obj;
			return (firstName.equals (name.firstName) ) &&  (lastName.equals (name.lastName) );
		}
		return (super.equals(obj));
	}

	public int hashCode(){
		return firstName.hashCode();
	}	

	/*public int compareTo(Object o){
		Name n = (Name) o;
		if(n.lastName.compareTo(lastName) == 0 ) {return (n.firstName.compareTo(firstName));}
		else {return n.lastName.compareTo(lastName);}
	}*/
	public int compareTo(Object o){
		Name n = (Name)o;
		int lastCmp = n.lastName.compareTo(lastName);
		int firstCmp = n.firstName.compareTo(firstName);
		return (lastCmp != 0 ? lastCmp:firstCmp);
	}	
}
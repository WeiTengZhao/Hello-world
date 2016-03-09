public class Name{
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
		return lastName + " " + firstName;
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
}
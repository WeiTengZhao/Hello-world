public class Date{
	int year;
	int mouth;
	int day;
	public Date(int year,int mouth,int day){
		this.year = year;
		this.mouth = mouth;
		this.day = day;
	}
	public  int compare(Date date){
		if(year > date.year){
			return 1;
		}
		else if(year < date.year){
			return -1;
		}

		if(mouth > date.mouth){
			return 1;
		}

		else if(mouth < date.mouth){
			return -1;
		}

		if(day > date.day){
			return 1;
		}

		else if(day < date.day){
			return -1;
		}
		else return 0;

	}

	public String toString(){
		return "Date:" + year +"--" + mouth + "--" + day;
	}
}
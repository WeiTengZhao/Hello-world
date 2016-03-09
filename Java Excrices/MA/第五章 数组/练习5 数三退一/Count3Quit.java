public class Count3Quit{
	public static void main(String [] args){
		boolean arr[] = new boolean [500];
		for(int i = 0;i	< arr.length;i++){
			arr[i] = true;
		}
		int leftCount = arr.length;
		int countNumber = 0;
		int index = 0;
		
		while(leftCount > 1){
			if(arr[index] == true){
				countNumber ++;
				if( countNumber == 3){
					countNumber = 0;
					arr[index] = false;
					leftCount --;
				}
			}
			index ++;
			if(index == arr.length){
				index = 0;
			} 
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i] == true){
				System.out.println(i);
			}
		}
	}
}
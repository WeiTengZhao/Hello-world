public class KidCircle{
	int count = 0;
	Kid first;
	Kid last;

	KidCircle(int n){
		for(int i = 0;i < n;i ++){
			add();
		}
	}

	public void add(){
		Kid k = new Kid();
		k.id = count;
		if(count <= 0){
			k.left = k;
			k.right = k;
			first = k;
			last = k;
		}	
		else {
			k.left = last;
			last.right = k;
			k.right = first;
			first.left = k;
			last = k;
		}
		count ++;
	}
	
	public void delete(Kid k){
		if(count <= 0){
			System.out.println("并没有孩子");
		
		}else if(count == 1){
			first = last = null;
		}
		else{
			k.right.left = k.left;
			k.left.right = k.right;
		}if(k == first){
			first = k.right;
		}else if(k == last){
			last = k.left;
		}
		count --;
		
	}
}
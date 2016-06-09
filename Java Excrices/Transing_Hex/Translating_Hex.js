function Translate() {
	var t1 = document.getElementById('T1').value;
	var t2 = document.getElementById('T2');
	var t8 = document.getElementById('T8');
	var t16 = document.getElementById('T16');
	var newValue = new Number(t1);
	t2.value = newValue.toString(2);
	t8.value= newValue.toString(8);
	t16.value= newValue.toString(16);
	
	
}
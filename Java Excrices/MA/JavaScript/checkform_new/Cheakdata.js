
function cheakusername(){
	var ssn = document.getElementById('T1').value;	
	if(document.getElementById('T1').value.length< 3 || document.getElementById('T1').value.length> 19) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML = "<font color = 'red'>�û���������3��18λ</font>" ;
	}
	else if(withspace(ssn)) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML =	"<font color = 'red'> �û������ܰ����ո�</font>";	
	}
	else if(withrepeat(ssn)) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML =	"<font color = 'red'> �û����Ѿ����ڣ������</font>" ;				
	}

		else {document.getElementById('spenT1').innerHTML = "";}
	   //=====================================
	function withrepeat(ssn) {
		var re = /^[0-9a-z][/w_.]*[0-9][a-z]$/i
		if(re.test(ssn)) {
			return true;
		}
		return false;
	}
	function withspace(s) {
		var withspace = " \t\r\n";
		var c = document.getElementById('T1').value;
		for (var i = 0;i < s.length ; i++) {
			var ch = s.charAt(i);
			if(withspace.indexOf (ch) >= 0){
				return true;
			}
		}
		return false;
	}
}
//===========================================================================================
function cheakpassworld1(){
	var psw1 = document.getElementById('P1').value;
	var psw2 = document.getElementById('P2').value;
//����У��

	   if(strlen2(psw1)) {
		//form.psw1.focus();	
		document.getElementById('spenP1').innerHTML = "<font color = 'red'>�����зǷ��ַ�</font>";		
	}  	
	else if(psw1 == ""){
		//form.psw1.focus();	
		document.getElementById('spenP1').innerHTML = "<font color = 'red'>���벻��Ϊ��</font>";
	}
	 else if (strlen(psw1) < 6 || strlen(psw1) > 16) {
	                 //form.psw1.focus();
			                 document.getElementById('spenP1').innerHTML = "<font color = 'red'>������6��16λ</font>";				         
	}

	else {
		document.getElementById('spenP1').innerHTML ='';
		
		}
}
	//==========================================
	        function strlen(psw1) {
			var len = 0;
			for(var i = 0;i < psw1.length;i ++){
				if (psw1.charCodeAt(i) > 255) {
					len +=2;
   		                }
				else {len ++;}
												          
		  	}
			return len;
	      }
		function strlen2(psw1) {
			for(var i = 0;i < psw1.length;i ++){
				if (psw1.charCodeAt(i) > 255) {
					return true;
				}
			}
		}

	//������������У��
function cheakpassworld2(){
	var psw1 = document.getElementById('P1').value;
	var psw2 = document.getElementById('P2').value;
	if(!(psw1 == psw2)) {
		document.getElementById('spenP2').innerHTML = "<font color = 'red'>�����������벻һ��</font>"
	}
	else {document.getElementById('spenP2').innerHTML ='';}
}
	//�Ա�ѡ�����
function cheakcheck(){
	var ch1 = document.getElementById('C1');
	var ch2 = document.getElementById('C2');
	if(!(ch1.checked || ch2.checked)) {
		document.getElementById('spendC1').innerHTML = "<font color = 'red'> ��ѡ���Ա� </font>"		
	}
	else {document.getElementById('spenC1').innerHTML = '';}
}
function cheakdrop() {
	var dorp1 = document.getElementById('D1');
	if(dorp1.selectedIndex == 0){
		document.getElementById('spenD1').innerHTML = "<font color = 'red'> ��ѡ��ʡ�� </font>"
	}
	else {document.getElementById('spenD1').innerHTML = '';}
}
//=================================================================================================================
function cheakdata() {
	var ssn = document.getElementById('T1').value;
	var psw1 = document.getElementById('P1').value;
	var psw2 = document.getElementById('P2').value;
	var ch1 = document.getElementById('C1');
	var ch2 = document.getElementById('C2');
	var drop1 = document.getElementById('D1');
	var brief1 = document.getElementById('Brief');
	if(!cheakusername(ssn)) {
		return false;
	}
		
		//�û�����֤
	function cheakusername(ssn){
		if(ssn.length< 3 || ssn.length> 19) {
			alert("�û���������3��18λ");
			form.username.focus();
			return false;
		}
		
		if(withspace(ssn)) {
			alert("�û������ܰ����ո�");
			form.username.focus();
			return false;			
		}

		if(withrepeat(ssn)) {
			alert("�û����Ѿ����ڣ������");
			form.username.focus();
			return false;				
		}

		 return true;
	}
                        //=====================================
		function withrepeat(ssn) {
			var re = /^[0-9a-z][/w_.]*[0-9][a-z]$/i
			if(re.test(ssn)) {
				return true;
			}
			return false;
		}
		function withspace(s) {
			var withspace = " \t\r\n";
			//var c = document.getElementById('T1').value;
			for (var i = 0;i < s.length ; i++) {
				var ch = s.charAt(i);
				if(withspace.indexOf (ch) >= 0){
					return true;
				}
			}
			return false;
		}

		
	//����У��

	  	if(strlen2(psw1)) {
			alert("�����зǷ��ַ�");
			form.psw1.focus();	
			return false;		
		}  
		if (strlen(psw1) < 6 || strlen(psw1) > 16) {
			alert("������6��16λ");
			form.psw1.focus();
			return false;
		}
		
		if (!(psw1 == psw2)) {
			alert("�������β�һ��");
			form.psw2.focus();	
			return false;	
		}
		if(psw1 == ""){
			alert("���벻��Ϊ��");
			form.psw1.focus();	
			return false;	
		}
		//==========================================
		function strlen(psw1) {
			var len = 0;
			for(var i = 0;i < psw1.length;i ++){
				if (psw1.charCodeAt(i) > 255) {
					len +=2;
				}
				else {len ++;}
			}
			return len;
		}

		function strlen2(psw1) {
			for(var i = 0;i < psw1.length;i ++){
				if (psw1.charCodeAt(i) > 255) {
					return true;
				}
			}
		}
		//ѡ���Ա�
		if (!(ch1.checked || ch2.checked) ) {
			alert("��ѡ���Ա�");
			ch1.focus();	
			return false;
		}
		//ѡ��ʡ��
		if(drop1.selectedIndex == 0) {
			alert("��ѡ��ʡ��");
			form.address.focus();	
			return false;	
		}
		//��鲻��Ϊ��
		if(brief1.value == "") {
			alert("��鲻��Ϊ��");
			brief1.focus();	
			return false;	
		}
		else {return true;}
}

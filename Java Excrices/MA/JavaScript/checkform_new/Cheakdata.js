
function cheakusername(){
	var ssn = document.getElementById('T1').value;	
	if(document.getElementById('T1').value.length< 3 || document.getElementById('T1').value.length> 19) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML = "<font color = 'red'>用户名长度在3—18位</font>" ;
	}
	else if(withspace(ssn)) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML =	"<font color = 'red'> 用户名不能包含空格</font>";	
	}
	else if(withrepeat(ssn)) {
		//form.username.focus();
		document.getElementById('spenT1').innerHTML =	"<font color = 'red'> 用户名已经存在，请更换</font>" ;				
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
//密码校验

	   if(strlen2(psw1)) {
		//form.psw1.focus();	
		document.getElementById('spenP1').innerHTML = "<font color = 'red'>密码有非法字符</font>";		
	}  	
	else if(psw1 == ""){
		//form.psw1.focus();	
		document.getElementById('spenP1').innerHTML = "<font color = 'red'>密码不能为空</font>";
	}
	 else if (strlen(psw1) < 6 || strlen(psw1) > 16) {
	                 //form.psw1.focus();
			                 document.getElementById('spenP1').innerHTML = "<font color = 'red'>密码在6—16位</font>";				         
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

	//两次输入密码校验
function cheakpassworld2(){
	var psw1 = document.getElementById('P1').value;
	var psw2 = document.getElementById('P2').value;
	if(!(psw1 == psw2)) {
		document.getElementById('spenP2').innerHTML = "<font color = 'red'>两次密码输入不一致</font>"
	}
	else {document.getElementById('spenP2').innerHTML ='';}
}
	//性别选择检验
function cheakcheck(){
	var ch1 = document.getElementById('C1');
	var ch2 = document.getElementById('C2');
	if(!(ch1.checked || ch2.checked)) {
		document.getElementById('spendC1').innerHTML = "<font color = 'red'> 请选择性别 </font>"		
	}
	else {document.getElementById('spenC1').innerHTML = '';}
}
function cheakdrop() {
	var dorp1 = document.getElementById('D1');
	if(dorp1.selectedIndex == 0){
		document.getElementById('spenD1').innerHTML = "<font color = 'red'> 请选择省份 </font>"
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
		
		//用户名验证
	function cheakusername(ssn){
		if(ssn.length< 3 || ssn.length> 19) {
			alert("用户名长度在3—18位");
			form.username.focus();
			return false;
		}
		
		if(withspace(ssn)) {
			alert("用户名不能包含空格");
			form.username.focus();
			return false;			
		}

		if(withrepeat(ssn)) {
			alert("用户名已经存在，请更换");
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

		
	//密码校验

	  	if(strlen2(psw1)) {
			alert("密码有非法字符");
			form.psw1.focus();	
			return false;		
		}  
		if (strlen(psw1) < 6 || strlen(psw1) > 16) {
			alert("密码在6—16位");
			form.psw1.focus();
			return false;
		}
		
		if (!(psw1 == psw2)) {
			alert("密码两次不一致");
			form.psw2.focus();	
			return false;	
		}
		if(psw1 == ""){
			alert("密码不能为空");
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
		//选择性别
		if (!(ch1.checked || ch2.checked) ) {
			alert("请选择性别");
			ch1.focus();	
			return false;
		}
		//选择省份
		if(drop1.selectedIndex == 0) {
			alert("请选择省份");
			form.address.focus();	
			return false;	
		}
		//简介不能为空
		if(brief1.value == "") {
			alert("简介不能为空");
			brief1.focus();	
			return false;	
		}
		else {return true;}
}

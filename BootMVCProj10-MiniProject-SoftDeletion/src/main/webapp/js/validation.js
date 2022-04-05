function validation(frm){
	alert("Client side form validations");
	//empty the error messages
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	
	//read form data
	let ename=frm.ename.value;
	let job=frm.job.value;
	let sal=frm.sal.value;
	let flag = true;
	
	//form validations(client side)
	if(ename==""){  //ename required rule 
		document.getElementById("enameErr").innerHTML="employee name is mandatory(cs)";
		flag = false;
	}
	else if(ename.length>10){  //ename max length rule
		document.getElementById("enameErr").innerHTML="employee name must have max of 10 chars(cs)";
		flag = false;
	}
	
	if(job==""){  //job required rule
		document.getElementById("jobErr").innerHTML="employee desg is required(cs)";
		flag = false;
	}
	else if(job.length>9){  //job max length rule
		document.getElementById("jobErr").innerHTML="employee desg can have max of 9 characters(cs)";
		flag = false;
	}
	
	if(sal==""){  //sak required rule
		document.getElementById("salErr").innerHTML="employee salary is required(cs)";
		flag = false;
	}
	else if(isNaN(sal)){  //sal numeric rule
		document.getElementById("salErr").innerHTML="employee sal must be numeric value(cs)";
		flag = false;
	}
	else if(sal<0 || sal>1000000){  //sal range rule
		document.getElementById("salErr").innerHTML="employee salary must be in the range of 1 through 1000000";
		flag = false;
	}
	
	//change vflag value to "yes" indicating client side form validations are done
	frm.vflag.value="yes";
	
	return flag;
}
function login(){
	var login=$('#log').val();;
	var pas=$('#pas').val();;
	var params = {
		"login":login,
		"password":pas
		};
	var resp = POST("http://localhost:9000/Authorization",params);
	if (resp != null){
			localStorage.setItem("login",params["login"]);
			document.location.href='hi.html';
	} else	{
		alert('Login or password is wrong');
	}
}

function POST(url,params) {
	// Form fields, see IDs above
	const http = new XMLHttpRequest();
	http.open("POST", url,false);
	http.setRequestHeader('Content-type', 'application/json');
	http.send(JSON.stringify(params)); // Make sure to stringify
	if(http.status == 200){
		return JSON.parse(http.responseText);
	} else {
		return null;
	}
}
	
	
function checkParams() {
	var name = $('#nameAlg').val();
	var description = $('#descriptionAlg').val();
	var price = $('#priceAjg').val();
	var test = $('#testAlg').val();
	var code = $('#codeAlg').val();

	if(name.length != 0 && description.length != 0 && test.length != 0 && code.length != 0) {
		if($("#free").prop("checked") || ($("#pay").prop("checked") && price.length != 0)){
				$('.submit').css('display', 'inline-block');
				$('.submit').click(function(){				
					$('#nameAlg').addClass('disabled');
					$('#descriptionAlg').addClass('disabled');
					$('#priceAjg').addClass('disabled');
					$('#testAlg').addClass('disabled');
					$('#codeAlg').addClass('disabled');
				});
		}
		$('#back').css('display', 'inline-block');
		
		return;
	}

	$('.submit').css('display', 'none');
		
	return;
}

function checkLogin() {
	var login = $('#log').val();
	var pass = $('#pas').val();

	if(login.length != 0 && pass.length != 0) {
		$('.login').removeClass('disabled');
		return;
	}
	$('.login').addClass('disabled');
}

function checkLoginFirst() {
	var log = $('#logFirst').val();
	var first = $('#FirstName').val();
	var last = $('#LastName').val();
	var mid = $('#MiddleName').val();
	var pas = $('#pasFirst').val();

	if(log.length != 0 && pas.length != 0 && mid.length != 0 && first.length != 0 && last.length != 0) {
		$('.reg').removeClass('disabled');
				
		return;
	}
	$('.reg').addClass('disabled');
}


function send(){
	var name = $('#nameAlg').val();
    var description = $('#descriptionAlg').val();
    var price = $('#priceAjg').val();
    var test = $('#testAlg').val();
    var code = $('#codeAlg').val();
	
	var params = {
		"namealg":name,
		"language":"C++",
		"testfile":test,
		"sourcefile":code,
	};
	var resp = POST("http://localhost:9000/RunTest",params);
	if (resp != null){
		$('#answer').html(resp.answer);
		if(resp.successful == '0'){
			$('#add').css('display', 'inline-block');
		}
	}
}

function registration(){
	document.location.href='registration.html';	
}

function authorization(){	
	var log = $('#logFirst').val();
	var first = $('#FirstName').val();
	var last = $('#LastName').val();
	var mid = $('#MiddleName').val();
	var pas = $('#pasFirst').val();
	
	var params = {
		"login": log, 
		"password": pas, 
		"firstname": first, 
		"secondname" : last, 
		"middlename": mid
		};
	
	var resp = POST("http://localhost:9000/Registration",params);
	if (resp != null){
		document.location.href='index.html';
	} else	{
		alert('Your login is exist');
	}
}

function AddAlgorithm(){ 
 var name = $('#nameAlg').val();
 var description = $('#descriptionAlg').val();
 var price = $('#priceAlg').val();
 var test = $('#testAlg').val();
 var code = $('#codeAlg').val();
 
 if( price == ''){
   price = 0;
 };
 
 var params = {
  "namealg": name, 
  "cost": price, 
  "owner": localStorage.getItem("login"), 
  "description" : description, 
  "language": "C++",
  "sourcefile": code,
  "testfile": test
 };
 
 var resp = POST("http://localhost:9000/AddAlgorithm",params);
 if (resp != null){
  alert("Yorк algoritm added");
 } else {
  alert('Your name algoritm is exist');
 }
 $('#add').css('display', 'none');
}


function myfunc(namealg) {
	 var params = {
	  "namealg": namealg, 
	  "login": localStorage.getItem("login")
	};
	
	var resp = POST("http://localhost:9000/GetAlgorithmUser",params),
		costAlgoritm = resp.algorithm.cost,
		descriptionAlgoritm = resp.algorithm.description,
		languageAlgoritm = resp.algorithm.language,	
		source = resp.algorithm.sourcefile,
		test = resp.algorithm.testfile;
	$('#costAlg').val(costAlgoritm);
	$('#descrAlg').val(descriptionAlgoritm);
	$('#langAlg').val(languageAlgoritm);
	$('#codeAlg').val(source);
	$('#testAlg').val(test);
}
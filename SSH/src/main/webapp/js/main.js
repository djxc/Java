$(document).ready(function(){

	$("#query").click(function(){
		 $.ajax({
			 type:"GET",
			 url:"getAllUsers",
			 dataType:"json",
			 success:function(data, type){		
				 for(var u in data)
				 {
					 console.log(data[u].firstName);
				 }
				 alert(data[0].firstName);
				 $("#name").val(data[0].firstName);
			 }
		  });
	});
	
	$("#addUser").click(function(){
		var user = new userinfo($("#uFistName").val(),$("#uLastName").val() );
		var jsonstring = JSON.stringify(user);
		 $.ajax({
			 type:"POST",
			 url:"AddUser",
			 data:jsonstring,
			 contentType: "application/json",
			 success:function(data, type){						 
			 }
		  });
	});
	
	function userinfo(firstName, lastName)
	  {
		  this.firstName = firstName;
		  this.lastName = lastName;
	  }
});
$(document).ready(function(){
  $("#btn").click(function(){		  	
  	$.post("getPerson",{name:$("#name").val()},function(data){
        alert(data);
    });
  });
  
  $("#testRedir").click(function(){		  	
	  	$.post("Redir",{name:$("#name").val()});
	  });
  
  $("#URLmatch").click(function(){		  	
	   $.post("dj/12");
	   alert("");
	});
  
  function userinfo(uname, upassword)
  {
	  this.name = uname;
	  this.password = upassword;
  }
  
  $("#sendjson").click(function(){
	  var user = new userinfo($("#jsonstr").val(), 123);
	  var jsonstring = JSON.stringify(user);	
	  $.post("getJSONString",{jsonstr:jsonstring},function(data){
	        alert(data);
	    });
  });
  
  
  $("#json2object").click(function(){
	  var user = new userinfo("杜杰", 123);
	  var jsonstring = JSON.stringify(user);
	  $.ajax({
		 type:"POST",
		 data:jsonstring,
		 url:"json2object",
		 contentType: "application/json"
	  });
  });
  
  $("#getjson").click(function(){
	  var user = new userinfo("杜杰", 123);
	  var jsonstring = JSON.stringify(user);
	  $.ajax({
		 type:"POST",
		 data:jsonstring,
		 url:"sendjson",
		 contentType: "application/json",
		 success:function(data, type){
			 var jsonstr = JSON.parse(data);
			 alert(jsonstr.name+","+jsonstr.password);
		 }
	  });
  });
  
  $("#getjson2").click(function(){
	  var user = new userinfo("杜杰", 123);
	  var jsonstring = JSON.stringify(user);
	  $.ajax({
		 type:"POST",
		 data:jsonstring,
		 url:"sendjson2",
		 contentType: "application/json",
		 success:function(data, type){			
			 alert(data.name+","+data.password);
		 }
	  });
  });
  
});


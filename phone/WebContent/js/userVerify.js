 function checkName(){  
    //alert("ajax实例");  
    //1.获取文本框中的内容  
    //document.getElementById("username");dom的方式  
    //jquery 查找节点方式,参数中#加在id属性值可以得到一个节点  
    //jquery 的方法返回的都是jquery的对象，可以继续在上面执行其他的jquery方法  
    var nameObj = $("#uname");  
    //获取节点的值  
    var username = nameObj.val();  
    //2.将文本框中的数据发送给服务器的servlet  
    //使用jquery的xmlHttpRequest对象的get请求的封装 这几种方法都行  
    //$.get(url,date,回调函数)  
    $.get("chkUser?name="+username,null,callback);  
    //$.get("AjaxServlet",username,callback);  
    //$.get("AjaxServlet","name="+username,callback);     
      
      
}  
//回调函数  
function callback(data){  
   //alert("服务器端的数据回来了!!");  
   //3.接受服务器端返回的数据    
    //4.将服务器端返回的数据动态的显示在网页上  
    //找到保存结果信息的节点  
    $("#result").html(data);  
    //动态的改变页面节点div中的内容  
}  

// 检验手机号格式
    function checkMobile(mobile) {
	if (mobile != '') {
		var pattern = /^(((13[0-9]{1})|15[0-9]{1}|18[0-9]{1}|)+\d{8})$/;
		if (pattern.test(mobile) == false) {
			$("#result").html('请输入正确的格式~');
			return false;
		} else {
			return true;
		}
	}
}
 function delAddr(a_id,r)	{    

    $.post("delAddr?a_id="+a_id,null,callback);   
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById('adr').deleteRow(i);
    
}  
 
//回调函数  
function callback(data){  
   //alert("服务器端的数据回来了!!");  
    $("#result").html(data);  
} 

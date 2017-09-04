function goSort(sort){
		if(sort =="p_price升序"){
			document.getElementById("sort").value = "p_price";
			document.getElementById("order").value = "asc";
			document.getElementById("seach").submit();	
		}
		
		if(sort == "p_price降序"){
			document.getElementById("sort").value = "p_price";
			document.getElementById("order").value = "desc";
			document.getElementById("seach").submit();
		}
		
		if(sort == "p_sale升序"){
			document.getElementById("sort").value = "p_sale";
			document.getElementById("order").value = "asc";
			document.getElementById("seach").submit();
		}
		
		if(sort == "p_sale降序"){
			document.getElementById("sort").value = "p_sale";
			document.getElementById("order").value = "desc";
			document.getElementById("seach").submit();
		}
	} 
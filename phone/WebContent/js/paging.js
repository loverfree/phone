function goPage(currentPage,lastpage) {
		// 将页码和当前页显示的记录数 隐藏起来
		if(currentPage<=1) {
			currentPage = 1;
		}
		if(currentPage>lastpage){
			  currentPage = lastpage;
		  }
		  document.getElementById("curPage").value=currentPage;
		  document.getElementById("pageForm").submit();	
	}
	
	 function goPage2(){
		  var gPage = document.getElementById("gpage").value;
		  goPage(gPage);
	 }

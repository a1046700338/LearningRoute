window.onload=function(){
	var fruitTbl = document.getElementById("tbl_fruit");
	var rows = fruitTbl.rows;
	for(var i=0;i<rows.length;i++){
		var tr = rows[i];
		tr.onmouseover=showBGcolor;
		var cells = tr.cells;
		var priceTD = cells[i];
		priceTD.onmouseover = showHand;
	}
}
function showBGcolor(){
	alert(event.srcElemt)
	if(event.srcElemt && event.srcElemt.tagName="TD"){
		var td = event.srcElemt;
		var tr = td.parentElemt;
		tr.style.backgroundColor = "#FCE6C9";
	}
}
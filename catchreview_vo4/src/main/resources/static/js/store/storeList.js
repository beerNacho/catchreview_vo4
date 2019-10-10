var storeManager = (function(){
	alert('들어왔오');
	var getAll = function(obj, callback){
		alert("getall 함수 안 : " + obj.id);
		console.log("get ALL.....");
		$.getJSON('/mypage/store/' + obj.id, callback);
	};
	
	return{
		getAll: getAll
	}
})();
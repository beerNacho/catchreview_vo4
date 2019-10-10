function uploadSingleFile(obj, file) {
    var formData = new FormData();
    formData.append("file", file);
    formData.append("vo", obj);
    alert("함수 안으로 들어옴");
    alert(obj.writer);

    var xhr = new XMLHttpRequest();
    
    
    xhr.onload = function() {
    	$.ajax({
    		type:'post',
    		url: '/qnaBoards/register',
    		data: JSON.stringify(obj),
    		dataType: 'json',
    		beforeSend : function(xhr){
    			xhr.setRequestHeader(obj.csrf.headerName, obj.csrf.token);
    		},
    		contentType: "application/json",
    		success: location.href=alert('성공')
    	});
    }

    xhr.open("POST", "/register");
    
    xhr.send(formData);
}
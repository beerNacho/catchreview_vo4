function uploadSingleFile(obj, file) {
    var formData = new FormData(document.getElementById('form_upload'));
    formData.append("file", file);
    formData.append("vo", obj);
    alert("함수 안으로 들어옴");
    alert(obj.writer);
    
    xhr.onload = function() {
    	$.ajax({
    		type:'post',
    		url: '/qnaBoards/register',
    		data: form,
    		dataType : 'json',
    		processData : false,
    		contentType: false,
    		success: alert('성공')
    	});
    }

    xhr.open("POST", "http://localhost:8082/qnaBoards/register");
    
    xhr.send(formData);
}
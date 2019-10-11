'use strict';

var singleUploadForm = document.querySelector('#singleUploadForm');
var file1Input = document.querySelector('#filename1');
var file2Input = document.querySelector('#filename2');
var file3Input = document.querySelector('#filename3');
var file4Input = document.querySelector('#filename4');

function uploadSingleFile(file1, file2, file3, file4) {
    var formData = new FormData();
    formData.append("file", file);


    var xhr = new XMLHttpRequest();
    
    

    xhr.onload = function() {
    	$.ajax({
    		type:'post',
    		url: '/store/register',
    		data: form,
    		dataType : 'json',
    		processData : false,
    		contentType: false,
    		success: alert('성공')
    	});
    }
    
    xhr.open("POST", "/uploadFile", true);
    

    xhr.send(formData);
}

singleUploadForm.addEventListener('submit', function(event){
	
    var files1 = file1Input.files;
    var files2 = file2Input.files;
    var files3 = file3Input.files;
    var files4 = file4Input.files;
    alert('됨?' + files1.length);
    alert(files2.length);
    uploadSingleFile(files1[0], files2[0], files3[0], files4[0]);
    event.preventDefault();
}, true);
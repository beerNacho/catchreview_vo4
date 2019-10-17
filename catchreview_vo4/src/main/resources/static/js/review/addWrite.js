
window.onload=function(){
	var singleUploadForm = document.querySelector('#singleUploadForm');
	var file = document.querySelector('#file');
	
	$('.btn_close').on('click', function(){
		window.close();
	});
	

	$('#file').on('change', function(){
		var box = document.getElementById("imgBox");
		box.innerHTML="<div id = 'userimg'><img id = 'image_section'src='#'></div>"
		
			readURL(this);
	});

	
	function readURL(input) {

				  if (input.files && input.files[0]) {
 			   var reader = new FileReader();

   				 reader.onload = function (e) {
   			     $('#image_section').attr('src', e.target.result);
   				 }

   				 reader.readAsDataURL(input.files[0]);
				}
	}

	
	$('.borderIcon').on('click', function(){
		$('li').removeClass('borderLayout');
		$(this).addClass('borderLayout');
		$('#storeRate').html('<input type="hidden" name="storeRate" value="'+$(this).attr("value")+'">');
		$('#checkRate').val('o');
	});
	
	

	    
	
	$('#btn_submit').on('click', function(){
		if($("#checkRate").attr("value")=="o"){
			
			var files = file.files;
		    alert(files.length);
		    
		    var storeNum = $("input[name='storeNum']").val();
			
			var storeRate = $("input[name='storeRate']").val();
			
			var filename = $("input[name='filename']").val();
			
			var writer = $("input[name='writer']").val();
			
			var reviewTitle = $("input[name='reviewTitle']").val();
			
			var reviewContent = $("textarea[name='reviewContent']").val();
			
			var review = {storeRate:storeRate, filename:filename, writer:writer, reviewTitle:reviewTitle, reviewContent:reviewContent};
		    
			alert(review.reviewContent);
			
		    uploadSingleFile(files[0], review, storeNum);
		    
		} else{
			alert("가게에 대한 평가를 해주세요");
		}
	});
	
	function uploadSingleFile(file, review, storeNum) {
		var xhr = new XMLHttpRequest();
		alert(storeNum);
		var formData = new FormData();
	    formData.append("storeNum", storeNum);
	    formData.append("file", file);
	    formData.append("storeRate", review.storeRate);
	    formData.append("filename", review.filename);
	    formData.append("writer", review.writer);
	    formData.append("reviewTitle", review.reviewTitle);
	    formData.append("reviewContent", review.reviewContent);
		alert(review.reviewContent);
	    
	    $.ajax({
            type: "POST",
            url: "/review/register",
            data: formData,
            enctype: 'multipart/form-data',
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function(){
            	opener.parent.location.reload();
            	window.close();
            }
        });

	}

	
}
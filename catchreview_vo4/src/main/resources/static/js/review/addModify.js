
window.onload=function(){
	$('.btn_close').on('click', function(){
		window.close();
	});
	

	$('#iconFile').on('change', function(){
		var box = document.getElementById("imgBox");
		box.innerHTML="<div id = 'userimg'><img id = 'image_section'src='#'></div>"
		readURL(this);
	});

	$('#iconFile2').on('change', function(){
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
	});
	
	$('#btnDeletePicture').on('click', function(){
		$("#imgBox").html('');
		$("#pictureUpdate").attr('value', 'd');
	});
	
	$('#iconFile').on('click', function(){
		$("#pictureUpdate").attr('value', 'm');
	});
	
	$('#btn_submit').on('click', function(){
		$("#reviewModify").submit();	
	});
}
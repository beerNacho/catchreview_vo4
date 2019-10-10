
window.onload=function(){
	$('.btn_close').on('click', function(){
		window.close();
	});
	

	$('#iconFile').on('change', function(){
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
			$("#reviewWrite").submit();	
		} else{
			alert("가게에 대한 평가를 해주세요");
		}
	});
}



window.onload = function(){
	// 사진 미리보기 기능
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#image_section').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#imgInput").change(function() {
		$('#image_section').css("display", "block");
		$('#icon').css("display", "none");
		readURL(this);
	});

	// 정보 저장하기 기능
	var filenames = [];
	var contents = [];

	$('#btn_add').on('click', function() {
		var imgInpu = $('#imgInput').val();
		var imgInput = imgInpu.substring(12);
		var storePictureContent = $('#storePictureContent').val();
		filenames.push(imgInput);
		contents.push(storePictureContent);
		// 둘중 하나만 살리면 될듯?
		$('#storePictureContent').remove();
		$('#textareaSite').html('<textarea id = "storePictureContent" name = "storePictureContent"></textarea>');

		$('#image_section').css("display", "none");
		$('#icon').css("display", "block");
	});

	$('#btn_complete').on('click', function(){
		for(var i=0; i<filenames.length; i++){
			$('#inputHidden').append('<input type = "text" name = "sendfile", value = "' + filenames[i]+'">');	
			$('#inputHidden').append('<input type = "text" name = "sendcontent", value = "' + contents[i]+'">');
		}
		$('#photoForm').submit();
	});

	function submit(){

	}

	$('#storechange').on('click', function(){
	});
	$('#menuchange').on('click', function(){
		$('#datacheck').append('<form id = "menuForm" method = "post" action = "storeMenuRegist.jsp"></form>');
		for(var i = 0; i<filenames.length; i++){

			
			$('#menuForm').append('<input type = "text" name = "filenames", value = "' + filenames[i]+'">');
			$('#menuForm').append('<input type = "text" name = "contents", value = "' + contents[i]+'">');
			
		}
		$('#menuForm').submit();
	});
}


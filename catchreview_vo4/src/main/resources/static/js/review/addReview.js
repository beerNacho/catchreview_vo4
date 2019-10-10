
window.onload=function(){
	$('#btn_comment').on('click', function(){
		$('#commentForm').submit();
	})
	$('#btn_comment2').on('click', function(){
		alert("로그인 후 코멘트 작성이 가능합니다.");
	})
	$('.btn_close').on('click', function(){
		window.close();
	});


	$('#input_box').click(function() {
		$('#txt_reply').removeClass('reply_event');
	});
	
	$('#goStore').on('click', function() {
		var storeNum = $('#storeNum').val()
		opener.parent.location.href = "../store/store.jsp?storeNum="	+ storeNum;
		window.close();
	});
	
	$('#starBox1').on('click', function(){
		$('#starBox2').css('display', 'block');
	});
	
	$('#starBox2 li').on('click', function(){
		$('#starBox2').css('display', 'none');
		$('#btnRate').css('display', 'block');
		$('#starBox3').css('width', $(this).val()+'%');
		$('#reviewRate').attr('value', $(this).val()/20);
	});
	
	$('#btnRate').on('click', function(){
		if($('#id').val()==""){
			alert("로그인 후 평가가 가능합니다.");
		} else{
			$('#formReviewRate').submit();
		}
	});
}
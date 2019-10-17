$(document).ready(function () {
	
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
	

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        var storeNum = $("input[name='storeNum']").val();
		var filename = $("input[name='filename']").val();
		var writer = $("input[name='writer']").val();
		var reviewTitle = $("input[name='reviewTitle']").val();
		var reviewContent = $("textarea[name='reviewContent']").val();
		
		var review = {filename:filename, writer:writer, reviewTitle:reviewTitle, reviewContent:reviewContent};
	    
        fire_ajax_submit(review, storeNum);

    });

});

function fire_ajax_submit(review, storeNum) {
	
    // Get form
    var form = $('#fileUploadForm')[0];
    
    var data = new FormData(form);

    
    
    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/review/register/",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

        	opener.parent.location.reload();
        	window.close();

        },
        error: function (e) {

            alert("실패");

        }
    });

}
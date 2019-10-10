
  var left = Math.ceil((window.screen.width-750)/2);
  
function addReview(reviewNum){
	myWindow = window.open('addReview.jsp?reviewNum='+reviewNum, '', 'width=720, height=500, left='+left);
};

window.onload=function(){
	$('#setProfile').children('img').on('click', function(){
		myWindow = window.open("profileModify.jsp","tinyWindow", "width=400, height=400");
	});
}
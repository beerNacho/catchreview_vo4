
  var left = Math.ceil((window.screen.width-750)/2);
  
function addReview(reviewNum){
	myWindow = window.open('../review/addReview.jsp?reviewNum='+reviewNum, '', 'width=720, height=500, left='+left);
};

window.onload=function(){
	$('#setProfile').children('img').on('click', function(){
		myWindow = window.open("profileModify.jsp","tinyWindow", "width=400, height=400");
	});
}

function reviewModify(reviewNum){
	myWindow = window.open('../review/addModify.jsp?reviewNum='+reviewNum, "tinyWindow", "width=700, height=398, left="+left);
};

function reviewDelete(reviewNum){
	if(confirm("리뷰를 삭제하시겠습니까?")){
		location.href="../review/funcReviewDelete.jsp?reviewNum="+reviewNum;
	}
};

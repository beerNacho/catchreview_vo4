

	var local1 = ['강남구', '서초구', '송파구', '강동구', '동작구', '영등포구', '강서구', '구로구', '양천구', '금천구', '관악구', '은평구', '마포구', '서대문구', '종로구', '중구', '용산구', '성북구', '동대문구', '성동구', '중랑구', '광진구', '강북구', '도봉구', '노원구'];
	var local2 =[];
	for(var i=0; i<local1.length; i++){
		local2.push('<option>'+local1[i]+'</option>');
	};
	var local3 = local2.join('');
	$("#btn_location2").html(local3);

	var address1 = $('#btn_location').val();
	var address2 = $('#btn_location2').val();
	var address3 = $('#btn_location').val()+" "+$('#btn_location2').val();
	
	
	$("#list").load("mapStoreList.jsp?address1="+address1+"&address2="+address2);

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level: 5 // 지도의 확대 레벨
	};  

	//지도를 생성합니다    
	var map = new daum.maps.Map(mapContainer, mapOption); 


	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	//주소로 좌표를 검색합니다	
	geocoder.addressSearch(address3, function(result, status) {
		if (status === daum.maps.services.Status.OK) {
			var coords = new daum.maps.LatLng(result[0].y, result[0].x);
			map.setCenter(coords);			
		} 
	});  

	    

/////////////////////////////////////////////////////지도생성완료


	$('#btn_location').on('change', function(e) {
		
		var address = $(this).val();
		local2=[];
		if(address=='서울'){
			local1 = ['강남구', '서초구', '송파구', '강동구', '동작구', '영등포구', '강서구', '구로구', '양천구', '금천구', '관악구', '은평구', '마포구', '서대문구', '종로구', '중구', '용산구', '성북구', '동대문구', '성동구', '중랑구', '광진구', '강북구', '도봉구', '노원구'];
		}
		else if(address=='부산'){
			local1 = ['중구', '동구', '서구', '남구', '북구', '금정구', '해운대구', '수영구', '연제구', '동래구', '부산진구', '영도구', '사하구', '사상구', '강서구', '기장군'];				
		}
		else if(address=='대구'){
			local1 = ['중구'];				
		}
		else if(address=='인천'){
			local1 = ['중구'];				
		}
		else if(address=='광주'){
			local1 = ['서구'];				
		}
		else if(address=='대전'){
			local1 = ['중구'];				
		}
		else if(address=='울산'){
			local1 = ['중구'];				
		}
		else if(address=='세종'){
			local1 = [''];				
		}
		else if(address=='경기'){
			local1 = ['수원시'];				
		}
		else if(address=='강원'){
			local1 = ['강릉시'];				
		}
		else if(address=='충남'){
			local1 = ['천안시'];				
		}
		else if(address=='충북'){
			local1 = ['청주시'];				
		}
		else if(address=='전남'){
			local1 = ['목포시'];				
		}
		else if(address=='전북'){
			local1 = ['전주시'];				
		}
		else if(address=='경남'){
			local1 = ['창원시'];				
		}
		else if(address=='경북'){
			local1 = ['경주시'];				
		}
		else if(address=='제주'){
			local1 = ['제주시'];				
		}
		for(var i=0; i<local1.length; i++){
			local2.push('<option>'+local1[i]+'</option>');
		};
		var local3 = local2.join('');
		$("#btn_location2").html(local3);
		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();
		address1 = $('#btn_location').val();
		address2 = $('#btn_location2').val();
		address3 = $('#btn_location').val()+" "+$('#btn_location2').val();
		$("#list").load("mapStoreList.jsp?address1="+address1+"&address2="+address2);
		//주소로 좌표를 검색합니다	
		geocoder.addressSearch(address3, function(result, status) {

			// 정상적으로 검색이 완료됐으면 
			if (status === daum.maps.services.Status.OK) {

				var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);

			} 
		});
	});

	
	
//////////////////////////////// 광역단위 지역 선택	
	
	
	
	
	

	$('#btn_location2').on('change', function(e) {

		address1 = $('#btn_location').val();
		address2 = $('#btn_location2').val();
		address3 = $('#btn_location').val()+" "+$('#btn_location2').val();
		$("#list").load("mapStoreList.jsp?address1="+address1+"&address2="+address2);

		//주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();	
		//주소로 좌표를 검색합니다	
		geocoder.addressSearch(address3, function(result, status) {

			// 정상적으로 검색이 완료됐으면 
			if (status === daum.maps.services.Status.OK) {

				var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);

			} 
		});

		
	});
	
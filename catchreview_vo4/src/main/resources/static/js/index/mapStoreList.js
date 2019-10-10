						
						var listData = [];
						for(var i=0; i<document.getElementsByName("address").length; i++){
						
							listData.push(document.getElementsByName("address")[i].value);
						}
						 
						listData.forEach(function(addr, index) {
						    geocoder.addressSearch(addr, function(result, status) {

						        if (status === daum.maps.services.Status.OK) {
						        	var name=document.getElementsByName("name")[index].value;
						        	var num=document.getElementsByName("num")[index].value;
						        	var storePicture=document.getElementsByName("storePicture")[index].value;
						        	
						            var coords = new daum.maps.LatLng(result[0].y, result[0].x);

						            var marker = new daum.maps.Marker({
						                map: map,
						                position: coords
						            });
						           
						            var content = '<div class="wrap">' + 
									            '    <div class="info">' + 
									            '        <div class="title">' + 
									            name + 
									            '            <div class="close" title="닫기"></div>' + 
									            '        </div>' + 
									            '        <div class="body">' + 
									            '            <div class="img">' +
									            '                <img src="' + storePicture + '" width="73" height="70">' +
									            '           </div>' + 
									            '            <div class="desc">' + 
									            '                <div class="ellipsis">'+addr+'</div>' + 
									            '                <div><a href="./store/store.jsp?storeNum='+num+'" class="link">홈페이지</a></div>' + 
									            '            </div>' + 
									            '        </div>' + 
									            '    </div>' +    
									            '</div>';

									// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
									daum.maps.event.addListener(marker, 'click', function() {
										var overlay = new daum.maps.CustomOverlay({
										    content: content,
										    map: map,
										    position: marker.getPosition()      
										}); 
									    overlay.setMap(map);
									    $('.close').on('click', function(e) {
										    overlay.setMap(null);     
										});
									});
						        } 
						    });
						});
						
///////////////////////// 목록클릭시 중심좌표 이동 및 정보표시
						$('.localStore').on('click', function(e) {
							var address = $(this).attr('address');
							var num = $(this).attr('num');
							var name = $(this).attr('name');
							var storePicture = $(this).attr('storePicture');
							
							var geocoder = new daum.maps.services.Geocoder();
							geocoder.addressSearch(address, function(result, status) {
								if (status === daum.maps.services.Status.OK) {
									var coords = new daum.maps.LatLng(result[0].y, result[0].x);
									map.setCenter(coords);
									var marker = new daum.maps.Marker({
										map: map,
										position: coords
									});
									
									var content = '<div class="wrap">' + 
						            '    <div class="info">' + 
						            '        <div class="title">' + 
						            name + 
						            '            <div class="close" title="닫기"></div>' + 
						            '        </div>' + 
						            '        <div class="body">' + 
						            '            <div class="img">' +
						            '                <img src="' + storePicture + '" width="73" height="70">' +
						            '           </div>' + 
						            '            <div class="desc">' + 
						            '                <div class="ellipsis">'+address+'</div>' + 
						            '                <div><a href="./store/store.jsp?storeNum='+num+'" class="link">홈페이지</a></div>' + 
						            '            </div>' + 
						            '        </div>' + 
						            '    </div>' +    
						            '</div>';

									var overlay = new daum.maps.CustomOverlay({
									    content: content,
									    map: map,
									    position: marker.getPosition()      
									}); 
								    overlay.setMap(map);
								    $('.close').on('click', function(e) {
									    overlay.setMap(null);     
									});
						// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
						daum.maps.event.addListener(marker, 'click', function() {
							var overlay = new daum.maps.CustomOverlay({
							    content: content,
							    map: map,
							    position: marker.getPosition()      
							}); 
						    overlay.setMap(map);
						    $('.close').on('click', function(e) {
							    overlay.setMap(null);     
							});
						});
								} 
							});  
						});

						
						

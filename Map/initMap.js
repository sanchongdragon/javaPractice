function initMap() {
    var map; 
    var swh = false;
    var mylatlng = {lat:24.811915261010082, lng:121.18237502628263};
    // -----------宣告marker array--------------
    var marker = [];
    var infowindow = [];
    var json = {};
    // --------------------在DOM map處 生成一個google map物件
    map = new google.maps.Map(document.getElementById("map"),{
        // --------設定center , zoom大小，越大越小，越小越大
        center:mylatlng ,
        zoom : 10,
        // 隱藏預設的icon
        // styles: [ 
        //             { 
        //             "featureType": "poi", 
        //             "stylers": [ 
        //                 { "visibility": "off" } 
        //             ] 
        //             } 
        //         ] 
    });
    // 將預設icon改成不可點選
    // map.setClickableIcons(false);
    // -------連接DB取得infoConfig&markerConfig------------
    var xhr = new XMLHttpRequest();
    var url = "http://localhost:8080/WikiCampsTaiwan/gDB";
    var data;
    xhr.open("GET",url,true);
    xhr.addEventListener("readystatechange",function(){
        if (this.readyState === this.DONE) {
            var info_window = [];
            var info_config = [];
            var marker_config = [];

            data = JSON.parse(xhr.responseText);
            data.info.forEach(function(element,idx){
                //-------遍歷JSON物件，取得經緯度及名稱
                marker_config[idx] = {position : {lat:parseFloat(element[2]),lng:parseFloat(element[3])},
                            map : map,
                            title: element[1]};
                //-------遍歷JSON物件，取得名稱、簡介、圖片、圖源
                info_config[idx] =  '<h2>'+element[1]+'</h2>'+
                                    '<span>'+element[4]+'</span><br/>'+
                                    '<img width="500" height="280" class="infoImg" src="'+element[5]+'"><br/>'+
                                    '<table id="weather_table" style="width: 100%;margin: 0;padding: 0;">'+
                                    '<tr><td></td><td></td><td></td><td></td><td></td></tr>'+
                                    '<tr><td></td><td></td><td></td><td></td><td></td></tr>'+
                                    '</table>';
            });     
            //-----------------------------------------------------
                // 遍歷marker_config取得值
                marker_config.forEach(function(element,idx){
                // 丟進marker array ， call google maps.Marker function(丟入每個陣列的config)
                marker[idx] = new google.maps.Marker(element);
                // 設定icon
                marker[idx].setIcon("https://i.imgur.com/nhzSUJg.png");
                // 將marker設定到map
                marker[idx].setMap(map);
                marker[idx].addListener('click', function() {
                    // 點選一個marker後，先關閉所有的infowindow並且移除所有marker BOUNCE的animation
                    infowindow.forEach(function(element,idx){
                        infowindow[idx].close();
                        marker[idx].setAnimation(null)
                    });
                    
                    if(swh == false){
                        marker[idx].setAnimation(google.maps.Animation.BOUNCE); // 開啟marker BOUNCE的animation
                        infowindow[idx].open(map, marker[idx]); //設定點選 marker 打開資訊視窗事件
                        swh = true;
                        // 呼叫串接天氣API的function
                        // 取得當前點選的marker[idx]的lat&lng，打API取得一周天氣
                        connect_weather(marker[idx].position.lat(),marker[idx].position.lng());
                    }else{
                        marker[idx].setAnimation(null); // 關閉marker BOUNCE的animation
                        infowindow[idx].close(); //設定點選 marker 關閉資訊視窗事件
                        swh = false;
                    }
                });         
            });
            //------------------------------------------------
            // 遍歷info_config取得值
            info_config.forEach(function(element,idx){
            // 生成google.maps.InfoWindow
            infowindow[idx] = new google.maps.InfoWindow({
            content : element, 
                }); 
            });
            //------------------------------------------------
        }         
    });
    xhr.send();
    var tempmarker = new google.maps.Marker();
    //-------------------------------------------------------------
    // 使用googlemapAPI的監聽事件，監聽click事件
    // 監聽到click後執行function placeMarker
    google.maps.event.addListener(map, 'click', function(event) {
        
        $("#camp").modal("show");
        tempmarker.setPosition(event.latLng);
        tempmarker.setMap(map);
        // var chk = confirm("是否要添加新地標?");
        // return function(){
        
        // }(event)

        // if(chk){
            
        //     // temp.open(map,tempmarker);
        //     // placeMarker(event.latLng);
        // }else{
        //     tempmarker.setMap(null);
        // }
    });
    // placeMarker方法，可以代入location (即是經緯度)
    // 方法內執行 new google map Marker 
function placeMarker(location) {
        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/WikiCamp/pDB"; 
        // $.ajax({
        //     url:url,
        //     type:'POST',
        //     data:'',
        //     error:function(){
        //         console.log("Connect DB Failed");
        //     }
        // });
    // xhr.open("POST",url,true);
    // xhr.send();  
    // initMap();
        // var marker = new google.maps.Marker({
        //     position: location, 
        //     map: map
        // });
    }

}
    // ---------------------------------------------------------        

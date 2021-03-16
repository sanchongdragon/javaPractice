// 串接OpenWeatherMapAPI的function，須代入經緯度
function connect_weather(lat,lon){
    const data = null;
    const xhr = new XMLHttpRequest();
    // xhr.withCredentials = true;
    // 每個3小時搜尋一次天氣
    // xhr.open("GET", "https://community-open-weather-map.p.rapidapi.com/forecast?lat="+lat+"&lon="+lon);
    // 每天搜尋一次天氣
    xhr.open("GET", "https://community-open-weather-map.p.rapidapi.com/forecast/daily?lat="+lat+"&lon="+lon+"&cnt=5");
    xhr.setRequestHeader("x-rapidapi-key", "a69a484665msh60376b172ca5bb0p12c9bejsnb540084eb980");
    xhr.setRequestHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            // 連接api成功後，取得weather_table物件
            var table = document.getElementById("weather_table");
            // 取得table的tagName(tr)
            var tb_arr = table.getElementsByTagName("tr");
            // 將response Parse成json
            var data = JSON.parse(xhr.responseText);
            // console.log(xhr.responseText);
            var cnt = 0,idx = 0;
            var maxtmp = [];
            var mintmp = [];
            var dtpd = [];
            var weather_stats = [];
            // 遍歷data物件中的list屬性
            data.list.forEach(function(element,idx){
                // 取得dt (時戳) 屬性
                let timestamp = element.dt;
                // 宣告date物件dt，代入時戳*1000
                var dt = new Date(timestamp * 1000);
                // 將dt轉換成月日，丟進dtpd內
                dtpd[idx] = (dt.getMonth()+1) + "月"+ dt.getDate() +"日";
                // 將最高溫丟進maxtmp
                maxtmp[idx] = Math.round(element.temp.max-273.15);
                // 將最高溫丟進mintmp
                mintmp[idx] = Math.round(element.temp.min-273.15);
                // 將天氣資訊丟進weather_stats
                weather_stats[idx] = element.weather[0].main;
            });
            // 遍歷Date Perday的日期丟進table裡面
            // table位於infoWindows內部
            dtpd.forEach(function(element,idx){
                tb_arr[0].children[idx].innerHTML = element+"<br>";
            });
            // 遍歷maxtmp的最高溫丟進table裡面
            maxtmp.forEach(function(element,idx){
                tb_arr[0].children[idx].innerHTML += "Max:"+element +"℃<br>";
            });
            // 遍歷mintmp的最低溫丟進table裡面
            mintmp.forEach(function(element,idx){
                tb_arr[0].children[idx].innerHTML += "Min:"+element +"℃<br>";
            });
            // 遍歷weather_stats的天氣資訊丟進table裡面
            weather_stats.forEach(function(element,idx){
                console.log(element)
                if(element == "Clear")
                    tb_arr[1].children[idx].innerHTML = "<img src=https://i.imgur.com/Aorh2cb.png>";
                else if(element == "Clouds")
                    tb_arr[1].children[idx].innerHTML = "<img src=https://i.imgur.com/G8z6jjL.png>";
                else if(element == "Cloudsun")
                    tb_arr[1].children[idx].innerHTML = "<img src=https://i.imgur.com/cvfIDsX.png>";
                else if(element == "Rain")
                    tb_arr[1].children[idx].innerHTML = "<img src=https://i.imgur.com/92IZuwh.png>";
            });
        }
    });
    xhr.send();
}
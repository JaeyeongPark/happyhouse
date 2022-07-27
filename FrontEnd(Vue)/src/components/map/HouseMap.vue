<template>
  <div id="map" style="width: 100%; height: 700px"></div>
</template>

<script>
// import imgpath from "@/assets/img/school.png";
import { mapState } from "vuex";
export default {
  data() {
    return {
      map: null,
    };
  },
  props: {
    maptype: String,
    interests: Array,
    facilitys: Array,
    searchcondition: Object,
  },
  watch: {
    houselist: function (list) {
      if (list.length != 0) {
        var mapContainer = document.getElementById("map"),
          mapOption = {
            center: new kakao.maps.LatLng(list[0].lat, list[0].lng),
            level: 3,
          };

        var map = new kakao.maps.Map(mapContainer, mapOption);
        let img = "../house.png";

        for (let i = 0; i < list.length; i++) {
          var imageSrc = img, // 마커이미지의 주소입니다
            imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

          // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(
              imageSrc,
              imageSize,
              imageOption
            ),
            markerPosition = new kakao.maps.LatLng(list[i].lat, list[i].lng); // 마커가 표시될 위치입니다

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            position: markerPosition,
            image: markerImage, // 마커이미지 설정
          });
          marker.setMap(null);
          marker.setMap(map);
          var iwContent =
            '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0;">' +
            list[i].apartmentName +
            "</div>";

          var infowindow = new kakao.maps.InfoWindow({
            content: iwContent,
          });
          // 마커에 마우스오버 이벤트를 등록합니다
          kakao.maps.event.addListener(marker, "mouseover", function () {
            // 마커에 마우스오버 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
            infowindow.open(map, marker);
          });

          // 마커에 마우스아웃 이벤트를 등록합니다
          kakao.maps.event.addListener(marker, "mouseout", function () {
            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
            infowindow.close();
          });

          map.setCenter(markerPosition);
        }
      }
    },
  },
  computed: {
    ...mapState("userStore", ["userinterest"]),
    ...mapState("houseStore", ["houselist"]),
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5012743, 127.039585),
        level: 8,
      };
      this.map = new kakao.maps.Map(container, options);
      if (this.maptype == "interestmap") {
        this.interestmap(this.interests);
      }
    },
  },
  mounted() {
    // if (!window.kakao || !window.kakao.maps) {
    const script = document.createElement("script");

    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&libraries=services`;
    /* global kakao */
    script.addEventListener("load", () => {
      kakao.maps.load(this.initMap);
    });
    document.head.appendChild(script);
    // } else {
    //   //console.log("이미 로딩됨: ", window.kakao);
    //   this.initMap;
    // }
  },
};
</script>

<style></style>

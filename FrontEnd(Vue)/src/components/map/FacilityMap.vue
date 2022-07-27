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
    facilitylist: function (list) {
      var category = this.$store.state.addressStore.condition.category;

      if (list.length != 0) {
        var geocoder = new kakao.maps.services.Geocoder();
        let center =
          list[0].sidoname + " " + list[0].gugunname + " " + list[0].dongname;
        let centerlat = 0;
        let centerlng = 0;

        geocoder.addressSearch(center, function (result, status) {
          if (status === kakao.maps.services.Status.OK) {
            centerlat = result[0].y;
            centerlng = result[0].x;
          }
        });

        var mapContainer = document.getElementById("map"),
          mapOption = {
            center: new kakao.maps.LatLng(centerlat, centerlng),
            level: 5,
          };

        var map = new kakao.maps.Map(mapContainer, mapOption);

        for (let i = 0; i < list.length; i++) {
          let name = "";
          let img = "";
          if (category == "kinder") {
            name = list[i].kindername;
            img = "../kinder.png";
          }
          if (category == "nursery") {
            name = list[i].nurseryname;
            img = "../nursery.png";
          }
          if (category == "school") {
            name = list[i].schoolname;
            img = "../school.png";
          }
          if (category == "academy") {
            name = list[i].academyname;
            img = "../academy.png";
          }
          if (category == "park") {
            name = list[i].parkname;
            img = "../park.png";
          }
          if (category == "protectionzone") {
            name = list[i].protectionzonename;
            img = "../protectionzone.png";
          }
          // console.log(name);
          geocoder.addressSearch(list[i].address, function (result, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === kakao.maps.services.Status.OK) {
              // var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

              var imageSrc = img, // 마커이미지의 주소입니다
                imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
                imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

              let lat = "";
              let lng = "";
              if (category == "park") {
                lat = list[i].lat;
                lng = list[i].lng;
              } else {
                lat = result[0].y;
                lng = result[0].x;
              }

              // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
              var markerImage = new kakao.maps.MarkerImage(
                  imageSrc,
                  imageSize,
                  imageOption
                ),
                markerPosition = new kakao.maps.LatLng(lat, lng); // 마커가 표시될 위치입니다

              // 마커를 생성합니다
              var marker = new kakao.maps.Marker({
                position: markerPosition,
                image: markerImage, // 마커이미지 설정
              });
              marker.setMap(null);
              marker.setMap(map);

              var iwContent =
                '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0; ">' +
                name +
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

              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              map.setCenter(markerPosition);
            }
          });
        }
      }
    },

    facilmarkercenter: function (data) {
      this.facilitymap(this.facilitys, data.address);
    },
  },
  computed: {
    ...mapState("userStore", ["userinterest"]),
    ...mapState("facilityStore", ["facilitylist"]),
    ...mapState("userStore", ["userinterest", "facilmarkercenter"]),
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

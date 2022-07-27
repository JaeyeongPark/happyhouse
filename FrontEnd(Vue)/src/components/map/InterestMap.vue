<template>
  <div id="map" style="width: 100%; height: 700px"></div>
</template>

<script>
// import imgpath from "@/assets/img/school.png";
import { mapState, mapActions, mapMutations } from "vuex";
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
    interestfacility: Array,
  },
  watch: {
    intermarkercenter: function (data) {
      // console.log(1);
      // this.interestmap(this.interests, data.address);
      this.getfacilitydetailmap(data);
    },
    facilitydetailmap: function (data) {
      this.mapcenter(data);
    },
  },
  computed: {
    ...mapState("userStore", ["userinterest"]),
    ...mapState("userStore", ["userinterest", "intermarkercenter"]),
    ...mapState("facilityStore", ["facilitydetailmap"]),
  },
  methods: {
    ...mapMutations("facilityStore", ["SET_FACILITY_LATLNG"]),
    ...mapActions("facilityStore", ["getfacilitydetailmap"]),
    initMap() {
      // console.log(this.interests);
      this.interestmap(this.interests);
    },

    mapcenter(data) {
      var geocoder = new kakao.maps.services.Geocoder();
      let lat = 0;
      let lng = 0;
      let map = this.map;

      if (data[0].parkname) {
        var coords = new kakao.maps.LatLng(data[0].lat, data[0].lng);
        // console.log(this.map);
        this.map.setCenter(coords);
      } else {
        geocoder.addressSearch(data[0].address, function (result, status) {
          if (status === kakao.maps.services.Status.OK) {
            lat = result[0].y;
            lng = result[0].x;
            var coordss = new kakao.maps.LatLng(lat, lng);
            // console.log(lng);
            map.setCenter(coordss);
          }
        });
      }
    },

    interestmap(list) {
      // console.log(list);
      if (list.length != 0) {
        // console.log(list);
        var geocoder = new kakao.maps.services.Geocoder();
        var mapContainer = document.getElementById("map"),
          mapOption = {
            center: new kakao.maps.LatLng(37.541, 126.986),
            level: 4,
          };

        var map = new kakao.maps.Map(mapContainer, mapOption);
        for (let i = 0; i < list.length; i++) {
          let img = "";
          let lat = "";
          let lng = "";
          let park = false;
          let listdetail = this.interestfacility;
          if (list[i].category == "school") {
            img = "../school.png";
          }
          if (list[i].category == "academy") {
            img = "../academy.png";
          }
          if (list[i].category == "kinder") {
            img = "../kinder.png";
          }
          if (list[i].category == "nursery") {
            img = "../nursery.png";
          }
          if (list[i].category == "park") {
            // console.log(i);
            lat = listdetail[i].lat;
            lng = listdetail[i].lng;
            // console.log(lat);
            // console.log(lng);
            park = true;
            img = "../park.png";
          }
          if (list[i].category == "protectionzone") {
            img = "../protectionzone.png";
          }
          geocoder.addressSearch(list[i].address, function (result, status) {
            // 정상적으로 검색이 완료됐으면
            if (status === kakao.maps.services.Status.OK) {
              // var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

              // let lat = "";
              // let lng = "";
              // if (list[i].category == "park") {
              //   lat = list[i].lat;
              //   lng = list[i].lng;
              // } else {
              //   lat = result[0].y;
              //   lng = result[0].x;
              // }

              var imageSrc = img, // 마커이미지의 주소입니다
                imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
                imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
              // console.log(park);
              let latt = result[0].y;
              let lngt = result[0].x;
              if (park) {
                latt = lat;
                lngt = lng;
              }

              // console.log(latt);
              // console.log(lngt);
              // console.log("==============");
              // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
              var markerImage = new kakao.maps.MarkerImage(
                  imageSrc,
                  imageSize,
                  imageOption
                ),
                markerPosition = new kakao.maps.LatLng(latt, lngt); // 마커가 표시될 위치입니다

              // 마커를 생성합니다
              var marker = new kakao.maps.Marker({
                position: markerPosition,
                image: markerImage, // 마커이미지 설정
              });
              marker.setMap(null);
              marker.setMap(map);

              var iwContent =
                '<div style="font-weight:bold;width:150px;text-align:center;padding:6px 0;">' +
                list[i].categoryvalue +
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
          });
        }
        this.map = map;
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

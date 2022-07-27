<template>
  <div id="map" style="width: 100%; height: 500px"></div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
    };
  },
  props: {
    facility: Object,
    category: String,
    categoryvalue: String,
    house: Object,
  },
  watch: {
    house: function (data) {
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };
      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      let img = "../house.png";

      var imageSrc = img, // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        ),
        markerPosition = new kakao.maps.LatLng(data.lat, data.lng); // 마커가 표시될 위치입니다

      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage, // 마커이미지 설정
      });
      marker.setMap(null);
      marker.setMap(map);

      var iwContent =
        '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0;">' +
        data.apartmentName +
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
    },

    facility: function (data) {
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };
      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();

      let img = "";
      let name = this.categoryvalue;
      let lat = "";
      let lng = "";
      let park = false;

      if (this.category == "kinder") {
        img = "../kinder.png";
      }
      if (this.category == "nursery") {
        img = "../nursery.png";
      }
      if (this.category == "school") {
        img = "../school.png";
      }
      if (this.category == "academy") {
        img = "../academy.png";
      }
      if (this.category == "park") {
        lat = data.lat;
        lng = data.lng;
        park = true;
        img = "../park.png";
      }
      if (this.category == "protectionzone") {
        img = "../protectionzone.png";
      }
      geocoder.addressSearch(data.address, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var imageSrc = img, // 마커이미지의 주소입니다
            imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

          let latt = result[0].y;
          let lngt = result[0].x;
          if (park) {
            latt = lat;
            lngt = lng;
          }

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
            '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0;">' +
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

          map.setCenter(markerPosition);
        }
      });
    },
  },
  computed: {},
  methods: {
    roadview() {
      var geocoder = new kakao.maps.services.Geocoder();
      var roadviewContainer = document.getElementById("map"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

      geocoder.addressSearch(this.facility.address, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var position = new kakao.maps.LatLng(result[0].y, result[0].x);

          // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
          roadviewClient.getNearestPanoId(position, 50, function (panoId) {
            roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
          });
        }
      });
    },

    houseroadview(data) {
      var roadviewContainer = document.getElementById("map"); //로드뷰를 표시할 div
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

      var position = new kakao.maps.LatLng(data.lat, data.lng);

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(position, 50, function (panoId) {
        roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },

    initMap() {
      // console.log(4);
      // console.log(this.facility);
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5012743, 127.039585),
        level: 8,
      };
      this.map = new kakao.maps.Map(container, options);
      // this.detailmap(this.facility);
    },

    detailmap(data) {
      // console.log("들어옴?");
      // console.log(data);
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };
      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();

      let img = "";
      let name = this.categoryvalue;
      let lat = "";
      let lng = "";
      let park = false;

      if (this.category == "kinder") {
        img = "../kinder.png";
      }
      if (this.category == "nursery") {
        img = "../nursery.png";
      }
      if (this.category == "school") {
        img = "../school.png";
      }
      if (this.category == "academy") {
        img = "../academy.png";
      }
      if (this.category == "park") {
        lat = data.lat;
        lng = data.lng;
        park = true;
        img = "../park.png";
      }
      if (this.category == "protectionzone") {
        img = "../protectionzone.png";
      }
      geocoder.addressSearch(data.address, function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          var imageSrc = img, // 마커이미지의 주소입니다
            imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

          let latt = result[0].y;
          let lngt = result[0].x;
          if (park) {
            latt = lat;
            lngt = lng;
          }

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
            '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0;">' +
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

          map.setCenter(markerPosition);
        }
      });
    },

    housedetailmap(data) {
      // console.log("들어옴?");
      // console.log(data);
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3, // 지도의 확대 레벨
        };
      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      let img = "../house.png";

      var imageSrc = img, // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(40, 40), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(15, 50) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imageOption
        ),
        markerPosition = new kakao.maps.LatLng(data.lat, data.lng); // 마커가 표시될 위치입니다

      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage, // 마커이미지 설정
      });
      marker.setMap(null);
      marker.setMap(map);

      var iwContent =
        '<div style="font-weight:bold; width:200px;text-align:center;padding:6px 0;">' +
        data.apartmentName +
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
    },
  },
  mounted() {
    // console.log(1);
    if (!window.kakao || !window.kakao.maps) {
      // console.log(2);
      const script = document.createElement("script");

      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&libraries=services`;
      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    } else {
      // console.log(3);
      //console.log("이미 로딩됨: ", window.kakao);
      this.initMap();
    }
    // this.detailmap(this.facility);
  },
};
</script>

<style></style>

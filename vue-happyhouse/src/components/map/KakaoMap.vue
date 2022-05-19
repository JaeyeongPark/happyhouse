<template>
  <div id="map"></div>
</template>

<script>
import { mapState } from "vuex";
export default {
  data() {
    return {
      map: null,
    };
  },
  computed: {
    ...mapState(["houses"]),
  },
  watch: {
    houses(houses) {
      if (houses.length != 0) {
        let lat = houses[0].lat;
        let lng = houses[0].lng;

        const container = document.getElementById("map");
        const options = {
          center: new kakao.maps.LatLng(lat, lng),
          level: 5,
        };
        this.map = new kakao.maps.Map(container, options);

        for (let i = 0; i < houses.length; i++) {
          let lat = houses[i].lat;
          let lng = houses[i].lng;
          var markerPosition = new kakao.maps.LatLng(lat, lng);

          var marker = new kakao.maps.Marker({
            position: markerPosition,
            title: houses[i].aptName,
          });

          marker.setMap(this.map);
        }
      }
    },
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5012743, 127.039585),
        level: 8,
      };
      this.map = new kakao.maps.Map(container, options);
    },
  },
  mounted() {
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");

      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}`;
      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    } else {
      //console.log("이미 로딩됨: ", window.kakao);
      this.initMap;
    }
  },
};
</script>

<style></style>

<template>
  <v-main class="grey lighten-3 pt-3">
    <!-- <house-address-search></house-address-search> -->

    <v-row justify="center">
      <!-- <v-btn class="white--text" color="teal" @click="overlay = !overlay"
        >상세보기</v-btn
      > -->
      <v-overlay :z-index="zIndex" :value="overlay">
        <v-container class="text-right">
          <v-btn
            class="white--text"
            color="blue accent-4"
            @click="overlay = false"
            light
          >
            <v-icon>{{ icons.mdiClose }} </v-icon>
          </v-btn>
        </v-container>
        <house-detail :code="code"></house-detail>
      </v-overlay>
    </v-row>

    <v-container>
      <v-row>
        <v-col cols="1"></v-col>
        <v-col cols="10">
          <house-search-bar></house-search-bar>
        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
    </v-container>

    <v-container>
      <v-row>
        <v-col cols="8">
          <v-card color="grey lighten-4">
            <house-map ref="initmap"></house-map>
          </v-card>
        </v-col>
        <v-col cols="4">
          <template v-if="houselist && houselist.length != 0">
            <v-card
              v-scroll.self="onScroll"
              class="overflow-y-auto"
              min-height="700px"
              max-height="700"
              color="grey lighten-4"
            >
              <house-list-item
                v-for="(house, index) in houselist"
                :key="index"
                :house="house"
                :condition="condition"
                @overlayevent="closeopen"
              ></house-list-item>
            </v-card>
          </template>
          <template v-else>
            <v-card
              class="text-center nolist"
              min-height="700px"
              max-height="700"
            >
              검색조건을 설정해주세요
            </v-card>
          </template>
          <template>
            <house-paging
              v-show="this.isshow"
              :pagenavi="pagenavi"
              :HouseInfoObj="HouseInfoObj"
              @overlayevent="closeopen"
            ></house-paging>
          </template>
        </v-col>
      </v-row>

      <router-view></router-view>
    </v-container>
  </v-main>
</template>

<script>
import HouseListItem from "@/components/House/HouseListItem.vue";
import HousePaging from "@/components/House/HousePaging.vue";
import HouseMap from "@/components/map/HouseMap.vue";
import HouseDetail from "@/components/House/HouseDetail.vue";
import HouseSearchBar from "@/components/layout/HouseSearchBar.vue";
import { mdiClose } from "@mdi/js";
// import KakaoMap from "@/components/map/KakaoMap.vue";
import { mapState, mapActions } from "vuex";
// import OptionNav from "@/components/layout/OptionNav.vue";
// import HouseAddressSearch from "../layout/HouseAddressSearch.vue";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
    HousePaging,
    HouseDetail,
    HouseSearchBar,
    // KakaoMap,
    HouseMap,
    // OptionNav,
    // HouseAddressSearch,
  },
  data() {
    return {
      zIndex: 5,
      overlay: false,
      optionitems: [{ text: "아파트이름", value: "apartmentName" }],

      HouseInfoObj: {
        pg: 1,
        key: "apartmentName",
        word: "",
        dongCode: "",
        dealYear: "",
      },
      isshow: false,
      code: {
        aptCode: "",
        no: "",
      },
      icons: {
        mdiClose,
      },
    };
  },
  watch: {
    housecondition: function (data) {
      this.HouseInfoObj = data;
      this.gethouselist(this.HouseInfoObj);
    },
    houselist: function (data) {
      if (!data || data.length == 0) {
        this.mapinit();
      }
    },
    condition: function (condition) {
      this.HouseInfoObj.dealYear = this.$store.state.addressStore.dealYear;
      this.HouseInfoObj.dongCode = condition;
      this.HouseInfoObj.pg = 1;
      this.HouseInfoObj.key = "";
      this.HouseInfoObj.word = "";
      console.log(this.HouseInfoObj);
      this.gethouselist(this.HouseInfoObj);
    },
    dealYear: function (data) {
      this.HouseInfoObj.dealYear = data;
      this.HouseInfoObj.dongCode = this.$store.state.addressStore.dongcode;
      this.HouseInfoObj.pg = 1;
      this.HouseInfoObj.key = "";
      this.HouseInfoObj.word = "";
      console.log(this.HouseInfoObj);
      this.gethouselist(this.HouseInfoObj);
    },
  },
  computed: {
    ...mapState("addressStore", ["condition", "dealYear"]),
    ...mapState("houseStore", ["houselist", "pagenavi", "housecondition"]),
  },
  methods: {
    ...mapActions("houseStore", ["gethouselist"]),
    updatepage(newpg) {
      let conditions = this.HouseInfoObj;
      conditions.pg = newpg;
      this.gethouselist(conditions);
    },
    mapinit() {
      this.$refs.initmap.initMap();
    },
    closeopen(data) {
      this.overlay = !this.overlay;
      this.code = data;
    },
    onScroll(e) {
      this.scroll = e.target.scrollTop;
    },
    search() {
      this.HouseInfoObj.pg = 1;
      let conditions = this.HouseInfoObj;
      conditions.key = "apartmentName";
      this.gethouselist(conditions);
    },
  },
};
</script>

<style scoped>
#aptinfo {
  height: 300px;
}
#map-sheet {
  display: inline;
}
#list-sheet {
  display: inline;
}
.nolist {
  font-weight: bold;
  font-size: 30px;
  padding-top: 350px;
  font-family: "SuseongDotum";
}
</style>

<template>
  <v-main class="grey lighten-3 pt-3">
    <!-- <option-nav></option-nav> -->

    <v-row justify="center">
      <v-overlay :z-index="zIndex" :value="overlay">
        <v-container class="text-right">
          <v-btn
            class="white--text"
            color="primary accent-4"
            @click="overlay = false"
            light
          >
            <v-icon>{{ icons.mdiClose }} </v-icon>
          </v-btn>
        </v-container>
        <facility-detail :code="code"></facility-detail>
      </v-overlay>
    </v-row>

    <v-container>
      <v-row>
        <v-col cols="1"></v-col>
        <v-col cols="10">
          <search-nav></search-nav>
        </v-col>
        <v-col cols="1"></v-col>
      </v-row>
    </v-container>

    <v-container>
      <v-row>
        <v-col cols="8">
          <v-card color="grey lighten-4">
            <facility-map
              :searchcondition="this.searchcondition"
              ref="initmap"
            ></facility-map>
          </v-card>
        </v-col>
        <v-col cols="4">
          <template v-if="facilitylist && facilitylist.length != 0">
            <v-card
              v-scroll.self="onScroll"
              class="overflow-y-auto"
              min-height="700px"
              max-height="700"
              color="grey lighten-4"
            >
              <facility-list-item
                v-for="(facility, index) in facilitylist"
                :key="index"
                :facility="facility"
                :condition="condition"
                @overlayevent="closeopen"
              ></facility-list-item>
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
        </v-col>
      </v-row>
      <router-view></router-view>
    </v-container>
  </v-main>
</template>

<script>
import { mapActions, mapState } from "vuex";
// import OptionNav from "@/components/layout/OptionNav.vue";
// import KakaoMap from "@/components/map/KakaoMap.vue";
import FacilityDetail from "@/components/facility/FacilityDetail.vue";
import FacilityListItem from "@/components/facility/FacilityListItem.vue";
import FacilityMap from "@/components/map/FacilityMap.vue";
import SearchNav from "@/components/layout/SearchNav.vue";
import { mdiClose } from "@mdi/js";
export default {
  data() {
    return {
      categoryvalue: null,
      zIndex: 5,
      overlay: false,
      code: "",
      searchcondition: {},
      clear: false,
      maptype: "facilitymap",
      icons: {
        mdiClose,
      },
    };
  },
  components: {
    // OptionNav,
    // KakaoMap,
    FacilityDetail,
    FacilityListItem,
    FacilityMap,
    SearchNav,
  },
  watch: {
    facilitylist: function (data) {
      if (!data || data.length == 0) {
        this.mapinit();
      }
    },
    condition: function (condition) {
      console.log(condition);
      if (condition.dongCode == null) {
        console.log("옴?");
        condition.dongCode = this.$store.state.addressStore.dongcode;
      }
      this.searchcondition = condition;
      this.getfacilitylist(condition);
    },
  },
  computed: {
    ...mapState("addressStore", ["condition"]),
    ...mapState("facilityStore", ["facilitylist"]),
  },
  methods: {
    ...mapActions("facilityStore", ["getfacilitylist"]),
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
    wordsearch() {
      this.searchcondition.categoryvalue = this.categoryvalue;
      this.getfacilitylist(this.searchcondition);
    },
    clearsearch() {
      this.$store.state.addressStore.condition.categoryvalue = "";
      this.$store.state.addressStore.condition.category = "";
      this.$store.state.addressStore.condition.dongCode = "";
      this.$refs.initmap.initMap();
    },
  },
};
</script>

<style scoped>
.nolist {
  font-weight: bold;
  font-size: 30px;
  padding-top: 350px;
  font-family: "SuseongDotum";
}
</style>

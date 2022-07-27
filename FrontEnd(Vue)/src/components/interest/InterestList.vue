<template>
  <v-main class="grey lighten-3">
    <v-row justify="center">
      <!-- <v-btn class="white--text" color="teal" @click="overlay = !overlay"
        >상세보기</v-btn
      > -->
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
        <interest-detail :data="data"></interest-detail>
      </v-overlay>
    </v-row>

    <v-container>
      <v-row>
        <v-col cols="8">
          <v-card color="grey lighten-4">
            <interest-map
              :maptype="maptype"
              :interests="interests"
              :interestfacility="interestfacility"
            ></interest-map>
          </v-card>
        </v-col>
        <v-col cols="4">
          <template v-if="interests && interests.length != 0">
            <v-card
              v-scroll.self="onScroll"
              class="overflow-y-auto"
              min-height="700px"
              max-height="700"
              color="grey lighten-4"
            >
              <interest-list-item
                v-for="(interest, index) in interests"
                :key="index"
                :interest="interest"
                @overlayevent="closeopen"
              ></interest-list-item>
            </v-card>
          </template>
          <template v-else>
            <v-card
              class="text-center nolist"
              min-height="700px"
              max-height="700"
            >
              관심시설을 등록해보세요
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
// import KakaoMap from "@/components/map/KakaoMap.vue";
import InterestDetail from "@/components/interest/InterestDetail.vue";
import InterestListItem from "@/components/interest/InterestListItem.vue";
import InterestMap from "@/components/map/InterestMap.vue";
import { mdiClose } from "@mdi/js";
export default {
  components: {
    // KakaoMap,
    InterestListItem,
    InterestDetail,
    InterestMap,
  },
  data() {
    return {
      interests: [],
      interestfacility: [],
      zIndex: 5,
      overlay: false,
      data: {},
      maptype: "interestmap",
      icons: {
        mdiClose,
      },
    };
  },
  watch: {
    userinterest: function (data) {
      this.interests = data;
      for (let i = 0; i < data.length; i++) {
        this.getfacilitydetail(data[i]);
      }
    },
    facilitydetail: function (data) {
      this.interestfacility.push(data[0]);
    },
  },
  created() {
    this.interestlist(this.$store.state.userStore.userInfo.id);
  },
  methods: {
    ...mapActions("userStore", ["interestlist"]),
    ...mapActions("facilityStore", ["getfacilitydetail"]),
    closeopen(data) {
      this.overlay = !this.overlay;
      this.data = data;
    },
    onScroll(e) {
      this.scroll = e.target.scrollTop;
    },
  },
  computed: {
    ...mapState("facilityStore", ["facilitydetail"]),
    ...mapState("userStore", ["userinterest"]),
  },
};
</script>

<style>
.nolist {
  font-weight: bold;
  font-size: 30px;
  padding-top: 350px;
  font-family: "SuseongDotum";
}
</style>

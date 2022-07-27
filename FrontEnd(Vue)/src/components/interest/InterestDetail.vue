<template>
  <v-card class="red lighten-5" height="700px" width="1300px">
    <v-container>
      <v-row>
        <v-col cols="3"></v-col>
        <v-col cols="6">
          <v-card
            class="text-center ml-3 pt-2 pl-5 white"
            height="50px"
            width="700px"
            light
          >
            <h2>
              {{ this.data.categoryvalue }}
            </h2>
          </v-card></v-col
        >
        <v-col cols="3"></v-col>
      </v-row>
    </v-container>

    <v-card class="ml-3 mt-1" height="590px" width="1270px" light>
      <v-container>
        <v-row>
          <v-col cols="6">
            <v-sheet class="light-blue lighten-4" height="500px">
              <template v-if="this.data.category === 'kinder'">
                <kinder-detail :facility="this.facility"></kinder-detail>
              </template>

              <template v-if="this.data.category === 'nursery'">
                <nursery-detail :facility="this.facility"></nursery-detail>
              </template>

              <template v-if="this.data.category === 'school'">
                <school-detail :facility="this.facility"></school-detail>
              </template>
              <template v-if="this.data.category === 'academy'">
                <academy-detail :facility="this.facility"></academy-detail>
              </template>
              <template v-if="this.data.category === 'park'">
                <park-detail :facility="this.facility"></park-detail>
              </template>
              <template v-if="this.data.category === 'protectionzone'">
                <protectionzone-detail
                  :facility="this.facility"
                ></protectionzone-detail>
              </template>
            </v-sheet>
          </v-col>
          <v-col cols="6">
            <v-sheet class="grey lighten-4" height="500px">
              <!-- 카카오맵 -->
              <div>
                <mini-map
                  :facility="this.facility"
                  :category="data.category"
                  :categoryvalue="data.categoryvalue"
                  ref="road"
                ></mini-map>
              </div>
            </v-sheet>
          </v-col>
        </v-row>

        <v-container class="text-right">
          <v-btn class="ml-3" color="blue" dark @click="moveboard()"
            >커뮤니티 이동</v-btn
          >
          <v-btn class="ml-3" color="green" dark @click="mapviewdiv()"
            >지도보기</v-btn
          >
          <v-btn class="ml-3" color="green" dark @click="roadviewdiv()"
            >로드뷰보기</v-btn
          >
          <v-btn
            class="ml-3"
            color="red"
            dark
            v-if="interest == true"
            @click="interdelete()"
            >♥</v-btn
          >
          <v-btn class="ml-3" color="red" dark v-else @click="interregist()"
            >♡</v-btn
          >
        </v-container>
      </v-container>
    </v-card>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MiniMap from "../map/MiniMap.vue";
import KinderDetail from "@/components/facility/KinderDetail.vue";
import NurseryDetail from "@/components/facility/NurseryDetail.vue";
import SchoolDetail from "@/components/facility/SchoolDetail.vue";
import AcademyDetail from "@/components/facility/AcademyDetail.vue";
import ParkDetail from "@/components/facility/ParkDetail.vue";
import ProtectionzoneDetail from "@/components/facility/ProtectionzoneDetail.vue";

export default {
  components: {
    MiniMap,
    KinderDetail,
    NurseryDetail,
    SchoolDetail,
    AcademyDetail,
    ParkDetail,
    ProtectionzoneDetail,
  },
  props: {
    data: Object,
  },
  data() {
    return {
      facility: {},
      interest: "",
    };
  },
  created() {
    this.$store.state.userStore.isinterest = false;
    let conditions = this.data;
    this.getfacilitydetail(conditions);

    let data = {
      id: this.$store.state.userStore.userInfo.id,
      category: this.data.category,
      code: this.data.code,
    };

    this.isinterestfacility(data);
  },
  mounted() {
    this.mapviewdiv();
  },
  watch: {
    facilitydetail: function (data) {
      this.facility = data[0];
    },
    isinterest: function (data) {
      if (data == true) {
        this.interest = true;
      }
    },
  },
  computed: {
    ...mapState("facilityStore", ["facilitydetail"]),
    ...mapState("addressStore", ["directboardcondition"]),
    ...mapState("userStore", ["isinterest"]),
  },
  methods: {
    ...mapActions("facilityStore", ["getfacilitydetail"]),
    ...mapActions("userStore", [
      "interestregist",
      "isinterestfacility",
      "interestdelete",
    ]),
    roadviewdiv() {
      this.$refs.road.roadview();
    },
    mapviewdiv() {
      this.$refs.road.detailmap(this.facility);
    },
    moveboard() {
      this.$store.state.boardStore.issearchdirect = true;
      let condition = {
        dongCode: this.data.dongcode,
        category: this.data.category,
        categoryvalue: this.data.categoryvalue,
      };
      this.$store.state.addressStore.condition = condition;
      this.$router.push({ name: "boardlist" });
    },
    interregist() {
      this.interestregist(this.data);
      this.interest = true;
    },
    interdelete() {
      console.log("1번들어가고");
      this.interestdelete(this.data);
      this.interest = false;
    },
  },
};
</script>

<style></style>

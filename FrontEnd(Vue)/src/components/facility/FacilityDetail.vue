<template>
  <v-card class="blue lighten-5" height="700px" width="1300px">
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
            <template v-if="category === 'kinder'">
              <h2>
                {{ facility.kindername }}
              </h2>
            </template>
            <template v-if="category === 'nursery'">
              <h2>
                {{ facility.nurseryname }}
              </h2>
            </template>
            <template v-if="category === 'school'">
              <h2>
                {{ facility.schoolname }}
              </h2>
            </template>
            <template v-if="category === 'academy'">
              <h2>
                {{ facility.academyname }}
              </h2>
            </template>
            <template v-if="category === 'park'">
              <h2>
                {{ facility.parkname }}
              </h2>
            </template>
            <template v-if="category === 'protectionzone'">
              <h2>{{ facility.protectionzonename }} 어린이 보호구역</h2>
            </template>
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
              <template v-if="category === 'kinder'">
                <kinder-detail :facility="facility"></kinder-detail>
              </template>

              <template v-if="category === 'nursery'">
                <nursery-detail :facility="facility"></nursery-detail>
              </template>

              <template v-if="category === 'school'">
                <school-detail :facility="facility"></school-detail>
              </template>
              <template v-if="category === 'academy'">
                <academy-detail :facility="facility"></academy-detail>
              </template>
              <template v-if="category === 'park'">
                <park-detail :facility="facility"></park-detail>
              </template>
              <template v-if="category === 'protectionzone'">
                <protectionzone-detail
                  :facility="facility"
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
                  :category="this.category"
                  :categoryvalue="this.categoryvalue"
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
import { mapActions, mapState, mapMutations } from "vuex";
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
    code: String,
  },
  data() {
    return {
      facility: {},
      category: "",
      categoryvalue: "",
      interest: "",
    };
  },

  created() {
    this.$store.state.userStore.isinterest = false;
    let conditions = {
      category: this.$store.state.addressStore.condition.category,
      code: this.code,
    };
    this.getfacilitydetail(conditions);
    this.category = this.$store.state.addressStore.condition.category;

    if (sessionStorage.getItem("access-token")) {
      let data = {
        id: this.$store.state.userStore.userInfo.id,
        category: this.category,
        code: this.code,
      };

      this.isinterestfacility(data);
    } else {
      let data = {
        id: "",
        category: this.category,
        code: this.code,
      };

      this.isinterestfacility(data);
    }

    // this.$refs.road.detailmap(this.facility);
  },
  // mounted() {

  // },
  watch: {
    facilitydetail: function (data) {
      this.facility = data[0];

      if (this.category === "kinder") {
        this.categoryvalue = this.facility.kindername;
      }
      if (this.category === "nursery") {
        this.categoryvalue = this.facility.nurseryname;
      }
      if (this.category === "school") {
        this.categoryvalue = this.facility.schoolname;
      }
      if (this.category === "academy") {
        this.categoryvalue = this.facility.academyname;
      }
      if (this.category === "park") {
        this.categoryvalue = this.facility.parkname;
      }
      if (this.category === "protectionzone") {
        this.categoryvalue = this.facility.protectionzonename;
      }
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
    ...mapState("boardStore", ["issearchdirect"]),
  },
  methods: {
    ...mapMutations("boardStore", ["SET_SEARCHDIRECT"]),
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
        dongCode: this.facility.dongcode,
        category: this.$store.state.addressStore.condition.category,
        categoryvalue: this.categoryvalue,
      };
      this.$store.state.addressStore.condition = condition;
      this.$router.push({ name: "boardlist" });
    },
    interregist() {
      if (sessionStorage.getItem("access-token")) {
        let data = {
          id: this.$store.state.userStore.userInfo.id,
          dongcode: this.facility.dongcode,
          categoryvalue: this.categoryvalue,
          category: this.category,
          code: this.code,
          address: this.facility.address,
        };
        this.interestregist(data);
        this.interest = true;
      } else {
        alert("로그인 해주세요");
      }
    },
    interdelete() {
      let data = {
        id: this.$store.state.userStore.userInfo.id,
        dongcode: this.facility.dongcode,
        categoryvalue: this.categoryvalue,
        category: this.category,
        code: this.code,
        address: this.facility.address,
      };
      this.interestdelete(data);
      this.interest = false;
    },
  },
};
</script>

<style></style>

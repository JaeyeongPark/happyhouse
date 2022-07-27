<template>
  <v-card class="blue lighten-5 m-2" elevation="24">
    <template v-if="condition.category === 'kinder'">
      <!-- <v-card-title> 이름 :  </v-card-title> -->
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.kindername }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 유치원</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.kindercode)"
        >상세보기</v-btn
      >
    </template>

    <template v-if="condition.category === 'nursery'">
      <!-- <v-card-title> 이름 : {{ facility.nurseryname }} </v-card-title> -->
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.nurseryname }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 어린이집</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.nurserycode)"
        >상세보기</v-btn
      >
    </template>

    <template v-if="condition.category === 'school'">
      <!-- <v-card-title> 이름 : {{ facility.schoolname }} </v-card-title> -->
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.schoolname }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 초등학교</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.schoolcode)"
        >상세보기</v-btn
      >
    </template>

    <template v-if="condition.category === 'academy'">
      <!-- <v-card-title> 이름 : {{ facility.academyname }} </v-card-title> -->
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.academyname }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 학원</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.academycode)"
        >상세보기</v-btn
      >
    </template>

    <template v-if="condition.category === 'park'">
      <!-- <v-card-title> 이름 : {{ facility.parkname }} </v-card-title> -->
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.parkname }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 공원</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.parkcode)"
        >상세보기</v-btn
      >
    </template>

    <template v-if="condition.category === 'protectionzone'">
      <v-card-title>
        <!-- 이름 : {{ facility.protectionzonename }} 어린이 보호구역 -->
      </v-card-title>
      <v-card-text>
        <h4 style="font-weight: bold">{{ facility.protectionzonename }}</h4>
        <h6>주소 : {{ facility.address }}</h6>
        <h6>분류 : 어린이 보호구역</h6>
      </v-card-text>
      <v-btn
        color="blue lighten-3"
        style="font-weight: bold"
        @click="overlayview(facility.protectionzonecode)"
        >상세보기</v-btn
      >
    </template>
    <v-divider></v-divider>
  </v-card>
</template>

<script>
import { mapMutations } from "vuex";
// import FacilityDetail from "@/components/facility/FacilityDetail.vue";
export default {
  components: {
    // FacilityDetail,
  },
  props: {
    facility: Object,
    condition: Object,
  },
  methods: {
    ...mapMutations("userStore", ["SET_FACILMARKER_CENTER"]),
    categorystore() {
      this.$store.state.facilityStore.facilitydetailcategory =
        this.condition.category;
    },
    overlayview(data) {
      this.$emit("overlayevent", data);
    },
    movemarker() {
      this.SET_FACILMARKER_CENTER(this.facility);
    },
  },
};
</script>

<style scoped>
.m-2 {
  text-align: center;
}
h6 {
  font-weight: bold;
}
</style>

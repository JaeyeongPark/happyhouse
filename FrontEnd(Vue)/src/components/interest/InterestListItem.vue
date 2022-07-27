<template>
  <v-card class="red lighten-5 m-2" elevation="24" @click="movemarker()">
    <!-- <v-card-title> 이름 : {{ interest.categoryvalue }} </v-card-title> -->
    <v-card-text>
      <h4 style="font-weight: bold">{{ interest.categoryvalue }}</h4>
      <h6>주소 : {{ interest.address }}</h6>
      <template v-if="interest.category == 'academy'">
        <h6>분류 : 학원</h6>
      </template>
      <template v-if="interest.category == 'school'">
        <h6>분류 : 학교</h6>
      </template>
      <template v-if="interest.category == 'kinder'">
        <h6>분류 : 유치원</h6>
      </template>
      <template v-if="interest.category == 'nursery'">
        <h6>분류 : 어린이집</h6>
      </template>
      <template v-if="interest.category == 'protectionzone'">
        <h6>분류 : 어린이 보호구역</h6>
      </template>
      <template v-if="interest.category == 'park'">
        <h6>분류 : 공원</h6>
      </template>
    </v-card-text>
    <v-btn
      @click="overlayview()"
      color="red lighten-3"
      style="font-weight: bold"
      >상세보기</v-btn
    >

    <v-divider></v-divider>
  </v-card>

  <!-- <div @click="movemarker()">
    <div>{{ interest.categoryvalue }}</div>
    <v-btn @click="overlayview()">상세보기</v-btn>
  </div> -->
</template>

<script>
import { mapMutations, mapState, mapActions } from "vuex";
export default {
  data() {
    return {
      isupdate: false,
    };
  },
  props: {
    interest: Object,
  },
  watch: {
    isinterdelete: function (data) {
      console.log(data);
      if (data) {
        this.interestlist(this.$store.state.userStore.userInfo.id);
      }
    },
  },
  computed: {
    ...mapState("userStore", ["isinterdelete", "isinterregist"]),
  },
  methods: {
    ...mapActions("userStore", ["interestlist"]),
    ...mapMutations("userStore", ["SET_INTERMARKER_CENTER"]),
    overlayview() {
      this.$emit("overlayevent", this.interest);
    },
    movemarker() {
      this.SET_INTERMARKER_CENTER(this.interest);
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

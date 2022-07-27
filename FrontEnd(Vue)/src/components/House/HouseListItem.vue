<template>
  <v-card
    class="indigo lighten-5 m-2"
    elevation="24"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <!-- <v-card-title> </v-card-title> -->
    <v-card-text>
      <h4 style="font-weight: bold">{{ house.apartmentName }}</h4>
      <h6>거래가격 : {{ house.dealAmount }}</h6>
      <h6>
        거래날짜 : {{ house.dealYear }}.{{ house.dealMonth }}.{{
          house.dealDay
        }}
      </h6>
      <h6>면적 : {{ house.area }}</h6>
    </v-card-text>

    <v-btn @click="overlayview()" class="indigo lighten-3">상세보기</v-btn>
    <!-- <v-btn color="primary" @click="overlayview(facility.kindercode)"
        >상세보기</v-btn
      > -->
    <v-divider></v-divider>
  </v-card>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "HouseListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    house: Object,
  },
  methods: {
    ...mapActions(["detailHouse"]),
    // selectHouse() {
    //   // this.$store.dispatch("getHouse", this.house);
    //   this.detailHouse(this.house);
    // },
    overlayview() {
      let data = this.house;
      this.$emit("overlayevent", data);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.m-2 {
  text-align: center;
}
.align-self-center {
  font-size: 15px;
  padding: 0;
  padding-bottom: 5px;
}
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
h6 {
  font-weight: bold;
}
</style>

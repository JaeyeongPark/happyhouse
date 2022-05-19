<template>
  <div>
    <b-row
      class="m-2"
      @click="selectHouse"
      @mouseover="colorChange(true)"
      @mouseout="colorChange(false)"
      :class="{ 'mouse-over-bgcolor': isColor }"
    >
      <b-col cols="10" class="align-self-center">
        아파트이름 : {{ house.aptName }}
      </b-col>
      <b-col cols="10" class="align-self-center">
        거래가격 : {{ house.dealAmount }}
      </b-col>
      <b-col cols="10" class="align-self-center">
        거래날짜 : {{ house.dealYear }}.{{ house.dealMonth }}.{{
          house.dealDay
        }}
      </b-col>
      <b-col cols="10" class="align-self-center">
        면적 : {{ house.area }}
      </b-col>
    </b-row>
    <hr />
  </div>
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
    selectHouse() {
      console.log("listRow : ", this.house);
      // this.$store.dispatch("getHouse", this.house);
      this.detailHouse(this.house);
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
</style>

<template>
  <v-container fluid>
    <v-row align="center">
      <v-col cols="1"></v-col>
      <v-col cols="2" class="sm-3">
        <v-autocomplete
          v-model="sidoName"
          :items="sidos"
          dense
          filled
          solo-inverted
          label="시/도"
        ></v-autocomplete>
      </v-col>
      <v-col cols="2" class="sm-3">
        <v-autocomplete
          v-model="gugunName"
          :items="guguns"
          dense
          filled
          solo-inverted
          label="구/군"
        ></v-autocomplete>
      </v-col>
      <v-col cols="2" class="sm-3">
        <v-autocomplete
          v-model="dongName"
          :items="dongs"
          dense
          filled
          solo-inverted
          label="동"
        ></v-autocomplete>
      </v-col>
      <v-col cols="2" class="sm-3">
        <v-autocomplete
          v-model="category"
          :items="categorys"
          dense
          filled
          solo-inverted
          label="시설"
        ></v-autocomplete>
      </v-col>
      <v-col cols="2" class="sm-3">
        <v-autocomplete
          v-model="categoryvalue"
          :items="categoryvalues"
          dense
          filled
          solo-inverted
          label="시설명"
        ></v-autocomplete>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const addressStore = "addressStore";

export default {
  name: "AddressSearch",
  data() {
    return {
      sidoName: null,
      gugunName: null,
      dongName: null,
      dongCode: null,
      category: "",
      categoryvalue: "",
    };
  },
  watch: {
    sidoName: function (sido) {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.SET_SIDO(sido);
      this.getGugun(sido);
    },
    gugunName: function (gugun) {
      let arr = [this.sidoName, gugun];
      this.CLEAR_DONG_LIST();
      this.SET_GUGUN(gugun);
      this.getDong(arr);
    },
    dongName: function (dong) {
      let arr = [this.sidoName, this.gugunName, dong];
      this.SET_DONG(dong);
      this.getDongcode(arr);
    },
    dongcode: function (dongcode) {
      this.dongCode = dongcode;

      let dongCode = this.dongCode;
      let category = this.category;
      let categoryvalue = this.categoryvalue;
      let search = {
        dongCode,
        category,
        categoryvalue,
      };
      this.search(search);
    },
    category: function () {
      this.CLEAR_CATEGOTYVALUE_LIST();
      let arr = [this.dongCode, this.category];
      this.getCategoryvalue(arr);

      let dongCode = this.dongCode;
      let category = this.category;
      let categoryvalue = this.categoryvalue;
      let search = {
        dongCode,
        category,
        categoryvalue,
      };
      this.search(search);
    },
    categoryvalue: function () {
      let dongCode = this.dongCode;
      let category = this.category;
      let categoryvalue = this.categoryvalue;
      let search = {
        dongCode,
        category,
        categoryvalue,
      };
      this.search(search);
    },
  },
  computed: {
    ...mapState(addressStore, [
      "sidos",
      "guguns",
      "dongs",
      "dongcode",
      "categorys",
      "categoryvalues",
    ]),
  },
  created() {
    this.$store.state.addressStore.dongcode = "";
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(addressStore, [
      "getSido",
      "getGugun",
      "getDong",
      "getDongcode",
      "search",
      "getCategoryvalue",
    ]),
    ...mapMutations(addressStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_CATEGORY_LIST",
      "CLEAR_CATEGOTYVALUE_LIST",
      "SET_SIDO",
      "SET_GUGUN",
      "SET_DONG",
    ]),
  },
};
</script>

<style></style>

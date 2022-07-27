<template>
  <v-expansion-panels v-model="panel">
    <v-expansion-panel>
      <v-expansion-panel-header> 검색옵션 </v-expansion-panel-header>
      <v-expansion-panel-content>
        <v-container>
          <v-container fluid>
            <v-row align="center">
              <v-col class="sm-3">
                <v-autocomplete
                  v-model="sidoName"
                  :items="sidos"
                  dense
                  filled
                  label="시/도"
                ></v-autocomplete>
              </v-col>
              <v-col class="sm-3">
                <v-autocomplete
                  v-model="gugunName"
                  :items="guguns"
                  dense
                  filled
                  label="구/군"
                ></v-autocomplete>
              </v-col>
              <v-col class="sm-3">
                <v-autocomplete
                  v-model="dongName"
                  :items="dongs"
                  dense
                  filled
                  label="동"
                ></v-autocomplete>
              </v-col>
              <v-col class="sm-3">
                <v-autocomplete
                  v-model="dealYear"
                  :items="dealYears"
                  dense
                  filled
                  label="거래년도"
                ></v-autocomplete>
              </v-col>
            </v-row>
          </v-container>

          <v-divider light></v-divider>

          <v-container justify-center>
            <v-row>
              <v-col cols="2"></v-col>
              <v-col cols="8">
                <v-text-field
                  label="건물이름을 입력하세요."
                  hide-details="auto"
                  solo
                  v-model="word"
                ></v-text-field>
                <v-col cols="2"></v-col>
              </v-col>
            </v-row>
          </v-container>
          <v-divider light></v-divider>

          <v-btn
            color="primary"
            style="float: right"
            class="mr-1 mt-14"
            @click="submit()"
          >
            설정완료
          </v-btn>
        </v-container>
        <!--  -->
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
// import houseStore from "@/store/modules/houseStore";
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  data() {
    return {
      panel: [],
      drawer: true,
      mini: true,
      sidoName: null,
      gugunName: null,
      dongName: null,
      dongCode: null,
      dealYear: null,
      dealYears: [
        { text: "2015", value: "2015" },
        { text: "2016", value: "2016" },
        { text: "2017", value: "2017" },
        { text: "2018", value: "2018" },
        { text: "2019", value: "2019" },
        { text: "2020", value: "2020" },
        { text: "2021", value: "2021" },
        { text: "2022", value: "2022" },
      ],
      word: "",
    };
  },
  watch: {
    sidoName: function (sido) {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.getGugun(sido);
    },
    gugunName: function (gugun) {
      let arr = [this.sidoName, gugun];
      this.CLEAR_DONG_LIST();
      this.getDong(arr);
    },
    dongName: function (dong) {
      let arr = [this.sidoName, this.gugunName, dong];
      this.getDongcode(arr);
    },
    dongcode: function (dongcode) {
      this.dongCode = dongcode;
    },
  },
  computed: {
    ...mapState("addressStore", ["sidos", "guguns", "dongs", "dongcode"]),
  },
  created() {
    this.$store.state.addressStore.dongcode = "";
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions("addressStore", [
      "getSido",
      "getGugun",
      "getDong",
      "getDongcode",
      "aptsearch",
    ]),
    ...mapMutations("addressStore", [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    ...mapMutations("houseStore", ["SET_CONDITION"]),

    submit() {
      this.panel = [];
      let dongCode = this.dongCode;
      let dealYear = this.dealYear;
      let word = this.word;
      let search = {
        dongCode,
        dealYear,
        pg: 1,
        key: "apartmentName",
        word,
      };

      this.SET_CONDITION(search);
    },
  },
};
</script>

<style scoped>
#option-bar {
  color: black;
  background-color: antiquewhite;
  position: fixed;
  width: 50px;
  height: 100px;
}
h2 {
  color: white;
  position: absolute;
  margin-top: 30px;
  margin-left: 10px;
}
</style>

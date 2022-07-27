<template>
  <v-expansion-panels v-model="panel">
    <v-expansion-panel>
      <v-expansion-panel-header> 검색옵션 </v-expansion-panel-header>
      <v-expansion-panel-content>
        <!--  -->

        <!--  -->

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
            </v-row>
          </v-container>

          <v-divider light></v-divider>

          <v-container class="text-center">
            <v-radio-group v-model="category">
              <v-row>
                <v-col cols="4">
                  <v-radio :value="facilities[0]" label="어린이집"></v-radio>
                </v-col>
                <v-col cols="4">
                  <v-radio :value="facilities[1]" label="유치원"></v-radio>
                </v-col>
                <v-col cols="4">
                  <v-radio :value="facilities[2]" label="초등학교"></v-radio>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="4"
                  ><v-radio :value="facilities[3]" label="학원"></v-radio
                ></v-col>
                <v-col cols="4">
                  <v-radio :value="facilities[4]" label="공원"></v-radio>
                </v-col>
                <v-col cols="4">
                  <v-radio
                    :value="facilities[5]"
                    label="어린이보호구역"
                  ></v-radio>
                </v-col>
              </v-row>
            </v-radio-group>
          </v-container>
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
                v-model="categoryvalue"
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

        <!--  -->
      </v-expansion-panel-content>
    </v-expansion-panel>
  </v-expansion-panels>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  data() {
    return {
      panel: [],
      drawer: true,

      sidoName: null,
      gugunName: null,
      dongName: null,
      dongCode: null,
      category: "",
      categoryvalue: "",
      facilities: [
        "nursery",
        "kinder",
        "school",
        "academy",
        "park",
        "protectionzone",
      ],
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
    ...mapState("addressStore", [
      "sidos",
      "guguns",
      "dongs",
      "dongcode",
      "categorys",
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
    ...mapActions("addressStore", [
      "getSido",
      "getGugun",
      "getDong",
      "getDongcode",
      "search",
    ]),
    ...mapMutations("addressStore", [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    submit() {
      this.panel = [];
      this.mini = !this.mini;
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

<template>
  <div>
    <div>
      <v-container fluid>
        <v-row align="center">
          <v-col class="d-flex" cols="12" sm="1">
            <v-select
              v-model="HouseInfoObj.key"
              :items="optionitems"
              label="옵션"
              dense
            ></v-select>
          </v-col>
          <v-col class="d-flex" cols="12" sm="3">
            <v-text-field
              label="검색어를 입력하세요"
              hide-details="auto"
              v-model="HouseInfoObj.word"
            ></v-text-field>
          </v-col>
          <v-col class="d-flex" cols="12" sm="3">
            <v-btn color="success" class="mr-4" @click="searchApt">
              검색
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </div>
    <div>
      <v-container fluid>
        <v-row align="center">
          <b-col class="sm-3">
            <b-form-select
              v-model="HouseInfoObj.sidoName"
              :options="sidos"
              @change="gugunList"
            ></b-form-select>
          </b-col>
          <b-col class="sm-3">
            <b-form-select
              v-model="HouseInfoObj.gugunName"
              :options="guguns"
              @change="dongList"
            ></b-form-select>
          </b-col>
          <b-col class="sm-3">
            <b-form-select
              v-model="HouseInfoObj.dongName"
              :options="dongs"
              @change="searchApt"
            ></b-form-select>
          </b-col>
        </v-row>
      </v-container>
    </div>
    <div class="aptinfo">
      <v-row style="height: 500px">
        <v-col sm="7" id="map">
          <kakao-map></kakao-map>
        </v-col>
        <v-col sm="5">
          <b-container
            v-if="houses && houses.length != 0"
            class="bv-example-row mt-3"
          >
            <house-list-item
              v-for="(house, index) in houses"
              :key="index"
              :house="house"
            />

            <div>
              <house-paging
                :pagenavi="pagenavi"
                :HouseInfoObj="HouseInfoObj"
              ></house-paging>
            </div>
          </b-container>

          <b-container v-else class="bv-example-row mt-3">
            <b-row>
              <b-col><b-alert show>주택 목록이 없습니다.</b-alert></b-col>
            </b-row>
          </b-container>
        </v-col>
      </v-row>
    </div>
  </div>
</template>

<script>
import HouseListItem from "@/components/House/HouseListItem.vue";
import HousePaging from "@/components/House/HousePaging.vue";
import KakaoMap from "@/components/map/KakaoMap.vue";
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
    HousePaging,
    KakaoMap,
  },
  data() {
    return {
      optionitems: [{ text: "아파트이름", value: "aptName" }],
      HouseInfoObj: {
        sidoName: null,
        gugunName: null,
        dongName: null,
        pg: 1,
        key: "",
        word: "",
      },
    };
  },
  computed: {
    ...mapState(["sidos", "guguns", "dongs", "houses", "pagenavi"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(["getSido", "getGugun", "getDong", "getHouseList"]),
    ...mapMutations(["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_DONG_LIST"]),
    gugunList() {
      let HO = this.HouseInfoObj;
      this.CLEAR_GUGUN_LIST();
      HO.gugunName = null;
      if (HO.sidoName) this.getGugun(HO.sidoName);
    },
    dongList() {
      let HO = this.HouseInfoObj;
      this.CLEAR_DONG_LIST();
      HO.dongName = null;
      let getdongarr = [HO.sidoName, HO.gugunName];
      if (HO.gugunName) this.getDong(getdongarr);
    },
    searchApt() {
      let HO = this.HouseInfoObj;
      let gethousearr = [
        HO.sidoName,
        HO.gugunName,
        HO.dongName,
        HO.pg,
        HO.key,
        HO.word,
      ];
      if (this.HouseInfoObj.dongName) this.getHouseList(gethousearr);
    },
  },
};
</script>

<style>
#aptinfo {
  height: 300px;
}
</style>

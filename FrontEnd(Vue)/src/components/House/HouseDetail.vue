<template>
  <v-card class="indigo lighten-5" height="700px" width="1300px">
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
              {{ this.housedetail.apartmentName }}
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
              <v-simple-table class="grey lighten-3" height="500px">
                <tbody claa="">
                  <tr>
                    <td></td>
                    <td></td>
                  </tr>

                  <tr>
                    <td>거래코드</td>
                    <td>{{ this.housedetail.no }}</td>
                  </tr>

                  <tr>
                    <td>아파트코드</td>
                    <td>{{ this.housedetail.aptCode }}</td>
                  </tr>

                  <tr>
                    <td>거래가격</td>
                    <td>{{ this.housedetail.dealAmount }}</td>
                  </tr>

                  <tr>
                    <td>거래일</td>
                    <td>
                      {{ this.housedetail.dealYear }}
                      {{ this.housedetail.dealMonth }}
                      {{ this.housedetail.dealDay }}
                    </td>
                  </tr>

                  <tr>
                    <td>면적</td>
                    <td>{{ this.housedetail.area }}</td>
                  </tr>

                  <tr>
                    <td>층수</td>
                    <td>{{ this.housedetail.floor }}</td>
                  </tr>

                  <tr>
                    <td>도로명</td>
                    <td>{{ this.housedetail.roadName }}</td>
                  </tr>

                  <tr>
                    <td></td>
                    <td></td>
                  </tr>
                </tbody>
              </v-simple-table>
            </v-sheet>
          </v-col>
          <v-col cols="6">
            <v-sheet class="grey lighten-4" height="500px">
              <!-- 카카오맵 -->
              <div>
                <mini-map :house="this.housedetail" ref="road"></mini-map>
              </div>
            </v-sheet>
          </v-col>
        </v-row>

        <v-container class="text-right">
          <v-btn class="ml-3" color="green" dark @click="mapviewdiv()"
            >지도보기</v-btn
          >
          <v-btn class="ml-3" color="green" dark @click="roadviewdiv()"
            >로드뷰보기</v-btn
          >
        </v-container>
      </v-container>
    </v-card>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MiniMap from "../map/MiniMap.vue";
export default {
  props: {
    code: Object,
  },
  components: {
    MiniMap,
  },
  data() {
    return {
      housedetail: {},
    };
  },
  watch: {
    house: function (data) {
      console.log(data);
      this.housedetail = data;
    },
  },
  created() {
    this.gethousedetail(this.code);
  },
  computed: {
    ...mapState("houseStore", ["house"]),
  },
  methods: {
    ...mapActions("houseStore", ["gethousedetail"]),
    roadviewdiv() {
      let lat = this.code.lat;
      let lng = this.code.lng;
      let data = {
        lat,
        lng,
      };
      this.$refs.road.houseroadview(data);
    },
    mapviewdiv() {
      let lat = this.code.lat;
      let lng = this.code.lng;
      let apartmentName = this.code.apartmentName;
      let data = {
        lat,
        lng,
        apartmentName,
      };
      this.$refs.road.housedetailmap(data);
    },
  },
};
</script>

<style scoped>
td {
  font-weight: bolder;
}
</style>

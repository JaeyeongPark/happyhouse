<template>
  <!-- <v-img src="@/assets/img/flowerimg.jpg" height="100%" width="100%"> -->
  <v-sheet class="grey lighten-3">
    <v-container>
      <v-card class="mx-auto" outlined>
        <v-img src="@/assets/img/community.jpg" height="500px" outlined rounded>
          <v-container>
            <v-card id="banner-card1" elevation="12" outlined rounded="">
              <v-banner class="banner" shaped>
                <h2>커뮤니티</h2>
                <p>사람들과 의견을 공유해보세요!</p>
              </v-banner>
              <v-btn
                :to="{ name: 'board' }"
                :class="isColor"
                class="direct-btn1"
                @mouseover="colorChange(true)"
                @mouseout="colorChange(false)"
                style="font-family: 'SuseongDotum'"
              >
                바로가기
              </v-btn>
            </v-card>
          </v-container>
        </v-img>
      </v-card>
    </v-container>

    <v-container>
      <v-row>
        <v-col cols="6">
          <v-card class="mx-auto">
            <v-img src="@/assets/img/school.jpg" height="500px">
              <v-container>
                <v-card id="banner-card2" elevation="12" outlined rounded="">
                  <v-banner class="banner" shaped>
                    <h2>교육시설 조회</h2>
                    <p>사는 곳 주변의 교육환경을 알아보세요!</p>
                  </v-banner>
                  <v-btn
                    :class="{ 'mouse-over': isColor }"
                    class="direct-btn2"
                    @mouseover="colorChange(true)"
                    @mouseout="colorChange(false)"
                    :to="{ name: 'facility' }"
                    style="font-family: 'SuseongDotum'"
                  >
                    바로가기
                  </v-btn>
                </v-card>
              </v-container>
            </v-img>
          </v-card>
        </v-col>
        <v-col cols="6">
          <v-card class="mx-auto">
            <v-img src="@/assets/img/아파트.png" height="500px">
              <v-container>
                <v-card id="banner-card2" elevation="12" outlined rounded="">
                  <v-banner class="banner" shaped>
                    <h2>아파트 시세 조회</h2>
                    <p>사는 지역의 아파트 시세를 알아보세요!</p>
                  </v-banner>
                  <v-btn
                    :class="{ 'mouse-over': isColor }"
                    class="direct-btn2"
                    :to="{ name: 'house' }"
                    @mouseover="colorChange(true)"
                    @mouseout="colorChange(false)"
                    style="font-family: 'SuseongDotum'"
                  >
                    바로가기
                  </v-btn>
                </v-card>
              </v-container>
            </v-img>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-sheet>
  <!-- </v-img> -->
</template>

<script>
export default {
  data() {
    return {
      isColor: true,
    };
  },
  methods: {
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
p,
h2 {
  font-family: "SuseongDotum";
}

@font-face {
  font-family: "SBAgroL";
  src: url("@/assets/fonts/SBAgroL.ttf") format("truetype");
  font-weight: 700;
}

#banner-card1 {
  border-style: ridge;
  border-width: 5px;
  background-color: rgba(255, 255, 255, 0.5);
  color: black;
  width: 430px;
  margin-top: 5%;
  margin-left: 55%;
  padding: 20px;
}
#banner-card2 {
  border-style: ridge;
  border-width: 5px;
  background-color: rgba(255, 255, 255, 0.5);
  color: black;
  width: 400px;
  margin-top: 20%;
  margin-left: 20%;
  padding: 20px;
}
.banner {
  font-weight: bolder;
  text-size-adjust: 50;
}
.direct-btn1 {
  margin-top: 30px;
  margin-left: 250px;
  font-weight: bold;
}
.direct-btn2 {
  margin-top: 30px;
  margin-left: 70%;
  font-weight: bold;
}
.mouse-over {
  background-color: black;
}
</style>

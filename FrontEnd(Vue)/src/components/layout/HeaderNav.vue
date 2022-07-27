<template>
  <div>
    <v-app-bar
      app
      color="blue lighten-4"
      outlined
      flat
      hide-on-scroll
      height="90px"
    >
      <v-container absolute class="py-0 fill-height">
        <v-toolbar-title class="mr-4">
          <router-link
            to="/"
            class="logo"
            style="font-family: 'Cafe24Ssurround'"
          >
            행복한
            <img
              src="@/assets/img/house_logo.png"
              width="40px"
              height="40px"
              color="orange"
              class="mb-3"
            />
          </router-link>
        </v-toolbar-title>

        <v-btn class="nav-item" :to="{ name: 'notice' }" text>공지사항</v-btn>
        <v-btn class="nav-item" :to="{ name: 'board' }" text>커뮤니티</v-btn>
        <v-btn class="nav-item" :to="{ name: 'facility' }" text
          >교육시설 조회</v-btn
        >
        <v-btn
          style="font-family: 'SuseongDotum'"
          class="nav-item"
          @click="moveinterest()"
          text
          >관심시설 조회</v-btn
        >
        <v-btn class="nav-item" :to="{ name: 'house' }" text
          >아파트 시세 조회</v-btn
        >
        <!-- <v-btn class="nav-item" @click="log">현재userinfo는??</v-btn> -->

        <v-spacer></v-spacer>
        <!-- 로그인(아이콘) -->
        <!-- <v-sheet height="" class="overflow-hidden" style="position: relative">
          <v-container class="fill-height">
            <v-row align="center" justify="center">
              <v-btn dark @click.stop="drawer = !drawer">
                <v-icon large>{{ icons.mdiAccount }}</v-icon>
              </v-btn>
            </v-row>
          </v-container>
        </v-sheet> -->
        <!-- 로그인 아이콘 끝 -->
        <div class="text-center">
          <v-menu offset-y>
            <template v-slot:activator="{ on, attrs }">
              <v-btn dark v-bind="attrs" v-on="on">
                <v-icon>{{ icons.mdiAccount }}</v-icon>
              </v-btn>
            </template>
            <v-list
              v-if="userInfo"
              class="text-center"
              style="font-weight: bold"
            >
              <v-list-item>
                <v-list-item-title
                  ><a @click="userdetail">회원정보</a></v-list-item-title
                >
              </v-list-item>
              <v-list-item>
                <v-list-item-title
                  ><a @click="onClickLogout">로그아웃</a></v-list-item-title
                >
              </v-list-item>
            </v-list>
            <v-list v-else class="text-center" style="font-weight: bold">
              <v-list-item>
                <v-list-item-title
                  ><a @click="login">로그인</a></v-list-item-title
                >
              </v-list-item>
              <v-list-item>
                <v-list-item-title
                  ><a @click="regist">회원가입</a></v-list-item-title
                >
              </v-list-item>
            </v-list>
          </v-menu>
        </div>
      </v-container>
    </v-app-bar>
  </div>
</template>
<script>
import { mdiAccount } from "@mdi/js";
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {
      drawer: false,
      icon: { icon1: "mdi-view-dashboard", icon2: "mdi-forum" },
      icons: {
        mdiAccount,
      },
    };
  },
  watch: {
    userInfo: function (data) {
      console.log(data);
    },
  },
  computed: {
    ...mapState("userStore", ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations("userStore", ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      // sessionStorage.removeItem("vuex");

      if (this.$route.path != "/") this.$router.push({ name: "home" });
    },
    userdetail() {
      this.$router.push({ name: "userdetail" });
    },
    login() {
      this.$router.push({ name: "login" });
    },
    regist() {
      this.$router.push({ name: "userregist" });
    },
    moveinterest() {
      if (sessionStorage.getItem("access-token")) {
        this.$router.push({ name: "interest" });
      } else {
        alert("로그인 해주세요");
      }
    },
    // logout() {
    //   console.log("로그아웃~");
    // },
  },
};
</script>
<style scoped>
a {
  text-decoration: none;
}
.nav-item {
  font-weight: bold;
  font-size: 18px;
}

.logo {
  height: 80px;
  width: 180px;
  text-decoration: none;
  font-size: 30px;
  font-weight: bold;
  color: orange;
}
v-btn,
a {
  font-family: "SuseongDotum";
}
</style>

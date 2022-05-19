<template>
  <div>
    <v-app-bar app color="white" flat hide-on-scroll height="90px">
      <v-container absolute class="py-0 fill-height">
        <v-toolbar-title class="mr-4">
          <router-link to="/" class="logo"> HappyHouse </router-link>
        </v-toolbar-title>

        <v-btn class="nav-item" text>공지사항</v-btn>
        <v-btn class="nav-item" :to="{ name: 'board' }" text>게시판</v-btn>
        <v-btn class="nav-item" :to="{ name: 'house' }" text
          >실거래가 조회</v-btn
        >
        <!-- <v-btn class="nav-item" @click="log">현재userinfo는??</v-btn> -->

        <v-spacer></v-spacer>
        <!-- 로그인(아이콘) -->
        <v-sheet height="" class="overflow-hidden" style="position: relative">
          <v-container class="fill-height">
            <v-row align="center" justify="center">
              <v-btn dark @click.stop="drawer = !drawer">
                <v-icon large>{{ icons.mdiAccount }}</v-icon>
              </v-btn>
            </v-row>
          </v-container>
        </v-sheet>
        <!-- 로그인 아이콘 끝 -->
      </v-container>
    </v-app-bar>
    <!-- 로그인 폼 시작 -->
    <v-navigation-drawer v-model="drawer" absolute temporary right>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title> John Leider님 환영합니다.</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense v-if="isLogin">
        <v-list-item>
          <v-list-item-icon>
            <v-icon>{{ icon.icon1 }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>
              <v-btn class="nav-item" to="/user/detail" text>회원정보</v-btn>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>{{ icon.icon2 }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>
              <v-btn class="nav-item" @click="logout"
                >로그아웃</v-btn
              ></v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense v-else>
        <v-list-item>
          <v-list-item-icon>
            <v-icon>{{ icon.icon1 }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>
              <v-btn class="nav-item" to="/login" text>로그인</v-btn>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>{{ icon.icon2 }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>
              <v-btn class="nav-item" to="/user/regist" text
                >회원가입</v-btn
              ></v-list-item-title
            >
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <!-- 로그인 폼 끝 -->
  </div>
</template>
<script>
import { mapState } from "vuex";
import { mdiAccount } from "@mdi/js";

export default {
  data() {
    return {
      drawer: false,
      icon: { icon1: "mdi-view-dashboard", icon2: "mdi-forum" },
      icons: {
        mdiAccount,
      },
      isLogin: false,
    };
  },
  computed: {
    ...mapState(["userinfo"]),
  },
  watch: {
    userinfo(user) {
      if (user) {
        this.isLogin = true;
      } else {
        this.isLogin = false;
      }
    },
  },
  methods: {
    log() {
      console.log(this.userinfo.udto.id);
      console.log(this.userinfo.udto.password);
      console.log(this.userinfo.udto.email);
      console.log(this.userinfo.udto.name);
      console.log(this.userinfo.udto.age);
    },
    logout() {
      this.$store.commit("USER_LOGOUT");
      //this.$router.push("/");
    },
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
</style>

<template>
  <div>
    <v-app-bar app color="white" flat hide-on-scroll>
      <v-container absolute class="py-0 fill-height">
        <v-toolbar-title class="mr-8">
          <router-link to="/"> HappyHouse </router-link>
        </v-toolbar-title>

        <v-btn class="nav-item" to="/notice" text>공지사항</v-btn>
        <v-btn class="nav-item" to="/board" text>게시판</v-btn>
        <v-btn class="nav-item" to="/deal" text>실거래가 조회</v-btn>
        <v-btn class="nav-item" to="/chat" text>실시간 채팅</v-btn>

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
    <v-navigation-drawer v-model="drawer" absolute temporary>
      <v-list-item>
        <v-list-item-avatar>
          <v-img src="https://randomuser.me/api/portraits/men/78.jpg"></v-img>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>John Leider</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item v-for="item in items" :key="item.title" link>
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon> 
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <!-- 로그인 폼 끝 -->
  </div>
</template>
<script>
import { mdiAccount } from "@mdi/js";
export default {
  data() {
    return {
      drawer: false,
      items: [
        { title: "Home", icon: "mdi-view-dashboard" },
        { title: "About", icon: "mdi-forum" },
      ],
      icons: {
        mdiAccount,
      },
    };
  },
};
</script>
<style scoped>
a {
  text-decoration: none;
  font-size: 30px;
  font-weight: bold;
  color: orange;
}

.nav-item {
  font-weight: bold;
  font-size: 18px;
}
</style>

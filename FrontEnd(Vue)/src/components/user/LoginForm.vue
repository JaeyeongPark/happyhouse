<template>
  <v-main class="grey lighten-3">
    <v-sheet class="grey lighten-3 mt-10" height="500px">
      <v-layout align-center justify-center>
        <v-flex xs12 sm8 md4>
          <v-card class="elevation-10">
            <v-toolbar dark color="primary">
              <v-toolbar-title>Login form</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form>
                <b-alert show variant="danger" v-if="isLoginError"
                  >아이디 또는 비밀번호를 확인하세요.</b-alert
                >
                <v-text-field
                  label="id"
                  type="text"
                  v-model="user.id"
                ></v-text-field>
                <v-text-field
                  id="password"
                  label="Password"
                  type="password"
                  v-model="user.password"
                ></v-text-field>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="primary" @click="confirm">Login</v-btn>
              <v-btn color="primary" @click="pwfind">비밀번호찾기</v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-sheet>
  </v-main>
</template>

<script>
import { mapState, mapActions } from "vuex";
export default {
  name: "MemberLogin",
  data() {
    return {
      user: {
        id: null,
        password: null,
      },
    };
  },
  computed: {
    ...mapState("userStore", ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions("userStore", ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "signup" });
    },
    pwfind() {
      this.$router.push({ name: "findpw" });
    },
  },
};
</script>

<style></style>

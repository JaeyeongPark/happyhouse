<template>
  <v-app id="inspire">
    <v-layout align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-10">
          <v-toolbar dark color="primary">
            <v-toolbar-title>Login form</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field label="id" type="text" v-model="id"></v-text-field>
              <v-text-field
                id="password"
                label="Password"
                type="password"
                v-model="password"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" @click="login">Login</v-btn>
            <v-btn color="primary" @click="pwfind">비밀번호찾기</v-btn>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
  </v-app>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "UserLogin",
  data() {
    return {
      id: null,
      password: null,
    };
  },
  computed: {
    ...mapState(["userinfo"]),
  },
  watch: {
    userinfo(user) {
      console.log(user);
      if (user) {
        alert("성공");
      }
    },
  },
  methods: {
    login() {
      let user = {
        id: this.id,
        password: this.password,
      };

      this.$store.dispatch("loginUser", user);
      // this.$router.push("/");
    },
    pwfind() {
      this.$router.push({ name: "findpw" });
    },
  },
};
</script>

<style></style>

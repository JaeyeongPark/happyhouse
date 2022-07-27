<template>
  <v-main class="grey lighten-3">
    <v-sheet class="grey lighten-3 mt-10" height="500px">
      <v-layout align-center justify-center>
        <v-flex xs12 sm8 md4>
          <v-card class="elevation-10">
            <v-toolbar dark color="primary">
              <v-toolbar-title>비밀번호 찾기</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field
                  label="id"
                  type="text"
                  v-model="id"
                ></v-text-field>
                <v-text-field
                  label="전화번호"
                  type="text"
                  v-model="phonenumber"
                ></v-text-field>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="primary" @click="pwfind">찾기</v-btn>
              <v-btn color="primary" @click="login">취소</v-btn>
            </v-card-actions>
          </v-card>
        </v-flex>
      </v-layout>
    </v-sheet>
  </v-main>

  <!-- <v-app id="inspire">
    <v-layout align-center justify-center>
      <v-flex xs12 sm8 md4>
        <v-card class="elevation-10">
          <v-toolbar dark color="primary">
            <v-toolbar-title>비밀번호 찾기</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                label="아이디"
                type="text"
                v-model="id"
              ></v-text-field>

              <v-text-field
                label="전화번호"
                type="text"
                v-model="phonenumber"
              ></v-text-field>
            </v-form>
          </v-card-text>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" @click="pwfind">찾기</v-btn>
            <v-btn color="primary" @click="login">취소</v-btn>
          </v-card-actions>

        </v-card>
      </v-flex>
    </v-layout>
  </v-app> -->
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      id: "",
      phonenumber: "",
    };
  },
  methods: {
    pwfind() {
      http
        .get(`/user/${this.id}/${this.phonenumber}`)
        .then(({ data }) => {
          if (data.password != 0) {
            alert("비밀번호는 " + data.password + " 입니다.");
            this.$router.push({ name: "login" });
          } else {
            alert("정보가 일치하지 않습니다.");
          }
        })
        .catch((error) => {
          alert("정보가 일치하지 않습니다.");
          console.log(error);
        });
    },
    login() {
      this.$router.push({ name: "login" });
    },
  },
};
</script>

<style></style>

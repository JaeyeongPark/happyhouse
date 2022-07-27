<template>
  <v-main class="pb-16 grey lighten-3 text-center">
    <v-container class="grey lighten-2 text-center">
      <v-sheet outlined>
        <h2 class="mt-3">회원정보 등록</h2>
        <v-divider></v-divider>
        <v-simple-table fixed-header>
          <thead>
            <tr class="text-center">
              <th class="text-center" width="100px">아이디</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th class="">
                <v-text-field
                  class="mt-6"
                  label="아이디 입력"
                  solo
                  v-model="id"
                ></v-text-field>
              </th>
            </tr>
            <tr>
              <th class="text-center" width="100px">패스워드</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="패스워드 입력"
                  solo
                  v-model="password"
                  type="password"
                ></v-text-field>
              </th>
            </tr>

            <tr>
              <th class="text-center" width="100px">이름</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="이름 입력"
                  solo
                  v-model="name"
                ></v-text-field>
              </th>
            </tr>

            <tr>
              <th class="text-center" width="100px">이메일</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="이메일 입력"
                  solo
                  v-model="email"
                ></v-text-field>
              </th>
            </tr>

            <tr>
              <th class="text-center" width="100px">전화번호</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="전화번호 입력"
                  solo
                  v-model="phonenumber"
                ></v-text-field>
              </th>
            </tr>
            <tr>
              <th class="text-center" width="100px">나이</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <v-text-field
                  class="mt-6"
                  label="나이 입력"
                  solo
                  v-model="age"
                ></v-text-field>
              </th>
            </tr>
            <tr>
              <th class="text-center" width="100px">지역</th>
              <th class="text-left" width="10px">
                <v-divider vertical></v-divider>
              </th>
              <th>
                <!-- 지역 드롭다운 -->

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
                <!-- 지역드롭다운 끝 -->
              </th>
            </tr>
          </thead>
        </v-simple-table>
      </v-sheet>
    </v-container>
    <v-container class="text-right">
      <v-btn color="primary" class="ml-3" @click="regist">회원가입</v-btn>
      <v-btn color="primary" class="ml-3" @click="moveloginform"
        >로그인 화면으로</v-btn
      >
    </v-container>
  </v-main>
</template>

<script>
import http from "@/api/http";
import { mapState, mapActions, mapMutations } from "vuex";

export default {
  name: "UserRegist",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: "",
      age: "",
      phonenumber: "",
      sidoName: null,
      gugunName: null,
      dongName: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState("addressStore", ["sidos", "guguns", "dongs", "dongcode"]),
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
    ]),
    ...mapMutations("addressStore", [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_CONDITION_LIST",
    ]),
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.email === "" ||
        this.age === "" ||
        this.phonenumber === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      } else {
        let dongcode = this.dongCode;
        let id = this.id;
        let password = this.password;
        let name = this.name;
        let email = this.email;
        let phonenumber = this.phonenumber;
        let age = this.age;
        let sidoName = this.sidoName;
        let gugunName = this.gugunName;
        let dongName = this.dongName;
        let userInfo = {
          id,
          password,
          name,
          email,
          phonenumber,
          age,
          dongcode,
          sidoName,
          gugunName,
          dongName,
        };
        http
          .post(`/user`, userInfo)
          .then(({ data }) => {
            let msg = "등록 처리시 문제가 발생했습니다.";
            if (data) {
              msg = "등록이 완료되었습니다.";
            }
            this.CLEAR_CONDITION_LIST();
            alert(msg);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
    moveloginform() {
      this.$router.push("/login");
    },
  },
};
</script>

<style scoped></style>

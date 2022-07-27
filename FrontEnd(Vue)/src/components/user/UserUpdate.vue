<template>
  <v-main class="pb-16 grey lighten-3 text-center">
    <v-container class="grey text-center">
      <v-sheet outlined>
        <h2>회원정보</h2>
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
                  solo
                  readonly
                  v-model="user.id"
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
                  label=""
                  solo
                  v-model="user.password"
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
                  label=""
                  solo
                  v-model="user.name"
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
                  label=""
                  solo
                  v-model="user.email"
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
                  label=""
                  solo
                  v-model="user.phonenumber"
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
                  label=""
                  solo
                  v-model="user.age"
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
                        v-model="user.sidoName"
                        :items="sidos"
                        dense
                        filled
                        label="시/도"
                      ></v-autocomplete>
                    </v-col>
                    <v-col class="sm-3">
                      <v-autocomplete
                        v-model="user.gugunName"
                        :items="guguns"
                        dense
                        filled
                        label="구/군"
                      ></v-autocomplete>
                    </v-col>
                    <v-col class="sm-3">
                      <v-autocomplete
                        v-model="user.dongName"
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
      <v-btn color="primary" class="ml-3" @click="update">수정</v-btn>
      <v-btn color="primary" class="ml-3" :to="{ name: 'userdetail' }"
        >취소</v-btn
      >
    </v-container>
  </v-main>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";
// import http from "@/api/http";
export default {
  name: "UserUpdate",
  data() {
    return {
      sidoName: null,
      gugunName: null,
      dongName: null,
      dongCode: null,
      user: {
        id: "",
        password: "",
        name: "",
        email: "",
        phonenumber: "",
        age: "",
        dongcode: "",
        sidoName: "",
        gugunName: "",
        dongName: "",
      },
    };
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
    ...mapState("addressStore", [
      "sidos",
      "guguns",
      "dongs",
      "dongcode",
      "alladdress",
    ]),
  },
  watch: {
    "user.sidoName": function (sido) {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.getGugun(sido);
    },
    "user.gugunName": function (gugun) {
      let arr = [this.user.sidoName, gugun];
      this.CLEAR_DONG_LIST();
      this.getDong(arr);
    },
    "user.dongName": function (dong) {
      let arr = [this.user.sidoName, this.user.gugunName, dong];
      this.getDongcode(arr);
    },
    dongcode: function (dongcode) {
      // console.log(dongcode);
      this.user.dongcode = dongcode;
    },
  },
  created() {
    this.$store.state.addressStore.dongcode = "";
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();

    this.user = this.$store.state.userStore.userInfo;
    // this.sidoName = this.alladdress.allAddress.sidoName;
    // this.gugunName = this.alladdress.allAddress.gugunName;
    // this.dongName = this.alladdress.allAddress.dongName;
    // this.getAddressName(this.userInfo.dongcode);
  },
  methods: {
    ...mapActions("userStore", ["updateuser"]),
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

    update() {
      this.CLEAR_CONDITION_LIST();
      this.updateuser(this.userInfo);
      alert("수정이 완료되었습니다.");
      this.$router.push("/");
    },
  },
};
</script>

<style></style>

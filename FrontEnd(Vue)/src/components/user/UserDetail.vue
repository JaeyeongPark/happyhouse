<template>
  <v-main class="pb-16 grey lighten-3 text-center">
    <v-container class="grey lighten-2 text-center">
      <v-sheet outlined>
        <h2 class="mt-3">회원정보</h2>
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
                  v-model="userInfo.id"
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
                  readonly
                  v-model="userInfo.password"
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
                  label=""
                  solo
                  readonly
                  v-model="userInfo.name"
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
                  readonly
                  v-model="userInfo.email"
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
                  readonly
                  v-model="userInfo.phonenumber"
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
                  readonly
                  v-model="userInfo.age"
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
                      <v-text-field
                        class="mt-6"
                        solo
                        readonly
                        v-model="userInfo.sidoName"
                      ></v-text-field>
                    </v-col>
                    <v-col class="sm-3">
                      <v-text-field
                        class="mt-6"
                        solo
                        readonly
                        v-model="userInfo.gugunName"
                      ></v-text-field>
                    </v-col>
                    <v-col class="sm-3">
                      <v-text-field
                        class="mt-6"
                        solo
                        readonly
                        v-model="userInfo.dongName"
                      ></v-text-field>
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
      <v-btn class="ml-3" color="primary" :to="{ name: 'userupdate' }"
        >수정</v-btn
      >
      <v-btn class="ml-3" color="red" @click="UserDelete">탈퇴</v-btn>
    </v-container>
  </v-main>
</template>

<script>
import { mapActions, mapState } from "vuex";
// import http from "@/api/http";

export default {
  name: "UserDetail",
  // data() {
  //   return {
  //     address: {
  //       sidoName: "",
  //       gugunName: "",
  //       dongName: "",
  //     },
  //   };
  // },
  // watch: {
  //   alladdress: function (data) {
  //     console.log(data);
  //     this.address = data;
  //   },
  // },
  computed: {
    ...mapState("userStore", ["userInfo"]),
    // ...mapState("addressStore", ["alladdress"]),
  },
  // created() {
  //   this.getAddressName(this.userInfo.dongcode);
  // },
  methods: {
    // ...mapActions("addressStore", ["getAddressName"]),
    ...mapActions("userStore", ["deleteuser"]),

    UserDelete() {
      let id = this.userInfo.id;
      console.log(id);
      this.deleteuser(id);
      alert("삭제가 완료되었습니다.");
      this.$router.push("/");
    },
  },
};
</script>

<style scoped></style>

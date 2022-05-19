<template>
  <div class="container text-center">
    <h2>회원 정보</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input
        readonly
        type="text"
        v-model="userinfo.udto.id"
        class="view"
      /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        v-model="userinfo.udto.password"
        class="view"
      /><br />
      <label for="name">이름</label>
      <input type="text" v-model="userinfo.udto.name" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" v-model="userinfo.udto.email" class="view" /><br />
      <label for="phonenumber">전화번호</label>
      <input
        type="text"
        v-model="userinfo.udto.phonenumber"
        class="view"
      /><br />
      <button class="btn" @click="updateUser">수정</button>
      <button class="btn" @click="deleteUser">삭제</button>
    </fieldset>
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/api/http";

export default {
  name: "UserDetail",
  computed: {
    ...mapState(["userinfo"]),
  },
  methods: {
    updateUser() {
      http
        .put(`/user/${this.id}`, {
          id: this.userinfo.udto.id,
          password: this.userinfo.udto.password,
          name: this.userinfo.udto.name,
          email: this.userinfo.udto.email,
          phonenumber: this.userinfo.udto.phonenumber,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data) {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push("/");
        })
        .catch((error) => {
          console.log(error);
        });
    },
    deleteUser() {
      http
        .delete(`/user/${this.id}`, {
          id: this.userinfo.udto.id,
          password: this.userinfo.udto.password,
          name: this.userinfo.udto.name,
          email: this.userinfo.udto.email,
          phonenumber: this.userinfo.udto.phonenumber,
        })
        .then(({ data }) => {
          let msg = "삭제 처리시 문제가 발생했습니다.";
          if (data) {
            msg = "삭제가 완료되었습니다.";
          }
          alert(msg);
          this.$store.commit("USER_LOGOUT");
          this.$router.push("/");
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}
</style>

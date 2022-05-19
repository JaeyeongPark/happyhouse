<template>
  <div class="container text-center">
    <h2>회원 가입</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input type="password" v-model="password" class="view" /><br />
      <label for="name">이름</label>
      <input type="text" v-model="name" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" v-model="email" class="view" /><br />
      <label for="phonenumber">전화번호</label>
      <input type="text" v-model="phonenumber" class="view" /><br />
      <button class="btn" @click="regist">등록</button>
    </fieldset>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "UserRegist",
  data() {
    return {
      id: "",
      password: "",
      name: "",
      email: "",
      phonenumber: "",
    };
  },
  methods: {
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.name === "" ||
        this.email === "" ||
        this.phonenumber === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      } else {
        http
          .post(`/user`, {
            id: this.id,
            password: this.password,
            name: this.name,
            email: this.email,
            phonenumber: this.phonenumber,
          })
          .then(({ data }) => {
            let msg = "등록 처리시 문제가 발생했습니다.";
            if (data) {
              msg = "등록이 완료되었습니다.";
            }
            alert(msg);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      }
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

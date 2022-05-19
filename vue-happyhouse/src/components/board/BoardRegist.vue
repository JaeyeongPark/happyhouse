<template>
  <div class="regist text-center row" style="float: none; margin: 100 auto">
    <h1 class="underline">글 등록</h1>
    <div class="regist_form">
      <label for="userid">작성자 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        v-model="boardreginfo.id"
        readonly
      /><br />
      <label for="subject">제목 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        v-model="boardreginfo.subject"
      /><br />
      <label for="content">내용 | </label><br />
      <textarea
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        v-model="boardreginfo.contents"
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <b-button @click="boardregist">등록</b-button>
      <b-button @click="moveList">목록</b-button>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      boardreginfo: {
        id: "",
        subject: "",
        contents: "",
      },
    };
  },
  methods: {
    boardregist() {
      http
        .post(`/board`, this.boardreginfo)
        .then(({ data }) => {
          if (data.flag == 1) {
            alert("글등록 성공");
            this.$router.push({ name: "list" });
          } else {
            alert("글등록 실패");
            this.$router.push({ name: "list" });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    moveList() {
      this.$router.push({ name: "list" });
    },
  },
  created() {
    // console.log(this.$store.state.userinfo.udto);
    this.boardreginfo.id = this.$store.state.userinfo.udto.id;
  },
};
</script>

<style>
.view {
  border: 1px solid black;
  margin-top: 4px;
  margin-bottom: 4px;
}
label {
  font-weight: bold;
  display: block;
}
input {
  display: block;
}
</style>

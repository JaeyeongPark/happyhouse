<template>
  <div class="regist text-center row" style="float: none; margin: 100 auto">
    <h1 class="underline">글 정보</h1>
    <div class="regist_form">
      <label for="userid">글 번호 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        v-model="article.no"
        readonly
      /><br />
      <label for="userid">작성자 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        v-model="article.id"
        readonly
      /><br />
      <label for="subject">제목 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        v-model="article.subject"
        readonly
      /><br />
      <label for="content">내용 | </label><br />
      <textarea
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        name="contents"
        v-model="article.contents"
        readonly
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <b-button @click="modifyboard">수정</b-button>
      <b-button @click="deleteboard">삭제</b-button>
      <b-button @click="moveList">목록</b-button>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
export default {
  data: function () {
    return {
      article: {},
    };
  },
  created() {
    console.log("gd");
    http.get(`/board/${this.$route.params.no}`).then(({ data }) => {
      this.article = data.info;
    });
  },
  methods: {
    modifyboard() {
      this.$router.push({ name: "modify", params: { no: this.article.no } });
    },
    deleteboard() {
      this.$router.push({ name: "delete", params: { no: this.article.no } });
    },
    moveList() {
      this.$router.push({ name: "list" });
    },
  },
};
</script>

<style scoped>
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

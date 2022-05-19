<template>
  <div class="regist text-center row" style="float: none; margin: 100 auto">
    <h1 class="underline">글 수정</h1>
    <div class="regist_form">
      <label for="userid">작성자 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        id="id"
        name="id"
        v-model="id"
        ref="id"
      /><br />
      <label for="subject">제목 | </label>
      <input
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        type="text"
        id="subject"
        name="subject"
        v-model="subject"
        ref="subject"
      /><br />
      <label for="content">내용 | </label><br />
      <textarea
        class="view col-md-3"
        style="float: none; margin: 0 auto"
        id="contents"
        name="contents"
        v-model="contents"
        ref="contents"
        cols="35"
        rows="5"
      ></textarea
      ><br />
      <b-button @click="checkValue">수정</b-button>
      <b-button @click="moveList">목록</b-button>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
export default {
  data() {
    return {
      no: 0,
      id: "",
      subject: "",
      contents: "",
    };
  },
  created() {
    http.get(`/board/${this.$route.params.no}`).then(({ data }) => {
      this.no = data.info.no;
      this.id = data.info.id;
      this.subject = data.info.subject;
      this.contents = data.info.contents;
    });
  },
  methods: {
    // 입력값 체크하기 - 체크가 성공하면 registBook 호출
    checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      !this.id &&
        ((msg = "작성자 입력해주세요"), (err = false), this.$refs.id.focus());
      err &&
        !this.subject &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.contents &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.contents.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
      else this.modifyBook();
    },

    modifyBook() {
      http
        .put(`/board/${this.no}`, {
          no: this.no,
          id: this.id,
          subject: this.subject,
          contents: this.contents,
        })
        .then(({ data }) => {
          let msg = "";
          console.log(data.flag);
          if (data.flag == 0) {
            msg = "수정중 오류발생.";
          } else {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({ name: "list" });
        });
    },
    moveList() {
      // 현재 route를 /list로 변경.
      this.$router.push({ name: "list" });
    },
  },
};
</script>

<style scoped>
.view {
  border: 1px solid black;
  margin-top: 10px;
  margin-bottom: 10px;
}
label {
  font-weight: bold;
  display: block;
}
input {
  display: block;
}
</style>

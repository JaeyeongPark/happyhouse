<template>
  <div class="regist text-center grey lighten-3">
    <h1>글 삭제</h1>
    <div>삭제중...</div>
  </div>
</template>

<script>
import { mapActions, mapState, mapMutations } from "vuex";

export default {
  watch: {
    datastate: function (data) {
      if (data == "success") {
        alert("글 삭제성공");
      } else {
        alert("글 삭제실패");
      }
      this.$router.push({ name: "boardlist" });
      this.SET_DATASTATE_NULL();
    },
  },
  created() {
    this.deleteBoard(this.$route.params.no);
    this.SET_DATASTATE_NULL();
  },
  computed: {
    ...mapState("boardStore", ["datastate"]),
  },
  methods: {
    ...mapActions("boardStore", ["deleteBoard"]),
    ...mapMutations("boardStore", ["SET_DATASTATE_NULL"]),
  },
};
</script>

<style></style>

<template>
  <v-sheet class="grey lighten-3 text-center">
    <v-container text-right>
      <template>
        <v-btn class="ml-3" color="primary" @click="moveList">목록</v-btn>
      </template>
    </v-container>
    <v-container class="grey lighten-2">
      <v-sheet outlined>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1"> 글번호 </v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left">{{ noticedetail.noticeno }} </v-col>
        </v-row>
        <v-divider></v-divider>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1">제목</v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left">{{ noticedetail.subject }} </v-col>
        </v-row>
        <v-divider></v-divider>

        <v-row>
          <v-col class="text-left">
            <v-textarea
              class="mr-2 ml-2"
              solo
              height="400px"
              v-model="noticedetail.content"
              readonly
            >
            </v-textarea>
          </v-col>
        </v-row>
      </v-sheet>
    </v-container>

    <v-sheet height="50" class="grey lighten-3"></v-sheet>
  </v-sheet>
</template>

<script>
import { mapActions, mapState } from "vuex";
export default {
  data() {
    return {
      noticedetail: {},
    };
  },
  watch: {
    notice: function (data) {
      this.noticedetail = data;
    },
  },
  created() {
    this.detailNotice(this.$route.params.no);
  },
  computed: {
    ...mapState("noticeStore", ["notice"]),
  },
  methods: {
    ...mapActions("noticeStore", ["detailNotice"]),
    moveList() {
      this.$router.push({ name: "noticelist" });
    },
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
.bs {
  font-weight: bold;
}
</style>

<template>
  <v-container class="text-left grey lighten-2">
    <v-card min-height="100" v-if="!isUpdate" class="pb-1">
      <v-row>
        <v-col class="pl-5" style="font-weight: bold"> {{ comment.id }} </v-col>
      </v-row>
      <v-row>
        <v-col class="px-5"> {{ comment.comment }} </v-col>
      </v-row>
      <v-row>
        <v-col cols="11"></v-col>
        <v-col cols="1">
          <template
            v-if="this.userInfo && this.comment.id === this.userInfo.id"
          >
            <a class="ml-3" @click="closeopen"
              ><v-icon>{{ icons.mdiPencil }}</v-icon></a
            >

            <a class="ml-3" @click="delcomment">
              <v-icon>{{ icons.mdiDelete }}</v-icon></a
            >
          </template>
        </v-col>
      </v-row>
    </v-card>
    <v-card min-height="100" v-if="isUpdate">
      <v-row>
        <v-col class="px-5 pb-1">
          <v-textarea v-model="curcomment" height="80" solo></v-textarea>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="11"></v-col>
        <v-col cols="1">
          <template
            v-if="this.userInfo && this.comment.id === this.userInfo.id"
          >
            <a class="ml-3" @click="updatecomment"
              ><v-icon>{{ icons.mdiCheck }} </v-icon></a
            >
            <a class="ml-3" @click="closeopen"
              ><v-icon>{{ icons.mdiClose }} </v-icon></a
            >
          </template>
        </v-col>
      </v-row>
    </v-card>
    <!-- <v-btn
      width="100px"
      color="blue"
      v-if="this.comment.id === this.userInfo.id"
      @click="updatecomment"
      >수정</v-btn
    > -->
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { mdiPencil, mdiDelete, mdiCheck, mdiClose } from "@mdi/js";
export default {
  data() {
    return {
      commentno: "",
      curcomment: "",
      boardno: "",
      id: "",
      isUpdate: false,
      icons: {
        mdiPencil,
        mdiDelete,
        mdiCheck,
        mdiClose,
      },
    };
  },
  props: {
    comment: Object,
  },
  computed: {
    ...mapState("userStore", ["userInfo"]),
  },
  created() {
    if (this.userInfo) {
      this.commentno = this.comment.commentno;
      this.curcomment = this.comment.comment;
      this.id = this.userInfo.id;
      this.boardno = this.comment.boardno;
    }
  },
  methods: {
    ...mapActions("boardStore", ["deleteComment", "updateComment"]),
    delcomment() {
      //console.log(this.comment.commentno);
      let no = this.comment.commentno;
      this.deleteComment(no);
      this.$router.go();
    },
    closeopen() {
      this.isUpdate = !this.isUpdate;
    },
    updatecomment() {
      let commentno = this.commentno;
      let boardno = this.boardno;
      let id = this.id;
      let comment = this.curcomment;
      let commentinfo = {
        commentno,
        id,
        boardno,
        comment,
      };
      this.updateComment(commentinfo);
      this.$router.go();
      // console.log(this.curcomment);
      // console.log(this.id);
      // console.log(this.boardno);
    },
  },
};
</script>

<style></style>

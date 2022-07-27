<template>
  <v-sheet class="grey lighten-3 text-center">
    <v-container text-right>
      <template
        v-if="this.userInfo && this.boarddetail.id === this.userInfo.id"
      >
        <v-btn class="ml-3" color="primary" @click="modifyboard">수정</v-btn>
        <v-btn class="ml-3" color="primary" @click="moveList">목록</v-btn>
        <v-btn class="ml-3" color="red" @click="deleteboard">삭제</v-btn>
      </template>
      <template v-else>
        <v-btn class="ml-3" color="primary" @click="moveList">목록</v-btn>
      </template>
    </v-container>
    <v-container class="grey lighten-2">
      <v-sheet outlined>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1"> 작성자 </v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left">{{ boarddetail.id }} </v-col>
        </v-row>
        <v-divider></v-divider>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1">제목</v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left">{{ boarddetail.subject }} </v-col>
        </v-row>
        <v-divider></v-divider>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1"> 지역 </v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left"
            >{{ boarddetail.sidoName }} {{ boarddetail.gugunName }}
            {{ boarddetail.dongName }}</v-col
          >
        </v-row>
        <v-divider></v-divider>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1">시설분류</v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <!-- 시설별 출력 -->
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'kinder'"
            >유치원
          </v-col>
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'nursery'"
            >어린이집
          </v-col>
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'school'"
            >학교
          </v-col>
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'academy'"
            >학원
          </v-col>
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'park'"
            >공원
          </v-col>
          <v-col
            class="text-left"
            cols="10"
            v-if="boarddetail.category == 'protectionzone'"
            >어린이 보호구역
          </v-col>

          <!-- 시설별 출력 -->
        </v-row>
        <v-divider></v-divider>
        <v-row justify="center">
          <v-col class="text-center bs" cols="1">시설명</v-col>
          <v-col cols="1">
            <v-divider vertical></v-divider>
          </v-col>
          <v-col class="text-left">{{ boarddetail.categoryvalue }} </v-col>
        </v-row>
        <v-divider></v-divider>
        <v-row>
          <v-col class="text-left">
            <v-textarea
              class="mr-2 ml-2"
              solo
              height="400px"
              v-model="boarddetail.content"
              readonly
            >
            </v-textarea>
          </v-col>
        </v-row>
      </v-sheet>
    </v-container>
    <v-divider inset></v-divider>
    <v-container class="grey lighten-2">
      <v-row>
        <v-col>
          <v-textarea
            v-model="inputcomment"
            height="130"
            solo
            label="댓글을 입력하세요."
          ></v-textarea>
        </v-col>
      </v-row>
      <v-row class="mt-1 text-right">
        <v-col class="pt-1">
          <v-btn width="50px" color="primary" @click="regcomment">등록</v-btn>
        </v-col>
      </v-row>
      <!-- <v-row>
        <v-icon>{{ icons.mdiCheck }} </v-icon>
      </v-row> -->
    </v-container>

    <v-divider inset></v-divider>

    <board-comment
      v-for="(comment, index) in comments"
      :key="index"
      :comment="comment"
    >
    </board-comment>

    <v-sheet height="50" class="grey lighten-3"></v-sheet>
  </v-sheet>
</template>

<script>
import { mapActions, mapState } from "vuex";
// import http from "@/api/http";
// import BoardAddressSearch from "../layout/BoardAddressSearch.vue";
import BoardComment from "./BoardComment.vue";
import { mdiCheck } from "@mdi/js";
// import { getAllAddress } from "@/api/address.js";
export default {
  components: {
    // BoardAddressSearch,
    BoardComment,
  },
  data() {
    return {
      inputcomment: "",
      boarddetail: {},
      sidoName: "",
      gugunName: "",
      dongName: "",
      icons: {
        mdiCheck,
      },
    };
  },
  watch: {
    board: function (data) {
      this.boarddetail = data;
      // console.log("여기옴?");
      // let dongcode = this.boarddetail.dongcode;
      // let params = {
      //   dongcode,
      // };
      // getAllAddress(
      //   params,
      //   ({ data }) => {
      //     console.log(data);
      //     this.sidoName = data.allAddress.sidoName;
      //     this.gugunName = data.allAddress.gugunName;
      //     this.dongName = data.allAddress.dongName;
      //   },
      //   (error) => {
      //     console.log("에러....");
      //     console.log(error);
      //   }
      // );
    },
    comments: function (data) {
      console.log("코멘트");
      console.log(data);
    },
  },
  created() {
    this.detailBoard(this.$route.params.no);
  },
  computed: {
    ...mapState("boardStore", ["board", "comments"]),
    ...mapState("userStore", ["userInfo"]),
  },
  methods: {
    ...mapActions("boardStore", ["detailBoard", "registComment"]),
    modifyboard() {
      this.$router.push({
        name: "boardupdate",
        params: { no: this.$route.params.no },
      });
    },
    deleteboard() {
      this.$router.push({
        name: "boarddelete",
        params: { no: this.$route.params.no },
      });
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    },
    regcomment() {
      if (this.userInfo) {
        let boardno = this.boarddetail.boardno;
        let id = this.userInfo.id;
        let comment = this.inputcomment;
        let commentinfo = {
          id,
          boardno,
          comment,
        };
        this.registComment(commentinfo);
        this.$router.go();
      } else {
        alert("로그인 해주세요");
      }
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
.bs {
  font-weight: bold;
}
</style>

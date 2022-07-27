import http from "@/api/http";

const boardStore = {
  namespaced: true,
  state: {
    boards: [],
    board: null,
    pagenavi: {},
    condition: {},
    comments: [],
    datastate: "",
    issearchdirect: false,
  },
  getters: {},
  mutations: {
    SET_BOARD_LIST(state, boards) {
      state.boards = boards;
    },
    SET_PAGENAVI(state, pagenavi) {
      state.pagenavi = pagenavi;
    },
    SET_BOARD_DETAIL(state, data) {
      state.board = data;
    },
    SET_BOARD_COMMENT(state, data) {
      state.comments = data;
    },
    SET_DATASTATE(state, data) {
      state.datastate = data;
    },
    SET_DATASTATE_NULL(state) {
      state.datastate = "";
    },
    SET_SEARCHDIRECT(state) {
      state.issearchdirect = true;
    },
  },
  actions: {
    getBoardList({ commit }, condition) {
      http
        .get(
          `/board?&pg=${condition.pg}&key=${condition.key}&word=${condition.word}&dongcode=${condition.dongcode}&category=${condition.category}&categoryvalue=${condition.categoryvalue}`
        )
        .then(({ data }) => {
          commit("SET_BOARD_LIST", data.BoardDTO);
          commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    registBoard({ commit }, info) {
      console.log(info);
      http
        .post(`/board`, info)
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    detailBoard({ commit }, no) {
      http
        .get(`/board/${no}`)
        .then(({ data }) => {
          commit("SET_BOARD_DETAIL", data.boarddetail);
          commit("SET_BOARD_COMMENT", data.boardcomment);
          // commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    updateBoard({ commit }, data) {
      http
        .put(`/board/${data[0]}`, data[1])
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    deleteBoard({ commit }, no) {
      console.log(no);
      http
        .delete(`/board/${no}`)
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    registComment({ commit }, commentinfo) {
      console.log(commentinfo);
      http
        .post(`/board/comment`, commentinfo)
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나오냐?");
          console.log(error);
        });
    },
    deleteComment({ commit }, no) {
      console.log(no);
      http
        .delete(`/board/comment/${no}`)
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    updateComment({ commit }, commentinfo) {
      console.log(commentinfo);
      http
        .put(`/board/comment`, commentinfo)
        .then(({ data }) => {
          commit("SET_DATASTATE", data);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
  },
};

export default boardStore;

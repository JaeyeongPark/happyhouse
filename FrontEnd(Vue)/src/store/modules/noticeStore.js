import http from "@/api/http";

const noticeStore = {
  namespaced: true,
  state: {
    noticies: [],
    notice: null,
    pagenavi: {},
    datastate: "",
  },
  getters: {},
  mutations: {
    SET_NOTICE_LIST(state, noticies) {
      state.noticies = noticies;
    },
    SET_PAGENAVI(state, pagenavi) {
      state.pagenavi = pagenavi;
    },
    SET_NOTICE_DETAIL(state, notice) {
      state.notice = notice;
    },
  },
  actions: {
    getNoticeList({ commit }, pg) {
      console.log("출력되냐?");
      http
        .get(`/notice?&pg=${pg}`)
        .then(({ data }) => {
          commit("SET_NOTICE_LIST", data.NoticeDTO);
          commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
    detailNotice({ commit }, no) {
      console.log("디테일 들어오냐?");
      http
        .get(`/notice/${no}`)
        .then(({ data }) => {
          commit("SET_NOTICE_DETAIL", data.noticedetail);
        })
        .catch((error) => {
          console.log("에러나옴?");
          console.log(error);
        });
    },
  },
};

export default noticeStore;

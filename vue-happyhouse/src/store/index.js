import Vue from "vue";
import Vuex from "vuex";
import http from "@/api/http";
import router from "@/router";
// import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    pagenavi: {},
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ value: null, text: "선택하세요" }],
    dongs: [{ value: null, text: "선택하세요" }],
    houses: [],
    house: null,
    boards: [],
    board: null,
    userinfo: {},
  },
  getters: {},

  mutations: {
    /////////////////////////////// House start /////////////////////////////////////
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoName, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunName, text: gugun.gugunName });
      });
    },
    SET_DONG_LIST(state, dongs) {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.dongName, text: dong.dongName });
      });
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "선택하세요" }];
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_DETAIL_HOUSE(state, house) {
      state.house = house;
    },
    SET_BOARD_LIST(state, boards) {
      state.boards = boards;
    },
    SET_PAGENAVI(state, pagenavi) {
      state.pagenavi = pagenavi;
    },
    SET_LOGIN_USER(state, user) {
      state.userinfo = user;
    },
    USER_LOGOUT(state) {
      state.userinfo = null;
    },
    /////////////////////////////// House end /////////////////////////////////////
  },

  actions: {
    /////////////////////////////// House start /////////////////////////////////////
    getSido({ commit }) {
      http
        .get(`/address/sido?sidoName=&gugunName=&dongName=`)
        .then(({ data }) => {
          // console.log(data.sidolist);
          commit("SET_SIDO_LIST", data.sidolist);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoName) {
      const params = { sido: sidoName };
      http
        .get(`/address/gugun?sidoName=${sidoName}&gugunName=&dongName=`, {
          params,
        })
        .then(({ data }) => {
          commit("SET_GUGUN_LIST", data.gugunlist);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDong({ commit }, getdongarr) {
      const params = { sido: getdongarr[0], gugun: getdongarr[1] };
      http
        .get(
          `/address/dong?sidoName=${getdongarr[0]}&gugunName=${getdongarr[1]}&dongName=`,
          { params }
        )
        .then(({ data }) => {
          commit("SET_DONG_LIST", data.donglist);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getHouseList({ commit }, gethousearr) {
      http
        .get(
          `/apt?sidoName=${gethousearr[0]}&gugunName=${gethousearr[1]}&dongName=${gethousearr[2]}&pg=${gethousearr[3]}&key=${gethousearr[4]}&word=${gethousearr[5]}`
        )
        .then(({ data }) => {
          commit("SET_HOUSE_LIST", data.AptDTO);
          commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    getBoardList({ commit }, getboardarr) {
      http
        .get(
          `/board?&pg=${getboardarr[0]}&key=${getboardarr[1]}&word=${getboardarr[2]}`
        )
        .then(({ data }) => {
          commit("SET_BOARD_LIST", data.BoardDTO);
          commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    /////////////////////////////// House end /////////////////////////////////////
    loginUser({ commit }, user) {
      http
        .get(`/user/${user.id}`)
        .then(({ data }) => {
          if (
            user.id === data.udto.id &&
            user.password === data.udto.password
          ) {
            commit("SET_LOGIN_USER", data);
            alert("로그인 성공");
            router.push("/");
          } else {
            alert("로그인 실패");
          }
        })
        .catch((error) => {
          alert("로그인 실패");
          console.log(error);
        });
    },
  },
  modules: {},
  // plugins: [
  //   createPersistedState({
  //     // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
  //     storage: sessionStorage,
  //   }),
  // ],
});

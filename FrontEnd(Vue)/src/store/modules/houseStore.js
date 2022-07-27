import http from "@/api/http.js";

const houseStore = {
  namespaced: true,
  state: {
    houselist: [],
    house: null,
    pagenavi: {},
    housecondition: {},
  },
  getters: {},
  mutations: {
    SET_HOUSE_LIST(state, data) {
      state.houselist = data;
    },
    SET_HOUSE_DETAIL(state, data) {
      state.house = data;
    },
    SET_PAGENAVI(state, pagenavi) {
      state.pagenavi = pagenavi;
    },
    SET_CONDITION(state, data) {
      state.housecondition = data;
    },
  },
  actions: {
    gethouselist({ commit }, condition) {
      const params = { condition: condition };
      http
        .get(
          `/apt?dongCode=${condition.dongCode}&dealYear=${condition.dealYear}&pg=${condition.pg}&key=${condition.key}&word=${condition.word}`,
          {
            params,
          }
        )
        .then(({ data }) => {
          commit("SET_HOUSE_LIST", data.AptDTO);
          commit("SET_PAGENAVI", data.PageNavigation);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    gethousedetail({ commit }, code) {
      const params = { code: code };
      http
        .get(`/apt/detail?aptCode=${code.aptCode}&no=${code.no}`, {
          params,
        })
        .then(({ data }) => {
          commit("SET_HOUSE_DETAIL", data.aptdetail);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};

export default houseStore;

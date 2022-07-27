import http from "@/api/http.js";

const facilityStore = {
  namespaced: true,
  state: {
    facilitylist: [],
    facilitydetail: {},
    facilitydetailmap: {},
  },
  getters: {},
  mutations: {
    SET_FACILITY_LIST(state, data) {
      state.facilitylist = data;
    },
    SET_FACILITY_DETAIL(state, data) {
      state.facilitydetail = data;
    },
    SET_FACILITY_DETAILMAP(state, data) {
      state.facilitydetailmap = data;
    },
  },
  actions: {
    getfacilitylist({ commit }, condition) {
      const params = { condition: condition };
      http
        .get(
          `/facility?pg=1&key=&word=&dongcode=${condition.dongCode}&category=${condition.category}&categoryvalue=${condition.categoryvalue}`,
          {
            params,
          }
        )
        .then(({ data }) => {
          commit("SET_FACILITY_LIST", data.facilitylist);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getfacilitydetail({ commit }, condition) {
      // const params = { condition: condition };
      http
        .get(
          `facility/detail?category=${condition.category}&code=${condition.code}`
        )
        .then(({ data }) => {
          commit("SET_FACILITY_DETAIL", data.facilitydetail);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getfacilitydetailmap({ commit }, condition) {
      // const params = { condition: condition };
      http
        .get(
          `facility/detail?category=${condition.category}&code=${condition.code}`
        )
        .then(({ data }) => {
          commit("SET_FACILITY_DETAILMAP", data.facilitydetail);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};

export default facilityStore;

import { apiInstance } from "./index.js";

const api = apiInstance();

function sidoList(success, fail) {
  api
    .get(`/address/sido?sidoName=&gugunName=&dongName=&dongcode=&category=`)
    .then(success)
    .catch(fail);
}

function gugunList(param, success, fail) {
  api
    .get(
      `/address/gugun?sidoName=${param.sido}&gugunName=&dongName=&dongcode=&category=`,
      {
        params: param,
      }
    )
    .then(success)
    .catch(fail);
}

function dongList(param, success, fail) {
  api
    .get(
      `/address/dong?sidoName=${param.sido}&gugunName=${param.gugun}&dongName=&dongcode=&category=`,
      {
        params: param,
      }
    )
    .then(success)
    .catch(fail);
}

function dongcode(param, success, fail) {
  api
    .get(
      `/address/dongcode?sidoName=${param.sido}&gugunName=${param.gugun}&dongName=${param.dong}&dongcode=&category=`,
      {
        params: param,
      }
    )
    .then(success)
    .catch(fail);
}

function Categoryvalue(param, success, fail) {
  api
    .get(
      `/address/categoryvalue?sidoName=&gugunName=&dongName=&dongcode=${param.dongCode}`,
      {
        params: param,
      }
    )
    .then(success)
    .catch(fail);
}
function getAllAddress(param, success, fail) {
  api
    .get(
      `/address/alladdress?dongcode=${param.dongcode}&sidoName=&gugunName=&dongName=&category=`
    )
    .then(success)
    .catch(fail);
}
export {
  sidoList,
  gugunList,
  dongList,
  getAllAddress,
  dongcode,
  Categoryvalue,
};

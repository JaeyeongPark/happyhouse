import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(id, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${id}`).then(success).catch(fail);
}

async function userinterregist(data, success, fail) {
  await api
    .post(`/user/interest`, JSON.stringify(data))
    .then(success)
    .catch(fail);
}

async function userinterdelete(data, success, fail) {
  await api
    .delete(
      `/user/interest?id=${data.id}&category=${data.category}&code=${data.code}`
    )
    .then(success)
    .catch(fail);
}

async function userinterlist(data, success, fail) {
  await api.get(`/user/interest/${data}`).then(success).catch(fail);
}

async function confirminterest(data, success, fail) {
  await api
    .post(`/user/interestconfirm`, JSON.stringify(data))
    .then(success)
    .catch(fail);
}

async function deleteUser(id, success, fail) {
  await api.delete(`/user/${id}`).then(success).catch(fail);
}

async function updateUser(data, success, fail) {
  await api
    .put(`/user/${data.id}`, JSON.stringify(data))
    .then(success)
    .catch(fail);
}
// function logout(success, fail)

export {
  login,
  findById,
  userinterregist,
  confirminterest,
  userinterdelete,
  userinterlist,
  deleteUser,
  updateUser,
};

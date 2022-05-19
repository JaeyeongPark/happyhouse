import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:70/",
  headers: {
    "Content-Type": "application/json",
  },
});

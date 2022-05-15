<template>
  <div class="notice-container">
    <h1 class="text-h3 text-center mt-5 pt-6 pb-6">공지사항</h1>
    <div class="inner-container">
      <v-simple-table>
        <thead>
          <tr>
            <th class="text-center">번호</th>
            <th class="text-center">제목</th>
            <th class="text-center">작성자</th>
            <th class="text-center">조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="text-center">1</td>
            <td>~~~제목입니다~~~~</td>
            <td class="text-center">작성자</td>
            <td class="text-center">5</td>
          </tr>
          <tr>
            <td class="text-center">1</td>
            <td>~~~제목입니다~~~~</td>
            <td class="text-center">작성자</td>
            <td class="text-center">5</td>
          </tr>
          <tr>
            <td class="text-center">1</td>
            <td>~~~제목입니다~~~~</td>
            <td class="text-center">작성자</td>
            <td class="text-center">5</td>
          </tr>
          <tr>
            <td class="text-center">1</td>
            <td>~~~제목입니다~~~~</td>
            <td class="text-center">작성자</td>
            <td class="text-center">5</td>
          </tr>
        </tbody>
      </v-simple-table>

      <v-pagination v-model="page" :length="4" circle></v-pagination>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      page: 1,
    };
  },
};
</script>

<style></style>

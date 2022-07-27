<template>
  <v-simple-table class="grey lighten-3" height="500px">
    <tbody claa="">
      <tr>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>교육청</td>
        <td>{{ facility.eduoffice }}</td>
      </tr>

      <tr>
        <td>분류</td>
        <td>{{ facility.type }}</td>
      </tr>

      <tr>
        <td>대표자</td>
        <td>{{ facility.director }}</td>
      </tr>

      <tr>
        <td>전화번호</td>
        <td>{{ facility.contactnumber }}</td>
      </tr>

      <tr>
        <td>홈페이지</td>
        <td>
          <a :href="facility.website">{{ facility.website }}</a>
        </td>
      </tr>

      <tr>
        <td>운영시간</td>
        <td>{{ facility.operationtime }}</td>
      </tr>
      <tr>
        <td>정원</td>
        <td>{{ facility.maxnum }}</td>
      </tr>

      <tr>
        <td>주소</td>
        <td>{{ facility.address }}</td>
      </tr>
      <tr>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </v-simple-table>
</template>

<script>
export default {
  props: {
    facility: Object,
  },
};
</script>

<style scoped>
td {
  font-weight: bolder;
}
</style>

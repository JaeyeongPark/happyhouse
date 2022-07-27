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
        <td>전화번호</td>
        <td>{{ facility.contactnumber }}</td>
      </tr>

      <tr>
        <td>홈페이지</td>
        <td v-if="facility.website">
          <a :href="facility.website">{{ facility.website }}</a>
        </td>
        <td v-else>-</td>
      </tr>

      <tr>
        <td>전체학생 수</td>
        <td>
          {{ facility.studentnum }}
        </td>
      </tr>
      <tr>
        <td>남학생 수</td>
        <td>{{ facility.boynum }}</td>
      </tr>

      <tr>
        <td>여학생 수</td>
        <td>{{ facility.girlnum }}</td>
      </tr>
      <tr>
        <td>개교기념일</td>
        <td>{{ facility.anniversary }}</td>
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

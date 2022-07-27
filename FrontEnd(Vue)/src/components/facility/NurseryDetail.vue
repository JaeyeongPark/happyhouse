<template>
  <v-simple-table class="grey lighten-3" height="500px">
    <tbody claa="">
      <tr>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>종류</td>
        <td>{{ facility.type }}</td>
      </tr>

      <tr>
        <td>운영여부</td>
        <td>{{ facility.operation }}</td>
      </tr>

      <tr>
        <td>주소</td>
        <td>{{ facility.address }}</td>
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
        <td>교실 수</td>
        <td>{{ facility.roomcnt }}</td>
      </tr>
      <tr>
        <td>놀이터 수</td>
        <td>{{ facility.playground }}</td>
      </tr>

      <tr>
        <td>교사 수</td>
        <td>{{ facility.teacher }}</td>
      </tr>
      <tr>
        <td>정원</td>
        <td>{{ facility.maxnum }}</td>
      </tr>
      <tr>
        <td>버스 운영여부</td>
        <td>{{ facility.bus }}</td>
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

<template>
  <v-simple-table class="grey lighten-3" height="500px">
    <tbody claa="">
      <tr>
        <td></td>
        <td></td>
      </tr>
      <tr>
        <td>분류</td>
        <td>{{ facility.type }}</td>
      </tr>
      <tr>
        <td>도로폭</td>
        <td v-if="facility.roadlength">{{ facility.roadlength }}</td>
        <td v-else>-</td>
      </tr>

      <tr>
        <td>CCTV 여부</td>
        <td>{{ facility.cctv }}</td>
      </tr>
      <tr>
        <td>CCTV 개수</td>
        <td v-if="facility.cctvcnt">{{ facility.cctvcnt }}</td>
        <td v-else>-</td>
      </tr>
      <tr>
        <td>관할 경찰서</td>
        <td>{{ facility.police }}</td>
      </tr>
      <tr>
        <td>관리 기관</td>
        <td>{{ facility.management }}</td>
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

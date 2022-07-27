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
        <td>면적</td>
        <td>{{ facility.area }}</td>
      </tr>
      <tr>
        <td>체육시설</td>
        <td v-if="facility.sportsfacility">{{ facility.sportsfacility }}</td>
        <td v-else>-</td>
      </tr>
      <tr>
        <td>놀이시설</td>
        <td v-if="facility.usementfacility">{{ facility.usementfacility }}</td>
        <td v-else>-</td>
      </tr>
      <tr>
        <td>편의시설</td>
        <td v-if="facility.convenfacility">{{ facility.convenfacility }}</td>
        <td v-else>-</td>
      </tr>
      <tr>
        <td>교양시설</td>
        <td v-if="facility.edufacility">{{ facility.edufacility }}</td>
        <td v-else>-</td>
      </tr>
      <tr>
        <td>기타시설</td>
        <td v-if="facility.etcfacility">{{ facility.etcfacility }}</td>
        <td v-else>-</td>
      </tr>

      <tr>
        <td>전화번호</td>
        <td v-if="facility.contactnumber">{{ facility.contactnumber }}</td>
        <td v-else>-</td>
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

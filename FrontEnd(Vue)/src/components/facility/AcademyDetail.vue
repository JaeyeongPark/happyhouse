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
        <td>운영상태</td>
        <td>{{ facility.state }}</td>
      </tr>

      <tr>
        <td>교과 분류</td>
        <td>{{ facility.edutype }}</td>
      </tr>
      <tr>
        <td>교과 상세</td>
        <td v-if="facility.edulist">{{ facility.edulist }}</td>
        <td v-else>{{ facility.edudetail }}</td>
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

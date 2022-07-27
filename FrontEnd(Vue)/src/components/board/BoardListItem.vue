<template>
  <tr class="text-center">
    <td>{{ article.boardno }}</td>
    <!-- <th class="text-center"><v-divider vertical></v-divider></th> -->
    <td>
      <router-link
        :to="{ name: 'boarddetail', params: { no: article.boardno } }"
        >{{ article.subject }}</router-link
      >
    </td>
    <!-- <td><v-divider vertical></v-divider></td> -->
    <td>{{ article.id }}</td>

    <!-- <td><v-divider vertical></v-divider></td> -->

    <td v-if="article.dongName">
      {{ article.sidoName }} {{ article.gugunName }} {{ article.dongName }}
    </td>
    <td v-else>-</td>

    <!-- <td><v-divider vertical></v-divider></td> -->

    <td v-if="article.category == 'kinder'">유치원</td>
    <td v-else-if="article.category == 'nursery'">어린이집</td>
    <td v-else-if="article.category == 'school'">초등학교</td>
    <td v-else-if="article.category == 'park'">공원</td>
    <td v-else-if="article.category == 'academy'">학원</td>
    <td v-else-if="article.category == 'protectionzone'">어린이보호구역</td>
    <td v-else>-</td>

    <!-- <td><v-divider vertical></v-divider></td> -->
    <td v-if="article.categoryvalue">{{ article.categoryvalue }}</td>
    <td v-else>-</td>
  </tr>
</template>

<script>
export default {
  props: {
    article: Object,
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}
</style>

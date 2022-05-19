<template>
  <tr>
    <td>{{ article.no }}</td>
    <td>
      <router-link :to="{ name: 'detail', params: { no: article.no } }">{{
        article.subject
      }}</router-link>
    </td>
    <td>{{ article.id }}</td>
    <td>{{ article.search }}</td>
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

<script setup lang="ts">

defineProps<{
  note: {
    id: number,
    title: string,
    caption: string,
    createDate: string
  }
}>()

function formatDate(date: string) {
  return new Date(date).toLocaleDateString()
}
</script>

<template>
  <div class="border-pink-500 border rounded p-4 shadow-lg hover:shadow-pink-300 cursor-pointer hover:-translate-y-1">
    <h3 class="text-lg text-pink-800 line-clamp-1">{{ note.title }}</h3>
    <hr class="text-pink-500 py-2">
    <p class="mb-3 text-pink-700 line-clamp-2">{{ note.caption }}</p>
    <span class="text-sm text-pink-400 line-clamp-1">{{ formatDate(note.createDate) }}</span>
  </div>
</template>
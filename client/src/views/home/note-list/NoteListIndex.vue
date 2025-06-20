<script setup lang="ts">
import NoteCard from "@/views/home/note-list/components/NoteCard.vue";
import {onMounted, ref} from "vue";
import axiosInstance from "@/axiosInstance.ts";

type Note = {
  id: number
  title: string
  caption: string
  createDate: string
}

const notes = ref<Note[]>([])

onMounted(async () => {
  try {
    const response = await axiosInstance.get("/notes", {
      params: {
        ownerId: 1
      }
    })
    notes.value = response.data
  } catch (err) {
    console.error('Failed to load notes: ', err)
  }
})

</script>

<template>
  <section class="h-screen bg-pink-50">
    <header class="bg-pink-100">
      <div class=" py-5 w-[90%] mx-auto">
        <div class="text-2xl text-pink-500">Spring Note</div>
      </div>
    </header>
    <main class="grid gap-4 grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 w-[90%] mx-auto mt-5" v-if="notes.length > 0">
      <NoteCard
          v-for="note in notes"
          :key="note.id"
          :note="note"
      />
    </main>
    <main class="m-10 flex items-center justify-center" v-else>
      <h3 class="text-2xl text-pink-700">No notes yet.</h3>
    </main>
  </section>
</template>

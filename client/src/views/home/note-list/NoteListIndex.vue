<script setup lang="ts">
import NoteCard from "@/views/home/note-list/components/NoteCard.vue";
import {onMounted, ref} from "vue";
import axiosInstance from "@/axiosInstance.ts";
import NewNoteDialog from "@/views/home/note-list/components/NewNoteDialog.vue";
import {useRouter} from "vue-router";

type Note = {
  id: number
  title: string
  caption: string
  createDate: string
}

const notes = ref<Note[]>([])
const showDialog = ref(false)
const router = useRouter()

async function fetchNotes() {
  const res = await axiosInstance.get("/notes", {params: {ownerId: 1}})
  notes.value = res.data
}

function addNote(note: { title: string; caption: string }) {
  axiosInstance
      .post("/notes/create", {
        ownerId: 1,
        title: note.title,
        caption: note.caption
      })
      .then(fetchNotes)
      .catch(error => console.log(error))
      .finally(() => {
            showDialog.value = false
          }
      )
}

function logout() {
  localStorage.clear()

  // NOTES:
  // Navigates to /login
  // Replaces current history (no "back" to home after logout)
  // Clears any stored auth/session info
  router.replace({name: 'login'})
}

onMounted(fetchNotes)

</script>

<template>
  <section class="h-screen bg-pink-50">
    <header class="bg-pink-100">
      <div class=" py-5 w-[90%] mx-auto flex justify-between items-center">
        <div class="text-2xl text-pink-500">Spring Note</div>
        <button @click="logout" type="button">
          Logout
        </button>
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

    <div class="fixed bottom-6 right-6 z-50">
      <button
          @click="showDialog = true"
          class="bg-pink-500 hover:bg-pink-600 text-pink-50 font-semibold py-3 px-6 rounded-sm shadow-lg transition">
        NEW
      </button>
    </div>
    <NewNoteDialog v-if="showDialog" @close="showDialog = false" @submit="addNote"/>
  </section>
</template>

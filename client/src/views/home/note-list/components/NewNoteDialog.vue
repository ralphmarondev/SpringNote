<script setup lang="ts">
import {ref} from "vue";

const emit = defineEmits(['close', 'submit'])

const title = ref('')
const caption = ref('')

function submitForm() {
  emit('submit', {
    title: title.value,
    caption: caption.value
  })
  title.value = ''
  caption.value = ''
}
</script>

<template>
  <div
      class="fixed inset-0 bg-pink-800 flex items-center justify-center z-50"
      @click.self="emit('close')"
  >
    <div class="bg-white rounded-lg shadow-lg w-[90%] max-w-md p-6">
      <h2 class="text-xl font-semibold text-pink-500 mb-4">Create New Note</h2>
      <form @submit.prevent="submitForm">
        <input
            v-model="title"
            type="text"
            placeholder="Title"
            class="w-full p-2 mb-3 border rounded"
            required
        />
        <textarea
            v-model="caption"
            placeholder="Caption"
            class="w-full p-2 mb-3 border rounded resize-none"
            required
        />
        <div class="flex justify-end gap-2">
          <button
              type="button"
              @click="emit('close')"
              class="text-gray-500 hover:text-gray-800"
          >
            Cancel
          </button>
          <button
              type="submit"
              class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600"
          >
            Save
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

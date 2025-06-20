<script setup lang="ts">
import {ref} from "vue";
import axiosInstance from "@/axiosInstance.ts";
import {useRouter} from "vue-router";

const email = ref('')
const password = ref('')

const router = useRouter()

const login = async () => {
  console.log(`Email: ${email.value}, Password: ${password.value}`)
  const data = {
    email: email.value,
    password: password.value
  }
  axiosInstance.post("/users/login", data)
      .then(res => {
        console.log(res)
        router.push("/note-list")
      })
      .catch(err => {
        console.log('Login error:', err.response?.data || err.message)
      })
}
</script>

<template>
  <section class="h-screen bg-pink-50 flex items-center justify-center">
    <form @submit.prevent="login" class="border shadow-2xl w-[400px] p-6 rounded-sm border-pink-500">
      <h3 class="text-2xl text-pink-600 font-bold mb-5">Spring Note</h3>

      <div class="group flex flex-col mb-3">
        <label for="email" class="text-pink-800 mb-1">Email:</label>
        <input type="email" name="email" placeholder="Enter email" class="bg-pink-100 py-2 px-4 text-pink-800 " required
               v-model="email">
      </div>
      <div class="group flex flex-col mb-8">
        <label for="password" class="text-pink-800 mb-1">Password:</label>
        <input type="password" name="password" placeholder="Enter password" class="bg-pink-100 py-2 px-4 text-pink-800"
               required
               v-model="password">
      </div>

      <button
          type="submit"
          class="bg-pink-400 hover:bg-pink-500 cursor-pointer w-full p-2 rounded-md uppercase text-pink-50 font-semibold">
        Login
      </button>

      <div class="my-5 flex justify-between">
        <hr>
        <span class="text-sm text-pink-800">OR</span>
        <hr>
      </div>

      <RouterLink
          to="/register"
          class="bg-pink-200 hover:bg-pink-300 cursor-pointer block w-full text-center p-2 rounded-md uppercase text-pink-500 font-semibold">
        CREATE NEW ACCOUNT
      </RouterLink>
    </form>
  </section>
</template>
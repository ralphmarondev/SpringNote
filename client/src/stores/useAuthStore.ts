import {defineStore} from "pinia";

export const useAuthStore = defineStore("auth", {
  state: () => ({
    accessToken: localStorage.getItem("accessToken") as string | null,
    refreshToken: localStorage.getItem("refreshToken") as string | null,
  }),
  actions: {
    setTokens(access: string, refresh: string) {
      this.accessToken = access;
      this.refreshToken = refresh;
      localStorage.setItem("accessToken", access);
      localStorage.setItem("refreshToken", refresh);
    },
    clearTokens() {
      this.accessToken = null
      this.refreshToken = null
      localStorage.removeItem("accessToken")
      localStorage.removeItem("refreshToken")
    }
  }
})


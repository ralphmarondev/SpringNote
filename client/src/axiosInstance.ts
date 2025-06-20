import axios from 'axios'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8765/api',
  headers: {
    'Content-Type': 'application/json'
  },
  withCredentials: true
})

export default axiosInstance
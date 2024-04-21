import { fetchData, postData } from '@/http-common'

export default {
  async login(data) {
    return postData('login', data)
  }
}

import { fetchData, postData } from '@/http-common'

export default {
  async login(username, pass) {
    return postData('login', {
      username: username,
      password: pass
    })
  }
}

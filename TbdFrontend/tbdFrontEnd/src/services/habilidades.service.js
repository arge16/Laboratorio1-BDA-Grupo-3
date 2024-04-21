import { fetchData } from '@/http-common'

export default {
  async getHabilidades() {
    return fetchData('habilidad')
  }
}

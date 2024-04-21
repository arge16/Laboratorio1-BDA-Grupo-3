import { fetchData } from '@/http-common'

export default {
  async getTareas() {
    return fetchData('tarea')
  },
  async getTareaById(id) {
    return
  }
}

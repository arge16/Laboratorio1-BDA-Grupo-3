import { fetchData, postData, putData } from '@/http-common'

export default {
  async getTareas() {
    return fetchData('tarea')
  },
  async getTareaById(id) {
    return fetchData(`tarea/id?id=${id}`)
  },
  async getHabilidadesByTarea(id) {
    return fetchData(`habilidad/byTarea?id=${id}`)
  },
  async putHabilidadUpdate(body) {
    return putData('tarea', body)
  },
  async addHabilidades(id, habilidades) {
    return putData(`tarea/addHabilidades?id_tarea=${id}`, habilidades)
  }
}

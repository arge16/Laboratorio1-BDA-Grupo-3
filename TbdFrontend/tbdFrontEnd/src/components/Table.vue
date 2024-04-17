<script>
export default {
  data() {
    return {
      tareas: [],
      items3: [
        'Opción Final 1',
        'Opción Final 2',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3',
        'Opción Final 3'
      ],
      columna2Visible: false,
      columna3Visible: false,
      itemSeleccionado1: null,
      itemSeleccionado2: null,
      itemSeleccionado3: null
    }
  },
  methods: {
    seleccionarItem(columna, index, item) {
      if (columna === 1) {
        this.itemSeleccionado1 = index
        this.columna2Visible = true
        this.itemSeleccionado2 = null
        this.columna3Visible = false
        tareasService.getTareas().then((response) => {
          const temporal = []
          //console.log(item.id + ' ' + response)
          response.forEach((element) => {
            if (element.emergencia_id == item.id) {
              temporal.push(element)
              //console.log(element)
            }
          })
          this.tareas = temporal
        })
      } else if (columna === 2) {
        this.itemSeleccionado2 = index
        this.columna3Visible = true
        this.itemSeleccionado3 = null
      } else {
        this.itemSeleccionado3 = index
      }
    },
    handleBack(columna) {
      if (columna === 1) {
        this.columna2Visible = false
        this.columna3Visible = false
        this.itemSeleccionado1 = null
      } else if (columna === 2) {
        this.columna2Visible = true
        this.columna3Visible = false
        this.itemSeleccionado2 = null
      }
    }
  }
}
</script>

<script setup>
import emergenciasService from '@/services/emergencias.service'
import tareasService from '@/services/tareas.service'
import { ref } from 'vue'
const emergencias = ref([])
emergenciasService.getEmergencias().then((response) => {
  emergencias.value = response
})
</script>

<template>
  <div class="row">
    <div class="col" :style="{ maxWidth: columna2Visible ? '300px' : '' }">
      <div class="card">
        <div class="card-header">
          <h3 class="card-title" @click="handleBack(1)">Emergencias</h3>
        </div>
        <div class="card-body mb-4 mt-2">
          <table class="table table-bordered">
            <thead class="sticky-top bg-white">
              <tr class>
                <th class="idCol">ID</th>
                <th>Nombre</th>
                <th v-if="!columna2Visible">Estado</th>
              </tr>
            </thead>
            <tbody class="scroll">
              <tr
                v-for="(item, index) in emergencias"
                :key="index"
                @click="seleccionarItem(1, index, item)"
                :class="{ 'table-primary': itemSeleccionado1 === index }"
              >
                <th class="idCol">{{ item.id }}</th>
                <td>{{ item.name }}</td>
                <td v-if="!columna2Visible">{{ item.estado }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <transition name="bounce">
      <div class="col" v-if="columna2Visible" :style="{ maxWidth: columna3Visible ? '300px' : '' }">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title" @click="handleBack(2)">Tareas</h3>
          </div>
          <div class="card-body">
            <table class="table scroll table-bordered">
              <thead>
                <tr>
                  <th class="idCol">ID</th>
                  <th>Nombre</th>
                  <th v-if="!columna3Visible">Cantidad voluntarios</th>
                  <th v-if="!columna3Visible">Estado</th>
                </tr>
              </thead>
              <tbody class="scroll">
                <tr
                  v-for="(tarea, index) in tareas"
                  :key="index"
                  @click="seleccionarItem(2, index)"
                  :class="{ 'table-primary': itemSeleccionado2 === index }"
                >
                  <th class="idCol" scope="row">{{ tarea.id }}</th>
                  <td>{{ tarea.nombre }}</td>
                  <td v-if="!columna3Visible">{{ tarea.cantidadVol }}</td>
                  <td v-if="!columna3Visible">{{ tarea.estado }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </transition>
    <transition name="bounce">
      <div class="col a" v-if="columna3Visible">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">Voluntarios</h3>
          </div>
          <div class="card-body">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th class="idCol">RUT</th>
                  <th>Nombre</th>
                  <th>Participa</th>
                </tr>
              </thead>
              <tbody class="scroll">
                <tr v-for="(item, index) in items3" :key="index" @click="seleccionarItem(3, index)">
                  <th class="idCol" scope="row">{{ index + 1 }}</th>
                  <td>{{ item }}</td>
                  <td></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.idCol {
  width: 50px;
  text-align: end;
}

.card {
  z-index: 0;
  margin: 'auto';
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
}

.col {
  max-width: 30rem;
}

.scroll {
  max-height: 35vh;
  overflow-y: auto;
  display: block;
}

.card-header {
  background-color: #243346;
  text-align: center;
  color: white;
}

tr {
  display: table;
  width: 100%;
  table-layout: fixed;
}

.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  75% {
    transform: scale(1.3);
  }
  100% {
    transform: scale(1);
  }
}
</style>

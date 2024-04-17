<script>
export default {
  data() {
    return {
      items1: ['Opción 1', 'Opción 2', 'Opción 3'],
      items2: ['Sub-Opción 1', 'Sub-Opción 2', 'Sub-Opción 3'],
      items3: ['Opción Final 1', 'Opción Final 2', 'Opción Final 3'],
      columna2Visible: false,
      columna3Visible: false,
      itemSeleccionado1: null,
      itemSeleccionado2: null,
      itemSeleccionado3: null
    }
  },
  methods: {
    seleccionarItem(columna, index) {
      if (columna === 1) {
        this.itemSeleccionado1 = index
        this.columna2Visible = true
        this.itemSeleccionado2 = null
        this.columna3Visible = false
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

<template>
  <div class="row">
    <div class="col">
      <div class="card">
        <div class="card-header">
          <h3 class="card-title" @click="handleBack(1)">Emergencias</h3>
        </div>
        <div class="card-body">
          <table class="table table-bordered">
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th v-if="!columna2Visible">Estado</th>
              </tr>
            </thead>
            <tbody>
              <tr
                v-for="(item, index) in items1"
                :key="index"
                @click="seleccionarItem(1, index)"
                :class="{ 'table-primary': itemSeleccionado1 === index }"
              >
                <th scope="row">{{ index + 1 }}</th>
                <td>{{ item }}</td>
                <td v-if="!columna2Visible">{{ item }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <transition name="bounce">
      <div class="col" v-if="columna2Visible">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title" @click="handleBack(2)">Tareas</h3>
          </div>
          <div class="card-body">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Nombre</th>
                  <th v-if="!columna3Visible">Cantidad voluntarios</th>
                  <th v-if="!columna3Visible">Estado</th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(item, index) in items2"
                  :key="index"
                  @click="seleccionarItem(2, index)"
                  :class="{ 'table-primary': itemSeleccionado2 === index }"
                >
                  <th scope="row">{{ index + 1 }}</th>
                  <td>{{ item }}</td>
                  <td v-if="!columna3Visible">{{ item }}</td>
                  <td v-if="!columna3Visible">{{ item }}</td>
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
                  <th>RUT</th>
                  <th>Nombre</th>
                  <th>Participa</th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(item, index) in items3"
                  :key="index"
                  @click="seleccionarItem(3, index)"
                  class="table"
                >
                  <th scope="row">{{ index + 1 }}</th>
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

<style>
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

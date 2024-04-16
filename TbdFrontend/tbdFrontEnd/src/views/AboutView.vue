<script setup>
import NavBar from '@/components/NavBar.vue'
import Multiselect from '@vueform/multiselect'
import { ref } from 'vue'
let data = ref({
  nombre: '',
  emergencia: '',
  habilidades: []
})
const submitForm = () => {
  console.log('Form submitted:', data.value)
}
</script>

<template>
  <NavBar></NavBar>
  <div class="container paper">
    <div class="row d-flex justify-content-center">
      <div class="col-12 align-content-center title h4">Ingreso de tareas</div>
    </div>
    <div class="container d-grid tarea align-content-around pb-5">
      <div class="mb-3 col">
        <label for="name" class="">Descripcion de la tarea:</label>
        <input type="text" class="form-control" id="name" v-model="data.nombre" />
      </div>
      <div>
        <label for="name" class="col">Seleccione la emergencia</label>
        <Multiselect v-model="data.emergencia" :options="['Batman', 'Robin', 'Joker']" />
      </div>
      <div>
        <label for="name" class="mt-3 col">Seleccione las habilidades asociadas</label>
        <Multiselect
          v-model="data.habilidades"
          mode="tags"
          :close-on-select="false"
          :searchable="true"
          :create-option="false"
          :options="[
            { value: 'batman', label: 'Batman' },
            { value: 'robin', label: 'Robin' },
            { value: 'joker', label: 'Joker' },
            { value: 'Dog', label: 'Dog' },
            { value: 'Cat', label: 'Cat' }
          ]"
        />
      </div>
      <div class="row">
        <button type="submit" class="btn submit btn-primary mt-3">Crear tarea</button>
      </div>
    </div>
  </div>
</template>

<style src="@vueform/multiselect/themes/default.css"></style>

<style scoped>
.paper {
  overflow: visible;
  background-color: rgba(255, 255, 255, 1);
  width: 40vw;
  height: 60vh;
  border-radius: 25px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
}
.title {
  width: 50%;
  height: 50px;
  margin-top: -5%;
  margin-left: -40%;
  background-color: #243346;
  color: white;
  text-align: center;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
}

.container.tarea {
  height: 100%;
}

.multiselect {
}

.submit {
  background-color: #243346;
  border-color: #243346;
  &:hover {
    filter: brightness(150%);
  }
}
</style>

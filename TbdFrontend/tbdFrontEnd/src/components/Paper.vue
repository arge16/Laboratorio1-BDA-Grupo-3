<script setup>
import { onBeforeMount, onBeforeUnmount } from 'vue'
onBeforeMount(() => {
  document.body.classList = 'login'
})

onBeforeUnmount(() => {
  document.body.classList = ''
})
</script>

<template>
  <div class="container d-flex justify-content-around">
    <div class="row">
      <div class="column pt-4 d-flex text-center justify-content-center align-items-center">
        <div class="backPaper h2 voluTitle">Voluntariados</div>
      </div>
      <div class="column d-flex align-items-center justify-content-center">
        <div class="form-group">
          <label class="h4 mx-1 nameInput" for="exampleFormControlInput1">Nombre de usuario</label>
          <input
            type="username"
            class="form-control form-control-lg"
            id="exampleFormControlInput1"
          />
        </div>
      </div>
      <div class="column d-flex align-items-center justify-content-center">
        <div class="form-group">
          <label class="h4 mx-1 nameInput" for="exampleFormControlInput1">Contraseña</label>
          <input
            type="password"
            class="form-control form-control-lg"
            id="exampleFormControlInput1"
          />
        </div>
      </div>
      <div class="column pb-4 d-flex align-items-center justify-content-center">
        <button type="button" class="btn btn-primary btn-lg btn-block">Ingresar</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  background-color: rgba(33, 33, 33, 0.2);
  width: 35vw;
  height: 70vh;
  border-radius: 25px;
}
.backPaper {
  padding: 2% 3%;
  background-color: white;
  border-radius: 8px;
}
.nameInput {
  color: white;
  font-weight: 200;
}

.form-control-lg {
  width: 20rem;
}
.btn-primary {
  color: white;
  background-color: #243346;
  border: 0;
  font-size: x-large;
  &:hover {
    filter: brightness(120%);
  }
}
.voluTitle {
  font-weight: 350;
  letter-spacing: 2px;
}
</style>

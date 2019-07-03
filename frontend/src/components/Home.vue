<template>
<div>
    <Navigation></Navigation>
    <div style="height: 100vh">
    <div class="flex-center flex-column">

      <h1 class="text-hide animated fadeIn mb-4"
        style="background-image: url('@/assets/clound.png'); width: 250px; height: 90px;">
        MDBootstrap</h1>
      <h5 class="animated fadeIn mb-3">This is PersonalProject</h5>

      <p class="animated fadeIn text-muted">Developer WonJungHo</p>
    </div>
  </div>
    <Foot></Foot>
</div>
</template>

<script>
  import Navigation from '@/components/common/Navigation.vue'
  import Foot from '@/components/common/Foot.vue'
export default {
  name: 'Home',
  data () {
    return {
      
    }
  },
  components:{
    Navigation,
    Foot
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>

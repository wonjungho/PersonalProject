<template>
<div>
    <Navigation></Navigation>
<div class="container">
    <button class="btn btn-primary btn-lg"><router-link to="/boardwrite" style="color:white">write</router-link></button>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">제목</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(board,index) in list" :key="board.bno" @click="detail(board)" >
      <th scope="row">{{index+1}}</th>
      <td>{{board.title}}</td>
    </tr>
  </tbody>
</table>
</div>
<Foot></Foot>
</div>
</template>
<script>
import Navigation from '@/components/common/Navigation.vue'
import Foot from '@/components/common/Foot.vue'
import {boards} from '@/api/api'
export default {
    data(){
        return{
          list:[]
        }
    },
    components:{
        Navigation,Foot

    },
    methods:{
      detail(board){
        this.$router.push('/boarddetail/'+board.bno)
      }
    },
    created:function(){
      boards.findall().then(res=>{
        this.list =res
      })
    }
    
}
</script>
<style scoped>

</style>

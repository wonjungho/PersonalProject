<template>
<div>
<Navigation></Navigation>
<div class="container">
<h1>글번호 {{id}}</h1>
<h2>
    Title : {{board.title}}
</h2>
<div>
    <label for="content">Content</label>
    <p id="content">{{board.content}}</p>
</div>
<div>
    <button class="btn btn-info" @click="modify()">modify</button><button class="btn btn-danger" @click="del()">delete</button>
</div>
</div>
<Foot></Foot>    
</div> 
</template>
<script>
import Navigation from '@/components/common/Navigation.vue'
import Foot from '@/components/common/Foot.vue'
import {boards} from '@/api/api'
export default {
    name:'BoardDetail',
    props:['id'],
    data(){
        return{
            board:{
                title:'',
                content:''
            },
            context:'/board'
        }
    },
    components:{
        Navigation,Foot
    },
     beforeRouteEnter (to,from,next){
         boards.get(to.params.id).then((res)=>{
             next(vm =>{
                 vm.board =res
             })
         }).catch((e)=>{
             next(false)
         })
     },
     watch:{
         '$route':function (from,to){
             this.init()
         }
     },
     methods:{
         init(){
             boards.get(this.bno).then((res)=>{
                 this.board =res.data
             })
             .catch((e)=>{
                 alert('ERROR')
             })
         },
         modify(){
             this.$router.push('/boardmodify/'+this.id)
         },
         del(){
             boards.del(this.id).then(()=>{
                 this.$router.push('/boardlist')
             })
         }
     }
    
    
}
</script>
<style scoped>

</style>

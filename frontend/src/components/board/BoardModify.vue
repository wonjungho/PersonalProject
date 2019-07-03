<template>
<div>
<Navigation></Navigation>
<div class="container">
    <!-- <form> -->
        <div class="form-group">
        <label for="inputPrefilledEx">No.</label>
        <p>{{id}}</p>
        </div>
        <div class="form-group">
        <label for="inputPrefilledEx">Title</label>
        <input type="text" id="inputPrefilledEx" class="form-control" v-model="title">
        </div>
        <div class="form-group">
        <label for="exampleFormControlTextarea3">Content</label>
        <textarea class="form-control" id="exampleFormControlTextarea3" rows="7" v-model="content"></textarea>
        </div>
        <div class="form-group">
        <button  class="btn btn-primary" @click="proc">완료</button>
        </div>
    <!-- </form> -->
</div>
<Foot></Foot>
</div>
</template>
<script>
import Navigation from '@/components/common/Navigation.vue'
import Foot from '@/components/common/Foot.vue'
import {boards} from '@/api/api'
import axios from 'axios'
export default {
    name:'BoardModify',
    props:['id'],
    data(){
        return{
                title:'',
                content:'',
            list:[]
        }
    },
    components:{
        Navigation,Foot

    },
    created: function(){
        boards.get(this.id).then((res) =>{
                this.title =res.title
                this.content =res.content
        })
    },
    methods:{
        proc(e){
            e.preventDefault();
            alert('클릭')
            let data={
                title:this.title,
                content:this.content
            }
             let header={
                 'Content-Type':'application/json',
                'Authorization':'JWT fefege..'
             }
            axios.put('/board/'+this.id,data,{headers:header})
            .then(res=>{
                alert('된다!')
                this.$router.push("/boardlist")
            }).catch(e=>{
                alert('안된다!')
            })
        }
    }
    
}
</script>
<style scoped>

</style>

<template>
<div>
<Navigation></Navigation>
<div class="container">
    <form @submit.prevent="save">
        <div class="form-group">
        <label for="title">Title</label>
        <input type="text" id="title" class="form-control" v-model="title">
        </div>
        <div class="form-group">
        <label for="content">Content</label>
        <textarea class="form-control" id="content" rows="12" v-model="content"></textarea>
        </div>
        <div class="form-group">
        <button type="submit" class="btn btn-primary">완료</button>
        </div>
    </form>
</div>
<Foot></Foot>
</div>
</template>
<script>
import Navigation from '@/components/common/Navigation.vue'
import Foot from '@/components/common/Foot.vue'
import axios from 'axios'
export default {
    data(){
        return{
            title:'',
            content:'',
            context:'/board'
        }
    },
    components:{
        Navigation,Foot

    },
    methods:{
        save(){
            let data={
                title:this.title,
                content:this.content
            }
             let header={
                 'Content-Type':'application/json',
                'Authorization':'JWT fefege..'
             }
             axios.post(`${this.context}`,data,{headers:header})
             .then(res=>{
                 alert(`게시글작성성공! ${res.result}`)
                 this.$router.push("/boardlist")
             })
             .catch(e=>{
                 alert('ERROR')
                 this.$router.link(-1);
             })
        }
    }
    
}
</script>
<style scoped>

</style>

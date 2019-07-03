import axios from 'axios'

const url ='/board'

let boards={
    baseURL:`${url}`,
    findall:function(){
        return axios.get(boards.baseURL).then((res)=>res.data)
    },
    get:function(id){
        return axios.get(boards.baseURL+'/'+id).then((res)=>res.data)
    },
    del:function(id){
        return axios.delete(boards.baseURL+'/'+id)
    }
}
export{boards}
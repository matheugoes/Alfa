<template>
    <div> 
        <home-page-professor :key="getUserType" v-if="getUserType=='teacher'"/>
        <home-page-aluno :key="getUserType" v-if="getUserType=='student'"/>
    </div> 
</template>

<script>
import HomePageProfessor from "./HomePageProfessor.vue"
import HomePageAluno from "./HomePageAluno.vue"
import {mapGetters} from "vuex"
export default {
    components: {HomePageProfessor, HomePageAluno},
    computed: {
        ...mapGetters(["getUserType"])
    }
}
</script>

<template>
    <b-container class="loginPage">
        <b-row class="h-100 text-center" align-v="center"> 
            <b-row align-h="center">
                <logo class="mb-2" />
                <card icon="icon-right" @click="student" title="Sou aluno(a)" description="Gostaria de me alfabetizar com a ajuda de um(a) professor(a) através do aplicativo alfa"/>
                <card icon="icon-right" @click="teacher" title="Sou professor(a)" description="Gostaria de ajudar alunos(as) a se alfabetizarem com a ajuda do aplicativo alfa"/>
            </b-row>
        </b-row>
    </b-container>
    
</template>

<script>
    import Logo from "../components/Logo.vue"
    import Card from "../components/Card.vue"
    import { mapMutations } from "vuex"

    export default {
        components: {Logo, Card}, 
        methods: {
        ...mapMutations(["setPageName", "setBackUrl"]),
        student() {
            this.$router.push('/signup/student')
        },
        teacher() {
            this.$router.push('/signup/teacher')
        }
        },
        beforeMount(){
            this.setPageName("Cadastro");
            this.setBackUrl("/");
        }

    }
</script>

<style scoped>

</style>
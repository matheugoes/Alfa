<template>
    <b-container class="welcome">
        <b-row class="vh-100 text-center" align-v="center">
            <b-row align-h="center">
                <logo class="my-4"/>
                <h1>Você foi convidado para entrar em <span class="color my-4">{{this.classData.className}}</span> do professor(a) <span class="color my-4">{{this.classData.teacherName}}</span>.</h1>
                <primary-button @click="accept" class="signup mt-4" text="Aceitar"/>
                <text-button @click="recuse" class="mt-2" textButton="Recusar"/>
            </b-row>
        </b-row>
    </b-container>
</template>

<script>
    import Logo from "../components/Logo.vue"
    import PrimaryButton from '../components/buttons/PrimaryButton.vue'
    import TextButton from '../components/buttons/TextButton.vue'
    
    export default {
        components: {Logo, PrimaryButton, TextButton}, 
        data(){
            let classData = Buffer.from(this.$route.params.classData, 'base64');
            return {classData: JSON.parse(classData)}
        },
        methods: {
            accept(){
                this.$router.push("/signup/student/"+this.classData.classId)
            },
            recuse(){
                this.$router.push("/")
            }
        }
    }
</script>

<style>
    h1{
        font-family: "Mulish";
        font-size: 24px;
        color: #4f4f4f;
        text-align: center;
    }

    h2{
        font-family: "Mulish";
        font-size: 22px;
        color: #4f4f4f;
        text-align: center;
    }

    .card-title{
        font-size: 30px!important;
    }

    .signup{
       height: 64px;
    }

    .color{
        color: #FF8A0C;
    }
</style>
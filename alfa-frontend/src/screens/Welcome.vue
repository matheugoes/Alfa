<template>
    <b-container class="welcome">
        <b-row class="vh-100 text-center" align-v="center">
            <b-row align-h="center">
                <logo class="my-4"/>
                <h1>Bem vindo ao <span class="color my-4">alfa</span>, o seu aplicativo de aprendizagem. </h1>
                <primary-button @click="signUp" class="signup mt-4" text="Inscrever-se"/>
                <text-button @click="forLogin" class="mt-2" textButton="Eu já possuo uma conta"/>
            </b-row>
        </b-row>
    </b-container>
</template>

<script>
    import Logo from '../components/Logo.vue'
    import PrimaryButton from '../components/buttons/PrimaryButton.vue'
    import TextButton from '../components/buttons/TextButton.vue'

    export default {
        name: 'App',
        components: {
            Logo,
            PrimaryButton,
            TextButton
        },
        methods: {
            signUp() {
                this.$router.push('/signup')
            },
            forLogin() {
                this.$router.push('/login')
            }
        }
    }
</script>

<style scoped>
    h1{
        font-family: "Mulish";
        font-size: 24px;
        color: #4f4f4f;
        text-align: center;
    }

    .signup{
       height: 64px;
    }

    .color{
        color: #FF8A0C;
    }
</style>

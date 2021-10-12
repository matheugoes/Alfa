<template>
    <b-container class="loginPage">
        <b-row class="h-100 text-center" align-v="center"> 
            <b-row align-h="center">
                <logo class="mb-4" />
                <input-component v-model="loginData.email"  class="formInput" type="text" placeholder="E-mail"></input-component>
                <input-component v-model="loginData.password" class="formInput" type="password" placeholder="Senha"></input-component>
                <primary-button class="loginBtn mt-4" @click="login" text="Entrar"/>
                <text-button @click="forgetPassword" class="forgetPasswordBtn mt-2" textButton="Esqueceu a senha?"/>
            </b-row>
        </b-row>
    </b-container>
</template>

<script>
    import PrimaryButton from "../components/buttons/PrimaryButton.vue"
    import TextButton from "../components/buttons/TextButton.vue"
    import InputComponent from "../components/Input.vue"
    import Logo from "../components/Logo.vue"
    import firebase from "firebase"
    import { mapMutations } from "vuex"
    import { mapActions } from "vuex"

    export default {
        components: {PrimaryButton, TextButton, InputComponent, Logo},
        data(){
                let loginData = {
                    email: "",
                    password: ""
                }
                return {loginData}
        },
        methods: {
            ...mapMutations(["setPageName", "setBackUrl"]),
            ...mapActions(["getUserByEmail"]),
            login(){
                firebase.auth().setPersistence(firebase.auth.Auth.Persistence.SESSION)
                .then(() => {
                    firebase
                            .auth()
                            .signInWithEmailAndPassword(this.loginData.email, this.loginData.password)
                            .then(() => {
                                this.getUserByEmail(this.loginData.email).then(() => {
                                    this.$router.push("/home")
                                })
                            })
                            .catch(error => {
                                alert(error.message);
                            });
                });
            },
            forgetPassword(){
                firebase.auth().sendPasswordResetEmail()
                console.log("Esqueci a senha");
            },
        },
      
        beforeMount(){
            this.setPageName("Entrar no aplicativo");
            this.setBackUrl("/");
        }
    }
</script>

<style scoped >
    .forgetPasswordBtn{
        text-decoration: none;
        color: var(--primary-btn-palceholder-color);
    }

    .loginBtn{
        height: 64px;
    }
    
    .formInput{
        height: 64px;
    }
</style>
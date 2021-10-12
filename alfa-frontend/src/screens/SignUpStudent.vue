<template>
    <b-container class="registrationPage">
        <b-row class="h-100 text-center" align-v="center"> 
            <b-row align-h="center">
                <logo class="mb-2" />
                <Form :questions="questions" :responses="responses" @selectChanged="onSelectChanged" @createConfirmed="createStudent"/>
            </b-row>
        </b-row>
    </b-container>
</template>

<script>
    import Logo from "../components/Logo.vue"
    import Form from "../components/Form.vue"
    import { mapActions, mapGetters, mapMutations } from "vuex"
    import firebase from "firebase"

    export default {
        components: {Logo, Form},
        data(){
            return {
                responses: {
                    name: "",
                    age: "",
                    state: null,
                    city: null,
                    gender: null,
                    race: null,
                    email: "",
                    pass: ""
                }
            };
        },
        methods:{
            ...mapMutations(["setPageName", "setBackUrl"]),
            ...mapActions(["getStates", "getCities", "createStudentAction", "registerStudentClassAction"]),
            createStudent(){
                let user = JSON.parse(JSON.stringify(this.responses));
                if(this.onClass == false){
                    console.log(this.responses);
                    this.createStudentAction(this.responses)
                    .then(() => {
                        firebase.auth().createUserWithEmailAndPassword(user.email, user.pass)
                        alert("Aluno(a) criado(a) com sucesso");
                        this.$router.push("/login")
                    })
                    .catch(error => {
                        alert("Falha ao criar o(a) aluno(a)");
                        console.log("ERROR", error);
                    })
                }else{
                    let assign = { classId: parseInt(this.$route.params.classId) };
                    this.responses = Object.assign(this.responses, assign);
                    console.log(this.responses);
                    this.registerStudentClassAction(this.responses)
                    .then(() => {
                        firebase.auth().createUserWithEmailAndPassword(user.email, user.pass)
                        alert("Aluno(a) criado(a) com sucesso");
                        this.$router.push("/login")
                    })
                    .catch(error => {
                        alert("Falha ao criar o(a) aluno(a)");
                        console.log("ERROR", error);
                    })
                }
                
            },
            onSelectChanged(name){
                if(name === "state"){
                    this.responses.city = null;
                    this.getCities(this.responses.state)
                } 
            }
        },
        computed:{
            ...mapGetters(["states", "cities"]),
            questions: function(){
                let questionsToReturn = [
                    {
                        title: 'Qual o seu nome?',
                        type: 'text',
                        name: 'name',
                    },
                    {
                        title: 'Qual a sua idade?',
                        type: 'number',
                        name: 'age',
                    },
                    {
                        title: 'Qual o seu estado?',
                        type: 'array',
                        name: 'state',
                        data: {
                            selected: null,
                            options: this.states
                        },
                    },
                    {  
                        title: 'Qual a seu cidade?',
                        type: 'array',
                        name: 'city',
                        data: {
                            selected: null,
                            options: this.cities
                        },
                    },
                    {
                        title: 'Sexo',
                        type: 'array',
                        name: 'gender',
                        data: {
                            selected: null,
                            options: [
                                { value: null, text: 'Sexo' },
                                { value: "MASCULINO", text: 'Masculino' },
                                { value: 'FEMININO', text: 'Feminino' },
                                { value: 'OUTROS', text: 'Outros' },
                                { value: 'NAO_INFORMADO', text: 'Não Informado' },
                            ]
                        }
                    },
                    {
                        title: 'Raça',
                        type: 'array',
                        name: 'race',
                        data: {
                            selected: null,
                            options: [
                                { value: null, text: 'Raça' },
                                { value: 'BRANCO', text: 'Branco' },
                                { value: 'PRETO', text: 'Preto' },
                                { value: 'PARDO', text: 'Pardo' },
                                { value: 'INDIGENA', text: 'Indígena' },
                                { value: 'AMARELA', text: 'Amarela' }
                            ]
                        }
                    },
                    {
                        title: 'Qual o seu email?',
                        type: 'text',
                        name: 'email',
                    },
                    {
                        title: 'Digite uma senha',
                        type: 'password',
                        name: 'pass',
                    },
                ];

                return questionsToReturn;
            }
        },
        beforeMount(){
            if(this.$route.params.classId == undefined){
                this.onClass = false
            }else {
                this.onClass = true
            }

            this.setPageName("Cadastro aluno(a)");
            this.setBackUrl("/signup");
            this.getStates();
            this.getCities();
        }
    }
</script>

<style>

</style>
<template>
    <b-container class="registrationPage">
        <b-row class="h-100 text-center" align-v="center"> 
            <b-row align-h="center">
                <logo class="mb-2" />
                <Form :questions="questions" :responses="responses" @selectChanged="onSelectChanged" @createConfirmed="createTeacher"/>
            </b-row>
        </b-row>
    </b-container>
</template>

<script>
    import Logo from "../components/Logo.vue"
    import Form from "../components/Form.vue"
    import { mapMutations, mapGetters, mapActions } from "vuex"
    import firebase from "firebase"

    export default {
        components: {Logo, Form},
        data() {
            return {responses: {
                name: "",
                age: "",
                state: null,
                city: null,
                gender: null,
                race: null,
                subject: null,
                education: null,
                school: null,
                eja: null,
                email: "",
                pass: "",
            }}
        },

        computed:{
            ...mapGetters(["states", "cities"]),
            questions: function(){
                let questions = [
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
                    title: 'Área de atuação',
                    type: 'array',
                    name: 'subject',
                    data: {
                        selected: null,
                        options: [
                            { value: null, text: 'Área de atuação' },
                            { value: "Ciências Humanas", text: 'Ciências Humanas' },
                            { value: "Ciências Exatas", text: 'Ciências Exatas' },
                            { value: "Ciências da Natureza", text: 'Ciências da Natureza' },
                            { value: "Linguagens", text: 'Linguagens' },
                        ]
                    }
                },
                {
                    title: 'Formação',
                    name: 'education',
                    type: 'array',
                    data: {
                        selected: null,
                        options: [
                            { value: null, text: 'Formação' },
                            { value: "Licenciatura na mesma disciplina que você leciona", text: 'Licenciatura na mesma disciplina que você leciona' },
                            { value: "Bacharelado na mesma disciplina que leciona com curso de complementação pedagógica concluído", text: 'Bacharelado na mesma disciplina que leciona com curso de complementação pedagógica concluído' },
                            { value: "Bacharelado na disciplina que leciona, sem complementação pedagógica", text: 'Bacharelado na disciplina que leciona, sem complementação pedagógica' },
                            { value: "Bacharelado em outra área, com complementação pedagógica", text: 'Bacharelado em outra área, com complementação pedagógica' },
                            { value: "Bacharelado em outra área, sem complementação pedagógica", text: 'Bacharelado em outra área, sem complementação pedagógica' },
                            { value: "Magistério e estudante de licenciatura", text: 'Magistério e estudante de licenciatura' },
                            { value: "Estudante de licenciatura", text: 'Estudante de licenciatura' },
                            { value: "Não estuda licenciatura nem possui diploma da Educação Superior", text: 'Não estuda licenciatura nem possui diploma da Educação Superior' },
                        ]
                    }
                },
                {
                    title: 'Escola em que atua',
                    type: 'array',
                    name: 'school',
                    data: {
                        selected: null,
                        options: [
                            { value: null, text: 'Escola em que atua' },
                            { value: "Instituto Federal", text: 'Instituto Federal' },
                            { value: "Escola Estadual", text: 'Escola Estadual' },
                            { value: "Escola Municipal", text: 'Escola Municipal' },
                            { value: "Escola Privada", text: 'Escola Privada' },
                        ]
                    }
                },
                {
                    title: 'Atua em escola de eja?',
                    type: 'array',
                    name: 'eja',
                    data: {
                        selected: null,
                        options: [
                            { value: null, text: 'Atua em escola de eja?' },
                            { value: true, text: 'Sim' },
                            { value: false, text: 'Não' }
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
                ]

            return questions;
            }
        },
        methods:{
            ...mapMutations(["setPageName", "setBackUrl"]),
            ...mapActions(["getStates", "getCities","createTeacherAction"]),
            createTeacher(){
                let user = JSON.parse(JSON.stringify(this.responses));
                console.log(user);
                this.createTeacherAction(this.responses)
                .then(response => {
                    console.log(user);
                    firebase.auth().createUserWithEmailAndPassword(user.email, user.pass)
                    alert("Professor(a) criado com sucesso");
                    console.log("RESPONSE", response);
                    this.$router.push("/login")
                })
                .catch(error => {
                    alert("Falha ao criar o(a) professor(a)");
                    console.log("ERROR", error);
                })
            },
            onSelectChanged(name){
                if(name === "state"){
                    this.responses.city = null;
                    this.getCities(this.responses.state)
                } 
            }
        },
        beforeMount(){
            this.setPageName("Cadastro Professor(a)");
            this.setBackUrl("/signup");
            this.getStates();
            this.getCities();
        }
    }
</script>

<style>

</style>
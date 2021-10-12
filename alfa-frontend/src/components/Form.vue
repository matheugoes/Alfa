<template>
    <b-form class="questions">
        <div class="questionsQuestion" v-for="(question, index) in questions" :key="index">
            <div v-if="(question.type === 'array') && (index === (currentPage-1)*2 || index === (currentPage-1)*2+1)">
                <Select @selectChanged="$emit('selectChanged', question.name)" class="questionsSelect" v-model="responses[question.name]" :name="question.title" :data="question.data"/>
            </div>
            <div v-else-if="(question.type === 'text' || question.type === 'number' || question.type === 'password') && (index === (currentPage-1)*2 || index === (currentPage-1)*2+1)">
                <Input class="questionsInput" v-model="responses[question.name]"  :placeholder="question.title" :type="question.type"/>
            </div>
        </div>
        <div class="navigation mt-4" v-if="currentPage <= totalPages">
            <round-button icon="icon-left" v-if="currentPage > 1" @click="prevPage" class="round-button mr-4"/>
            <div class="elipse" v-for="(valor, index) in totalPages" :key="index" :style="activePage(index)"/>
            <round-button icon="icon-right" v-if="currentPage <= totalPages" @click="nextPage" class="round-button ml-4"/>
        </div>
    </b-form>
</template>

<script>
    import Input from './Input.vue'
    import Select from './Select.vue'
    import RoundButton from './buttons/RoundButton.vue'

    export default {
        components: {Input, Select, RoundButton},
        data() {
            let currentPage = 1;
            let totalPages = Math.round((this.questions.length/2));

            return {currentPage, totalPages};
        },
        props: {
            questions: {
                type: Array,
            },
            responses: {
                type: Object,
            }
        },
        methods: {
            nextPage() {
                this.currentPage++;
                if(this.currentPage > this.totalPages) {
                    if(Object.keys(this.responses).find(key => this.responses[key] === "")){
                        alert("Preencha todos os campos!");
                        this.currentPage--;
                    }else{
                        if(confirm("Deseja realizar o cadastro?"))
                            this.$emit("createConfirmed")
                    }
                }
            },
            prevPage() {
                this.currentPage--;
            },
            activePage(index) {
                if(index === this.currentPage-1) {
                    return {
                        backgroundColor: "var(--primary-btn-color)",
                    }
                }
            }
        },
        beforeMount() {
            console.log(this.questions);
        }
    }
</script>

<style>
    .navigation {
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: row;
        gap: 20px;
    }

    .elipse {
        background-color: var(--primary-btn-focus-color);
        width: 16px;
        height: 16px;
        border-radius: 50%;
        border: none;
    }

    .questions {
        width: 100%;
        padding: 0px!important;
    }

    .questionsInput{
        height: 64px;
    }

    .questionsSelect{
        height: 64px;
    }
</style>
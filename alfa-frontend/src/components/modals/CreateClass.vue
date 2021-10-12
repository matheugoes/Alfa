<template>
    <modal ref="modal">
        <template v-slot:header>
            <h1 v-if="!link">Qual o nome da sua nova turma?</h1>
            <h1 class="link-title" v-if="link">O link da sua turma foi gerado, você pode envia-lo para seus alunos.</h1>
            <text-button class="close-button" textButton="X" @click="toggleModal"/>
        </template>
        <template v-slot:body>
            <input-component v-if="!link" v-model="createClassName" class="create-class-name" type="text" placeholder="Escreva o nome"/>
            <div v-if="link">
                <input-component class="inputLink" :value="String(link)" type="text" ref="inputLink"/>
            </div>
        </template>
        <template v-slot:footer>
            <primary-button v-if="!link" class="create-class-confirm" text="Criar turma" @click="createClass"/>
            <primary-button v-if="link" class="create-class-confirm" text="Copiar link" @click="copyURL"/> 
        </template>
    </modal>
</template>

<script>
import Modal from './Modal.vue'
import TextButton from '../buttons/TextButton.vue'
import InputComponent from '../Input.vue'
import PrimaryButton from '../buttons/PrimaryButton.vue'

export default {
    components: {Modal, TextButton, PrimaryButton, InputComponent},
    data() {
        return {createClassName: ""}
    },
    props: {
        link: {}
    },
    methods: {
        toggleModal() {
            this.$refs.modal.toggleModal()
            this.createClassName = ""
        },
        createClass() {
            this.$emit("createClass", this.createClassName)
        },
        copyURL() {
            let copy = document.querySelector('.inputLink')
            copy.setAttribute('type', 'text') 
            copy.select()

            try {
                var successful = document.execCommand('copy');
                var msg = successful ? 'O link foi copiado com sucesso!' : 'O link não pode ser copiado';
                alert(msg);
            } catch (err) {
                alert('O link não pode ser copiado');
            }

            window.getSelection().removeAllRanges()
        }
    }
}
</script>

<style scoped>
    .close-button{
        font-size: 30px!important;
        font-weight: 800!important;
        align-self: flex-start;
        line-height: 30px;
        color: var(--primary-btn-palceholder-color)!important;
    }

    .modal-header h1{
        width: 85%;
        margin: 0px;
        font-size: 27px;
        text-align: left;
        line-height: 30px;
        color: var(--primary-btn-focus-color)!important;
    }

    .create-class-confirm{
        width: 100%;
    }

    .link-title {
        font-size: 26px!important;
        line-height: 26px!important;
    }
</style>
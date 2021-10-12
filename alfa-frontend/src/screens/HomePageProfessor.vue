<template>
    <b-container>
        <b-row class="homepage-container vh-100">
            <div class="central-content">
                <create-class @createClass="createClass" ref="modalCreateClass" :link="link"/>
                <b-row class="home-top mt-3">
                    <mini-logo/>
                    <primary-button class="create-class" @click="toggleModal" text="Criar turma"/>
                </b-row>
                <div class="home-teacher-content">
                    <class-card title="Turmas antigas" class="old-classes" icon="icon-left"/>
                    <div class="classes-content">
                        <class-card title="Turma 101" class="class" icon="icon-right"/>
                    </div>
                </div>
            </div>
            <navigation/>
        </b-row>
    </b-container>
</template>

<script>
import MiniLogo from "../components/MiniLogo.vue"
import PrimaryButton from "../components/buttons/PrimaryButton.vue"
import Navigation from "../components/Navigation.vue"
import ClassCard from "../components/ClassCard.vue"
import CreateClass from "../components/modals/CreateClass.vue"  
import { mapActions, mapGetters,  } from "vuex"

export default {
    components: {MiniLogo,  PrimaryButton, Navigation, ClassCard, CreateClass},
    data() {
        return {link: ""}
    },
    methods: {
        ...mapActions(["createClassAction"]),
        ...mapGetters(["actualUserId"]),
        toggleModal() {
            this.$refs.modalCreateClass.toggleModal()
            this.link = ""
        },
        createClass(name) {
            let classData = {
                name: name,
                teacherId: this.actualUserId()
            }
            this.createClassAction(classData)
            .then(response => {
                console.log(response)
				this.link = response
            })
            .catch(error => {
                this.link = error
            })
        }
    }
}
</script>

<style>
    .container {
        padding: 0px!important;
    }

    .homepage-container{
        padding: 0px!important;
    }

    .home-teacher-content {
        margin-left: calc(var(--bs-gutter-x) * 0.5) !important;
        margin-right: calc(var(--bs-gutter-x) * 0.5) !important;
    }

    .central-content {
        height: calc(100% - (70px + var(--bs-gutter-x)));
        overflow-y: auto;
        -webkit-box-shadow: inset 0px -16px 8px -5px #FFFFFF; 
        box-shadow: inset 0px -16px 8px -5px #FFFFFF;
    }

    .home-top {
        height: 54px;
        display: flex;
        justify-content: space-between;
        padding: 0px!important;
        align-items: center;
        margin-left: calc(var(--bs-gutter-x) * 0.5) !important;
        margin-right: calc(var(--bs-gutter-x) * 0.5) !important;
    }

    .create-class {
        width: 120px!important;
        height: 40px!important;
        border-radius: 15px!important;
    }
</style>
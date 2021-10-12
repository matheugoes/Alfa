]<template>
   
<b-container>
    <b-row class="homepage-container vh-100">
        <div class="central-content">
            <b-row class="home-top mt-3">
                <mini-logo/>
                <!--<primary-button class="create-class"  text="Criar turma"/> -->
            </b-row>
            <div class="trail-progress">
                <div class="progress-title">
                    <h1>Trilha 1</h1>
                    <h1 class="progress-number">50% completo</h1>
                </div>
                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </div>
            <div class="cards-content">
                <h1>Módulos para fazer</h1>
                <div class="module-content">
                    <module @click="goToModule" ref="module" v-for="moduleObject in modules" v-bind:key="moduleObject.title" :moduleId="moduleObject.id" :title="moduleObject.title" :description="moduleObject.description" :activities="moduleObject.activities"/>
                </div>
            </div>
            <div class="cards-content">
                <h1>Módulos feitos</h1>
                <div class="module-content">
                    <module @click="goToModule" ref="module" v-for="moduleObject in modules" v-bind:key="moduleObject.title" :moduleId="moduleObject.id" :title="moduleObject.title" :description="moduleObject.description" :classes="moduleObject.classes" :exercises="moduleObject.exercises"/>
                </div>
            </div>
        </div>
        <navigation/>
    </b-row>
</b-container>
    
</template>

<script>
import MiniLogo from "../components/MiniLogo.vue"
import Navigation from "../components/Navigation.vue"
import Module from "../components/Module.vue"
import {mapMutations, mapGetters, mapActions} from "vuex";
export default {
    components: {MiniLogo, Navigation, Module},
    computed: {
        ...mapGetters(["modules"]),
    },
    methods:{  
        ...mapActions(["getStoryModules"]),
        ...mapMutations(["setPageName", "setBackUrl"]),
        goToModule: function(module){
            this.setPageName(module.title);
            this.$router.push(`/modules/${module.id}/activities`);
        }
    },
    beforeMount(){
        this.setPageName("Trilha 1");
        this.setBackUrl("/");
        this.getStoryModules();
    },

}
</script>

<style>
    .container {
        padding: 0px!important;
    }

    .homepage-container{
        padding: 0px!important;
    }

    .central-content {
        height: calc(100% - (70px + var(--bs-gutter-x)));
        overflow-y: auto;
        -webkit-box-shadow: inset 0px -16px 8px -5px #FFFFFF; 
        box-shadow: inset 0px -16px 8px -5px #FFFFFF;
        padding: 0px!important;
    }

    .cards-content{
        margin-top: 1.2rem;
        text-align: start;
    }

    .cards-content h1{
        margin-left: calc(var(--bs-gutter-x) * 0.5);
    }

    .module-content{
        justify-items: flex-start;
        margin-top: 0.8rem;
        width: 100%;
        overflow-x: scroll;
        display: flex;
        flex-direction: row;
        flex-wrap: nowrap;
    }

    .module{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        margin-right: calc(var(--bs-gutter-x) * 0.5);
        margin-left: 0px;
        padding: 15px;
        min-width: 150px;
        width: 150px;
        height: 200px;
        background-color: #f2f2f2;
        border-radius: 22px;
    }

    .module-start h1{
        font-size: 20px;
    }

    .module-start p{
        font-size: 16px;
    }

    .module-data{
        font-size: 14px!important;
        margin-bottom: 0px;
    }

    .homepage-container {
        justify-items: flex-start;
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

    .progress {
        padding: 0px!important;
        border-radius: 40px!important;
        background-color: #D9DBE9!important;
    }

    .progress-bar {
        background-color: var(--primary-btn-color)!important;
        border-radius: 40px;
    }

    .trail-progress {
        margin-top: 1.2rem;
        padding: 0px!important;
        margin-left: calc(var(--bs-gutter-x) * 0.5) !important;
        margin-right: calc(var(--bs-gutter-x) * 0.5) !important;
    }

    .progress-title {
        display: flex !important;
        justify-content: space-between!important;
        padding: 0px!important;
        align-items: center;
    }

    .progress-title h1 {
        font-size: 24px;
        width: auto!important;
        padding: 0px!important;
    }

    .progress-number {
        font-size: 16px!important;
    }

    .create-class {
        width: 120px!important;
        height: 40px!important;
        border-radius: 15px!important;
    }
</style>
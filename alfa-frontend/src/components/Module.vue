<template>
    <div class="module" @click="emitClick">
        <div class="module-start">
            <h1>{{title}}</h1>
            <p>{{description}}</p>
        </div>
        <div class="module-end">
            <p class="module-data">1 Aula</p>
            <p class="module-data">1 Exercicío</p>
            <div class="progress">
                <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
            </div>
        </div>
    </div>
</template>


<script>
export default {
    props: {
        title: {
            type: String
        },
        description: {
            type: String
        },
        moduleId: {
            type: [String, Number]
        },
        activities: {
            type: Array
        },
        
    },
    methods: {
        emitClick: function(){
            console.log("MODULE ID", this.moduleId);
            this.$emit("click", {title: this.title, id: this.moduleId})
        }
    },
    computed: {
        countExercises: function(){
            let count = 0;
            if(this.activities){
                this.activities.forEach(activity => {
                    if(activity.type == 2)count++;
                });
            }
            return count;
        },
        countClasses: function(){
            let count = 0;
            if(this.activities){
                this.activities.forEach(activity => {
                    if(activity.type == 1)count++;
                });
            }

            return count;
        },
        exercisesText: function(){
            return this.countExercises == 1 ? "exercício" : "execícios"
        },
        classesText: function(){
            return this.countClasses == 1 ? "aula" : "aulas"
        },
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
        text-align: initial;
        margin-left: calc(var(--bs-gutter-x) * 0.5);
    }

    .module-content{
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
        margin-left: calc(var(--bs-gutter-x) * 0.5);
        padding: 15px;
        min-width: 150px;
        width: 150px;
        height: 200px;
        background-color: #f2f2f2;
        border-radius: 22px;
        cursor: pointer;
    }

    .module-start{
        margin-left: 0px!important;
    }

    .module-start h1{
        margin-left: 0px!important;
    }

    .module h1{
        font-size: 20px;
    }

    .module p{
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
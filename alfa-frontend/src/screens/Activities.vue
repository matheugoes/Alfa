<template>

<b-container>
    <b-row class="activity-container">
        <div class="central-content">
            <div class="trail-progress">
                <div class="progress">
                    <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </div>
            <div class="cards-content">
                <h1>Aulas</h1>
                <div class="activity-content" v-if="activities.length > 0">
                    <activity v-for="activity in activities" v-bind:key="activity.title" :isBlocked="false" :title="activity.title" :description="activity.description"/>
                </div>

            </div>
        </div>
        <navigation/>
    </b-row>
</b-container>

</template>

<script>
import Navigation from "../components/Navigation.vue"
import Activity from "../components/Activity.vue"
import {mapMutations, mapGetters, mapActions} from "vuex"

export default {
    components: { Navigation, Activity},
    props: {
        moduleId: {
            type: [String, Number]
        }
    },
    computed: {
        ...mapGetters(["questions", "lessons"]),
        activities: function(){
            return [...this.questions, ...this.lessons];
        }
    },
    methods:{
        ...mapMutations(["setPageName", "setBackUrl"]),
        ...mapActions(["getModuleById"]),
    },
    beforeMount(){
        this.getModuleById(this.moduleId);
        this.setBackUrl("/home");
    },
}
</script>

<style scoped>
    .trail-progress{
        margin-top: 0px;
    }

    .activity-container{
        height: calc(100vh - 70px);
    }
    .activity-content{
        height: 440px;
        overflow: auto;
        text-align: start;
    }

    .activity-content::-webkit-scrollbar {
    display: none;
    }
</style>
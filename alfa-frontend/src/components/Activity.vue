<template>
    <b-row class="mt-2">
        <div ref="activityDiv" class="activity">
            <div class="module-start">
                <h1><b-icon icon="lock-fill" v-if="isBlocked" class="lockIcon"/>{{title}}</h1>
                <p>{{description}}</p>
            </div>
        </div>
    </b-row>

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
        isBlocked: {
            type: Boolean
        }
    },
    mounted(){
        if(this.isBlocked)  this.$refs.activityDiv.classList.add("blocked");
    },
    beforeMount(){
        console.log("AAA");
    }
}
</script>

<style>
    .activity{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding: 15px;
        height: 85px;
        background-color: #f2f2f2;
        border-radius: 22px;
    }

    .cards-content {
        width: calc(100% - var(--bs-gutter-x))!important;
        margin-left: calc(var(--bs-gutter-x) * .5)!important;
        margin-right: calc(var(--bs-gutter-x) * .5)!important;
    }

    .cards-content h1{
        margin: 0px;
    }
    
    .lockIcon{
        margin-right: 5px;
    }

    .blocked{
        background-color: #4f4f4f;
        color: white;
    }   

    .module-start{
        text-align: start;
        margin-left: 15px;
    }

    .activity h1{
        font-size: 20px;
        margin: 0;
    }

    .activity p{
        font-size: 16px;
    }

    .module-data{
        font-size: 14px!important;
        margin-bottom: 0px;
    }
</style>
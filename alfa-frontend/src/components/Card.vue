<template>
    <div @click="emitClick" class="card mt-3">
      <div class="card-body">
        <h5 class="card-title">{{title}}</h5>
        <p class="card-text">{{description}}</p>
        <div v-if="icon">
            <round-button :icon="icon" @click="emitClick" class="round-button"/>
        </div>
      </div>
    </div>
</template>

<script>
    import RoundButton from './buttons/RoundButton.vue';

    export default {
        components: {RoundButton},
        props: {
            title: {
                type: String,
            },
            description: {
                type: String,
            },
            icon: {
                type: String,
            }
        },
        methods: {
            emitClick(){
                this.$emit("click");
            }
        }
    }
</script>

<style scoped>
    .card {
        background-color: var(--primary-input-color);
        border: none;
        border-radius: 22px;
        cursor: pointer;
        text-align: justify;
    }

    .card-title{
        font-weight: bold;
        font-size: 40px;
        color: var(--primary-btn-focus-color);
    }

    .card-text{
        font-size: 16px;
        color:  var(--primary-btn-palceholder-color);
    }

    .round-button{
        float: right;
    }
</style>